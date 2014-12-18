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

public class MakeSureDelInfo extends MakeSureCusInfo{
	private CustomerVO customerVO;
	private DelCusPanel delCusPanel;
	private MyFrame frame;
	private UIController controller;
	private SalesUIController salesUIController;
	
	public MakeSureDelInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO,DelCusPanel delCusPanel){
		super(frame,url,controller,salesUIController,customerVO);
		this.customerVO = customerVO;
		this.delCusPanel = delCusPanel;
		this.controller = controller;
		this.salesUIController = salesUIController;
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
//				System.out.println("qianjing!");
				SalesblService salesblService = new SalesController();
				SalesResult salesResult = new SalesResult(frame,controller,salesUIController,MakeSureDelInfo.this);
				switch(salesblService.delCustomer_up(customerVO)){
				case 0:
					salesResult.succeeded("删除成功！");
					break;
				}
				
			} else if (e.getSource() == secondCusBack) {
				System.out.println("fff");
				frame.remove(MakeSureDelInfo.this);
				frame.setPanel(delCusPanel);
				frame.repaint();
			}
		}
	}
}
