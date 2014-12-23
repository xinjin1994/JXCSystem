package ui.sales;

import java.util.ArrayList;

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
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.ThirdPanel;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

/**
 * controller 作用：用来创建ui，并且实现ui之间的跳转
 * @author lsy
 * @version 2014年12月1日下午7:36:37
 */
public class SalesUIController {
	
	private SalesManagerPanel salesManagerPanel;
	private MyFrame frame;
	private UIController uiController;
	private CusPanel cusPanel;
	private SalesPanel salesPanel;
	private ImPanel imPanel;
	private ThirdPanel thirdPanel;
	private MyTable showTable; 
	private ColorFactory colors = new ColorFactory();
	private SalesblService salesblService;
	
	public SalesUIController(UIController uiController, MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		this.thirdPanel = new ThirdPanel();
		this.salesManagerPanel = new SalesManagerPanel(frame, "Image/Sales/sales.jpg", uiController, this,thirdPanel);
		salesblService = new SalesController();
		salesManagerPanel.add(thirdPanel);
		this.setSalesPanel();
		frame.setPanel(salesManagerPanel);
		frame.repaint();
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
//		if(!panelNow.equals(seeCusInfoPanel)){
//			setCustomer();
//		}
		frame.remove(panelNow);
		frame.setPanel(salesManagerPanel);
		frame.repaint();
	}
	
	public void toPanel(int cusPanelID){
		frame.remove(salesManagerPanel);
		thirdPanel.removeAll();
		switch(cusPanelID){
		case 0:
			frame.setPanel(new AddCusPanel(frame,"Image/Sales/对话框/添加客户/addCustomer.jpg",uiController,this));
			break;
		case 1:
			frame.setPanel(new DelCusPanel(frame,"Image/Sales/对话框/删除客户/删除_查找客户对话框_背景.jpg",uiController,this));
			break;
		case 2:
			frame.setPanel(new ChangeCusPanel(frame,"Image/Sales/对话框/修改客户/修改客户对话框_背景.jpg",uiController,this));
			break;
		case 3:
			frame.setPanel(new FindCusPanel(frame,"Image/Sales/对话框/查找客户/查找客户对话框_背景.jpg",uiController,this,thirdPanel));
			break;
		case 4:
			frame.setPanel(new ImInPanel(frame,"Image/Sales/对话框/创建进货单/创建进货单_背景.jpg",uiController,this));
		    break;
		case 5:
			frame.setPanel(new ImBackPanel(frame,"Image/Sales/对话框/创建进货单/创建进货退货单_背景.jpg",uiController,this));
			break;
		case 6:
			frame.setPanel(new SalesInPanel(frame,"Image/Sales/对话框/创建销售单/创建销售单_背景.jpg",uiController,this));
			break;
		case 7:
			frame.setPanel(new SalesBackPanel(frame,"Image/Sales/对话框/创建销售单/创建销售退货单_背景.jpg",uiController,this));
			break;
		}
		frame.repaint();
	}
}

