package ui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.UserVO;

public class AddUserPanel extends FatherPanel implements ActionListener{
	
	private AdminAllUIController uiController;

	private MyFrame frame;
	private MyTextFieldBorder textInfos[] = new MyTextFieldBorder[5];
	private MyButton forwardButton;
	private MyLabel label;
	
	private UserVO user;
	
	private int dutyGet;
	
	public AddUserPanel(MyFrame frame, String url, AdminAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		
		controller.setBack_second(this,188,70);
	
		addTextField();
		addLabel();
		
		setForward();
		this.repaint();
	}
	
	private void setForward() {
		ForwardButton forward = new ForwardButton(700, 500);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	
	public void addLabel(){
		label = new MyLabel(320,145+75*5,320,35);
		this.add(label);
	}
	private void addTextField() {
		for(int i = 0;i < textInfos.length;i++){
			textInfos[i] = new MyTextFieldBorder(320, 145 + 75 * i);
			this.add(textInfos[i]);
			textInfos[i].setForeground(new ColorFactory().greyFont);
		}
		textInfos[4].addFocusListener(new TextListener());
	}
	
	class TextListener implements FocusListener{

		public void focusGained(FocusEvent e) {
			label.setText("");
		}

		public void focusLost(FocusEvent e) {
			
		}
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == forwardButton){
			boolean isLegal = true;
			try{
				dutyGet = Integer.parseInt(textInfos[2].getText());
			}catch(Exception e){
				isLegal = false;
			}
			if(!textInfos[3].getText().equals(textInfos[4].getText())){
				label.setText("请重新确认密码！");
			}else if(textInfos[0].getText().equals("")||textInfos[1].getText().equals("")||textInfos[2].getText().equals("")||
					textInfos[3].getText().equals("")||textInfos[4].getText().equals("")||isLegal == false||dutyGet<0||dutyGet>6){
				label.setText("请重新确认输入信息");
			}else {
			frame.remove(this);
			frame.setPanel(uiController.getMainPanel());
			user = new UserVO(textInfos[0].getText(),textInfos[1].getText()
					,textInfos[3].getText(),Integer.parseInt(textInfos[2].getText()));
			uiController.confirmUserPanel(user,"添加");
			}
			frame.repaint();
		}
	}

}