//회원가입창
package TicTacToe;

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

import TicTacToe.tictactoe_login.FrameDragListener;


public class tictactoe_sign extends JFrame implements ActionListener { 

	private JLabel titlelabel = new JLabel(); 

	private JLabel idlabel; 					// 아이디 라벨
	private JTextField idText; 					// 아이디 적는 텍스트필드
	private JButton idButton; 					// 아이디 중복확인하는 버튼

	private JLabel pwlabel; 					// 비밀번호 라벨
	private JPasswordField pwText; 				// 비밀번호 적는 텍스트 필드
	
	private JButton signCompleteButton; 		// 계정등록(회원가입) 버튼
	private boolean signidcheck = false;

	// 색상 생성
	public static final Color btn_backgroundcolor = new Color(197, 199, 196);
	protected static final Object anchor = null;

	private MemberDTO dto;
	private MemberDAO dao;

	// 생성자
	public tictactoe_sign() {
		
		super("Welcome");
		
		dao = new MemberDAO();
		FrameDragListener frameDragListener = new FrameDragListener(this); 
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener); // 타이틀바 제거시, 프레임이 움직이지 않는 현상을 방지한다
		setLayout(null); // 레이아웃 해제

		// JFrame 환경설정
		setSize(400, 500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// 타이틀 라벨
		titlelabel = new JLabel("WELCOME");
		titlelabel.setFont(new Font("arial", Font.BOLD, 25));
		titlelabel.setSize(200, 80);
		titlelabel.setLocation(135, 30);
		// 아이디 라벨
		idlabel = new JLabel("Username");
		idlabel.setFont(new Font("서울남산체", Font.ITALIC, 16));
		idlabel.setSize(150, 35);
		idlabel.setLocation(15, 120);
		// 아이디 텍스트 필드
		idText = new JTextField(30);
		idText.setSize(360, 30);
		idText.setLocation(15, 155);
		// 비밀번호 라벨
		pwlabel = new JLabel("Password");
		pwlabel.setFont(new Font("서울남산체", Font.ITALIC, 16));
		pwlabel.setSize(100, 50);
		pwlabel.setLocation(15, 200);
		// 비밀번호 텍스트 필드
		pwText = new JPasswordField(30); 
		pwText.setSize(360, 30);
	    pwText.setLocation(15, 245);
		 
		// 아이디 중복확인 버튼
		idButton = new JButton("중복 확인");
		idButton.setBounds(225, 200, 150, 30);
		idButton.setFocusPainted(false);
		idButton.setForeground(Color.WHITE);
		idButton.setBackground(btn_backgroundcolor);
		idButton.setFont(new Font("서울남산체", Font.ITALIC, 16));

		// 계정등록 버튼
		signCompleteButton = new JButton("계정등록");
		signCompleteButton.setBackground(btn_backgroundcolor);
		signCompleteButton.setFont(new Font("서울남산체", Font.BOLD, 16));
		signCompleteButton.setFocusPainted(false);
		signCompleteButton.setForeground(Color.BLACK);
		signCompleteButton.setBounds(15, 300, 360, 35);
		signCompleteButton.setBorderPainted(false);

		// 컴포넌트 추가
		add(titlelabel);
		add(idlabel);
		add(idText);
		add(idButton);
		add(pwlabel);
		add(pwText);
		add(signCompleteButton);
		

		// swing에서 배경색상 설정
		this.getContentPane().setBackground(Color.WHITE);

		// event
		idButton.addActionListener(this);
		signCompleteButton.addActionListener(this);

	}// sign();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == idButton) {// id��ư
			String id = idText.getText();
			MemberDAO dao = new MemberDAO();
			String idcheck = dao.idCheck(id);
			boolean check = true;

			if (idcheck != null) {
				check = false;
			}

			if (id.length() == 0) {
				JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
				return;
			} else if (check) {
				JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다");
				signidcheck = true;

			} else if (check != true) {
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다");
				return;
			}
			
		} else if (e.getSource() == signCompleteButton) {
			String id = idText.getText();
			@SuppressWarnings("deprecation")
			String pwd = pwText.getText();

			if (signidcheck != true) {
				JOptionPane.showMessageDialog(null, "id 중복을 확인해주세요");

			} else if (pwd.length() == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
				return;
			}else {
				JOptionPane.showMessageDialog(null, "회원가입 되었습니다");
				
				// 데이터
				dto = new MemberDTO();
				dto.setId(id);
				dto.setPwd(pwd);

				// DB 
				dao.insertMember(dto);
			}
			//dispose();
		} 
	}
}
