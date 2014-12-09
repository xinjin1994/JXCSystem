package ui.manager;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;

public class CheckProPanel extends FatherPanel{

	ManagerAllUIController uiController;
	MyFrame frame;
	public CheckProPanel(MyFrame frame, String url, ManagerAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.repaint();
	}
	
}
