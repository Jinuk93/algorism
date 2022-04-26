package TicTacToe.server;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
   private Connection conn;
   private PreparedStatement pstmt;
   private CallableStatement cstmt;
   private ResultSet rs;
   
   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String username = "bitacademy";
   private String password = "bitacademy";
   //MemberDAO
   //테이블 이름 : t_member,    
   //사용자 이름 : bitacademy
   //비밀 번호 : bitacademy
   //컬럼 : no, id, pwd, win, lose, m_registdate
   
   public MemberDAO() {
      try {
         Class.forName(driver);
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   public void getConnection() {
      try {
         conn = DriverManager.getConnection(url, username, password);
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }
   
//   public void insertMember(MemberDTO dto) {
//      String sql = "insert into t_member values(?,?)"; // 테이블이름 t_member로 생성하기
//      this.getConnection();
//
//      try {
//         pstmt = conn.prepareStatement(sql); // 생성
//         pstmt.setString(1, dto.getId());
//         pstmt.setString(2, dto.getPwd());
//         
//         pstmt.executeUpdate();            //실행 - 개수 리턴
//         
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }finally {
//         try {
//            if(pstmt != null) pstmt.close();
//            if(conn != null) conn.close();
//         }catch(SQLException e) {
//            e.printStackTrace();
//         }
//      }   
//   }
   
   // 유저등록하기
      public boolean insertMember(MemberDTO dto){    
             
           boolean result = false;            
           try {
               getConnection();
              
               String sql = "INSERT INTO T_Member VALUES (LPAD(seq_member_no.nextval,4,'0'),?,?,sysdate)";
               PreparedStatement pstmt = conn.prepareStatement(sql);
              
               pstmt.setString(1,dto.getId());
               pstmt.setString(2,dto.getPwd());
//               pstmt.setString(3,dto.getWin());
//               pstmt.setString(4,dto.getLose());
              
               int r = pstmt.executeUpdate();
              
               if(r>0) result = true;
              
           } catch (Exception e) {
               System.out.println("예외발생:insertMember()=> "+e.getMessage());
           }finally{          
               dbClose();
           }      
           return result;
       }     
   
   // 로그인
   public String loginMember(String id, String pwd){
      String name = null;
      String sql = "select * from t_member where id=? and pwd=?";
      getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);//생성
         pstmt.setString(1, id);
         pstmt.setString(2, pwd);
         
         rs = pstmt.executeQuery();//실행
      
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }   
      return id; //이거 틀릴수도...
   }
   
   //중복아이디를 체크하는 부분
   public String idCheck(String id) {
      String sql = "select * from t_member where id=?";
      getConnection();
      String idcheck = null;
      
      try {
         pstmt = conn.prepareStatement(sql);//생성
         pstmt.setString(1, id);
         
         rs = pstmt.executeQuery();//실행
         
         if(rs.next()) idcheck = rs.getString("id");
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      return idcheck;
   }
   
    /**
       * 유저번호에 해당하는 유저정보 보기
       */
       public MemberDTO getMember(String no){
           MemberDTO dto =null;
           try {
               getConnection();
              
               String sql = "SELECT no, id, pwd, m_registdate FROM T_Member WHERE no = ?";
               PreparedStatement pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, no);
               ResultSet r = pstmt.executeQuery();
              
               if(r.next()) {
                   String no1 = r.getString("no");
                   String id = r.getString("id");
                   String pwd = r.getString("pwd");
                   String m_registdate = r.getDate("m_registdate").toString();
                   dto = new MemberDTO(no1, id, pwd, m_registdate);
               }
              
           } catch (Exception e) {
               System.out.println("예외발생:deleteMember()=> "+e.getMessage());
           }finally{          
               dbClose();
           }      
          
           return dto;
       }
   
       
       // 유저수정
       public boolean updateMember(MemberDTO dto){
           
           boolean result = false;            
           try {
               getConnection();
              
               String sql = "UPDATE T_Member SET id=:id , pwd=:pwd , WHERE no=:no";
               PreparedStatement pstmt = conn.prepareStatement(sql);
              
               pstmt.setString(1,dto.getId());
               pstmt.setString(2,dto.getPwd());
               pstmt.setString(3,dto.getNo());        
              
               int r = pstmt.executeUpdate();
              
               if(r>0) result = true;
              
           } catch (Exception e) {
               System.out.println("예외발생:updateMember()=> "+e.getMessage());
           }finally{          
               dbClose();
           }      
           return result;
       }
   
       // 유저삭제
       public boolean deleteMember(String id){        
           boolean result = false;            
           try {
               getConnection();
              
               String sql = "DELETE FROM T_Member WHERE no = ?";
               PreparedStatement pstmt = conn.prepareStatement(sql);
               pstmt.setString(1, id);
               int r = pstmt.executeUpdate();
              
               if(r>0) result = true;
              
           } catch (Exception e) {
               System.out.println("예외발생:deleteMember()=> "+e.getMessage());
           }finally{          
               dbClose();
           }      
           return result;
       }
       
   
   
   /**DB연결 해제(닫기)*/
    public void dbClose(){      
     
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("예외:ResultSet객체 close():" + e.getMessage());
            }
        }
         
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                System.out.println("예외:PreparedStatement객체 close():" + e.getMessage());
            }
        }
       
        if (cstmt != null) {
            try {
                cstmt.close();
            } catch (SQLException e) {
                System.out.println("예외:CallableStatement객체 close():" + e.getMessage());
            }
        }      
       
           
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("예외:Connection객체 close():" + e.getMessage());
            }
        }    
         
        conn = null;        
    }//dbClose()---------
    
   
   
}