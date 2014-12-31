package ui.sales.cuspanel;

import javax.swing.ImageIcon;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyStopButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldFilled;
import ui.setting.TextField.MyTextFieldTrans;
import vo.CustomerVO;

public class MakeSureCusInfo extends FatherPanel{
	/*
	 * 确认界面的父类
	 */

	protected MyLabel cusName, cusTel, cusAdd, cusEBox, cusCode, cusShouldPay,shouldPay,person,shouldGet,id;
	protected int infoX1 = 495, infoX2 = 534, infoY = 170, infoInter = 41, infoWidth1 = 237, infoWidth2 = 190,
			infoHeight = 31;
	protected int levelX = 105, levelY = 328, levelInter = 42;
	protected MyStopButton sellerButton;
	MyStopButton supplierButton;
	protected MyStopButton level1,level2,level3,level4,level5;
	protected CustomerVO customerVO;
	
	public MakeSureCusInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,CustomerVO customerVO){
		super(frame,url,controller);
		this.customerVO = customerVO;
		addLabel();
		setLabel();
		addButton();
		setButton();
		this.repaint();
	}
	
	protected void addLabel(){
		id = new MyLabel(105, 173, 222, 36);
		cusName = new MyLabel(infoX1, infoY, infoWidth1, infoHeight);
		cusTel = new MyLabel(infoX1, infoY + infoInter, infoWidth1, infoHeight);
		cusAdd = new MyLabel(infoX1, infoY + 2 * infoInter, infoWidth1, infoHeight);
		cusEBox = new MyLabel(infoX1, infoY + 3 * infoInter, infoWidth1, infoHeight);
		cusCode = new MyLabel(infoX1, infoY + 4 * infoInter, infoWidth1, infoHeight);
		cusShouldPay = new MyLabel(infoX1, infoY + 5 * infoInter, infoWidth1, infoHeight);
		shouldGet = new MyLabel(634, 438, 94, 41);
		shouldPay = new MyLabel(634, 494, 94, 41);
		person = new MyLabel(407, 481, 155, 54);
		this.add(id);
		this.add(cusName);
		this.add(cusTel);
		this.add(cusAdd);
		this.add(cusEBox);
		this.add(cusCode);
		this.add(cusShouldPay);
		this.add(shouldGet);
		this.add(shouldPay);
		this.add(person);
	}
	
	protected void setLabel(){
		id.setText(customerVO.id);
		cusName.setText(customerVO.cusName);
		cusTel.setText(customerVO.tel);
		cusAdd.setText(customerVO.address);
		cusCode.setText(customerVO.zipCode);
		cusEBox.setText(customerVO.ezipCode);
		cusShouldPay.setText(customerVO.mostOwe+"");
		person.setText(customerVO.person);
		shouldGet.setText(customerVO.shouldGet+"");
		shouldPay.setText(customerVO.shouldPay+"");
	}
	
	protected void addButton(){
		supplierButton = new MyStopButton("Image/Sales/对话框/images/供货商_ori.png", 105, 255,
				"Image/Sales/对话框/images/供货商_ori.png");
		sellerButton = new MyStopButton("Image/Sales/对话框/images/销售商_ori.png", 220, 255,
				"Image/Sales/对话框/images/销售商_ori.png");
		this.add(supplierButton);
		this.add(sellerButton);
		
		level1 = new MyStopButton("Image/Sales/对话框/images/level1_ori.png",levelX,levelY,"Image/Sales/对话框/images/level1_ori.png");
		level2 = new MyStopButton("Image/Sales/对话框/images/level2_ori.png",levelX,levelY+levelInter,"Image/Sales/对话框/images/level2_ori.png");
		level3 = new MyStopButton("Image/Sales/对话框/images/level3_ori.png",levelX,levelY+2*levelInter,"Image/Sales/对话框/images/level3_ori.png");
		level4 = new MyStopButton("Image/Sales/对话框/images/level4_ori.png",levelX,levelY+3*levelInter,"Image/Sales/对话框/images/level4_ori.png");
		level5 = new MyStopButton("Image/Sales/对话框/images/level5_ori.png",levelX,levelY+4*levelInter,"Image/Sales/对话框/images/level5_ori.png");
		this.add(level1);
		this.add(level2);
		this.add(level3);
		this.add(level4);
		this.add(level5);
	}
	
	protected void setButton(){
		if(customerVO.classification == true){
			//false代表供应商，true代表销售商
			sellerButton.setIcon(new ImageIcon("Image/Sales/对话框/images/销售商_press_on_05.png"));
		}else{
			supplierButton.setIcon(new ImageIcon("Image/Sales/对话框/images/供应商_press_on_03.png"));
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
		
	}
	
	}

