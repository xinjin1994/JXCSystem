package ui.account.payRe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import vo.bill.PayVO;
import vo.bill.TransferListVO;
import businesslogic.accountbl.AccountController;
import businesslogic.salesbl.SalesController;
import businesslogicservice.accountblservice.AccountblService;
import businesslogicservice.salesblservice.SalesblService;

/**
 * 添加收款单
 * 
 * @author ZYC
 * 
 */
public class AddReceiptPanel extends FatherPanel implements ActionListener {
	AccountAllUIController uiController;
	MyButton forwardButton,saveButton;
	MyLabel idLabel, balance, operator, total,failLabel;
	MyTextFieldTrans ps, agent;
	MyTextFieldTrans money;
	MyComboBox customer, account;
	AccountblService accountblService;
	SalesblService salesblService;
	double turnMoney,balanceCash;
	GetVO newReceipt;	
	String remark, person, id, operate,cusName,accName;
	
	TransferListVO transferListVO;
	private ResultPanelController resController;
	private String failedAddress = "acc/finManage/rec";
	
	MyFrame frame;
	public AddReceiptPanel(MyFrame frame, String url, AccountAllUIController uiController) {
		super(frame, url, uiController);
		
		this.frame = frame;
		this.uiController = uiController;
		this.repaint();
		
		accountblService = new AccountController();
		salesblService = new SalesController();
		
		uiController.setBack_first(this);
		resController = new ResultPanelController(frame, this);
		addLabel();
		setForward();
		setIDOpe();
		setCustomer();
		setAccount();
		setTypeIn();
	}

	public AddReceiptPanel(MyFrame frame, String string,
			AccountAllUIController accountAllUIController, GetVO draft) {
		this(frame, string, accountAllUIController);
		setInfo(draft);
	}

	private void setInfo(GetVO get) {
		idLabel.setText(get.note);
		agent.setText(person);
		total.setText(get.transferList.transferValue+"");
		operator.setText(get.operator);
		ps.setText(newReceipt.transferList.remark);
		
		customer.setSelectedItem(get.cusName);
		account.setSelectedItem(get.transferList.bankAccount);
		balance.setText(accountblService.searchAccurateAccount_up(get.transferList.bankAccount).balance+"");
		money.setText(get.transferList.transferValue+"");
	}
	/**
	 * account的comboBox account从下层获得
	 */
	private void setAccount() {
		ArrayList<AccountVO> accVOArray = accountblService.getAllAccount_up();
		String[] accounts = new String[accVOArray.size()];
		for (int i = 0; i < accVOArray.size(); i++) {
			accounts[i] = accVOArray.get(i).name;
		}
//		 String [] accounts = new String[]{"a","b"};//从下层获得
		account = new MyComboBox(accounts, 491, 162, 205, 43);
		this.add(account);
		account.addActionListener(this);
	}

	/**
	 * 所有要输入信息，包括备注，转账列表，业务员textField
	 * 
	 */
	private void setTypeIn() {
		ps = new MyTextFieldTrans(106, 369, 222, 170);
		ps.setForeground(new ColorFactory().accColor);

		agent = new MyTextFieldTrans(406, 369, 150, 54);
		agent.setForeground(new ColorFactory().accColor);

		money = new MyTextFieldTrans(491, 248, 205, 43);
		money.setForeground(new ColorFactory().accColor);

		this.add(ps);
		this.add(agent);
		this.add(money);

		// money.getDocument().addDocumentListener(this);
	}

	/**
	 * Customer的ComboButton 从下层获得客户名称，供由操作员选择
	 */
	private void setCustomer() {
//		 String [] customers = new String []{"a","b"};//从下层获得
		ArrayList<CustomerVO> cusVOArray = accountblService.getAllCustomer_up();
//		ArrayList<CustomerVO> cusVOArray = salesblService.getAllExportCustomer_up();
		String[] customers = new String[cusVOArray.size()];
		for (int i = 0; i < cusVOArray.size(); i++) {
			customers[i] = cusVOArray.get(i).cusName;
		}

		customer = new MyComboBox(customers, 221, 255, 106, 41);
		this.add(customer);
		
		customer.addActionListener(this);
	}

