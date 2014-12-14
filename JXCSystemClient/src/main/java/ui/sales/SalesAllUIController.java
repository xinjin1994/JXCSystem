package ui.sales;

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

public class SalesAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	
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
	
	public SalesAllUIController(UIController uiController,MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		addMainPanel();
	}

	private void addMainPanel() {
		new SalesUIController(this, frame);
		frame.repaint();
	}
}
