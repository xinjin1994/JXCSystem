package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;

public class LoginPanel extends FatherPanel {

	private UIController controller;
	private JTextField user;
	private JPasswordField password;
	private int inputWidth = 260;
	private int inputHeight = 38;
	private int inputX = 62;
	private int inputY = 233;
	private int interval = 105;
	private JButton login;
	private String userText;
	private String passwordText;

	public LoginPanel(String url, UIController controller) {
		super(url);
		this.controller = controller;
		user = new JTextField("请输入用户名", 20);
		user.setBounds(inputX, inputY, inputWidth, inputHeight);
		user.setBorder(BorderFactory.createEmptyBorder());
		userText = user.getText();
		user.addFocusListener(new UserListener());
		password = new JPasswordField("请输入密码", 20);
		password.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		password.setBorder(BorderFactory.createEmptyBorder());
		passwordText = new String(password.getPassword());
		password.addFocusListener(new PasswordListener());
		login = new JButton();
		login.setBounds(228, 126, 43, 44);
		login.setBorder(BorderFactory.createEmptyBorder());
		login.addActionListener(new LoginListener());
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
			UserblService userbl = new UserController();
			int identity = userbl.login(userText, passwordText);
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
				//登陆失败
			}
           
            	
		}

	}

}
