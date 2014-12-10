package ui.manager;

import ui.FatherPanel;
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.account.AccountDetailPanel;
import ui.account.AddAccountPanel;
import ui.account.AddPaymentPanel;
import ui.account.AddReceiptPanel;
import ui.account.AllBillsPanel;
import ui.account.ChangeAccountPanel;
import ui.account.ConfirmAccPanel;
import ui.account.ConfirmIniComPanel;
import ui.account.ConfirmIniCusPanel;
import ui.account.ConfirmPaymentPanel;
import ui.account.ConfirmReceiptPanel;
import ui.account.DelAccountPanel;
import ui.account.FindAccountPanel;
import ui.account.IniAccPanel;
import ui.account.IniComPanel;
import ui.account.IniCusPanel;
import ui.account.OpeConPanel;
import ui.account.SalesListPanel;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.SetBack;
import ui.ManagerPanel;
import vo.AccountVO;
import vo.DiscountVO;
import vo.ProGiftVO;
import vo.VoucherVO;

public class ManagerAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	
	private FindAccountPanel findAccountPanel;
	private AddAccountPanel addAccountPanel;
	private DelAccountPanel delAccountPanel;
	private ChangeAccountPanel changeAccountPanel;
	private ConfirmAccPanel confirmAccPanel;
	private AccountDetailPanel accountDetailPanel;
	
	
	private SalesListPanel salesListPanel;
	private AllBillsPanel allBillsPanel;
	private OpeConPanel opeConPanel;
	
	private SetProPanel setProPanel;
	private ConfirmProPanel confirmProPanel;
	private CheckProPanel checkProPanel;
	
	FatherPanel prePanel;
	ManagerAllUIController controller;
	
	MyButton backButton;
	
	public ManagerAllUIController(UIController uiController,MyFrame frame){
		this.frame = frame;
		this.uiController = uiController;
		addMainPanel();
	}

	private void addMainPanel() {
		new ManagerUIController(this, frame);
		frame.repaint();
	}
	
	public void findAccount(){
		findAccountPanel = new FindAccountPanel(frame,"Image/Manager/查找账户.jpg",this,"manager");
		frame.setPanel(findAccountPanel);
		frame.repaint();
	}
	
	public void addAccount(){
		addAccountPanel = new AddAccountPanel(frame, "Image/Manager/增加账户.jpg", this,"manager");
		
		frame.setPanel(addAccountPanel);
		frame.repaint();
	}
	
	public void delAccount() {
		delAccountPanel = new DelAccountPanel(frame,"Image/Manager/删除账户.jpg", this,"manager");
		frame.setPanel(delAccountPanel);
		frame.repaint();
	}
	
	public void changeAccount(){
		changeAccountPanel = new ChangeAccountPanel(frame,"Image/Manager/修改账户.jpg", this,"manager");
		frame.setPanel(changeAccountPanel);
		frame.repaint();
	}
	

	public void confirmAcc(AccountVO acc,String ope){
		confirmAccPanel = new ConfirmAccPanel(frame, "Image/Manager/确认账户信息.jpg",this,acc,ope,"manager");
		frame.setPanel(confirmAccPanel);
		frame.repaint();
	}
	
	public void accountDetail(AccountVO foundAcc){
		System.out.println("OUY");
		accountDetailPanel = new AccountDetailPanel(frame, "Image/Manager/accDetail.jpg", this ,foundAcc);
		frame.setPanel(accountDetailPanel);
		frame.repaint();
	}

	public void salesList(){
		salesListPanel = new SalesListPanel(frame, "Image/Manager/销售明细_查询_背景.jpg", this,"manager");
		frame.setPanel(salesListPanel);
		frame.repaint();
	}
	
	public void allBills(){
		allBillsPanel = new AllBillsPanel(frame, "Image/Manager/经营历程_查询_背景.jpg", this,"manager");
		frame.setPanel(allBillsPanel);
		frame.repaint();
	}
	
	public void opeCon(){
		opeConPanel = new OpeConPanel(frame, "Image/Manager/经营情况_查询_背景.jpg", this,"manager");
		frame.setPanel(opeConPanel);
		frame.repaint();
	}
	
	public void setPro(){
		setProPanel = new SetProPanel(frame, "Image/Manager/promotion/proDo.jpg", this);
		frame.setPanel(setProPanel);
		frame.repaint();
	}
	public void confirmProDis(DiscountVO discount){
		confirmProPanel = new ConfirmProPanel(frame, "Image/Manager/promotion/proDoConfirm.jpg", this, discount);
		frame.setPanel(confirmProPanel);
		frame.repaint();
	}
	public void confirmProGift(ProGiftVO gift) {
		confirmProPanel = new ConfirmProPanel(frame,"Image/Manager/promotion/proDoConfirm.jpg" , this, gift);
		frame.setPanel(confirmProPanel);
		frame.repaint();
	}
	public void confirmProVou(VoucherVO voucher) {
		confirmProPanel = new ConfirmProPanel(frame, "Image/Manager/promotion/proDoConfirm.jpg", this, voucher);
		frame.setPanel(confirmProPanel);
		frame.repaint();
	}
	
	
	public void setBack_first(FatherPanel prePanel){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_first();
	}

	public void setBack_second(FatherPanel prePanel,int x,int y){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_second(x, y);
	}


}
