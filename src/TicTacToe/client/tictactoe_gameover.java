//게임종료시 뜨는, GAMEOVER 메뉴화면
package TicTacToe.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import TicTacToe.client.tictactoe_login.FrameDragListener;


@SuppressWarnings("serial")
public class tictactoe_gameover extends JFrame implements ActionListener { 
	
	private JLabel titlelabel = new JLabel(); 
	private JButton ReplayButton; 
	private JButton SaveButton; 

	// 색상 생성
	public static final Color btn_backgroundcolor = new Color(197, 199, 196);
	protected static final Object anchor = null;


	// 생성자
	public tictactoe_gameover() {
		
		super("End");

		// JFrame 환경설정
		setSize(300, 350);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// 라벨
		titlelabel = new JLabel("GAMEOVER");
		titlelabel.setFont(new Font("arial", Font.BOLD, 24));
		titlelabel.setSize(150, 40);
		titlelabel.setLocation(75, 50);
		
		// 다시하기 버튼
		ReplayButton = new JButton("Replay");
		ReplayButton.setBounds(80, 120, 130, 40);
		ReplayButton.setForeground(Color.BLACK);
		ReplayButton.setBackground(btn_backgroundcolor);
		ReplayButton.setFocusPainted(false);
		ReplayButton.setFont(new Font("서울남산체", Font.BOLD, 15));
		ReplayButton.setBorderPainted(false); // 버튼 테두리 제거

		// 저장하기 버튼
		SaveButton = new JButton("Save");
		SaveButton.setBounds(80, 190, 130, 40);
		SaveButton.setForeground(Color.BLACK);
		SaveButton.setBackground(btn_backgroundcolor);
		SaveButton.setFocusPainted(false);
		SaveButton.setFont(new Font("서울남산체", Font.BOLD, 16));
		SaveButton.setBorderPainted(false); // 버튼 테두리 제거
		
		// event
		ReplayButton.addActionListener(this);
		SaveButton.addActionListener(this);
		
		FrameDragListener frameDragListener = new FrameDragListener(this); 
		// 반드시 MouseEvent로 Drag 이동을 구현해줘야함 addMouseListener(frameDragListener);
		
		setLayout(null); // 레이아웃 해제
		
		add(titlelabel);
		add(ReplayButton);
		add(SaveButton);
	
		// swing에서 배경화면 설정
		this.getContentPane().setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		new tictactoe_gameover();
		}
}
	
