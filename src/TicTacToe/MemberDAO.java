package TicTacToe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "bitacademy";
	private String password = "bitacademy";
	//MemberDAO
	//테이블 이름 : t_member, 	
	//사용자 이름 : bitacademy
	//비밀 번호 : bitacademy
	//컬럼 : member_id, member_pwd,
	
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
	
	public void insertMember(MemberDTO dto) {
		String sql = "insert into t_member values(?,?)"; // 테이블이름 t_member로 생성하기
		this.getConnection();

		try {
			pstmt = conn.prepareStatement(sql); // 생성
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			
			pstmt.executeUpdate();				//실행 - 개수 리턴
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	public String loginMember(String id, String pwd){
		String name = null;
		String sql = "select * from t_member where member_id=? and member_pwd=?";
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
		String sql = "select * from t_member where member_id=?";
		getConnection();
		String idcheck = null;
		
		try {
			pstmt = conn.prepareStatement(sql);//생성
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();//실행
			
			if(rs.next()) idcheck = rs.getString("member_id");
			
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
}