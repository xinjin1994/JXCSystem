package ui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
import vo.UserVO;

public class AddUserPanel extends FatherPanel implements ActionListener{
	private MyFrame frame;
	private AdminAllUIController uiController;
	
	private MyTextFieldBorder textInfos[] = new MyTextFieldBorder[5];
	private MyButton forwardButton;
	
	
	
	private UserVO user;
	public AddUserPanel(MyFrame frame, String url, AdminAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		
		controller.setBack_second(this,188,70);
	
		addTextField();
		
		setForward();
		this.repaint();
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(700, 500);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	private void addTextField() {
		for(int i = 0;i < textInfos.length;i++){
			textInfos[i] = new MyTextFieldBorder(320, 145+75*i);
			this.add(textInfos[i]);
			textInfos[i].setForeground(new ColorFactory().greyFont);
		}
	}
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == forwardButton){
			frame.remove(this);
			frame.setPanel(uiController.getMainPanel());
//			user = new UserVO(textInfos[0].getText(),textInfos[1].getText()
//					,textInfos[2].getText(),Integer.parseInt(textInfos[4].getText()));
			uiController.confirmUserPanel(user,"添加");
			frame.repaint();
		}
	}

}
