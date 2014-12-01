package ui.sales.cuspanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldFilled;
import ui.setting.MyTextFieldTrans;
import vo.CustomerVO;

public class MakeSureCusInfo extends AddCusPanel{

	protected MyTextFieldTrans shouldGet;
	protected MyTextFieldFilled shouldPay, person;
	private CustomerVO customerVO;
	private AddCusPanel addCusPanel;
	private MyFrame frame;
	
	public MakeSureCusInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO,AddCusPanel addCusPanel){
		super(frame,url,controller,salesUIController);
		this.remove(salesManField);
		this.customerVO = customerVO;
		this.addCusPanel = addCusPanel;
		this.frame = frame;
//		this.addRestButton();
		idField.setText(customerVO.id);
		cusName.setText(customerVO.cusName);
		cusTel.setText(customerVO.tel);
		cusAdd.setText(customerVO.address);
		cusCode.setText(customerVO.zipCode);
		cusEBox.setText(customerVO.ezipCode);
		cusShouldPay.setText(customerVO.mostOwe+"");
		person.setText(customerVO.person);
		shouldGet.setText(customerVO.shouldGet+"");
		shouldPay.setText(customerVO.shouldPay+"");
		
		if(customerVO.classification == true){
			supplierButton.setIcon(new ImageIcon("Image/Sales/对话框/images/供应商_press_on_03.png"));
		}else{
			sellerButton.setIcon(new ImageIcon("Image/Sales/对话框/images/销售商_press_on_05.png"));
		}
		switch(customerVO.level){
			case 1:
				level1.setIcon(new ImageIcon("Image/Sales/对话框/images/level1_press_on.png"));
				break;
			case 2:
				level2.setIcon(new ImageIcon("Image/Sales/对话框/images/level2_press_on.png"));
				break;
			case 3:
				level3.setIcon(new ImageIcon("Image/Sales/对话框/images/level3_press_on.png"));
				break;
			case 4:
				level4.setIcon(new ImageIcon("Image/Sales/对话框/images/level4_press_on.png"));
				break;
			case 5:
				level5.setIcon(new ImageIcon("Image/Sales/对话框/images/level5_press_on.png"));
				break;
		}
		this.repaint();
	}
	
	public void addRestButton(){
		shouldGet = new MyTextFieldTrans(634,438,94,41);
		shouldPay = new MyTextFieldFilled(634,494,94,41);
		person = new MyTextFieldFilled(407,481,48,54);
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
	
	class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == forward){
				System.out.println("qianjing!");
				SalesblService salesBlService = new SalesController();
				salesBlService.addCustomer(customerVO);
			}else if(e.getSource() == secondCusBack){
				System.out.println("fff");
				frame.remove(MakeSureCusInfo.this);
				frame.setPanel(addCusPanel);
				frame.repaint();
			}
		}
		
	}
}
