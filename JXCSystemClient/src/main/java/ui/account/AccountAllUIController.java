package ui.account;


import ui.UIController;
import ui.setting.MyFrame;

public class AccountAllUIController extends UIController{
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
	
	
	public AccountAllUIController(UIController uiController,MyFrame frame) {
		this.frame = new MyFrame();
		new AccountUIController(this, frame);
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
	
	public void confirmReceipt(){
		confirmReceiptPanel = new ConfirmReceiptPanel(frame, "Image/Account/创建收款单_确认信息.jpg", this);
		frame.setPanel(confirmReceiptPanel);
		frame.repaint();
	}
	
	public void confirmPayment() {
		confirmPaymentPanel = new ConfirmPaymentPanel(frame, "Image/Account/创建付款单_确认信息.jpg", this);
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
	
	public void confirmAcc(){
		confirmAccPanel = new ConfirmAccPanel(frame, "Image/Account/确认账户信息.jpg", this);
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
}