package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
	private JButton login;
	private String userText;
	private String passwordText;
	private JLabel failure;
	

	public LoginPanel(JFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		this.addUserField();
		this.addField();
		this.addLogin();
		this.repaint();
	}
	
	
	private void addUserField() {
		user = new JTextField("请输入用户名", 20);
		user.setBounds(inputX, inputY, inputWidth, inputHeight);
		user.setBorder(BorderFactory.createEmptyBorder());
		user.addFocusListener(new TextListener());
		this.add(user);
	}

	/**
	 * 提示请输入密码
	 */
	private void addField() {
		jtf = new JTextField("请输入密码", 20);
		jtf.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		jtf.setBorder(BorderFactory.createEmptyBorder());
		jtf.addFocusListener(new TextListener());
		this.add(jtf);
	}

	private void addPasswordField() {
		password = new JPasswordField();
		password.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.addFocusListener(new TextListener());
		this.add(password);
	}

	private void addLogin() {
		login = new JButton();
		login.setBounds(228, 126, 43, 44);
		login.setBorder(null);
		login.setContentAreaFilled(false); // 将按钮设置为透明
		login.addActionListener(new LoginListener());
		this.add(login);
	}

	private void addFailure() {
		failure = new JLabel("您输入的帐户名或密码有误，请重新输入！");
		failure.setBounds(inputX, inputY + 150, 2 * inputWidth, inputHeight);
		failure.setFont(new Font("宋体", 0, 20));
		failure.setForeground(Color.red);
		this.add(failure);
		this.repaint();
	}

	public void remove() {
		this.remove(jtf);
	}

	class TextListener implements FocusListener {

		public void focusGained(FocusEvent e) {
			if(e.getSource() == user) {
				user.setText("");
			} else if(e.getSource() == password) {
				password.setText("");
			} else if(e.getSource() == jtf){
				jtf.setText("");
				remove();
				addPasswordField();
			}
		}

		public void focusLost(FocusEvent e) {
		}

	}


	class LoginListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			UserblService userbl = new UserController();
			int identity = userbl.login(userText, passwordText);
			identity = 3;
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
				// System.out.println("hello");
				addFailure();

			}

		}

	}

}
