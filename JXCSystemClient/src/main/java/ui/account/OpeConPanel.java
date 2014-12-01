package ui.account;

import ui.FatherPanel;
import ui.MyFrame;

public class OpeConPanel extends FatherPanel{
	public OpeConPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.repaint();
	}
}
