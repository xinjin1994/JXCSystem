package ui.account;

import ui.FatherPanel;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.SetBack;
import vo.AccountVO;
import vo.initial.InitialCommodityVO;
/**
 * 账户具体信息
 * @see accountVO
 * @author ZYC
 *
 */
public class AccountDetailPanel extends FatherPanel {
	protected AccountAllUIController accountController;
	protected ManagerAllUIController managerController;
	protected MyLabel name,balance;
	protected AccountVO fountAcc;
	
	
	public AccountDetailPanel(MyFrame frame,String url,
			AccountAllUIController uiController,AccountVO foundAcc){
		super(frame,url,uiController);
		this.accountController = uiController;
		this.fountAcc = foundAcc;
		this.repaint();
		SetBackAcc();
		
		setLabel();
		
	}
	
	public AccountDetailPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,AccountVO foundAcc){
		super(frame,url,uiController);
		this.managerController = uiController;
		this.fountAcc = foundAcc;
		this.repaint();
		SetBackMan();
		
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
	
	protected void SetBackAcc(){
		accountController.setBack_first(this);
	}
	protected void SetBackMan(){
		managerController.setBack_first(this);
	}
}
