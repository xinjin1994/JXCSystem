package ui.sales.salespanel;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import businesslogic.userbl.User;
import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.sales.impanel.ImInPanel;
import ui.sales.impanel.MakeSureIm;
import ui.setting.MyFrame;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldFilled;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;

public class SalesInPanel extends ImInPanel{

	MyTextFieldFilled newRemark;
	SalesResult salesResult = new SalesResult(frame,controller,salesUIController,SalesInPanel.this);
	public SalesInPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController){
		super(frame, url, controller,salesUIController);
		this.remove(remark);
		this.addRestText();
	}
	
	public void addButton() {
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back);
		this.add(forward);
		back.addMouseListener(new MouListener());
		forward.addMouseListener(new MouListener());
	}
	
	public void addRestText(){
		newRemark = new MyTextFieldFilled(104,420,104,118);
		discount = new MyTextFieldFilled(235, 421, 91, 37);
		voucher = new MyTextFieldFilled(235, 500, 91, 27);
		this.add(newRemark);
		this.add(discount);
		this.add(voucher);
		discount.addFocusListener(new disLis());
	}
	
	class disLis implements FocusListener{

		public void focusGained(FocusEvent e) {
		}

		public void focusLost(FocusEvent e) {
			double dis = Double.parseDouble(discount.getText());
			int i = User.duty;
			if(i == 2){
				//销售人员
				if(dis>1000){
					salesResult.failed("您的权限无法制定此价值的折让！", "export_failed");
				}
			}else if(i == 3){
				//销售经理
				if(dis>5000){
					salesResult.failed("您的权限无法制定此价值的折让！", "export_failed");
				}
			}
		}
		
	}

	public void getPrice() {
		goodsTypeSelected = goodsType.getSelectedItem().toString();
		 commodityVO = salesblService.getCommodity_up(goodsNameSelected,
		 goodsTypeSelected);
		 goodsPrice.setText(commodityVO.outValue+"");
//		goodsPrice.setText("30");
		this.add(goodsPrice);
		try{
			 price = Double.parseDouble(goodsPrice.getText());
			 if(price <= 0){
				 this.addLabel();
			 	}
			 }catch(Exception e){
				 this.addLabel();
			 }
		//		price = 30;
	}
	public void getTotalPrice() {
		try{
			totalPriceText = Double.parseDouble(goodsPrice.getText()) * num-Double.parseDouble(discount.getText())-Double.parseDouble(voucher.getText());
			goodsTotal.setText(totalPriceText + "");
			this.add(goodsTotal);
		}catch(Exception e2){
			failLabel.setText("请正确输入信息！");
		}
	}
	class MouListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(SalesInPanel.this);
			} else if (e.getSource() == forward) {
				
				if(id.getText().equals("")||newRemark.getText().equals("")||supplier.getText().equals("")||
						warehouse.getText().equals("")||person.getText().equals("")||operator.getText().equals("")){
					salesResult.failed("请重新确认输入信息！", "export_failed");
				}else{
				CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
						goodsTypeSelected, num, price, num*price, newRemark.getText());

				ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplier.getText(),person.getText(),
						warehouse.getText(), commodityListVO,Double.parseDouble(discount.getText()),Double.parseDouble(voucher.getText()),totalPriceText,4);
				MakeSureIm makeSureIm = new MakeSureIm(frame, "Image/Sales/对话框/创建销售单/创建销售单_背景.jpg", controller,
						exportMenuVO, commodityListVO, person.getText(), operator.getText(), SalesInPanel.this,salesUIController);
				frame.remove(SalesInPanel.this);
				frame.setPanel(makeSureIm);
				}
				frame.repaint();
			} else if (e.getSource() == goodsName) {
				setType();
			} else if (e.getSource() == goodsType) {
				setGoodsID();
				getPrice();
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
