package ui.account.payRe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyComboBox;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTextFieldTrans;
import vo.AccountVO;
import vo.GetVO;
import vo.TransferListVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;

/**
 * 添加收款单
 * 
 * @author ZYC
 * 
 */
public class AddReceiptPanel extends FatherPanel implements ActionListener {
	AccountAllUIController uiController;
	MyButton forwardButton;
	MyLabel idLabel, balance, operator, total;
	MyTextFieldTrans ps, agent;
	MyTextFieldTrans money;
	MyComboBox customer, account;
	AccountblService accountblService;
	double turnMoney;
	GetVO newReceipt;	
	String remark, person, id, operate;
	public AddReceiptPanel(MyFrame frame, String url, AccountAllUIController uiController) {
		super(frame, url, uiController);
		this.uiController = uiController;
		this.repaint();
		accountblService = new AccountController();
		uiController.setBack_first(this);
		setForward();
		setIDOpe();
		setCustomer();
		setAccount();
		setTypeIn();
	}

	/**
	 * account的comboBox account从下层获得
	 */
	private void setAccount() {
		ArrayList<AccountVO> accVOArray = accountblService.getAllAccount_up();
	/*	String[] accounts = new String[accVOArray.size()];
		for (int i = 0; i < accVOArray.size(); i++) {
			accounts[i] = accVOArray.get(i).name;
		}*/
		 String [] accounts = new String[]{"a","b"};//从下层获得
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
		 String [] customers = new String []{"a","b"};//从下层获得
	/*	ArrayList<CustomerVO> cusVOArray = accountblService.getAllCustomer_up();
		String[] customers = new String[cusVOArray.size()];
		for (int i = 0; i < cusVOArray.size(); i++) {
			customers[i] = cusVOArray.get(i).cusName;
		}*/

		customer = new MyComboBox(customers, 221, 255, 106, 41);
		this.add(customer);
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

	/*
	 * public void changedUpdate(DocumentEvent e) { Document doc =
	 * e.getDocument(); try { String totalMoney = doc.getText(0,
	 * doc.getLength()); } catch (BadLocationException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } setTotal(); }
	 */

	/**
	 * 实现根据输入的名称寻找余额的动态监听
	 */
	/*
	 * public void insertUpdate(DocumentEvent e) { Document doc =
	 * e.getDocument(); try { String totalMoney = doc.getText(0,
	 * doc.getLength()); } catch (BadLocationException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } total = new
	 * MyLabel(407, 496,318, 43); total.setText(money.getText());
	 * this.add(total); this.repaint();
	 * 
	 * 
	 * } public void removeUpdate(DocumentEvent e) { Document doc =
	 * e.getDocument(); try { String totalMoney = doc.getText(0,
	 * doc.getLength()); } catch (BadLocationException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } total = new
	 * MyLabel(407, 496,318, 43); total.setText(money.getText());
	 * this.add(total); this.repaint();
	 * 
	 * }
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			remark = ps.getText();// 备注
			person = agent.getText();// 业务员
			turnMoney = Double.parseDouble(money.getText());// 转账金额
			String accName = account.getSelectedItem().toString();// 银行账户
			String cusName = customer.getSelectedItem().toString();// 客户姓名
			double balance = accountblService.searchAccurateAccount_up(accName).balance;// 余额
			// TransferListVO(String bankAccount,double transferValue,String
			// remark){
			// 银行账户，转账金额，备注
//			String accName = "ss";
//			String cusName = "121";
//			double balance = 20;
			setBalanceLabel(balance);
			TransferListVO transferListVO = new TransferListVO(accName, turnMoney, remark);
			// GetVO(String id, String cusName, String operator, TransferListVO
			// transferList) {
			// 单据编号（SKD-yyyyMMdd-xxxxx），客户（同时包含供应商和销售商），操作员（当前登录用户），转账列表
			newReceipt = new GetVO(id, cusName,transferListVO);
			total.setText(accountblService.calTotalMoney_up(newReceipt) + "");
//			setTotal();

			frame.remove(this);

			uiController.confirmReceipt(newReceipt,person,operate,accountblService.calTotalMoney_up(newReceipt),balance);
			//这边将新生成的收款单信息传给确认收款单界面
		} else if (e.getSource() == account) {
			String accName = account.getSelectedItem().toString();
			// int balance = 10;//根据accName到下层寻找的余额
			double balance = accountblService.searchAccurateAccount_up(accName).balance;// 余额
			setBalanceLabel(balance);
		}

	}

}
