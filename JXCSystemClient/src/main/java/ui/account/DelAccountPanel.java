package ui.account;

import javax.swing.JFrame;



import ui.FatherPanel;
import ui.setting.MyFrame;

public class DelAccountPanel extends FatherPanel{
	AccountAllUIController uiController;
	public DelAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,199,141);
		
		
	}
}
