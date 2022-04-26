//로그인 성공시, 먼저 뜨는 메뉴창
package TicTacToe.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class tictactoe_menu extends JFrame implements ActionListener  { 
	
	private JLabel titlelabel = new JLabel(); 
	private JButton NewGameButton; 
	private JButton ReplayButton; 
	
	// 색상 생성
	public static final Color btn_backgroundcolor = new Color(197, 199, 196);
	protected static final Object anchor = null;

	// 생성자
	public tictactoe_menu() {
		
		super("Menu");
		
		FrameDragListener frameDragListener = new FrameDragListener(this); 
		// 반드시 MouseEvent로 Drag 이동을 구현해줘야함 addMouseListener(frameDragListener);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	
		setLayout(null); // 레이아웃 해제
		
		// JFrame 환경설정
		setSize(300, 350);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// 라벨
		titlelabel = new JLabel("MENU");
		titlelabel.setFont(new Font("arial", Font.BOLD, 25));
		titlelabel.setSize(130, 50);
		titlelabel.setLocation(110, 40);
		
		// 새 게임(New Game) 버튼
		NewGameButton = new JButton("NewGame");
		NewGameButton.setBounds(80, 120, 130, 40); //���� 55����
		NewGameButton.setForeground(Color.BLACK);
		NewGameButton.setBackground(btn_backgroundcolor);
		NewGameButton.setFocusPainted(false);
		NewGameButton.setFont(new Font("���ﳲ��ü", Font.BOLD, 16));
		NewGameButton.setBorderPainted(false); // ��ư �׵θ� ����

		// 리플레이 (Replay) 버튼
		ReplayButton = new JButton("Replay");
		ReplayButton.setBounds(80, 190, 130, 40);
		ReplayButton.setForeground(Color.BLACK);
		ReplayButton.setBackground(btn_backgroundcolor);
		ReplayButton.setFocusPainted(false);
		ReplayButton.setFont(new Font("���ﳲ��ü", Font.BOLD, 16));
		ReplayButton.setBorderPainted(false); // ��ư �׵θ� ����
		
		add(titlelabel);
		add(NewGameButton);
		add(ReplayButton);
	
		// swing에서 배경화면 설정
		this.getContentPane().setBackground(Color.WHITE);
	
		// event
		NewGameButton.addActionListener(this);
		ReplayButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NewGameButton) {	// easy level버튼 눌렀을 때 이벤트
			new tictactoe_levelchoice();	
		} else if (e.getSource() == ReplayButton) {
			new tictactoe_replay();
		} 
		dispose();
	}
}