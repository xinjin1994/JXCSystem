package ui.account;

import ui.AccountPanel;
import ui.FatherPanel;
import ui.setting.MyFrame;

public class AddReceiptPanel extends FatherPanel{
	AccountAllUIController uiController;
	public AddReceiptPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack(this);
		
		
	}
}
