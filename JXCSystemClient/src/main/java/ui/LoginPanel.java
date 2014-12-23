package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;

public class LoginPanel extends FatherPanel {

	private static final long serialVersionUID = 3788130429021132822L;
	private static final int CENTER = 0;
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
	
	private MyButton forwardButton;
	private ResultPanelController resController;
	private String failedAddress;
	
	public LoginPanel(MyFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		resController = new ResultPanelController(frame, this);
		
		this.failedAddress = "login";
		this.addUserField();
		this.addField();
		this.addLogin();
		this.repaint();
	}
	
	
	private void addUserField() {
		user = new JTextField("请输入用户名", 20);
		user.setHorizontalAlignment(CENTER);
		user.setOpaque(false);
		Color borderColor = new Color(230, 230, 230);
		user.setBorder(new LineBorder(borderColor));
		
		user.setFont(new FontFactory(20).font);
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
		jtf.setHorizontalAlignment(CENTER);
		jtf.setOpaque(false);
		Color borderColor = new Color(230, 230, 230);
		jtf.setBorder(new LineBorder(borderColor));
		
		jtf.setFont(new FontFactory(20).font);
		jtf.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		jtf.setBorder(BorderFactory.createEmptyBorder());
		jtf.addFocusListener(new TextListener());
		this.add(jtf);
	}

	private void addPasswordField() {
		password = new JPasswordField();
		password.setHorizontalAlignment(CENTER);
		password.setBounds(inputX, inputY + interval, inputWidth, inputHeight);
		
		
		password.setOpaque(false);
		Color borderColor = new Color(230, 230, 230);
		password.setBorder(new LineBorder(borderColor));
		password.addFocusListener(new TextListener());
		this.add(password);
	}

	private void addLogin() {
		ForwardButton forward = new ForwardButton(229, 127);
		forwardButton = forward.forward_black;
		this.add(forwardButton);
		
//		login = new JButton();
//		login.setBounds(228, 126, 43, 44);
//		login.setBorder(null);
//		login.setContentAreaFilled(false); // 将按钮设置为透明
		forwardButton.addActionListener(new LoginListener());
//		this.add(login);
	}

//	private void addFailure() {
//		failure = new JLabel("您输入的帐户名或密码有误，请重新输入！");
//		failure.setBounds(inputX, inputY + 150, 2 * inputWidth, inputHeight);
//		failure.setFont(new Font("宋体", 0, 20));
//		failure.setForeground(Color.red);
//		this.add(failure);
//		this.repaint();
//	}

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
			controller.setTempPanel(LoginPanel.this);
			
			UserblService userbl = new UserController();
			
			try {
				userText = user.getText();
				passwordText = new String(password.getPassword());
				int identity = userbl.login_up(userText, passwordText);
				switch (identity) {
				case 0:
					controller.AdminPanel();
					break;
				case 1:
					controller.CommodityPanel();;
					break;
				case 2:
					controller.SalesManagerPanel();
					break;
				case 3:
					controller.SalesManagerPanel();
					break;
				case 4:
					controller.AccountPanel();
					break;
				case 5:
					controller.AccountPanel();
					break;
				case 6:
					controller.ManagerPanel();
					break;
				default:
					frame.remove(LoginPanel.this);
					resController.failed("用户信息不存在！请检查输入！", failedAddress);
					frame.repaint();
				}
				user.setText("");
				password.setText("");

			} catch (Exception e2) {
				frame.remove(LoginPanel.this);
				resController.failed("存在输入为空！", failedAddress);
				frame.repaint();
			}
				
			
			
			
		}

	}

}
