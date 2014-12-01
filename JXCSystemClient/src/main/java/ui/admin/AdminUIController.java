package ui.admin;

import ui.AccountPanel;
import ui.AdminPanel;
import ui.MyButton;
import ui.MyFrame;
import ui.UIController;
import ui.sales.SecondPanel;

public class AdminUIController {

	
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	
	private SecondPanel adminSecondPanel;
	private AdminPanel adminPanel;
	private MyButton addUser, delUser, changeUser, findUser;
	
	private MyButton []userButtons = new MyButton[]{addUser, delUser, changeUser, findUser};

	public AdminUIController(UIController uiController, MyFrame frame){
		this.adminPanel = new AdminPanel(frame, "Image/Admin/admin_背景", uiController,this);
		frame.setPanel(adminPanel);
	}
	public void toUserPanel() {
		String images_ori_user[] = new String[]{"Image/Admin/button/userManage/addUser.png","Image/Admin/button/userManage/delUser.png",
				"Image/Admin/button/userManage/changeUser.png","Image/Admin/button/userManage/findUser.png"};
		String images_stop_user[] = new String[]{"Image/Admin/button/userManage/addUser_stop.png","Image/Admin/button/userManage/delUser_stop.png",
				"Image/Admin/button/userManage/changeUser_stop.png","Image/Admin/button/userManage/findUser_stop.png"};
		String images_press_on_user[] = new String[]{"Image/Admin/button/userManage/addUser_press_on.png","Image/Admin/button/userManage/delUser_press_on.png",
				"Image/Admin/button/userManage/changeUser_press_on.png","Image/Admin/button/userManage/findUser_press_on.png"};
		
		adminSecondPanel = new SecondPanel();
		for(int i = 0;i < userButtons.length;i++){
			userButtons[i] = new MyButton(images_ori_user[i], secondX, secondY+i*inter,
					images_stop_user[i], images_press_on_user[i]);
			adminSecondPanel.add(userButtons[i]);
		}
		adminPanel.add(adminSecondPanel);
		adminPanel.repaint();
	}
}
