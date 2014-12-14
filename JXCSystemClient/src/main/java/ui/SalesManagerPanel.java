package ui;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.Button.MyButton;

/**
 * 3销售经理
 * 
 * @author lsy
 * @version 2014年11月29日下午2:54:20
 */
public class SalesManagerPanel extends FatherPanel {

	private static final long serialVersionUID = -4472929361380810275L;
	private int firstX = 2;
	private int firstY = 110;
	private int inter = 54;
	
	private MyButton cusManage, salesManage, importManage;
	private SalesUIController salesController;
	public MyFrame frame;
	private MyButton detail, firstBack;
	private UIController controller;

	public SalesManagerPanel(MyFrame frame, String url, UIController controller, SalesUIController salesController) {
		super(frame, url, controller);
		this.frame = frame;
		this.controller = controller;
		this.salesController = salesController;
		this.addButton();
	}
	


	public void removeThis(JFrame frame) {
		frame.remove(this);
	}
/*	private void testTable() {
		ArrayList <String> info = new ArrayList<String>();
		info.add("a;b;c;e");
		info.add("s,r,t,h");
		info.add("w;t;x;h");
		info.add("gg");
		MyTable testTable = new MyTable();
		testTable.setTable(info);
		testTable.add("a;g;g");
		testTable.find(1, 2);
		testTable.del(3);
		
	}*/


	public void addButton() {

		cusManage = new MyButton("Image/Sales/Sales_image/客户管理.png", firstX, firstY,
				"Image/Sales/Sales_image/客户管理_stop.png", "Image/Sales/Sales_image/客户管理_press_on.png");
		salesManage = new MyButton("Image/Sales/Sales_image/销售管理.png", firstX - 2, firstY + inter,
				"Image/Sales/Sales_image/销售管理_stop.png", "Image/Sales/Sales_image/销售管理_press_on.png");
		importManage = new MyButton("Image/Sales/Sales_image/进货管理.png", firstX - 1, firstY + 2 * inter,
				"Image/Sales/Sales_image/进货管理_stop.png", "Image/Sales/Sales_image/进货管理_press_on.png");
		detail = new MyButton("Image/Sales/Sales_image/details.png", 670, 537,
				"Image/Sales/Sales_image/details.png", "Image/Sales/Sales_image/details_press_on.png");
		firstBack = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(detail);
		this.add(firstBack);
		this.add(cusManage);
		this.add(salesManage);
		this.add(importManage);
		FirstButtonListener listener = new FirstButtonListener();
		firstBack.addMouseListener(listener);
		cusManage.addMouseListener(listener);
		salesManage.addMouseListener(listener);
		importManage.addMouseListener(listener);
	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == firstBack){
				frame.remove(SalesManagerPanel.this);
				controller.backLoginPanel();
				frame.repaint();
				
			}
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == cusManage) {
				salesController.toCusPanel();
			}else if(e.getSource() == salesManage) {
				salesController.toSalesPanel();
			}else if(e.getSource() == importManage) {
				salesController.toImPanel();
			}
		}

		public void mouseExited(MouseEvent e) {
		}
		
	}

}
