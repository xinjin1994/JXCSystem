package ui.account;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.AccountPanel;
import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTextFieldFilled;
import ui.setting.MyTextFieldTrans;

public class AddReceiptPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	MyButton forwardButton;
	MyLabel idLabel;
	MyTextFieldTrans ps,agent;
	MyTextFieldTrans [] accTransList = new MyTextFieldTrans[3];
	public AddReceiptPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_first(this);
		setForward();
		setID();
		setCustomer();
		setTypeIn();
	}
	/**
	 * 所有要输入信息，包括备注，转账列表，业务员textField
	 * 
	 */
	private void setTypeIn() {
		ps = new MyTextFieldTrans(106, 369, 222, 170);
		ps.setForeground(new ColorFactory().acc);
		
		agent = new MyTextFieldTrans(406,369,150,54);
		agent.setForeground(new ColorFactory().acc);
		
		for(int i = 0;i < accTransList.length;i++){
		//	accTransList[i] = new MyTextFieldTrans(x, y, i, i)
		}
	}
	
	/**
	 * Customer的ComboButton
	 * 从下层获得客户名称，供由操作员选择
	 */
	private void setCustomer() {
		
		
	}
	/**
	 * ID的label
	 * 自动生成单据的编号
	 */
	private void setID() {
		idLabel = new MyLabel(106,165, 221,55);
		idLabel.setText("id");
		this.add(idLabel);
	}
	

	private void setForward() {
		ForwardButton forward = new ForwardButton(737, 540);
		forwardButton = forward.forward_black;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			System.out.println("jjj");
		}
		
	}
	
}
