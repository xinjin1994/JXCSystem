package ui.account;

import javax.swing.JFrame;



import ui.FatherPanel;
import ui.setting.MyFrame;

public class SalesListPanel extends FatherPanel{
	AccountAllUIController uiController;
	public SalesListPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		
		uiController.setBack(this);
		
		
	}
}
