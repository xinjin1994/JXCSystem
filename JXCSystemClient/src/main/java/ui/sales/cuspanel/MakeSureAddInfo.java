package ui.sales.cuspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldFilled;
import ui.setting.TextField.MyTextFieldTrans;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class MakeSureAddInfo extends MakeSureCusInfo {
	private CustomerVO customerVO;
	private AddCusPanel addCusPanel;
	private MyFrame frame;
	private SalesUIController salesUIController;
	private UIController controller;
	
	public MakeSureAddInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO,AddCusPanel addCusPanel){
		super(frame,url,controller,salesUIController,customerVO);
		this.customerVO = customerVO;
		this.addCusPanel = addCusPanel;
		this.salesUIController = salesUIController;
		this.controller = controller;
		this.frame = frame;
	}

	public void addRestButton() {
		shouldGet = new MyTextFieldTrans(634, 438, 94, 41);
		shouldPay = new MyTextFieldFilled(634, 494, 94, 41);
		person = new MyTextFieldFilled(407, 481, 48, 54);
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		forward.addActionListener(new Listener());
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		secondCusBack.addActionListener(new Listener());
		this.add(secondCusBack);
		this.add(shouldGet);
		this.add(shouldPay);
		this.add(person);
		this.add(forward);
	}

	class Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == forward) {
//		 SalesResult(MyFrame frame,UIController controller,SalesUIController salesUIController,FatherPanel backPanel){
				SalesblService salesblService = new SalesController();
				SalesResult salesResult = new SalesResult(frame,controller,salesUIController,MakeSureAddInfo.this);
			    switch(salesblService.addCustomer_up(customerVO)){
			    	case 0:
						salesResult.succeeded("成功！");
						break;
				
			    }
			} else if (e.getSource() == secondCusBack) {
				frame.remove(MakeSureAddInfo.this);
				frame.setPanel(addCusPanel);
				frame.repaint();
			}
		}
	}
}
