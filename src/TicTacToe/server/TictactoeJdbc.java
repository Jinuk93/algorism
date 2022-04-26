package TicTacToe.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TictactoeJdbc {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "bitacademy";
	String pass = "bitacademy";
	Connection con;
	Statement statemt;
	public TictactoeJdbc() {
		
		Connection con;
		try {
			con = DriverManager.getConnection(url,id,pass);
			statemt=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int npSelect(String log) {
		int[] scores=new int[9];
		int maxIndex=0;
		try {
			for(int i=0;i<9;i++) {
				String setSelect="SELECT NVL(SUM(score),0)\n\r"
						+"FROM t3\n\r"
						+"WHERE logs LIKE '"+log+Integer.toString(i)+"%'";
				ResultSet rs=statemt.executeQuery(setSelect);
				scores[i]=rs.getInt(1);
			}
			int maxNum=scores[0];
			
			for (int i=1;i<9;i++) {
				if(scores[i]>maxNum) {
					maxNum=scores[i];
					maxIndex=i;
				}
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return maxIndex;
	}
}
