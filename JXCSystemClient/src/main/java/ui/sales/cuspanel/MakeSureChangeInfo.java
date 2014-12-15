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

public class MakeSureChangeInfo extends MakeSureCusInfo{
	private CustomerVO customerVOBefore,customerVOAfter;
	private ChangeCusPanel changeCusPanel;
	private MyFrame frame;
	private UIController controller;
	private SalesUIController salesUIController;
	
	public MakeSureChangeInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO,ChangeCusPanel changeCusPanel){
		super(frame,url,controller,salesUIController,customerVO);
		this.customerVOBefore = customerVO;
		this.controller = controller;
		this.salesUIController = salesUIController;
		this.changeCusPanel = changeCusPanel;
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
				String ID = idField.getText();
				String name = cusName.getText();
				String tel = cusTel.getText();
				String add = cusAdd.getText();
				String code = cusCode.getText();
				String eBox = cusEBox.getText();
				double mostOwe = Double.parseDouble(cusShouldPay.getText());
				double shouldGet = 0;
				double shouldPay = 0;
				String person = salesManField.getText();
				customerVOAfter = new CustomerVO(ID,classification,level,name,tel,add,code,eBox,mostOwe,shouldGet,person);
				System.out.println("qianjing!");
				SalesblService salesBlService = new SalesController();
				SalesResult salesResult = new SalesResult(frame,controller,salesUIController,MakeSureChangeInfo.this);
				switch(salesBlService.updateCustomer_up(customerVOBefore,customerVOAfter)){
				case 0:
					salesResult.succeeded("修改成功！","sales");
					break;
				}
			} else if (e.getSource() == secondCusBack) {
				System.out.println("fff");
				frame.remove(MakeSureChangeInfo.this);
				frame.setPanel(changeCusPanel);
				frame.repaint();
			}
		}
	}
}
