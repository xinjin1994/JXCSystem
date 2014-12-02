package ui.account;

import ui.FatherPanel;

import ui.setting.MyFrame;

public class AllBillsPanel extends FatherPanel{
	AccountAllUIController uiController;
	public AllBillsPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		
		this.repaint();
		uiController.setBack_second(this,141,57);
	}
}
