package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/AccountDetailPanel.java
import ui.FatherPanel;
import ui.UIController;
import ui.manager.ManagerAllUIController;
=======
import ui.account.AccountAllUIController;
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/AccountDetailPanel.java
import ui.setting.ColorFactory;
import ui.setting.FatherPanel;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.AccountVO;
/**
 * 账户具体信息
 * @see accountVO
 * @author ZYC
 *
 */
public class AccountDetailPanel extends FatherPanel {
	AccountAllUIController accountController;
	ManagerAllUIController managerController;
	protected MyLabel name,balance;
	protected AccountVO fountAcc;
	
	
	public AccountDetailPanel(MyFrame frame,String url,
			AccountAllUIController uiController,AccountVO foundAcc){
		super(frame,url,uiController);
		this.accountController = uiController;
		this.fountAcc = foundAcc;
		this.repaint();
		
		accountController.setBack_first(this);
		setLabel();
		
	}
	
	public AccountDetailPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,AccountVO foundAcc){
		super(frame,url,uiController);
		this.managerController = uiController;
		this.fountAcc = foundAcc;
		this.repaint();
		
		managerController.setBack_first(this);
		setLabel();
		
	}
	/**
	 * 设置帐户名称和余额的label
	 */
	private void setLabel() {
		name = new MyLabel(333, 223, 195,60);
		balance = new MyLabel(333, 300, 195, 60);
		
		name.setForeground(new ColorFactory().greyFont);
		balance.setForeground(new ColorFactory().greyFont);
		
		this.add(name);
		this.add(balance);
		
		name.setText(fountAcc.name);
		balance.setText(String.valueOf(fountAcc.balance));
	}

}
