package ui.account.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

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
import vo.ItemList;
import vo.PayVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 添加付款单panel
 * @author ZYC
 *
 */
public class AddPaymentPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	
	MyButton forwardButton;
	MyLabel idLabel,balance,operator,total;
	MyTextFieldTrans ps,agent,item;
	MyTextFieldTrans money;
	MyComboBox customer,account;
	PayVO newPayment;
	String id,operate;
	AccountblService accountblService;
	public AddPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		accountblService = new AccountController();
		uiController.setBack_first(this);
		setAccount();
		setIDOpe();
		setTypeIn();
		setForward();
	}
	/**
	 * account的comboBox
	 * account从下层获得
	 */
	private void setAccount() {
		
		ArrayList<AccountVO> accVOArray = accountblService.getAllAccount_up();
		String []accounts = new String[accVOArray.size()];
		for(int i=0;i<accVOArray.size();i++){
			accounts[i] = accVOArray.get(i).name;
		}
//		String [] accounts = new String[]{"a","b"};//从下层获得
		account = new MyComboBox(accounts, 491, 162, 205, 43);
		this.add(account);
//		account.addActionListener(this);
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
			typeInItem[i].setForeground(new ColorFactory().acc);
		}
//		money.getDocument().addDocumentListener(this);
	}
	
	/**
	 * ID和operator的label
	 * 自动生成单据的编号，和操作员
	 */
	private void setIDOpe() {
		idLabel = new MyLabel(106,165, 221,55);
		idLabel.setForeground(new ColorFactory().acc);
		id = accountblService.getPaymentNote_up();
		idLabel.setText(id);
		this.add(idLabel);
		
		operator = new MyLabel(575, 370, 155, 55);
		operator.setForeground(new ColorFactory().acc);
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
//		total.setText(money.getText());
		total.setForeground(new ColorFactory().acc);
		this.add(total);
		this.repaint();
	}
	public void changedUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		try {
			String totalMoney = doc.getText(0, doc.getLength());
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTotal();
	}
	
	/**
	 * 实现根据输入的名称寻找余额的动态监听
	 */
	/*public void insertUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		try {
			String totalMoney = doc.getText(0, doc.getLength());
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		total = new MyLabel(407, 496,318, 43);
		total.setText(money.getText());
		this.add(total);
		this.repaint();
		
		
	}
	public void removeUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		try {
			String totalMoney = doc.getText(0, doc.getLength());
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		total = new MyLabel(407, 496,318, 43);
		total.setText(money.getText());
		this.add(total);
		this.repaint();
		
	}*/
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			String accountName = account.getSelectedItem().toString();
			double balanceValue = accountblService.searchAccurateAccount_up(accountName).balance;
			setBalanceLabel(balanceValue);
			//付款条目 备注 转账金额  业务员 ps,agent,item money
			String payItem = item.getText();
			String remark = ps.getText();
			double turnValue = Double.parseDouble(money.getText());
			String person = agent.getText();
			//PayVO(String id,String operator,String cusName,String bankAccount,ItemList itemList) {
		    //单据编号（XJFYD-yyyyMMdd-xxxxx）,操作员（当前登录用户），银行账户，条目清单
			//ItemList(String itemName, double money, String remark)
			ItemList itemList = new ItemList(payItem,turnValue,remark);
			newPayment = new PayVO(id,operate,accountName,itemList);
			total.setText(accountblService.calTotalMoney_up(newPayment)+"");
			frame.remove(this);
//			PayVO newPayment,String person,double totalValue,double balanceValue
			uiController.confirmPayment(newPayment,person,accountblService.calTotalMoney_up(newPayment),balanceValue);

		}
	}
}
