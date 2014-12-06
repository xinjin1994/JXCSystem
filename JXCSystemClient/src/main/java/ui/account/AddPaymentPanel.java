package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyComboBox;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTextFieldTrans;
import ui.setting.resultPanels.ResultPanelController;
import vo.PayVO;
/**
 * 添加收款单panel
 * @author ZYC
 *
 */
public class AddPaymentPanel extends FatherPanel implements ActionListener,DocumentListener{
	AccountAllUIController uiController;
	
	MyButton forwardButton;
	MyLabel idLabel,balance,operator,total;
	MyTextFieldTrans ps,agent,item;
	MyTextFieldTrans money;
	MyComboBox customer,account;
	PayVO newPayment;
	
	ResultPanelController resController;
	public AddPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_first(this);
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
		money.getDocument().addDocumentListener(this);
	}
	
	/**
	 * ID和operator的label
	 * 自动生成单据的编号，和操作员
	 */
	private void setIDOpe() {
		idLabel = new MyLabel(106,165, 221,55);
		idLabel.setForeground(new ColorFactory().accColor);
		idLabel.setText("id");
		this.add(idLabel);
		
		operator = new MyLabel(575, 370, 155, 55);
		operator.setForeground(new ColorFactory().accColor);
		operator.setText("我是操作员");
		this.add(operator);
	}
	
	private void setForward() {
		ForwardButton forward = new ForwardButton(737, 540);
		forwardButton = forward.forward_black;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);		
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
	public void insertUpdate(DocumentEvent e) {
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
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);

	//		resController.failed("!!!!","Image/result/acc/finManage/payFailed.jpg");
			uiController.confirmPayment(newPayment);

		}
	}
}
