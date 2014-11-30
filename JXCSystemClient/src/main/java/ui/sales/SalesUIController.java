package ui.sales;

import ui.MyButton;
import ui.MyFrame;
import ui.SalesManagerPanel;
import ui.UIController;

public class SalesUIController {

	private SecondPanel cusPanel, salesPanel, imPanel;
	private MyButton addCus, delCus, changeCusInfo, seeCusInfo;
	private MyButton importMenu,importBackMenu;
	private MyButton salesMenu,salesBackMenu ;
	private SalesManagerPanel salesManagerPanel;
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	
	public SalesUIController(UIController uiController, MyFrame frame) {
		this.salesManagerPanel = new SalesManagerPanel(frame, "Image/Sales/sales.jpg", uiController, this);
		frame.setPanel(salesManagerPanel);
		frame.repaint();
		cusPanel = new SecondPanel();
		salesPanel = new SecondPanel();
		imPanel = new SecondPanel();
		this.addCusButton();
		this.addImportButton();
		this.addSalesButton();
	}
	
	public void addCusButton() {

		addCus = new MyButton("Image/Sales/Sales_image/增加用户.png", secondX, secondY,
				"Image/Sales/Sales_image/增加用户_stop.png", "Image/Sales/Sales_image/增加客户_press_on.png");
		delCus = new MyButton("Image/Sales/Sales_image/删除客户.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/删除客户_stop.png", "Image/Sales/Sales_image/删除客户_press_on.png");
		changeCusInfo = new MyButton("Image/Sales/Sales_image/修改客户信息.png", secondX, secondY + 2 * inter,
				"Image/Sales/Sales_image/修改客户信息_stop.png", "Image/Sales/Sales_image/修改客户信息_press_on.png");
		seeCusInfo = new MyButton("Image/Sales/Sales_image/查看客户信息.png", secondX, secondY + 3 * inter,
				"Image/Sales/Sales_image/查看客户信息_stop.png", "Image/Sales/Sales_image/查看客户信息_press_on.png");
		cusPanel.add(addCus);
		cusPanel.add(delCus);
		cusPanel.add(changeCusInfo);
		cusPanel.add(seeCusInfo);
	}

	public void addImportButton() {

		importMenu = new MyButton("Image/Sales/Sales_image/进货单.png", secondX, secondY,
				"Image/Sales/Sales_image/进货单_stop.png", "Image/Sales/Sales_image/进货单_press_on.png");
		importBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/进货退货单_stop.png", "Image/Sales/Sales_image/进货退货单_press_on.png");
		imPanel.add(importMenu);
		imPanel.add(importBackMenu);
	}

	public void addSalesButton() {
		salesMenu = new MyButton("Image/Sales/Sales_image/销售单.png", secondX, secondY,
				"Image/Sales/Sales_image/销售单_stop.png", "Image/Sales/Sales_image/销售单_press_on.png");
		salesBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/进货退货单_stop.png", "Image/Sales/Sales_image/进货退货单_press_on.png");
		salesPanel.add(salesMenu);
		salesPanel.add(salesBackMenu);

	}
	
	public void toCusPanel(){
		salesPanel.setVisible(false);
		imPanel.setVisible(false);
		cusPanel.setVisible(true);
		salesManagerPanel.add(cusPanel);
		salesManagerPanel.repaint();
	}
	
	public void toSalesPanel() {
		cusPanel.setVisible(false);
		imPanel.setVisible(false);
		salesPanel.setVisible(true);
	    salesManagerPanel.add(salesPanel);
	    salesManagerPanel.repaint();
	}
	
	public void toImPanel() {
		salesPanel.setVisible(false);
		cusPanel.setVisible(false);
		imPanel.setVisible(true);
		salesManagerPanel.add(imPanel);
		salesManagerPanel.repaint();
	}
	
	
}
