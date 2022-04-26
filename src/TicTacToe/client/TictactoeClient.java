package TicTacToe.client;

public class TictactoeClient {
	   int difficulty=1;
	   String np;
	   TictactoeClientSocket socket;
	   public TictactoeClient() {
	      socket=new TictactoeClientSocket();
	   }
	   public void setDifficulty(int difficulty) {
	      this.difficulty = difficulty;
	      socket.sendPacket(Integer.toString(difficulty));
	   }
	   public void setPosition(int p) {
	      np=Integer.toString(p);
	      socket.sendPacket(np);
	   }
	   public void getPosition() {
	      String packet=socket.recivePacket();
	      String[] params=socket.parsePacket(packet);
	      if(params[0].equals("Win")) {
	         //누가 이겼는지에 대한 화면을 띄우는 페이지가 켜지게 한다.
	         //혹은 그런신호를 보내준다.
	         //==gameover페이지가 열리게 만들어 준다.
	         //승자는 params[1]
	      }else if (params[0].equals("Next")) {
	         //다시 본인턴임을 표시
	         //게임판 리프레시
	         
	      }
	  }  
}
