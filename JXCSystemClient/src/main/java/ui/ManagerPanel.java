package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.manager.ManagerUIController;
import ui.setting.FatherPanel;
import ui.setting.MyButton;

/**
 * 6 总经理
 * @author lsy
 * @version 2014年11月28日下午4:21:03
 */
public class ManagerPanel extends FatherPanel{
	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	MyButton accManage,recManage,invoiceManage,proManage,details;
	private MyButton [] buttons = new MyButton[]{ accManage, recManage,invoiceManage,proManage};
	private MyButton back;
	
	private ManagerUIController managerUIController;
	private String images_ori[] = new String[]{"Image/Manager/button/accManage.png","Image/Manager/button/recManage.png",
			"Image/Manager/button/invoiceManage.png","Image/Manager/button/proManage.png"};
	private String images_stop[] = new String[]{"Image/Manager/button/accManage_stop.png","Image/Manager/button/recManage_stop.png",
			"Image/Manager/button/invoiceManage_stop.png",	"Image/Manager/button/proManage_stop.png"};
	private String images_press_on[] = new String[]{"Image/Manager/button/accManage_press_on.png","Image/Manager/button/recManage_press_on.png",
			"Image/Manager/button/invoiceManage_press_on.png",	"Image/Manager/button/proManage_press_on.png"};
	
	
	public ManagerPanel(JFrame frame, String url, UIController controller,
			ManagerUIController managerUIController) {
		super(frame, url, controller);
		this.managerUIController= managerUIController;
		this.addButton();

		}


	public void addButton() {
		FirstButtonListener listener = new FirstButtonListener();
		for(int i = 0 ;i < buttons.length;i++){
			buttons[i] = new MyButton(images_ori[i], firstX, firstY +i * inter,
					images_stop[i], images_press_on[i]);
			this.add(buttons[i]);
			buttons[i].addMouseListener(listener);
		}
		details = new MyButton("Image/details.png", 670, 537, "Image/Manager/details_m.png", "Image/Manager/details_m.png");
		details.addMouseListener(listener);
		this.add(details);
	
	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if(e.getSource() == details){
				
			}
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				managerUIController.toAccPanel();
			}else if(e.getSource() == buttons[1]) {
				managerUIController.toRecPanel();
			}else if(e.getSource() == buttons[2]) {
				managerUIController.toInvoicePanel();
			}else if (e.getSource() == buttons[3]) {
				managerUIController.toProPanel();
			}
		}

		public void mouseExited(MouseEvent e) {
		}

		
//		public void addRestButton() {
//		detail = new MyButton("Image/Sales/Sales_image/details.png", 670, 537,
//				"Image/Sales/Sales_image/details.png", "Image/Sales/Sales_image/details_press_on.png");
//		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
//				"Image/Sales/Sales_image/返回_press_on.png");
//		this.add(detail);
//		this.add(back);
//	}


	}
}
