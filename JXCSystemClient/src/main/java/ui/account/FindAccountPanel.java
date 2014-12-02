package ui.account;

import ui.FatherPanel;
import ui.setting.MyFrame;

public class FindAccountPanel extends FatherPanel{

	AccountAllUIController uiController;
	public FindAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack(this);
		
		
	}

}
