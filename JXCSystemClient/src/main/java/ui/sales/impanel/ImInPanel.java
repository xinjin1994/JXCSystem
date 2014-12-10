package ui.sales.impanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.FatherPanel;
import ui.setting.MyButton;
import ui.setting.MyTextFieldFilled;
import ui.setting.MyTextFieldTrans;

public class ImInPanel extends FatherPanel {
	private ButtonListener buttonListener;
	protected MyTextFieldFilled id, supplier, warehouse, remark, discount, voucher;
	MyTextFieldTrans goodsName, goodsID, goodsType, goodsPrice, goodsNum, goodsTotal;
	MyTextFieldFilled person, operator;
	protected MyButton back, forward;
	protected SalesUIController salesUIController;

	public ImInPanel(JFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller);
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		this.addButton();
		this.addTextField();
	}

	public void addButton() {
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back);
		this.add(forward);
		back.addActionListener(buttonListener);
		forward.addActionListener(buttonListener);
	}
	

	public void addTextField() {
		id = new MyTextFieldFilled(105, 173, 222, 36);
		supplier = new MyTextFieldFilled(210, 255, 116, 42);
		warehouse = new MyTextFieldFilled(210, 308, 116, 42);
		remark = new MyTextFieldFilled(104, 420, 111, 118);
		discount = new MyTextFieldFilled(235, 421, 91, 37);
		voucher = new MyTextFieldFilled(235, 500, 91, 27);
		goodsName = new MyTextFieldTrans(488, 170, 237, 31);
		goodsID = new MyTextFieldTrans(488, 211, 237, 31);
		goodsType = new MyTextFieldTrans(488, 252, 237, 31);
		goodsPrice = new MyTextFieldTrans(488, 293, 237, 31);
		goodsNum = new MyTextFieldTrans(488, 334, 237, 31);
		goodsTotal = new MyTextFieldTrans(488, 375, 237, 31);
		person = new MyTextFieldFilled(408,481,147,36);
		operator = new MyTextFieldFilled (576,481,147,36);
//		this.add(id);
		this.add(supplier);
		this.add(warehouse);
		this.add(remark);
		this.add(discount);
		this.add(voucher);
		this.add(goodsName);
		this.add(goodsID);
		this.add(goodsType);
		this.add(goodsPrice);
		this.add(goodsNum);
		this.add(goodsTotal);
		this.add(person);
		this.add(operator);
		
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(ImInPanel.this);
			} else if (e.getSource() == forward) {
				SalesblService salesBlService = new SalesController();
//TODO 				
			}

		}
	}
}
