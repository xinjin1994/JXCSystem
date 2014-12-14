package ui.account.payRe;

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
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.ComboBox.MyComboBox;
import ui.setting.TextField.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;
import vo.bill.ItemList;
import vo.bill.PayVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 添加收款单panel
 * @author ZYC
 *
 */
public class AddPaymentPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	AccountblService accountblService;
	MyButton forwardButton;
	MyLabel idLabel,balance,operator,total,failLabel;
	MyTextFieldTrans ps,agent,item;
	MyTextFieldTrans money;
	MyComboBox customer,account;
	PayVO newPayment;
	String id,operate;
	String accountName;
	double balanceValue,totalValue;
	ResultPanelController resController;
	public AddPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		accountblService = new AccountController();
		uiController.setBack_first(this);
		addLabel();
		setAccount();
		setIDOpe();
		setTypeIn();
		setForward();
		resController = new ResultPanelController(frame, this);
	}
	/**
	 * account的comboBox
	 * account从下层获得
	 */
	private void setAccount() {
		String [] accounts = new String[]{"a","b"};//从下层获得
		/*ArrayList<AccountVO> accVOArray = accountblService.getAllAccount_up();
		String []accounts = new String[accVOArray.size()];
		for(int i=0;i<accVOArray.size();i++){
			accounts[i] = accVOArray.get(i).name;
		}*/
		account = new MyComboBox(accounts, 491, 162, 205, 43);
		this.add(account);
		account.addActionListener(this);
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
//		id = accountblService.getPaymentNote_up();
		idLabel.setText(id);
		this.add(idLabel);
		
		operator = new MyLabel(575, 370, 155, 55);
		operator.setForeground(new ColorFactory().accColor);
//		operate = accountblService.getOperator_up();
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			String payItem = item.getText();
			String remark = ps.getText();
			String person = agent.getText();
			if(payItem.equals("")||remark.equals("")||money.getText().equals("")||person.equals("")){
				failLabel.setText("请正确输入信息！");
			}else{
				try{
			double turnValue = Double.parseDouble(money.getText());
			//PayVO(String note,String bankAccount,ItemList itemList)
			//ItemList(String itemName, double money, String remark)
			ItemList itemList = new ItemList(payItem,turnValue,remark);
			newPayment = new PayVO(id,accountName,itemList);
			totalValue = accountblService.calTotalMoney_up(newPayment);
			frame.remove(this);
			uiController.confirmPayment(newPayment,person,operate,
					totalValue,balanceValue);
				}catch(Exception e2){
					failLabel.setText("请正确输入信息！");
				}
			}
		}else if(e.getSource() == account){
			accountName = account.getSelectedItem().toString();
			balanceValue = accountblService.searchAccurateAccount_up(accountName).balance;
			setBalanceLabel(balanceValue);
		}
	}
}