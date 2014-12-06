package ui.account.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.PayVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 确认付款
 * @author ZYC
 *
 */
public class ConfirmPaymentPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	MyLabel idLabel,operator,agent,item,total,ps;
	MyLabel transferList [] = new MyLabel[3] ;
	String person;
	PayVO newPayment;
	MyButton forwardButton;
	double totalValue,balanceValue;
	AccountblService accountblService;
	public ConfirmPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController, PayVO newPayment,String person,double totalValue,double balanceValue){
		super(frame,url,uiController);
		accountblService = new AccountController();
		this.person = person;
		this.balanceValue = balanceValue;
		this.totalValue = totalValue;
		this.uiController = uiController;
		this.repaint();
		this.newPayment = newPayment;
		
		uiController.setBack_first(this);
		
		setLabel();
		setForward();
	}
	private void setLabel() {
		idLabel = new MyLabel(106, 165, 221, 55);
		operator = new MyLabel(575, 370, 155, 55);
		agent = new MyLabel(406,369,155,55);
		item = new MyLabel(104,300,220,81);
		total = new MyLabel(407, 496,318, 43);
		ps = new MyLabel(104, 453, 220, 81);
		
		MyLabel labels[] = new MyLabel[]{idLabel,operator,agent,item,total,ps};
		for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(new ColorFactory().acc);
			this.add(labels[i]);
		}
		//PayVO(String id,String operator,String cusName,String bankAccount,ItemList itemList) {
	    //单据编号（XJFYD-yyyyMMdd-xxxxx）,操作员（当前登录用户），银行账户，条目清单
		//ItemList(String itemName, double money, String remark)		
		labels[1].setText(newPayment.id);
		labels[2].setText(newPayment.operator);
		labels[3].setText(person);
		labels[4].setText(newPayment.itemList.itemName);
		labels[5].setText(totalValue+"");
		labels[6].setText(newPayment.itemList.remark);
		
		for(int i = 0;i < transferList.length;i++){
			transferList[i] = new MyLabel(491, 162+i*43, 205, 43);
			if(i % 2 == 1){
				transferList[i].setForeground(new ColorFactory().greyFont);
			}else if(i % 2 == 0){
				transferList[i].setForeground(new ColorFactory().acc);
			}
			this.add(transferList[i]);
			transferList[0].setText(newPayment.bankAccount);
			transferList[1].setText(balanceValue+"");
			transferList[2].setText(newPayment.itemList.money+"");
		}
		
	}
	/**
	 * 确认
	 * 将新生成的VO传向下层
	 */
	private void setForward() {
		ForwardButton forward = new ForwardButton(737, 540);
		forwardButton = forward.forward_black;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			accountblService.addPayment_up(newPayment);
			uiController.addMainPanel();
		}
	}
}
