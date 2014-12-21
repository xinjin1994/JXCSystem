package ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import ui.admin.AdminAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.ThirdPanel;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
import vo.UserVO;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserblService;

//0 管理员
public class AdminPanel extends FatherPanel{
	
	private AdminAllUIController adminAllUIController;
	public ThirdPanel adminThirdPanel;
	
	private MyButton []userButtons = new MyButton[3];
	private String[]  image_ori = new String[]{"Image/User/search.png",
			"Image/User/user_add.png","Image/User/user_del.png"};
	private String[]  image_stop = new String[]{"Image/User/search_stop.png",
			"Image/User/user_add_stop.png","Image/User/user_del_stop.png"};
	private ImageIcon imageIcon;
	private MyTextFieldBorder searchTextField;
	private MyFrame frame;
	private MyLabel label;
	
	private MyTable showTable;
	private MyLabel[] infoLabels = new MyLabel[3];
	
	private ResultPanelController resController;
	
	private UserblService userblService;
	private ColorFactory colors = new ColorFactory();
	
	public AdminPanel(MyFrame frame, String url, UIController controller,
			AdminAllUIController adminAllUIController) {
		super(frame, url, controller);
		adminThirdPanel = new ThirdPanel();
		this.adminAllUIController= adminAllUIController;
		this.frame = frame;
		this.add(adminThirdPanel);
		userblService = new UserController();
		
	
		setLabel();
		setButtons();
		setSearchText();
		setTable();
		this.repaint();
	}
	
	public void setLabel(){
		label = new MyLabel(100,305+72*3,212,35);
		this.add(label);
	}
	/**
	 * 这个table在已进入admin界面就会出现，内容是现有的所有员工的信息
	 */
	public void setTable() {
		ArrayList<UserVO> user = new ArrayList<UserVO>();
		ArrayList <String> info = new ArrayList<String>();
		
		user = userblService.show_up();
		info.add("ID;用户名;职位");
		for(int i=0;i<user.size();i++){
			String userItem = user.get(i).id+";"+user.get(i).name+";"+user.get(i).duty;
			info.add(userItem);
		}
		
		adminThirdPanel.removeAll();
		showTable = new MyTable();
		showTable.setColor(colors.adminTableColor,colors.adminBkColor, colors.adminColor,Color.white);
		showTable.setTable(info);
		showTable.table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		adminThirdPanel.add(showTable.tablePanel);
		adminThirdPanel.repaint();
		this.repaint();
	}
	private void setSearchText() {
		searchTextField = new MyTextFieldBorder(15, 99);
		searchTextField.setForeground(colors.greyFont);
		this.add(searchTextField);
		searchTextField.addFocusListener(new SearchListener());
	}
	
	class SearchListener implements FocusListener{
		
		public void focusGained(FocusEvent e) {
			label.setText("");
		}

		public void focusLost(FocusEvent e) {
			
		}
		
	}
	private void setButtons() {
		userButtons[0] = new MyButton(image_ori[0],288,99,image_stop[0],image_stop[0]);//search
		userButtons[1] = new MyButton(image_ori[1], 15, 158, image_stop[1], image_stop[1]);//add
		userButtons[2] = new MyButton(image_ori[2], 191, 158,image_stop[2], image_stop[2]);//del

		UserListener listener = new UserListener();
		for(int i = 0;i < userButtons.length;i++){
			this.add(userButtons[i]);
			userButtons[i].addMouseListener(listener);
		}
	}
	/**
	 * 验证登陆账号密码
	 * <0代表失败
	 * 0代表管理员
	 * 1代表库存人员
	 * 2代表销售人员
	 * 3代表销售经理
	 * 4代表财务人员
	 * 5代表财务经理
	 * 6代表总经理
	 */
	public void setInfoLabel(UserVO user){
		String userDuty = "";
		for(int i = 0;i < infoLabels.length;i++){
			infoLabels[i] = new MyLabel(100, 305+72*i, 212, 35);
			this.add(infoLabels[i]);
			infoLabels[i].setForeground(new ColorFactory().greyFont);
		//	infoLabels[i].setText(""+i);
		}
		if(user.duty <0){
			frame.remove(this);
			resController = new ResultPanelController(frame, this);
			resController.failedConfirm("用户不存在！", "user");
			frame.repaint();
		}else{
		switch(user.duty){
		case 0:
			userDuty = "管理员";
			break;
		case 1:
			userDuty = "库存人员";
			break;
		case 2:
			userDuty = "销售人员";
			break;
		case 3:
			userDuty = "销售经理";
			break;
		case 4:
			userDuty = "财务人员";
			break;
		case 5:
			userDuty = "财务经理";
			break;
		case 6:
			userDuty = "总经理";
			break;
		default:
			userDuty = "";
			break;
		}
		infoLabels[0].setText(user.id);
		infoLabels[1].setText(user.name);
		infoLabels[2].setText(userDuty);
		}
		this.repaint();
	}
	
	private void clear(){
		try {
			infoLabels[0].setText("");
			infoLabels[1].setText("");
			infoLabels[2].setText("");
		} catch (Exception e) {
			
		}
	
		
	}

	class UserListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == userButtons[0]){
				clear();
				String findInfoS = searchTextField.getText();
				if(findInfoS.equals("")){
					frame.remove(AdminPanel.this);
					resController = new ResultPanelController(frame, AdminPanel.this);
					resController.failedConfirm("请输入要搜索的用户名称或编号！","user");
					frame.repaint();
				}else{
					
					searchTextField.setText("");
					UserVO user = userblService.searchUser_up(findInfoS).get(0);
					//				UserVO user = new UserVO("a","v","c",-1);
					setInfoLabel(user);
				}
				//根据此信息寻找，级如果在下方详细信息中显示,将参数UserVo传给setInfoLabel方法
			}else if(e.getSource() == userButtons[1]){
				clear();
				adminAllUIController.setMainPanel(AdminPanel.this);
				frame.remove(AdminPanel.this);
				adminAllUIController.addUser();
				
			}else if(e.getSource() == userButtons[2]){
				clear();
				adminAllUIController.setMainPanel(AdminPanel.this);
				frame.remove(AdminPanel.this);
				adminAllUIController.delUser();
			}
		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent arg0) {
			
		}

	}

}
