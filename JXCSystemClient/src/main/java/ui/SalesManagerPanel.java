package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 3销售经理
 * 
 * @author lsy
 * @version 2014年11月29日下午2:54:20
 */
public class SalesManagerPanel extends FatherPanel {

	int firstX = 2;
	int firstY = 110;
	int inter = 54;
	int secondX = 1;
	int secondY = 35;
	int secPanelX=176,secPanelY=75,secPanelWidth=174,secPanelHeight=525;

	MyFirstButton cusManage, salesManage, importManage;
	MyButton addCus, delCus, changeCusInfo, seeCusInfo, importMenu, importBackMenu, salesMenu, salesBackMenu,
			detail, back;

	JPanel cusPanel,salesPanel,imPanel;
	JFrame frame;

	public SalesManagerPanel(JFrame frame, String url, UIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.newPanel();
		this.addButton();
		}
	
	public void newPanel(){
		cusPanel = new JPanel();
		cusPanel.setLayout(null);
		cusPanel.setOpaque(false);
		cusPanel.setBounds(secPanelX, secPanelY, secPanelWidth, secPanelHeight);
		
		salesPanel = new JPanel();
		salesPanel.setLayout(null);
		salesPanel.setOpaque(false);
		salesPanel.setBounds(secPanelX, secPanelY, secPanelWidth, secPanelHeight);
		
		imPanel = new JPanel();
		imPanel.setLayout(null);
		imPanel.setOpaque(false);
		imPanel.setBounds(secPanelX, secPanelY, secPanelWidth, secPanelHeight);
	}

	private static final long serialVersionUID = -4472929361380810275L;

	

	public void addButton() {

		cusManage = new MyFirstButton("Image/Sales/Sales_image/客户管理.png", firstX, firstY, 
				"Image/Sales/Sales_image/客户管理_stop.png", "Image/Sales/Sales_image/客户管理_press_on.png");
		salesManage = new MyFirstButton("Image/Sales/Sales_image/销售管理.png", firstX - 2, firstY + inter, 
				"Image/Sales/Sales_image/销售管理_stop.png", "Image/Sales/Sales_image/销售管理_press_on.png");
		importManage = new MyFirstButton("Image/Sales/Sales_image/进货管理.png", firstX - 1, firstY + 2 * inter, 
				"Image/Sales/Sales_image/进货管理_stop.png", "Image/Sales/Sales_image/进货管理_press_on.png");
		this.add(cusManage);
		this.add(salesManage);
		this.add(importManage);
		addCus = new MyButton("Image/Sales/Sales_image/增加用户.png", secondX, secondY, 
				"Image/Sales/Sales_image/增加用户_stop.png", "Image/Sales/Sales_image/增加客户_press_on.png");
		delCus = new MyButton("Image/Sales/Sales_image/删除客户.png", secondX, secondY + inter, 
				"Image/Sales/Sales_image/删除客户_stop.png", "Image/Sales/Sales_image/删除客户_press_on.png");
		changeCusInfo = new MyButton("Image/Sales/Sales_image/修改客户信息.png", secondX, secondY + 2 * inter,
				 "Image/Sales/Sales_image/修改客户信息_stop.png",
				"Image/Sales/Sales_image/修改客户信息_press_on.png");
		seeCusInfo = new MyButton("Image/Sales/Sales_image/查看客户信息.png", secondX, secondY + 3 * inter, 
				"Image/Sales/Sales_image/查看客户信息_stop.png", "Image/Sales/Sales_image/查看客户信息_press_on.png");
		cusPanel.add(addCus);
		cusPanel.add(delCus);
		cusPanel.add(changeCusInfo);
		cusPanel.add(seeCusInfo);	

		importMenu = new MyButton("Image/Sales/Sales_image/进货单.png", secondX, secondY, 
				"Image/Sales/Sales_image/进货单_stop.png", "Image/Sales/Sales_image/进货单_press_on.png");
		importBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/进货退货单_stop.png", "Image/Sales/Sales_image/进货退货单_press_on.png");
		salesPanel.add(importMenu);
		salesPanel.add(importBackMenu);
		salesMenu = new MyButton("Image/Sales/Sales_image/销售单.png", secondX, secondY,
				"Image/Sales/Sales_image/销售单_stop.png", "Image/Sales/Sales_image/销售单_press_on.png");
		salesBackMenu = new MyButton("Image/Sales/Sales_image/进货退货单.png", secondX, secondY + inter,
				"Image/Sales/Sales_image/进货退货单_stop.png", "Image/Sales/Sales_image/进货退货单_press_on.png");
	    imPanel.add(salesMenu);
	    imPanel.add(salesBackMenu);
		detail = new MyButton("Image/Sales/Sales_image/details.png", 670, 537, "Image/Sales/Sales_image/details.png",
				"Image/Sales/Sales_image/details_press_on.png");
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(detail);
		this.add(back);
		cusManage.showSecondPanel(this,cusPanel);
		salesManage.showSecondPanel(this, salesPanel);
		importManage.showSecondPanel(this, imPanel);
	}


}
