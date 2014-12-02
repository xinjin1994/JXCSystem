package ui.account;

import ui.FatherPanel;
import ui.setting.MyFrame;

public class AddPaymentPanel extends FatherPanel{
	AccountAllUIController uiController;
	public AddPaymentPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack(this);
		
		
	}
}
