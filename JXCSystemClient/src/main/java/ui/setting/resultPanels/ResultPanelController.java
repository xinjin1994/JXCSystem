package ui.setting.resultPanels;

import ui.UIController;
import ui.account.AccountAllUIController;
import ui.setting.MyFrame;
/**
 * 控制所有结果panel的新建及跳转
 * @author ZYC
 *
 */
public class ResultPanelController extends UIController{
	UIController controller;
	MyFrame frame;
	/**
	 * 
	 * @param controller  其他界面的controller
	 */
	
	public ResultPanelController(UIController controller,MyFrame frame) {
		this.controller = controller;
		this.frame = frame;
	}
	public void delAcc() {
		AccountAllUIController accController = (AccountAllUIController)controller;
		accController.addMainPanel();
	}
	public void addAcc() {
		AccountAllUIController accController = (AccountAllUIController)controller;
		accController.addMainPanel();
	}
	public void chaAcc() {
		AccountAllUIController accController = (AccountAllUIController)controller;
		accController.addMainPanel();
	}
	
	
}
