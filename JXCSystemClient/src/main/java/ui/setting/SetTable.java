package ui.setting;

import java.util.ArrayList;

import ui.AccountPanel;
import ui.ManagerPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;

public class SetTable {
	
	public SetTable(MyTable showTable,MyFrame frame,
			AccountAllUIController accountAllUIController) {
		AccountPanel temp = (AccountPanel)(accountAllUIController.getMainPanel());
		
		temp.accountThirdPanel.removeAll();
		temp.accountThirdPanel.add(showTable.tablePanel);
		temp.accountThirdPanel.repaint();
		temp.repaint();
		
		accountAllUIController.setMainPanel(temp);
		frame.setPanel(temp);
		frame.repaint();
	}
	
	public SetTable(MyTable showTable,MyFrame frame,
			ManagerAllUIController managerAllUIController) {
		ManagerPanel temp = (ManagerPanel)(managerAllUIController.getMainPanel());
		
		temp.managerThirdPanel.removeAll();
		temp.managerThirdPanel.add(showTable.tablePanel);
		temp.managerThirdPanel.repaint();
		temp.repaint();
		
		managerAllUIController.setMainPanel(temp);
		frame.setPanel(temp);
		frame.repaint();
	}
}
