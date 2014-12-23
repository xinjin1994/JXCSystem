package ui.sales.cuspanel;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldTrans;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class MakeSureChangeInfo extends AddCusPanel{
	private CustomerVO customerVOBefore,customerVOAfter;
	private ChangeCusPanel changeCusPanel;
	private MyFrame frame;
	private UIController controller;
	private SalesUIController salesUIController;
	private MyButton forward,secondCusBack;
	private MyTextFieldTrans person;
	private MyLabel shouldGet,shouldPay;
	private MyLabel cusNameLabel;
	
	public MakeSureChangeInfo(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,
			CustomerVO customerVO,ChangeCusPanel changeCusPanel){
		super(frame,url,controller,salesUIController);
		this.customerVOBefore = customerVO;
		this.controller = controller;
		this.salesUIController = salesUIController;
		this.changeCusPanel = changeCusPanel;
		this.frame = frame;
		this.remove(salesManField);
		this.remove(cusName);
		
//		addRestButton();
		setText();
		setButton();
	}

	public void addRestButton() {
		shouldGet = new MyLabel(634, 438, 94, 41);
		shouldPay = new MyLabel(634, 494, 94, 41);
		person = new MyTextFieldTrans(407, 481, 94, 54);
		this.add(shouldGet);
		this.add(shouldPay);
		this.add(person);
		
		cusNameLabel = new MyLabel(infoX1, infoY, infoWidth1, infoHeight);
		this.add(cusNameLabel);
		
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		forward.addMouseListener(new Listener());
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		secondCusBack.addMouseListener(new Listener());
		this.add(secondCusBack);
		this.add(forward);
		
	}
	
	public void setText(){
		idField.setText(customerVOBefore.id);
		cusNameLabel.setText(customerVOBefore.cusName);
		cusTel.setText(customerVOBefore.tel);
		cusAdd.setText(customerVOBefore.address);
		cusCode.setText(customerVOBefore.zipCode);
		cusEBox.setText(customerVOBefore.ezipCode);
		cusShouldPay.setText(customerVOBefore.mostOwe+"");
		person.setText(customerVOBefore.person);
		shouldGet.setText(customerVOBefore.shouldGet+"");
		shouldPay.setText(customerVOBefore.shouldPay+"");
		System.out.println(customerVOBefore.person+"person "+customerVOBefore.shouldGet+"shouldGet "+
				customerVOBefore.shouldPay+"shouldPay ");
	}

	private void setButton(){
		if(customerVOBefore.classification == true){
			//false代表供应商，true代表销售商
			sellerButton.setIcon(new ImageIcon("Image/Sales/对话框/images/销售商_press_on_05.png"));
		}else{
			supplierButton.setIcon(new ImageIcon("Image/Sales/对话框/images/供应商_press_on_03.png"));
		}
		switch(customerVOBefore.level){
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
	
	class Listener implements MouseListener {

		public void actionPerformed(ActionEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			SalesResult salesResult = new SalesResult(frame,controller,salesUIController,changeCusPanel);
			if (e.getSource() == forward) {
				frame.remove(MakeSureChangeInfo.this);
				String ID = idField.getText();
				String name = cusNameLabel.getText();
				String tel = cusTel.getText();
				String add = cusAdd.getText();
				String code = cusCode.getText();
				String eBox = cusEBox.getText();
				String personText = person.getText();
				if(ID.equals("")||name.equals("")||tel.equals("")||add.equals("")||
						code.equals("")||eBox.equals("")||personText.equals("")){
					salesResult.failed("存在输入为空！", "MakeSureChangeInfo");
				}else{
					try{
				double mostOwe = Double.parseDouble(cusShouldPay.getText());
				double shouldGetMoney = Double.parseDouble(shouldGet.getText());
				double shouldPayMoney = Double.parseDouble(shouldPay.getText());
				customerVOAfter = new CustomerVO(ID,classification,level,name,tel,add,code,eBox,mostOwe,
						shouldGetMoney,shouldPayMoney,personText);
				SalesblService salesBlService = new SalesController();
				int i = salesBlService.updateCustomer_up(customerVOBefore,customerVOAfter);
				switch(i){
				case 0:
					salesResult.succeeded("修改成功！");
					break;
				case 3:
					salesResult.failed("客户的应收应付不为0", "MakeSureChangeInfo");
					break;
				default:
					salesResult.failed("未知错误！", "MakeSureChangeInfo");
				}
					}catch(Exception e2){
						salesResult.failed("请重新确认您的输入！", "MakeSureChangeInfo");
					}
				}
			} else if (e.getSource() == secondCusBack) {
				frame.remove(MakeSureChangeInfo.this);
				frame.setPanel(changeCusPanel);
				frame.repaint();
			}
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}
	}
}
