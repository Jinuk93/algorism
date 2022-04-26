//NewGame 누르고, 난이도 선택할 때 나오는 Menu
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
import TicTacToe.server.TicTacToe1;


@SuppressWarnings("serial")
public class tictactoe_levelchoice extends JFrame implements ActionListener { 
	
	private JLabel titlelabel = new JLabel(); 
	private JButton easylevelButton; 
	private JButton highlevelButton; 

	// 색상 생성
	public static final Color btn_backgroundcolor = new Color(197, 199, 196);
	protected static final Object anchor = null;


	// 생성자
	public tictactoe_levelchoice() {
		
		super("choice");
		
		FrameDragListener frameDragListener = new FrameDragListener(this); 
		// 반드시 MouseEvent로 Drag 이동을 구현해줘야함 addMouseListener(frameDragListener);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener); // 타이틀바 제거시, 프레임이 움직이지 않는 현상을 방지한다

		setLayout(null); // 레이아웃 해제
		
		// JFrame 환경설정
		setSize(300, 350);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// 타이틀 라벨
		titlelabel = new JLabel("LEVEL");
		titlelabel.setFont(new Font("arial", Font.BOLD, 27));
		titlelabel.setSize(150, 40);
		titlelabel.setLocation(100, 50);
		
		// 초급 레벨 버튼
		easylevelButton = new JButton("easy");
		easylevelButton.setBounds(80, 120, 130, 40); 
		easylevelButton.setForeground(Color.BLACK);
		easylevelButton.setBackground(btn_backgroundcolor);
		easylevelButton.setFocusPainted(false);
		easylevelButton.setFont(new Font("서울남산체", Font.BOLD, 16));
		easylevelButton.setBorderPainted(false); // 버튼 테두리 제거

		// 고급(high) 레벨 버튼
		highlevelButton = new JButton("high");
		highlevelButton.setBounds(80, 190, 130, 40);
		highlevelButton.setForeground(Color.BLACK);
		highlevelButton.setBackground(btn_backgroundcolor);
		highlevelButton.setFocusPainted(false);
		highlevelButton.setFont(new Font("서울남산체", Font.BOLD, 16));
		highlevelButton.setBorderPainted(false); // 버튼 테두리 제거
		
		add(titlelabel);
		add(easylevelButton);
		add(highlevelButton);
	
		// swing에서 배경화면 설정
		this.getContentPane().setBackground(Color.WHITE);
		
		// event
		easylevelButton.addActionListener(this);
		highlevelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == easylevelButton) {	// easy level버튼 눌렀을 때 이벤트
			new TicTacToe1();	
		} else if (e.getSource() == highlevelButton) {
		
		} 
		dispose();
	}
	
	public static void main(String[] args) {
		new tictactoe_levelchoice();
		}
}
	
