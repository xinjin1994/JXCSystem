package ui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.UserVO;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;

public class DelUserPanel extends FatherPanel implements ActionListener{
	private MyFrame frame;
	private AdminAllUIController adminAllUIController;
	
	private MyButton forwardButton;
	private MyTextFieldBorder idTextField;
	
	private UserVO user;
	
	private UserblService userblService;
	
	public DelUserPanel(MyFrame frame, String url, AdminAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.adminAllUIController = controller;
		
		controller.setBack_second(this,195,168);
		
		addTextField();
		setForward();
		
		userblService = new UserController();
		
		this.repaint();
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(583, 333);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	private void addTextField() {
		idTextField = new MyTextFieldBorder(284,243);
		this.add(idTextField);
		idTextField.setForeground(new ColorFactory().greyFont);
	}
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == forwardButton){
			frame.remove(this);
			frame.setPanel(adminAllUIController.getMainPanel());
			/*
			 * user是从下层搜索到的
			 * 
			 */
//			user = userblService.searchUser_up(idTextField.getText());
			user = new UserVO("21", "2", "2", 1);
			adminAllUIController.confirmUserDel(user,"删除");
			frame.repaint();
		}
	}

}
