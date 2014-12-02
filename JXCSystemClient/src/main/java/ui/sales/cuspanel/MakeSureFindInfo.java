package ui.sales.cuspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.UIController;
import ui.sales.SalesUIController;
import ui.sales.cuspanel.MakeSureDelInfo.Listener;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldFilled;
import ui.setting.MyTextFieldTrans;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class MakeSureFindInfo extends MakeSureCusInfo{

	private CustomerVO customerVO;
	private FindCusPanel findCusPanel;
	private MyFrame frame;
	
	public MakeSureFindInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO,FindCusPanel findCusPanel){
		super(frame,url,controller,salesUIController,customerVO);
		this.customerVO = customerVO;
		this.findCusPanel = findCusPanel;
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
				SalesblService salesBlService = new SalesController();
				salesBlService.delCustomer(customerVO);
				System.out.println("qianjing!");
			} else if (e.getSource() == secondCusBack) {
				System.out.println("fff");
				frame.remove(MakeSureFindInfo.this);
				frame.setPanel(findCusPanel);
				frame.repaint();
			}
		}
	}
}
