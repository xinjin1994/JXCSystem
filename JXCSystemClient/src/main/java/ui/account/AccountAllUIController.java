package ui.account;


import ui.AccountPanel;
import ui.FatherPanel;
import ui.UIController;
import ui.account.accBasic.AddAccountPanel;
import ui.account.accBasic.ChangeAccountPanel;
import ui.account.accBasic.ConfirmAccPanel;
import ui.account.accBasic.DelAccountPanel;
import ui.account.accBasic.FindAccountPanel;
import ui.account.ini.ConfirmIniComPanel;
import ui.account.ini.ConfirmIniCusPanel;
import ui.account.ini.IniAccPanel;
import ui.account.ini.IniComPanel;
import ui.account.ini.IniCusPanel;
import ui.account.list.AllBillsPanel;
import ui.account.list.OpeConPanel;
import ui.account.list.SalesListPanel;
import ui.account.payRe.AddPaymentPanel;
import ui.account.payRe.AddReceiptPanel;
import ui.account.payRe.ConfirmPaymentPanel;
import ui.account.payRe.ConfirmReceiptPanel;
import ui.manager.ManagerAllUIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.SetBack;
import vo.AccountVO;
import vo.bill.GetVO;
import vo.bill.PayVO;

public class AccountAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	
	static private AccountPanel accountPanel;
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
	private ManagerAllUIController managerController;
	
	FatherPanel prePanel;
	AccountAllUIController controller;
	
	MyButton backButton;

	public AccountAllUIController(UIController uiController,MyFrame frame) {
		this.frame = frame;
		addMainPanel();
	}
	public AccountAllUIController(UIController uiController,MyFrame frame,ManagerAllUIController managerController){
		this.frame = frame;
		this.managerController = managerController;
	}
	
	public void addMainPanel(){
		new AccountUIController(this, frame);
		frame.repaint();
	}
	
	public void findAccount(){
		findAccountPanel = new FindAccountPanel(frame,"Image/Account/查找账户.jpg",this);
		frame.setPanel(findAccountPanel);
		frame.repaint();
	}
	
	public void addAccount(){
		addAccountPanel = new AddAccountPanel(frame,"Image/Account/增加账户.jpg",this);
		frame.setPanel(addAccountPanel);
		frame.repaint();
	}
	
	public void delAccount() {
		delAccountPanel = new DelAccountPanel(frame,"Image/Account/删除账户.jpg",this);
		frame.setPanel(delAccountPanel);
		frame.repaint();
	}
	
	public void changeAccount(){
		changeAccountPanel = new ChangeAccountPanel(frame,"Image/Account/修改账户.jpg", this);
		frame.setPanel(changeAccountPanel);
		frame.repaint();
	}
	
	public void addReceipt(){
		addReceiptPanel = new AddReceiptPanel(frame, "Image/Account/收款单_背景.jpg", this);
		frame.setPanel(addReceiptPanel);
		frame.repaint();
	}
	
	public void addPayment(){
		addPaymentPanel = new AddPaymentPanel(frame, "Image/Account/创建付款单_背景.jpg", this);
		frame.setPanel(addPaymentPanel);
		frame.repaint();
	}
	
	public void confirmReceipt(GetVO newReceipt,String person,String operater,double totalValue,double balanceValue){
		confirmReceiptPanel = new ConfirmReceiptPanel(frame, "Image/Account/创建收款单_确认信息.jpg", this,
				newReceipt,person,operater,totalValue,balanceValue);
		frame.setPanel(confirmReceiptPanel);
		frame.repaint();
	}
	
	public void confirmPayment(PayVO newPayment,String person,String operate,double totalValue,double balanceValue) {
		confirmPaymentPanel = new ConfirmPaymentPanel(frame, "Image/Account/创建付款单_确认信息.jpg", this,
				newPayment,person,operate,totalValue,balanceValue);
		frame.setPanel(confirmPaymentPanel);
		frame.repaint();
	}
	
	public void salesList(){
		salesListPanel = new SalesListPanel(frame, "Image/Account/销售明细_查询_背景.jpg", this);
		frame.setPanel(salesListPanel);
		frame.repaint();
	}
	
	public void allBills(){
		allBillsPanel = new AllBillsPanel(frame, "Image/Account/经营历程_查询_背景.jpg", this);
		frame.setPanel(allBillsPanel);
		frame.repaint();
	}
	
	public void opeCon(){
		opeConPanel = new OpeConPanel(frame, "Image/Account/经营情况_查询_背景.jpg", this);
		frame.setPanel(opeConPanel);
		frame.repaint();
	}
	
	public void confirmAcc(AccountVO acc,String ope){
		confirmAccPanel = new ConfirmAccPanel(frame, "Image/Account/确认账户信息.jpg", this,acc,ope);
		frame.setPanel(confirmAccPanel);
		frame.repaint();
	}
	
	public void confirmAcc(AccountVO acc,String ope,AccountVO newAcc){
		confirmAccPanel = new ConfirmAccPanel(frame, "Image/Account/确认账户信息.jpg", this,acc,ope,newAcc);
		frame.setPanel(confirmAccPanel);
		frame.repaint();
	}
	
	public void iniCom(){
		iniComPanel = new IniComPanel(frame, "Image/Account/iniAddCom.jpg", this);
		frame.setPanel(iniComPanel);
		frame.repaint();
	}
	
	public void iniCus(){
		iniCusPanel = new IniCusPanel(frame, "Image/Account/iniAddCus.jpg", this);
		frame.setPanel(iniCusPanel);
		frame.repaint();
	}
	
	public void iniAcc(){
		iniAccPanel = new IniAccPanel(frame, "Image/Account/iniAddAcc.jpg", this);
		frame.setPanel(iniAccPanel);
		frame.repaint();
	}
	
	public void confirmIniCom(){
		confirmIniComPanel = new ConfirmIniComPanel(frame, "Image/Account/iniConCom.jpg", this);
		frame.setPanel(confirmIniComPanel);
		frame.repaint();
	}
	
	public void confirmIniCus(){
		confirmIniCusPanel = new ConfirmIniCusPanel(frame, "Image/Account/iniConCus.jpg", this);
		frame.setPanel(confirmIniCusPanel);
		frame.repaint();
	}
	
	public void accountDetail(AccountVO foundAcc){
		accountDetailPanel = new AccountDetailPanel(frame, "Image/Account/accDetail.jpg", this ,foundAcc);
		frame.setPanel(accountDetailPanel);
		frame.repaint();
	}
	
	
	/**
	 * 以下两个是account模块中的返回按钮，都会返回到主界面
	 * @param prePanel
	 */
	
	public void setBack_first(FatherPanel prePanel){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_first();
	}

	public void setBack_second(FatherPanel prePanel,int x,int y){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_second(x, y);
	}
}
