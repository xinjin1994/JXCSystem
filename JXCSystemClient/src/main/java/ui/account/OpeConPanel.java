package ui.account;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
/**
 * 经营情况查询panel
 * 查询结束后返回主界面
 * @author ZYC
 *
 */
public class OpeConPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	MyTextFieldBorder timeBegin,timeFinish;
	MyButton forwardButton;
	public OpeConPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,149,137);
		setTextField();
		setForward();
		
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(635,406);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	private void setTextField() {
		timeBegin = new MyTextFieldBorder(297,231);
		timeFinish = new MyTextFieldBorder(297, 333);
		
		timeBegin.setForeground(new ColorFactory().greyFont);
		timeFinish.setForeground(new ColorFactory().greyFont);
		
		this.add(timeBegin);
		this.add(timeFinish);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			uiController.addMainPanel();
		}
	}
}
