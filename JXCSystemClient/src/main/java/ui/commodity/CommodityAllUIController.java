package ui.commodity;

import ui.UIController;
import ui.setting.MyFrame;

public class CommodityAllUIController extends UIController{
	private UIController uiController;
	private MyFrame frame;
	
	
	public CommodityAllUIController(UIController uiController,MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		addMainPanel();
	}


	private void addMainPanel() {
		new CommodityUIController(this, frame);
		frame.repaint();
	}
}
