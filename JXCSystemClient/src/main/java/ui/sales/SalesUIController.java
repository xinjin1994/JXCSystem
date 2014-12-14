package ui.sales;

import ui.FatherPanel;
import ui.SalesManagerPanel;
import ui.UIController;
import ui.sales.cuspanel.AddCusPanel;
import ui.sales.cuspanel.ChangeCusPanel;
import ui.sales.cuspanel.CusPanel;
import ui.sales.cuspanel.DelCusPanel;
import ui.sales.cuspanel.FindCusPanel;
import ui.sales.impanel.ImBackPanel;
import ui.sales.impanel.ImInPanel;
import ui.sales.impanel.ImPanel;
import ui.sales.salespanel.SalesBackPanel;
import ui.sales.salespanel.SalesInPanel;
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
	private FindCusPanel seeCusInfoPanel;
	private AddCusPanel addCusPanel;
	private DelCusPanel delCusPanel;
	private CusPanel cusPanel;
	private SalesPanel salesPanel;
	private ImPanel imPanel;
	private ImInPanel imInPanel;
	private ChangeCusPanel changeCusPanel;
	private ImBackPanel imBackPanel;
	private SalesInPanel salesInPanel;
	private SalesBackPanel salesBackPanel;
	private UIController uiController;
	
	public SalesUIController(UIController uiController, MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		this.salesManagerPanel =  new SalesManagerPanel(frame, "Image/Sales/sales.jpg", uiController, this);
		this.setSalesPanel();
		this.setAllPanel();
		frame.setPanel(salesManagerPanel);
		
		frame.repaint();
	}
	
	public void setAllPanel() {
		addCusPanel = new AddCusPanel(frame,"Image/Sales/对话框/添加客户/addCustomer.jpg",uiController,this);
		delCusPanel = new DelCusPanel(frame,"Image/Sales/对话框/删除客户/删除_查找客户对话框_背景.jpg",uiController,this);
		changeCusPanel = new ChangeCusPanel(frame,"Image/Sales/对话框/修改客户/修改客户对话框_背景.jpg",uiController,this);
		seeCusInfoPanel = new FindCusPanel(frame,"Image/Sales/对话框/查找客户/查找客户对话框_背景.jpg",uiController,this);
		imInPanel = new ImInPanel(frame,"Image/Sales/对话框/创建进货单/创建进货单_背景.jpg",uiController,this);
		imBackPanel = new ImBackPanel(frame,"Image/Sales/对话框/创建进货单/创建进货退货单_背景.jpg",uiController,this);
	    salesInPanel = new SalesInPanel(frame,"Image/Sales/对话框/创建销售单/创建销售单_背景.jpg",uiController,this);
	    salesBackPanel = new SalesBackPanel(frame,"Image/Sales/对话框/创建销售单/创建销售退货单_背景.jpg",uiController,this);
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
		case 4:
			frame.setPanel(imInPanel);
		    break;
		case 5:
			frame.setPanel(imBackPanel);
			break;
		case 6:
			frame.setPanel(salesInPanel);
			break;
		case 7:
			frame.setPanel(salesBackPanel);
			break;
		}
		frame.repaint();
	}
}

