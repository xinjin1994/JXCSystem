package ui.sales;

import ui.FatherPanel;
import ui.SalesManagerPanel;
import ui.UIController;
import ui.sales.cuspanel.AddCusPanel;
import ui.sales.cuspanel.CusPanel;
import ui.sales.impanel.ImPanel;
import ui.sales.salespanel.SalesPanel;
import ui.setting.MyFrame;


/**
 * controller 作用：用来创建ui，并且实现ui之间的跳转
 * @author lsy
 * @version 2014年12月1日下午7:36:37
 */
public class SalesUIController {

	private SalesManagerPanel salesManagerPanel;
	private MyFrame frame;
	private UIController uiController;
	private FatherPanel delCusPanel, changeCusPanel, seeCusInfoPanel;
	private AddCusPanel addCusPanel;
	private CusPanel cusPanel;
	private SalesPanel salesPanel;
	private ImPanel imPanel;
	
	public SalesUIController(UIController uiController, MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		this.salesManagerPanel = new SalesManagerPanel(frame, "Image/Sales/sales.jpg", uiController, this);
		this.setSalesPanel();
		this.setCusPanel();
		frame.setPanel(salesManagerPanel);
		frame.repaint();
	}
	
	public void setCusPanel() {
		addCusPanel = new AddCusPanel(frame,"Image/Sales/对话框/添加客户/addCustomer.jpg",uiController,this);
//		delCusPanel = new FatherPanel(frame,"Image/Sales/对话框/删除客户/删除客户_背景.jpg",uiController);
		changeCusPanel = new FatherPanel(frame,"",uiController);
		seeCusInfoPanel = new FatherPanel(frame,"Image/Sales/对话框/查找客户/查找客户对话框_背景.jpg",uiController);
	}
	
	public void setSalesPanel() {
		cusPanel = new CusPanel(this);
		salesPanel = new SalesPanel(this);	
		imPanel = new ImPanel(this);
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
	
	public void backPanel(FatherPanel panelNow) {
		frame.remove(panelNow);
		frame.setPanel(salesManagerPanel);
		frame.repaint();
	}
	
	public void toPanel(int cusPanelID){
		frame.remove(salesManagerPanel);
		switch(cusPanelID){
		case 0:
			frame.setPanel(addCusPanel);
			break;
		case 1:
			frame.setPanel(delCusPanel);
			break;
		case 2:
			frame.setPanel(changeCusPanel);
			break;
		case 3:
			frame.setPanel(seeCusInfoPanel);
			break;
		}
		frame.repaint();
	}
}

