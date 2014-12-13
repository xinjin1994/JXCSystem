package ui.sales.salespanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.UIController;
import ui.sales.SalesUIController;
import ui.sales.impanel.ImInPanel;
import ui.sales.impanel.MakeSureIm;
import ui.setting.MyFrame;
import ui.setting.Button.MyButton;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class SalesBackPanel extends SalesInPanel{

	public SalesBackPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController){
		super(frame, url, controller,salesUIController);
	//	this.remove(remark);
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
	
	class MouListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == back) {
				salesUIController.backPanel(SalesBackPanel.this);
			} else if (e.getSource() == forward) {
				if(id.getText().equals("")||newRemark.getText().equals("")||supplier.getText().equals("")||
						warehouse.getText().equals("")||person.getText().equals("")||operator.getText().equals("")){
					failLabel.setText("请正确输入信息！");
				}else{
				CommodityListVO commodityListVO = new CommodityListVO(id.getText(), goodsNameSelected,
						goodsTypeSelected, num, price, num*price, newRemark.getText());
				ExportMenuVO exportMenuVO = new ExportMenuVO(id.getText(), supplier.getText(),person.getText(),
						warehouse.getText(), commodityListVO,Double.parseDouble(discount.getText()),Double.parseDouble(voucher.getText()),totalPriceText,5);
				MakeSureIm makeSureIm = new MakeSureIm(frame, "Image/Sales/对话框/创建销售单/创建销售单_背景.jpg", controller,
						exportMenuVO, commodityListVO, person.getText(), operator.getText(), SalesBackPanel.this,salesUIController);
				frame.remove(SalesBackPanel.this);
				frame.setPanel(makeSureIm);
				}
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
