package ui.account;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.resultPanels.ResultPanelController;
import vo.GetVO;
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
	
	ResultPanelController resController;
	public ConfirmReceiptPanel(MyFrame frame,String url,
			AccountAllUIController uiController,GetVO newReceipt){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		this.newReceipt = newReceipt;
		uiController.setBack_first(this);
		
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
		
		MyLabel labels[] = new MyLabel[]{idLabel,operator,agent,customer,total,ps};
		
		
		for(int i = 0;i < labels.length;i++){
			labels[i].setForeground(new ColorFactory().accColor);
			this.add(labels[i]);
			labels[i].setText("我是空的，我要内容");
		}
		for(int i = 0;i < transferList.length;i++){
			transferList[i] = new MyLabel(491, 162+i*43, 205, 43);
			if(i % 2 == 1){
				transferList[i].setForeground(new ColorFactory().greyFont);
			}else if(i % 2 == 0){
				transferList[i].setForeground(new ColorFactory().accColor);
			}
			this.add(transferList[i]);
			transferList[i].setText("我也是空的，我也要内容");
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
			resController.succeeded("成功添加收款单！","account");
		}
	}
}
