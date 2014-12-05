package ui.sales.cuspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldFilled;
import ui.setting.MyTextFieldTrans;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class MakeSureAddInfo extends MakeSureCusInfo {
	private CustomerVO customerVO;
	private AddCusPanel addCusPanel;
	private MyFrame frame;
	
	public MakeSureAddInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO,AddCusPanel addCusPanel){
		super(frame,url,controller,salesUIController,customerVO);
		this.customerVO = customerVO;
		this.addCusPanel = addCusPanel;
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
				System.out.println("qianjing!");
				SalesblService salesBlService = new SalesController();
				salesBlService.addCustomer_up(customerVO);
			} else if (e.getSource() == secondCusBack) {
				System.out.println("fff");
				frame.remove(MakeSureAddInfo.this);
				frame.setPanel(addCusPanel);
				frame.repaint();
			}
		}
	}
}
