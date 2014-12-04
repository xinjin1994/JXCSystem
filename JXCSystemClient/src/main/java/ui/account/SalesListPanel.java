package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;










import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import ui.setting.MyTextFieldTrans;
/**
 * 销售明细查询panel
 * 查找结束后返回主界面，列表显示信息
 * @author ZYC
 *
 */
public class SalesListPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	MyButton forwardButton;
	MyTextFieldBorder timeBegin,timeFinish,commodity,stock,customer,agent;
	
	public SalesListPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,146,57);
		setForward();
		setTextField();
		
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
		stock = new MyTextFieldBorder(293,344);
		customer = new MyTextFieldBorder(293, 418);
		agent = new MyTextFieldBorder(293, 495);
		
		MyTextFieldBorder []typeIn = new MyTextFieldBorder[]{timeBegin,timeFinish,
				commodity,stock,customer,agent};
		
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
