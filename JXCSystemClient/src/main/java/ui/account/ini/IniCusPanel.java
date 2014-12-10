package ui.account.ini;

import ui.account.AccountAllUIController;
import ui.setting.FatherPanel;
import ui.setting.MyFrame;

public class IniCusPanel extends FatherPanel{
	AccountAllUIController uiController;
	public IniCusPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_first(this);
		
		
	}
}
