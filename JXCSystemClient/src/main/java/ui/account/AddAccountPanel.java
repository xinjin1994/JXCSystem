package ui.account;

import ui.FatherPanel;

import ui.setting.MyFrame;

public class AddAccountPanel extends FatherPanel{
	AccountAllUIController uiController;
	public AddAccountPanel(MyFrame frame, String string,
			AccountAllUIController accountAllUIController) {
		super(frame,string,accountAllUIController);
		this.uiController = accountAllUIController;
		this.repaint();
		
		uiController.setBack(this);
	}

}
