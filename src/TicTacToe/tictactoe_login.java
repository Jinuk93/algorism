// 실행시 , 제일먼저 뜨는 로그인창
package TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import TicTacToe.tictactoe_sign;
import TicTacToe.tictactoe_login.FrameDragListener;
import TicTacToe.MemberDAO;
//import TicTacToe.TicTacToc_Menu;

@SuppressWarnings("serial")
public class tictactoe_login extends JFrame {
	
	private JPanel basePanel;
	
	JPanel signPanel;
	JLabel TicTacToeLabel = new JLabel("Username"); ;
	private JLabel titlelabel = new JLabel(); 
	private int aa;
	
	private JTextField idT, pwdT;						 // 아이디, 패스워드 텍스트필드(입력칸)
	private JButton loginbtn, Signbtn;					 // 로그인, 회원가입 버튼
	
	public static final Color login_backgroundcolor = new Color(255, 255, 255);
	public static final Color btn_backgroundcolor = new Color(197, 199, 196);
	
    private MemberDAO dao = new MemberDAO();
    FrameDragListener frameDragListener;
	
	public tictactoe_login() {
		
		super("TicTacToe");
		frameDragListener = new FrameDragListener(this);
		
		createComponent();
		addComponent();
		addListener();
		
		this.setSize(500, 650);    				      //사이즈 650x650
		this.setLocationRelativeTo(null); 			  //화면 중앙출력(고정)
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 'x'버튼 눌렀을시, 종료
													  //부모 프레임을 닫았을 때 메모리에서 제거되도록 설정
		this.setVisible(true); 						  //창을 보여준다(true)
		this.setResizable(false); 					  //창 크기 고정 실시, (650x650) 고정, 변경불가능
		
	}
	public void createComponent() { 				  //첫번째 화면 컴포넌트 생성
		
		basePanel = new JPanel(null); 				  // 레이아웃 해제
		basePanel.setBackground(login_backgroundcolor);
		
		// 라벨
		titlelabel = new JLabel("TicTacToe");
		titlelabel.setFont(new Font("arial", Font.BOLD, 50));
		titlelabel.setSize(250, 120);
		titlelabel.setLocation(115, 100);
		
		loginbtn = new JButton("Login");
		Signbtn = new JButton("Sign Up");
		
		idT = new JTextField("Username");   		  // 아이디 입력 TextField
		pwdT = new JPasswordField();			      // 비밀번호 입력 TextField, 자동 암호화		
		pwdT.setText("Password");
		
		basePanel.add(loginbtn); 					  // basePanel라는 패널에 loginbtn 버튼 추가
		basePanel.add(Signbtn); 
	
		//setBounds(가로위치, 세로위치, 가로길이, 세로길이); 
		loginbtn.setBounds(160, 450, 125, 30);
		loginbtn.setBackground(btn_backgroundcolor);
		loginbtn.setFocusPainted(false);
		loginbtn.setBorderPainted(false); 			  // 버튼 테두리 제거
		
		Signbtn.setBounds(300, 450, 125, 30);		  // 회원가입 버튼 위치조정
		Signbtn.setBackground(btn_backgroundcolor);
		Signbtn.setFocusPainted(false);
		Signbtn.setBorderPainted(false); 			  // 버튼 테두리 제거
		
	}
	
	public void addComponent() { // 첫번째 화면 컴포넌트 부착
		
		basePanel.add(titlelabel); // TicTacToe main 라벨추가

		JPanel pnlLogin = new JPanel(new GridLayout(5, 1, 5, 3));
		pnlLogin.setBackground(login_backgroundcolor);
		pnlLogin.add(idT);
		pnlLogin.add(pwdT);
		pnlLogin.add(loginbtn);
		pnlLogin.add(Signbtn);
		
		pnlLogin.setSize(285, 200);
		pnlLogin.setLocation(100, 265);
		basePanel.add(pnlLogin);
		add(basePanel); // 프레임 잡고있는 panel
		
		basePanel.add(TicTacToeLabel);
		add(basePanel); // 프레임 잡고있는 panel
	}
	
	public void addListener() {
		// 로그인 버튼 이벤트 처리
		loginbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 데이터
				String id = idT.getText().trim();
				String pwd = pwdT.getText().trim();

				// DB
				String name = dao.loginMember(id, pwd);
				boolean check = false;
				if (name != null) {
					check = true;
				}

				if (id.length() == 0 || pwd.length() == 0) {
					JOptionPane.showMessageDialog(null, "로그인 정보를 입력하세요");
					return;
				} else if (name == null) {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀렸습니다.");
					return;
				} else if (check) {		
			// 로그인 성공 후의 화면	
			new tictactoe_menu().setVisible(true); // 윈도우 닫기버튼 이벤트 처리
			aa = 1;
			// 사용자 정보에 대한 DB를 새로운 JFrame에 가져다 줘야하지 않을까
				}
			}
		});

		// 회원가입 창 생성( 회원가입 버튼 눌렀을 시 )
		Signbtn.addActionListener(new ActionListener() { // 윈도우 닫기버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				new tictactoe_sign();
			}
		});

		// 화면에 마우스 이벤트 처리를 통해 드래그 이동을 구현한다
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}

	// frameDragListener관련 마우스 이벤트
	public static class FrameDragListener extends MouseAdapter {

		private final JFrame frame;
		private Point mouseDownCompCoords = null;

		public FrameDragListener(JFrame frame) {
			this.frame = frame;
		}
		public void mouseReleased(MouseEvent e) {
			mouseDownCompCoords = null;
		}
		public void mousePressed(MouseEvent e) {
			mouseDownCompCoords = e.getPoint();
		}
		public void mouseDragged(MouseEvent e) {
			Point currCoords = e.getLocationOnScreen();
			frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
		}
	}
}
