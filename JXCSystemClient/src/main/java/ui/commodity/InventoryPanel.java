package ui.commodity;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;

public class InventoryPanel extends FatherPanel{
	MyFrame myFrame;
	CommodityAllUIController commodityAllUIController;
	
	public InventoryPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		this.commodityAllUIController = controller;
		commodityAllUIController.setBack_first(this);
		setTable();
	}
	private void setTable() {
		
	}

}
