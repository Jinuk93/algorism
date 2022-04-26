package TicTacToe.server;

//      -1 κ 
public class MemberDTO { 
//--------MemberDTO--------
   //   ̵ ,  й ȣ
   private String id;
   private String pwd;
   private String no;
   private String registdate;
   private String win;
   private String lose;
   //no sysdate gamelog 
   
   //기본생성자
    public MemberDTO() {
   
    }
   
    //생성자
    public MemberDTO(String id, String pwd, String win, String lose) {
        this.id = id;
        this.pwd = pwd;
        this.win = win;
        this.lose = lose;
    }
    //생성자
    public MemberDTO(String no, String id, String pwd,String win, String lose, String registdate) {
       super();
       this.no = no;
       this.id = id;
       this.pwd = pwd;
       this.win = win;
       this.lose = lose;
       this.registdate = registdate;
    }
   
//--------Getter, Setter--------
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPwd() {
      return pwd;
   }
   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public String getNo() {
      return no;
   }

   public void setNo(String no) {
      this.no = no;
   }
   
    public String getRegistdate() {
           return registdate;
       }
    
       public void setRegistdate(String registdate) {
           /*SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
           try {
               registdate = textFormat.format(textFormat.parse(registdate));
           } catch (ParseException e) {}*/
           this.registdate = registdate;
          
    }

   public String getWin() {
      return win;
   }
   public void setWin(String win) {
      this.win = win;
   }
   public String getLose() {
      return lose;
   }
   public void setLose(String lose) {
      this.lose = lose;
   }
}