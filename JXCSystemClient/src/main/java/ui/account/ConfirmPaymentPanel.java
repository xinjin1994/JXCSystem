package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.spi.DirStateFactory.Result;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.resultPanels.ResultPanelController;
import vo.GetVO;
import vo.PayVO;
/**
 * 确认付款
 * @author ZYC
 *
 */
public class ConfirmPaymentPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	MyLabel idLabel,operator,agent,item,total,ps;
	MyLabel transferList [] = new MyLabel[3] ;
	
	PayVO newPayment;
	MyButton forwardButton;
	ResultPanelController resController;
	public ConfirmPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController, PayVO newPayment){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		this.newPayment = newPayment;
		
		resController = new ResultPanelController(uiController, frame);
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
			resController.succeeded("成功添加付款单！","account");
		}
	}
}
