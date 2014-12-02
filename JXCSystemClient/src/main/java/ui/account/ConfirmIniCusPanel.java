package ui.account;

import ui.FatherPanel;
import ui.setting.MyFrame;

public class ConfirmIniCusPanel extends FatherPanel{
	AccountAllUIController uiController;
	public ConfirmIniCusPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_first(this);
		
		
	}
}
