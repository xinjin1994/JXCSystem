package ui.admin;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import businesslogic.initializationlbl.UserInfo;
import ui.FatherPanel;
import ui.UIController;
import ui.AdminPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.SetBack;
import ui.setting.resultPanels.ResultPanelController;
import vo.UserVO;

public class AdminAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	private AddUserPanel addUserPanel;
	private DelUserPanel delUserPanel;
	private AdminPanel adminPanel;
	private ConfirmUserPanel confirmUserPanel;
 
	
	private ResultPanelController resController;
	public AdminAllUIController(UIController uiController,MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		resController = new ResultPanelController(this, frame);
		addMainPanel();
	}
	private void addMainPanel() {
		adminPanel = new AdminPanel(frame, "Image/User/user.jpg", uiController,this);
		frame.setPanel(adminPanel);
		frame.repaint();
		setMainPanel(adminPanel);
	}
	public void addUser(){
		addUserPanel = new AddUserPanel(frame, "Image/User/addUser.jpg", this);
		frame.setPanel(addUserPanel);
		frame.repaint();
	}
	public void delUser() {
		delUserPanel = new DelUserPanel(frame, "Image/User/delUser.jpg", this);
		frame.setPanel(delUserPanel);
		frame.repaint();
	}
	

	
	public void confirmUserPanel(UserVO user,String type){
		confirmUserPanel = new ConfirmUserPanel(frame,"Image/User/confirmUser.jpg", this, user,type);
		confirmUserPanel.setLocation(0, 217);
		adminPanel.add(confirmUserPanel);
		adminPanel.repaint();
	}
	
	/**
	 * 以下两个是admin模块中的返回按钮，都会返回到主界面
	 * @param prePanel
	 */

	public void setBack_first(FatherPanel prePanel){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_first();
	}

	public void setBack_second(FatherPanel prePanel,int x,int y){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_second(x, y);
	}
	/**
	 * 返回主界面
	 * @param type
	 */
	public void setResult(String type) {
	//	setMainPanel(adminPanel);
		adminPanel.remove(confirmUserPanel);
		frame.remove(adminPanel);
		resController.succeeded("成功"+type+"用户！", "admin");
	}
}
