package ui.account.ini;

import ui.account.AccountAllUIController;
import ui.setting.FatherPanel;
import ui.setting.MyFrame;

public class IniAccPanel extends FatherPanel{
	AccountAllUIController uiController;
	public IniAccPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_first(this);
		
	}
}
