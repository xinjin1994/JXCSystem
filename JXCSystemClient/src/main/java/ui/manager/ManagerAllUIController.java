package ui.manager;

import ui.UIController;
import ui.account.AccountAllUIController;
import ui.account.ConfirmIniComPanel;
import ui.account.ConfirmIniCusPanel;
import ui.account.accBasic.AccountDetailPanel;
import ui.account.accBasic.AddAccountPanel;
import ui.account.accBasic.ChangeAccountPanel;
import ui.account.accBasic.ConfirmAccPanel;
import ui.account.accBasic.DelAccountPanel;
import ui.account.accBasic.FindAccountPanel;
import ui.account.ini.IniAccPanel;
import ui.account.ini.IniComPanel;
import ui.account.ini.IniCusPanel;
import ui.account.list.AddPaymentPanel;
import ui.account.list.AddReceiptPanel;
import ui.account.list.ConfirmPaymentPanel;
import ui.account.list.ConfirmReceiptPanel;
import ui.account.menu.AllBillsPanel;
import ui.account.menu.OpeConPanel;
import ui.account.menu.SalesListPanel;
import ui.setting.FatherPanel;
import ui.setting.MyButton;
import ui.setting.MyFrame;

public class ManagerAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	
	private FindAccountPanel findAccountPanel;
	private AddAccountPanel addAccountPanel;
	private DelAccountPanel delAccountPanel;
	private ChangeAccountPanel changeAccountPanel;
	
	private AddReceiptPanel addReceiptPanel;
	private AddPaymentPanel addPaymentPanel;
	
	private SalesListPanel salesListPanel;
	private AllBillsPanel allBillsPanel;
	private OpeConPanel opeConPanel;
	
	private ConfirmAccPanel confirmAccPanel;
	private ConfirmReceiptPanel confirmReceiptPanel;
	private ConfirmPaymentPanel confirmPaymentPanel;
	
	private ConfirmIniComPanel confirmIniComPanel;
	private ConfirmIniCusPanel confirmIniCusPanel;
	
	private IniComPanel iniComPanel;
	private IniCusPanel iniCusPanel;
	private IniAccPanel iniAccPanel;
	
	private AccountDetailPanel accountDetailPanel;
	
	FatherPanel prePanel;
	AccountAllUIController controller;
//	Listener backListener;
	
	MyButton backButton;
	
	public ManagerAllUIController(UIController uiController,MyFrame frame){
		this.frame = frame;
		addMainPanel();
	}

	private void addMainPanel() {
		new ManagerUIController(this, frame);
		frame.repaint();
	}

}
