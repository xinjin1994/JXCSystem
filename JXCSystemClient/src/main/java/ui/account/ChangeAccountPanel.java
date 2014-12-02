package ui.account;

import ui.FatherPanel;
import ui.setting.MyFrame;

public class ChangeAccountPanel extends FatherPanel{
	AccountAllUIController uiController;
	public ChangeAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,199,141);
		
		
	}
}
