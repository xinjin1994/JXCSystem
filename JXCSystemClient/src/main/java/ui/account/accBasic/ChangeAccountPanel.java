package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/ChangeAccountPanel.java
import ui.FatherPanel;
import ui.UIController;
import ui.manager.ManagerAllUIController;
=======
import ui.account.AccountAllUIController;
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/ChangeAccountPanel.java
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
	ManagerAllUIController managerController;
	AccountAllUIController accountController;

	private MyButton forwardButton;
	AccountVO acc;
<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/ChangeAccountPanel.java
	private MyTextFieldBorder formerName,changeName;
	
	private String type = "account";
=======
	MyTextFieldBorder formerName,changeName;
	AccountblService accountblService;
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/ChangeAccountPanel.java
	public ChangeAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.accountController = uiController;
		this.repaint();
		uiController.setBack_second(this,199,141);
<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/ChangeAccountPanel.java

		init();
	}
	
	public ChangeAccountPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		this.managerController = uiController;
		this.repaint();
		this.type = type;
		uiController.setBack_second(this,199,141);
		init();
	}
	
	private void init(){
=======
		accountblService =new AccountController();
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/ChangeAccountPanel.java
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
<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/ChangeAccountPanel.java
			acc = new AccountVO(changeName.getText(),0);
		//	acc.name = "kl";
		//	acc.name = changeName.getText();
		//	acc.balance = 0;
			if(type.equals("account")){
				accountController.confirmAcc(acc, "change");
			}else if(type.equals("manager")){
				managerController.confirmAcc(acc, "change");
			}
=======
			String oldName = formerName.getText();
			AccountVO oldVO = accountblService.searchAccurateAccount_up(oldName);
			double balance = oldVO.balance;
			String newName = changeName.getText();
			AccountVO newVO = new AccountVO(newName,balance);
			accountblService.updateAccount_up(oldVO, newVO);
//			AccountVO newVO = new AccountVO("hello",10);
			uiController.confirmAcc(newVO, "change");
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/ChangeAccountPanel.java
		}
	}
}
