package ui.account.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.FatherPanel;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.GetVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 确认收款单panel
 * @author ZYC
 *
 */
public class ConfirmReceiptPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	
	MyLabel idLabel,operator,agent,customer,total,ps;
	MyLabel transferList [] = new MyLabel[3] ;
	
	GetVO newReceipt;
	MyButton forwardButton;
	AccountblService accountblService;
	String person;
	double totalValue,balanceValue;
	public ConfirmReceiptPanel(MyFrame frame,String url,
			AccountAllUIController uiController,GetVO newReceipt,String person,double totalValue,double balanceValue){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.balanceValue = balanceValue;
		this.person = person;
		this.totalValue = totalValue;
		this.repaint();
		this.newReceipt = newReceipt;
		uiController.setBack_first(this);
		accountblService = new AccountController();
		setLabel();
		setForward();
		
	}
	private void setLabel() {
		idLabel = new MyLabel(106, 165, 221, 55);
		operator = new MyLabel(575, 370, 155, 55);
		agent = new MyLabel(406,369,155,55);
		customer = new MyLabel(221,255,106,41);
		total = new MyLabel(407, 496,318, 43);
		ps = new MyLabel(106, 369, 222, 170);
		idLabel.setText(newReceipt.id);
		operator.setText(newReceipt.operator);
		agent.setText(person);
		customer.setText(newReceipt.cusName);
		total.setText(totalValue+"");
		this.add(idLabel);
		this.add(operator);
		this.add(agent);
		this.add(customer);
		this.add(total);
		this.add(ps);
//		MyLabel labels[] = new MyLabel[]{idLabel,operator,agent,customer,total,ps};
		
		
		/*for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(new ColorFactory().acc);
			this.add(labels[i]);
			labels[i].setText("我是空的，我要内容");
		}*/
		for(int i = 0;i < transferList.length;i++){
			transferList[i] = new MyLabel(491, 162+i*43, 205, 43);
			if(i % 2 == 1){
				transferList[i].setForeground(new ColorFactory().greyFont);
			}else if(i % 2 == 0){
				transferList[i].setForeground(new ColorFactory().accColor);
			}
			this.add(transferList[i]);
			//TransferListVO(String bankAccount,double transferValue,String remark){
			//银行账户，转账金额，备注
		}
		transferList[0].setText(newReceipt.transferList.bankAccount);
		transferList[1].setText(balanceValue+"");
		transferList[2].setText(newReceipt.transferList.transferValue+"");
		
		
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
			accountblService.addReceipt_up(newReceipt);
			frame.remove(this);
			uiController.addMainPanel();
		}
	}
}
