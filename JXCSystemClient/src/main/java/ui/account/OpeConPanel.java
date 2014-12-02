package ui.account;

import ui.FatherPanel;
import ui.setting.MyFrame;

public class OpeConPanel extends FatherPanel{
	AccountAllUIController uiController;
	public OpeConPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,149,137);
		
		
	}
}
