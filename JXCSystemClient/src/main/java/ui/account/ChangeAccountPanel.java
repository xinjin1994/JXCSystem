package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import vo.AccountVO;
/**
 * 
 * @author ZYC
 *
 */
public class ChangeAccountPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	MyButton forwardButton;
	AccountVO acc;
	MyTextFieldBorder formerName,changeName;
	public ChangeAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,199,141);
		
		setTextField();
		setForward();
		
	}
	private void setTextField() {
		formerName = new MyTextFieldBorder(275,244);
		changeName = new MyTextFieldBorder(275,333);
		
		formerName.setForeground(new ColorFactory().greyFont);
		changeName.setForeground(new ColorFactory().greyFont);
		
		this.add(formerName);
		this.add(changeName);
	}
	
	private void setForward() {
		ForwardButton forward = new ForwardButton(606,394);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			//这里根据原有account从下层传回余额
			acc.name = changeName.getText();
			acc.balance = 0;
			uiController.confirmAcc(acc, "change");
		}
	}
}
