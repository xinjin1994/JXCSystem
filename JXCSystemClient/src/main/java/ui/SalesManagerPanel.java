package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.sales.SalesUIController;

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
	private MyButton detail, back;
	private SalesUIController salesController;

	public SalesManagerPanel(JFrame frame, String url, UIController controller, SalesUIController salesController) {
		super(frame, url, controller);
		this.salesController = salesController;
		this.addButton();
		this.addRestButton();
	}

	public void addButton() {

		cusManage = new MyButton("Image/Sales/Sales_image/客户管理.png", firstX, firstY,
				"Image/Sales/Sales_image/客户管理_stop.png", "Image/Sales/Sales_image/客户管理_press_on.png");
		salesManage = new MyButton("Image/Sales/Sales_image/销售管理.png", firstX - 2, firstY + inter,
				"Image/Sales/Sales_image/销售管理_stop.png", "Image/Sales/Sales_image/销售管理_press_on.png");
		importManage = new MyButton("Image/Sales/Sales_image/进货管理.png", firstX - 1, firstY + 2 * inter,
				"Image/Sales/Sales_image/进货管理_stop.png", "Image/Sales/Sales_image/进货管理_press_on.png");
		this.add(cusManage);
		this.add(salesManage);
		this.add(importManage);
		FirstButtonListener listener = new FirstButtonListener();
		cusManage.addMouseListener(listener);
		salesManage.addMouseListener(listener);
		importManage.addMouseListener(listener);
	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
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

	public void addRestButton() {
		detail = new MyButton("Image/Sales/Sales_image/details.png", 670, 537,
				"Image/Sales/Sales_image/details.png", "Image/Sales/Sales_image/details_press_on.png");
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(detail);
		this.add(back);
	}

}
