package ui.account.payRe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.GetVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 确认收款单panel
 * @author ZYC
 *
 */
public class ConfirmReceiptPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	AccountblService accountblService;
	MyLabel idLabel,operator,agent,customer,total,ps;
	MyLabel transferList [] = new MyLabel[3] ;
	String person,operater;
	double totalValue;
	double balanceValue;
	GetVO newReceipt;
	MyButton forwardButton;
	
	ResultPanelController resController;
	public ConfirmReceiptPanel(MyFrame frame,String url,
			AccountAllUIController uiController,GetVO newReceipt,String person,String operater,double totalValue,double balanceValue){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		this.newReceipt = newReceipt;
		uiController.setBack_first(this);
		accountblService = new AccountController();
		this.person = person;
		this.operater = operater;
		this.totalValue = totalValue;
		this.balanceValue = balanceValue;
		resController = new ResultPanelController(uiController, frame);
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
		//GetVO newReceipt,String person,double totalValue,double balanceValue
		//TransferListVO(String bankAccount,double transferValue,String remark){
			//银行账户，转账金额，备注。
		idLabel.setText(newReceipt.note);
		customer.setText(newReceipt.cusName);
		agent.setText(person);
		total.setText(totalValue+"");
		operator.setText(operater);
		ps.setText(newReceipt.transferList.remark);
		MyLabel labels[] = new MyLabel[]{idLabel,operator,agent,customer,total,ps};
		
		
		for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(new ColorFactory().accColor);
			this.add(labels[i]);
		}
		for(int i = 0;i < transferList.length;i++){
			transferList[i] = new MyLabel(491, 162+i*43, 205, 43);
			if(i % 2 == 1){
				transferList[i].setForeground(new ColorFactory().greyFont);
			}else if(i % 2 == 0){
				transferList[i].setForeground(new ColorFactory().accColor);
			}
			this.add(transferList[i]);
//			transferList[i].setText("我也是空的，我也要内容");
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
			frame.remove(this);
		    switch(accountblService.addReceipt_up(newReceipt)){
		    case 0:
		    	resController.succeeded("成功添加收款单！","account");
		    	break;
		    case 4:
		    	resController.failed("客户不存在！", "account");
		    	break;
		    }
		}
	}
}
