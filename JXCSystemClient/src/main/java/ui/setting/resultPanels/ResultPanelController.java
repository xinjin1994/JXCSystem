package ui.setting.resultPanels;

import ui.UIController;
import ui.account.AccountAllUIController;
import ui.setting.MyFrame;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
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
	private AccountblService accountblService;
//	private AccountVO vo;
	
	public ResultPanelController(UIController controller,MyFrame frame) {
		this.controller = controller;
		this.frame = frame;
//		this.vo = vo;
		accountblService = new AccountController();
	}
	public void delAcc() {
		AccountAllUIController accController = (AccountAllUIController)controller;
		accController.addMainPanel();
	}
	public void addAcc() {
		AccountAllUIController accController = (AccountAllUIController)controller;
		accController.addMainPanel();
	/*	switch(accountblService.addAccount_up(vo)){
		case -1:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}*/
		
	}
	public void chaAcc() {
		AccountAllUIController accController = (AccountAllUIController)controller;
		accController.addMainPanel();
	}
	
	
}
