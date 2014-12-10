package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.admin.AdminUIController;
import ui.setting.MyButton;

//0 管理员
public class AdminPanel extends FatherPanel{
 
	private int firstX = 1;
	private int firstY = 110;
	private int inter = 54;
	
	MyButton userManage;
	private MyButton [] buttons = new MyButton[]{ userManage};
	private MyButton detail, back;
	
	private AdminUIController adminUIController;
	
	private String images_ori[] = new String[]{"Image/Account/button/adminManage.png"};
	private String images_stop[] = new String[]{"Image/Account/button/adminManage_stop.png"};
	private String images_press_on[] = new String[]{"Image/Account/button/adminManage_press_on.png"};
	
	
	public AdminPanel(JFrame frame, String url, UIController controller,
			AdminUIController adminUIController) {
		super(frame, url, controller);
		this.adminUIController= adminUIController;
		this.addButton();

		}





	public void addButton() {
		FirstButtonListener listener = new FirstButtonListener();
		for(int i = 0 ;i < buttons.length;i++){
			buttons[i] = new MyButton(images_ori[0], firstX, firstY +i * inter,
					images_stop[0], images_press_on[0]);
			this.add(buttons[i]);
			buttons[i].addMouseListener(listener);
		}

	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				adminUIController.toUserPanel();
			}
		}

		public void mouseExited(MouseEvent e) {
		}
		
	}

	public void addRestButton() {
		detail = new MyButton("Image/Sales/Sales_image/details.png", 670, 537,
				"Image/Sales/Sales_image/details.png", "Image/Sales/Sales_image/details_press_on.png");
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(detail);
		this.add(back);
	}
}
