package ui.setting;

import java.awt.Color;
import java.util.ArrayList;

import businesslogic.commoditybl.Commodity;
import ui.AccountPanel;
import ui.CommodityPanel;
import ui.ManagerPanel;
import ui.account.AccountAllUIController;
import ui.commodity.CommodityAllUIController;
import ui.manager.ManagerAllUIController;
/**
 * 设置表格
 * @author ZYC
 *
 */
public class SetTable {
	
	private ColorFactory color = new ColorFactory();
	public SetTable(MyTable showTable,MyFrame frame,
			AccountAllUIController accountAllUIController) {
		AccountPanel temp = (AccountPanel)(accountAllUIController.getMainPanel());
		
		temp.accountThirdPanel.removeAll();
		temp.accountThirdPanel.add(showTable.tablePanel);
		temp.accountThirdPanel.repaint();
		temp.repaint();
		
		accountAllUIController.setMainPanel(temp);
//		frame.setPanel(temp);
//		frame.repaint();
	}
	
	public SetTable(MyTable showTable,MyFrame frame,
			ManagerAllUIController managerAllUIController) {
		ManagerPanel temp = (ManagerPanel)(managerAllUIController.getMainPanel());
		
//		showTable.setColor(color.manTableColor,color.manBkColor, color.manColor,color.manColor);
		temp.managerThirdPanel.removeAll();
		temp.managerThirdPanel.add(showTable.tablePanel);
		temp.managerThirdPanel.repaint();
		temp.repaint();
		
		managerAllUIController.setMainPanel(temp);
		frame.setPanel(temp);
		frame.repaint();
	}
	public SetTable(MyTable showTable,MyFrame frame,
			CommodityAllUIController commodityAllUIController) {
		CommodityPanel temp = (CommodityPanel)(commodityAllUIController.getMainPanel());
		
		temp.commodityThirdPanel.removeAll();
		temp.commodityThirdPanel.add(showTable.tablePanel);
		temp.commodityThirdPanel.repaint();
		temp.repaint();
		
		commodityAllUIController.setMainPanel(temp);
		frame.setPanel(temp);
		frame.repaint();
	}
}
