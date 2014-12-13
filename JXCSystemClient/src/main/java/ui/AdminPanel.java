package ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import ui.admin.AdminAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.UserVO;

//0 管理员
public class AdminPanel extends FatherPanel{
	
	private AdminAllUIController adminAllUIController;
	
	private MyButton []userButtons = new MyButton[3];
	private String[]  image_ori = new String[]{"Image/User/search.png",
			"Image/User/user_add.png","Image/User/user_del.png"};
	private String[]  image_stop = new String[]{"Image/User/search_stop.png",
			"Image/User/user_add_stop.png","Image/User/user_del_stop.png"};
	private ImageIcon imageIcon;
	private MyTextFieldBorder searchTextField;
	private MyFrame frame;
	
	private MyTable showTable;
	private MyLabel[] infoLabels = new MyLabel[3];
	
	private ColorFactory colors = new ColorFactory();
	public AdminPanel(MyFrame frame, String url, UIController controller,
			AdminAllUIController adminAllUIController) {
		super(frame, url, controller);
		this.adminAllUIController= adminAllUIController;
		this.frame = frame;
		setButtons();
		setSearchText();
		setTable();
		this.repaint();
	}
	/**
	 * 这个table在已进入admin界面就会出现，内容是现有的所有员工的信息
	 */
	private void setTable() {
		ArrayList <String> info = new ArrayList<String>();
		info.add("a;b;c;e");
		info.add("s,r,t,h");
		info.add("w;t;x;h");
		info.add("gg");
		
		showTable = new MyTable();
		showTable.setColor(colors.adminTableColor,colors.adminBkColor, colors.adminColor,Color.white);
		showTable.setTable(info);
		this.add(showTable.tablePanel);
	}
	private void setSearchText() {
		searchTextField = new MyTextFieldBorder(15, 99);
		searchTextField.setForeground(colors.greyFont);
		this.add(searchTextField);
	}
	private void setButtons() {
		userButtons[0] = new MyButton(image_ori[0],288,99,image_stop[0],image_stop[0]);
		userButtons[1] = new MyButton(image_ori[1], 15, 158, image_stop[1], image_stop[1]);
		userButtons[2] = new MyButton(image_ori[2], 191, 158,image_stop[2], image_stop[2]);

		UserListener listener = new UserListener();
		for(int i = 0;i < userButtons.length;i++){
			this.add(userButtons[i]);
			userButtons[i].addMouseListener(listener);
		}
	}

	public void setInfoLabel(UserVO user){
		for(int i = 0;i < infoLabels.length;i++){
			infoLabels[i] = new MyLabel(100, 305+72*i, 212, 35);
			this.add(infoLabels[i]);
			infoLabels[i].setForeground(new ColorFactory().greyFont);
		//	infoLabels[i].setText(""+i);
		}
		infoLabels[0].setText("1");
		infoLabels[1].setText("2");
		infoLabels[2].setText("3");
		this.repaint();
	}

	class UserListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == userButtons[0]){
				String findInfoS = searchTextField.getText();
		//		setInfoLabel(userVo);
				//根据此信息寻找，级如果在下方详细信息中显示,将参数UserVo传给setInfoLabel方法
			}else if(e.getSource() == userButtons[1]){
				frame.remove(AdminPanel.this);
				adminAllUIController.addUser();
				
			}else if(e.getSource() == userButtons[2]){
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
			// TODO Auto-generated method stub
			
		}

	}

}
