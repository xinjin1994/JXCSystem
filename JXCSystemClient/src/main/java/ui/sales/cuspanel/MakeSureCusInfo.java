package ui.sales.cuspanel;

import javax.swing.ImageIcon;

import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldFilled;
import ui.setting.MyTextFieldTrans;
import vo.CustomerVO;

public class MakeSureCusInfo extends AddCusPanel{

	protected MyTextFieldTrans shouldGet;
	protected MyTextFieldFilled shouldPay, person;
	
	public MakeSureCusInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO){
		super(frame,url,controller,salesUIController);
		this.remove(salesManField);
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
		//false代表供应商，true代表销售商
		if(customerVO.classification == true){
			sellerButton.setIcon(new ImageIcon("Image/Sales/对话框/images/供应商_press_on_03.png"));
		}else{
			supplierButton.setIcon(new ImageIcon("Image/Sales/对话框/images/销售商_press_on_05.png"));
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
		
	}

