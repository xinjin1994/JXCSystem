package ui.account;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.BackButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import vo.AccountVO;
import vo.GetVO;
import vo.PayVO;

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
	
	private AccountDetailPanel accountDetailPanel;
	
	FatherPanel prePanel;
	AccountAllUIController controller;
	Listener backListener;
	
	MyButton backButton;

	public AccountAllUIController(UIController uiController,MyFrame frame) {
		this.frame = new MyFrame();
		addMainPanel();
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
	
	public void confirmReceipt(GetVO newReceipt){
		confirmReceiptPanel = new ConfirmReceiptPanel(frame, "Image/Account/创建收款单_确认信息.jpg", this,newReceipt);
		frame.setPanel(confirmReceiptPanel);
		frame.repaint();
	}
	
	public void confirmPayment(PayVO newPayment) {
		confirmPaymentPanel = new ConfirmPaymentPanel(frame, "Image/Account/创建付款单_确认信息.jpg", this,newPayment);
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
	 * 以下三个是account模块中的返回按钮，都会返回到主界面
	 * @param prePanel
	 */
	public void setBack_first(FatherPanel prePanel){
		this.prePanel = prePanel;
		BackButton back = new BackButton();
		backButton = back.back_white;
		setBack();
	}
	
	public void setBack_second(FatherPanel prePanel,int x,int y){
		this.prePanel = prePanel;
		BackButton back = new BackButton(x,y);
		backButton = back.back_black;
		setBack();
	}
	
	public void setBack(){
		Listener backListener = new Listener();
		prePanel.add(backButton);
		backButton.addMouseListener(backListener);
	}
	
	   class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			if(e.getSource() == backButton){
				System.out.println("lk");
				frame.remove(prePanel);
				AccountAllUIController.this.addMainPanel();
			}
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		   

//		public void actionPerformed(ActionEvent e) {
//			if(e.getActionCommand().equals("back")){
//				System.out.println("klk");
//				frame.remove(prePanel);
//				delAccountPanel = new DelAccountPanel(frame,"Image/Account/删除账户.jpg",AccountAllUIController.this);
//				frame.setPanel(delAccountPanel);
//				frame.repaint();
//				
//			}
//		
		
	}
}