	/**
	 * ID和operator的label 自动生成单据的编号，和操作员
	 */
	private void setIDOpe() {
		idLabel = new MyLabel(106, 165, 221, 55);
		idLabel.setForeground(new ColorFactory().accColor);
		// idLabel.setText("id");
		id = accountblService.getReceiptNote_up();
		idLabel.setText(id);
		this.add(idLabel);

		operator = new MyLabel(575, 370, 155, 55);
		operator.setForeground(new ColorFactory().accColor);
		// operator.setText("我是操作员");
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

	/**
	 * 显示余额
	 */
	private void setBalanceLabel(double bal) {
		balance = new MyLabel(491, 205, 205, 41);
		balance.setText(String.valueOf(bal));
		balance.setForeground(new ColorFactory().greyFont);
		this.add(balance);
		this.repaint();
	}

	/**
	 * 总额
	 */
	private void setTotal() {
		total = new MyLabel(407, 496, 318, 43);
		total.setText(money.getText());
		total.setForeground(new ColorFactory().accColor);
		this.add(total);
		this.repaint();
	}
	
	private void setNewReceipt(){
		remark = ps.getText();// 备注
		try {
			turnMoney = Double.parseDouble(money.getText());// 转账金额
		} catch (Exception e) {
			turnMoney = 0.0;
		}
	
		transferListVO = new TransferListVO(accName, turnMoney, remark);
		newReceipt = new GetVO(id, cusName,transferListVO);
		setTotal();
	}

	/**
	 * 实现根据输入的名称寻找余额的动态监听
	 */

	public void addLabel() {
		failLabel = new MyLabel(407, 550, 200, 35);
		this.add(failLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {

			remark = ps.getText();// 备注
//			person = agent.getText();// 业务员

			if(person.equals("")||money.getText().equals("")){
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
			}else{
				try{
					setNewReceipt();
//					turnMoney = Double.parseDouble(money.getText());// 转账金额
//					cusName = customer.getSelectedItem().toString();// 客户姓名
//					
//					
//					// TransferListVO(String bankAccount,double transferValue,String
//					// remark){
//					// 银行账户，转账金额，备注
//					//			String accName = "ss";
//					//			String cusName = "121";
//					//			double balance = 20;
//					transferListVO = new TransferListVO(accName, turnMoney, remark);
//					newReceipt = new GetVO(id, cusName,transferListVO);
////					total.setText(accountblService.calTotalMoney_up(newReceipt) + "");
//								setTotal();

					uiController.setTempPanel(this);
					frame.remove(this);
					uiController.confirmReceipt(newReceipt,person,operate,accountblService.calTotalMoney_up(newReceipt),balanceCash);
				}catch(Exception e2){
					frame.remove(this);
					resController.failed("存在输入错误！",failedAddress);
				}
				//这边将新生成的收款单信息传给确认收款单界面
			} 

		}else if (e.getSource() == account) {
			accName = account.getSelectedItem().toString();
			// int balance = 10;//根据accName到下层寻找的余额
			balanceCash = accountblService.searchAccurateAccount_up(accName).balance;// 余额
			setBalanceLabel(balanceCash);
		}else if (e.getSource() == customer) {
			cusName = customer.getSelectedItem().toString();
			person = salesblService.searchExactCustomer_up(customer.getSelectedItem().toString()).person;
			agent.setText(person);
			AddReceiptPanel.this.repaint();
		}else if(e.getSource() == saveButton){
			setNewReceipt();
			GetVO get = new GetVO(id, cusName, operate, transferListVO, "", "");
			accountblService.addDraftReceipt_up(get);
			frame.remove(this);
			resController = new ResultPanelController(frame, uiController.getMainPanel());
			resController.succeeded("保存一条收款草稿单！", "account");
		}

	}

}
