package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.FatherPanel;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
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
	AccountblService accountblService;
	public ChangeAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		uiController.setBack_second(this,199,141);
		accountblService =new AccountController();
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
			String oldName = formerName.getText();
			AccountVO oldVO = accountblService.searchAccurateAccount_up(oldName);
			double balance = oldVO.balance;
			String newName = changeName.getText();
			AccountVO newVO = new AccountVO(newName,balance);
			accountblService.updateAccount_up(oldVO, newVO);
//			AccountVO newVO = new AccountVO("hello",10);
			uiController.confirmAcc(newVO, "change");
		}
	}
}
