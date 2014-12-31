package ui.admin;

//import junit.awtui.Logo;
import ui.AdminPanel;
import ui.CommodityPanel;
import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.SetBack;
import ui.setting.Button.LogOutButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.UserVO;
/**
 * 控制Admin模块各个界面的跳转
 * @author ZYC
 *
 */
public class AdminAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	private AddUserPanel addUserPanel;
	private DelUserPanel delUserPanel;
	static public AdminPanel adminPanel;
	private ConfirmUserPanel confirmUserPanel;
 
	
	private ResultPanelController resController;
	public AdminAllUIController(UIController uiController,MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		resController = new ResultPanelController(frame, adminPanel);
		addMainPanel();
		
	}
	public void logOut(){
		new LogOutButton(frame, adminPanel, "admin", uiController);
	}
	private void addMainPanel() {
		adminPanel = new AdminPanel(frame, "Image/User/user.jpg", uiController,this);
		logOut();
		frame.setPanel(adminPanel);
		frame.repaint();
		setMainPanel(adminPanel);
	}
	public void addUser(){
		this.setMainPanel(adminPanel);
		
		addUserPanel = new AddUserPanel(frame, "Image/User/addUser.jpg", this);
		frame.setPanel(addUserPanel);
		frame.repaint();
	}
	public void delUser() {
		this.setMainPanel(adminPanel);
		
		delUserPanel = new DelUserPanel(frame, "Image/User/delUser.jpg", this);
		frame.setPanel(delUserPanel);
		frame.repaint();
	}
	

	
	public void confirmUserPanel(UserVO user,String type){
		confirmUserPanel = new ConfirmUserPanel(frame,"Image/User/ConfirmUser.jpg", this, user,type);
		confirmUserPanel.setLocation(0, 217);
		adminPanel.add(confirmUserPanel);
		adminPanel.repaint();
	}
	
	public void confirmUserPanel(UserVO user,String type,FatherPanel panel){
		confirmUserPanel = new ConfirmUserPanel(frame,"Image/User/ConfirmUser.jpg", this, user,type,panel);
		confirmUserPanel.setLocation(0, 217);
		adminPanel.add(confirmUserPanel);
		adminPanel.repaint();
	}
	
//	public void confirmUserDel(UserVO user,String type){
//		confirmUserPanel = new ConfirmUserDel(frame,"Image/User/ConfirmUser.jpg", this, user,type);
//		confirmUserPanel.setLocation(0, 217);
//		adminPanel.add(confirmUserPanel);
//		adminPanel.repaint();
//	}
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
//	public void setResult(String type) {
//	//	setMainPanel(adminPanel);
//		adminPanel.remove(confirmUserPanel);
//		frame.remove(adminPanel);
//		resController.succeeded("成功"+type+"用户！", "user");
//	}
}
