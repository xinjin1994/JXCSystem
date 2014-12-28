package ui.account.payRe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import po.PaymentPO;
import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.Button.SaveButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;
import vo.CustomerVO;
import vo.bill.GetVO;
import vo.bill.ItemList;
import vo.bill.PayVO;
import businesslogic.accountbl.AccountController;
import businesslogic.salesbl.SalesController;
import businesslogicservice.accountblservice.AccountblService;
import businesslogicservice.salesblservice.SalesblService;
/**
 * 添加收款单panel
 * @author ZYC
 *
 */
public class AddPaymentPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	AccountblService accountblService;
	SalesblService salesblService;
	
	MyFrame frame;
	MyButton forwardButton,saveButton;
	MyLabel idLabel,balance,operator,total,failLabel;
	MyTextFieldTrans ps,agent,item;
	MyTextFieldTrans money;
	MyComboBox customer,account;
	PayVO newPayment;
	String id,operate,remark;
	String accountName,customerName,person;
	double balanceValue,totalValue;
	double turnValue;
	ResultPanelController resController;
	String failedAddress = "acc/finManage/pay";
	ItemList itemList;

	
	public AddPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.frame = frame;
		this.repaint();
		init();
		setIDOpe();
		
	}
	public AddPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController,PayVO pay){
		super(frame, url, uiController);
		this.uiController = uiController;
		this.frame = frame;
		this.repaint();

		init();
		setInfo(pay);
	}

	private void init(){
		
		accountblService = new AccountController();
		salesblService = new SalesController();
		
		uiController.setBack_first(this);
		addLabel();
		setComboBox();
		
		setTypeIn();
		setForward();
		resController = new ResultPanelController(frame, this);
	}
	
	private void setInfo(PayVO pay) {
		System.out.println(pay);
		idLabel.setText(pay.note);
		
		operator.setText(operate);
		agent.setText(person);
		item.setText(pay.itemList.itemName);
		total.setText(totalValue + "");
		ps.setText(pay.itemList.remark);
		
		account.setSelectedItem(pay.bankAccount);
		balance.setText(accountblService.searchAccurateAccount_up(pay.bankAccount).balance+"");
		money.setText(pay.itemList.money+"");
//		customer.setSelectedItem(pay.custom);
		
	}
	/**
	 * 
	 */
	
	/**
	 * account的comboBox
	 * account从下层获得
	 */
	private void setComboBox() {
//		String [] accounts = new String[]{"a","b"};//从下层获得
		ArrayList<AccountVO> accVOArray = accountblService.getAllAccount_up();
		String []accounts = new String[accVOArray.size()];
		for(int i=0;i<accVOArray.size();i++){
			accounts[i] = accVOArray.get(i).name;
		}
		account = new MyComboBox(accounts, 491, 166, 205, 43);
		this.add(account);
		account.addActionListener(this);
		
		ArrayList<CustomerVO> cusVoArray = new ArrayList<CustomerVO>();
		cusVoArray = accountblService.getAllCustomer_up();
		
//		cusVoArray = salesblService.getAllImportCustomer_up();
		String[]customers = new String[cusVoArray.size()];
		for(int i = 0;i < cusVoArray.size();i++){
			customers[i] = cusVoArray.get(i).cusName;
		}
		
		customer = new MyComboBox(customers, 104, 300, 222, 43);
		this.add(customer);
		customer.addActionListener(this);
	}
	
	/**
	 * 所有要输入信息，包括备注，转账列表，业务员textField
	 * 
	 */
	private void setTypeIn() {
		ps = new MyTextFieldTrans(104, 453, 220, 81);
		
		agent = new MyTextFieldTrans(406,369,150,54);
	
		money = new MyTextFieldTrans(491, 248, 205, 43);		

		item = new MyTextFieldTrans(104, 300, 220, 81);
		
		MyTextFieldTrans typeInItem []= new MyTextFieldTrans[]{ps,agent,money,item};
		for(int i = 0;i < typeInItem.length;i++){
			this.add(typeInItem[i]);
			typeInItem[i].setForeground(new ColorFactory().accColor);
		}
//		money.getDocument().addDocumentListener(this);
	}
	
	/**
	 * ID和operator的label
	 * 自动生成单据的编号，和操作员
	 */
	private void setIDOpe() {
		idLabel = new MyLabel(106,165, 221,55);
		idLabel.setForeground(new ColorFactory().accColor);
		id = accountblService.getPaymentNote_up();
		idLabel.setText(id);
		this.add(idLabel);
		
		operator = new MyLabel(575, 370, 155, 55);
		operator.setForeground(new ColorFactory().accColor);
		operate = accountblService.getOperator_up();
		operator.setText(operate);
		this.add(operator);
	}
	
	private void setForward() {
		SaveButton save = new SaveButton(this,736, 493);
		saveButton = save.saveButton;
		this.add(saveButton);
		saveButton.addActionListener(this);
		
		ForwardButton forward = new ForwardButton(737, 540);
		forwardButton = forward.forward_black;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);		
	}
	
	private void setBalanceLabel(double balance2) {
		balance = new MyLabel(491, 205,205, 41);
		balance.setText(String.valueOf(balance2));
		balance.setForeground(new ColorFactory().greyFont);
		this.add(balance);
		this.repaint();
	}
	/**
	 * 总额
	 */
	private void setTotal(){
		total = new MyLabel(407, 496,318, 43);
		total.setText(money.getText());
		total.setForeground(new ColorFactory().accColor);
		this.add(total);
		this.repaint();
	}
	
	/**
	 * 实现根据输入的名称寻找余额的动态监听
	 */
	
	public void addLabel() {
		failLabel = new MyLabel(407, 550, 200, 35);
		this.add(failLabel);
	}
	
	private void setNewPayment(){
		remark = ps.getText();
		try{
		turnValue = Double.parseDouble(money.getText());
		}catch(Exception e){
			turnValue = 0.0;
		}
		//PayVO(String note,String bankAccount,ItemList itemList)
		//ItemList(String itemName, double money, String remark)
		itemList = new ItemList(customerName,turnValue,remark);
		newPayment = new PayVO(id,accountName,itemList);
		totalValue = turnValue;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
		
			
			if(customerName.equals("")||money.getText().equals("")){
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
				
			}else{
				try {
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				try{
					
//					totalValue = accountblService.calTotalMoney_up(newPayment);
					setNewPayment();
					uiController.setTempPanel(this);
					frame.remove(this);
					uiController.confirmPayment(newPayment,person,operate,
							totalValue,balanceValue);
						}catch(Exception e2){
							frame.remove(this);
							resController.failed("存在输入错误！",failedAddress);		
							}
			}
				
		}else if(e.getSource() == account){
			accountName = account.getSelectedItem().toString();
			balanceValue = accountblService.searchAccurateAccount_up(accountName).balance;
			setBalanceLabel(balanceValue);
		}else if(e.getSource() == customer){
			customerName = customer.getSelectedItem().toString();
			person = salesblService.searchExactCustomer_up(customerName).person;
			agent.setText(person);
		}else if(e.getSource() == saveButton){
			setNewPayment();
			PayVO draft = new PayVO(id, person, accountName, itemList, "", "0");
			accountblService.addDraftPayment_up(draft);
			frame.remove(this);
			resController = new ResultPanelController(frame, uiController.getMainPanel());
			resController.succeeded("保存一条付款草稿单！", "account");
		}
	}
}
