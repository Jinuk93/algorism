package TicTacToe;

//데이터-1인분
public class MemberDTO { 
	//--------MemberDTO--------
	//아이디,비밀번호
	private String id;
	private String pwd;
	
	
//--------MemberDTO--------
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
}