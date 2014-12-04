package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
/**
 * 查询经营历程对话框
 * 查找结束后返回主界面列表显示
 * @author ZYC
 * 
 */
public class AllBillsPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	MyButton forwardButton;
	MyTextFieldBorder timeBegin,timeFinish,commodity,billType,customer,agent;
	
	public AllBillsPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,141,57);
		setTextField();
		setForward();
	}
	
	private void setForward() {
		ForwardButton forward = new ForwardButton(677,492);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	private void setTextField() {
		timeBegin = new MyTextFieldBorder(293,130);
		timeFinish = new MyTextFieldBorder(293,194);
		commodity = new MyTextFieldBorder(293, 269);
		billType = new MyTextFieldBorder(293,344);
		customer = new MyTextFieldBorder(293, 418);
		agent = new MyTextFieldBorder(293, 495);
	
		MyTextFieldBorder []typeIn = new MyTextFieldBorder[]{timeBegin,timeFinish,
				commodity,billType,customer,agent};
		
		for(int i = 0;i < typeIn.length;i++){
			typeIn[i].setForeground(new ColorFactory().greyFont);
			this.add(typeIn[i]);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			uiController.addMainPanel();
		}
		
	}
}
