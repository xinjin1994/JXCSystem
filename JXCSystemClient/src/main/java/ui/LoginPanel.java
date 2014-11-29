package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;

public class LoginPanel extends FatherPanel {

	private static final long serialVersionUID = 3788130429021132822L;
	private JTextField user;
	private JPasswordField password;
	private JTextField jtf;
	private int inputWidth = 260;
	private int inputHeight = 38;
	private int inputX = 62;
	private int inputY = 233;
	private int interval = 105;
	private int exitWidth = 27;
	private int exitHeight = 27;
	private int exitX = 759;
	private int exitY = 1;
	private int miniX = 711;
	private JButton login;
	private String userText;
	private String passwordText;
	private JLabel failure;
	private JLabel close1, close2;
	private JLabel minimize1,minimize2;
	private ImageIcon closeImage, closeImage2, miniImage1, miniImage2;

	public LoginPanel(JFrame frame,String url,UIController controller) {
        super(frame,url,controller);
		this.addUserField();
		this.addField();
		// this.addPasswordField();
		this.addCloseLabel();
		this.addMiniLabel();
		this.addLogin();
		this.repaint();
	}

	private void addMiniLabel(){
		miniImage1 = new ImageIcon("Image/mini.png");
		miniImage2 = new ImageIcon("Image/mini-pressON.png");
		minimize1 = new JLabel(miniImage1);
		minimize1.setBounds(miniX, exitY, exitWidth, exitHeight);
		minimize1.addMouseListener(new MiniListener());
		this.add(minimize1);
		minimize2 = new JLabel(miniImage2);
		minimize2.setBounds(exitX, exitY, exitWidth, exitHeight);
		minimize2.setVisible(false);
		this.add(minimize2);
	}
	
	class MiniListener implements MouseListener{

		int times=0;
		public void mouseClicked(MouseEvent e) {
			frame.setExtendedState(JFrame.ICONIFIED);//最小化
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			 if(times==0||times==1){
	             minimize1.setVisible(false);
	             minimize2.setVisible(true);
	             }
				 times++;	
		}

		public void mouseExited(MouseEvent e) {
			  minimize2.setVisible(false); 
				minimize1.setVisible(true);
				times=0;
		}
		
	}
	private void addCloseLabel() {
		closeImage = new ImageIcon("Image/exit.png");
		closeImage2 = new ImageIcon("Image/exit-pressON.png");
		close1 = new JLabel(closeImage);
		close1.setBounds(exitX, exitY, exitWidth, exitHeight);
		close1.addMouseListener(new closeListener());
		this.add(close1);
		close2 = new JLabel(closeImage2);
		close2.setBounds(exitX, exitY, exitWidth, exitHeight);
		close2.setVisible(false);
		this.add(close2);
	}

	class closeListener implements MouseListener {

		int times=0;
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			 if(times==0||times==1){
             close1.setVisible(false);
             close2.setVisible(true);
             }
			 times++;
		}

		public void mouseExited(MouseEvent e) {
            close2.setVisible(false); 
			close1.setVisible(true);
			times=0;
		}

	}

	private void addUserField() {
		user = new JTextField("请输入用户名", 20);
		user.setBounds(inputX, inputY, inputWidth, inputHeight);
		user.setBorder(BorderFactory.createEmptyBorder());
		user.addFocusListener(new UserListener());
		this.add(user);
	}

	private void addField() {
		jtf = new JTextField("请输入密码", 20);
		jtf.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		jtf.setBorder(BorderFactory.createEmptyBorder());
		jtf.addFocusListener(new AddListener());
		this.add(jtf);
	}

	private void addPasswordField() {
		password = new JPasswordField();
		password.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.addFocusListener(new PasswordListener());
		this.add(password);
	}

	private void addLogin() {
		login = new JButton();
		login.setBounds(228, 126, 43, 44);
		login.setBorder(null);
		login.setContentAreaFilled(false);//将按钮设置为透明
		login.addActionListener(new LoginListener());
		this.add(login);
	}

	private void addFailure() {
		failure = new JLabel("您输入的帐户名或密码有误，请重新输入！");
		failure.setBounds(inputX, inputY + 150, 2*inputWidth, inputHeight);
		failure.setFont(new Font("宋体", 0, 20));
		failure.setForeground(Color.red);
		this.add(failure);
		this.repaint();
	}

	public void remove() {
		this.remove(jtf);
	}

	class AddListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			jtf.setText("");
			remove();
			addPasswordField();
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class UserListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			user.setText("");
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class PasswordListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			password.setText("");
		}

		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class LoginListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("hello");
			UserblService userbl = new UserController();
			int identity = userbl.login(userText, passwordText);
//			identity=1;
			userText = user.getText();
			passwordText = new String(password.getPassword());
			switch (identity) {
			case 0:
				controller.AdminPanel();
				break;
			case 1:
				controller.StockPersonPanel();
				break;
			case 2:
				controller.SalesPersonPanel();
				break;
			case 3:
				controller.SalesManagerPanel();
				break;
			case 4:
				controller.FinPersonPanel();
				break;
			case 5:
				controller.FinManagerPanel();
				break;
			case 6:
				controller.ManagerPanel();
				break;
			default:
				// 登陆失败
//				System.out.println("hello");
				addFailure();

			}

		}

	}

}