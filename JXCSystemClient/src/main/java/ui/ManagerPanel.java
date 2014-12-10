package ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ui.manager.ManagerUIController;
import ui.setting.ColorFactory;
import ui.setting.MyButton;
import ui.setting.MyTable;

/**
 * 6 总经理
 * @author lsy
 * @version 2014年11月28日下午4:21:03
 */
public class ManagerPanel extends FatherPanel{
	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	private MyButton accManage,recManage,invoiceManage,proManage,details,refresh;
	private MyButton [] buttons = new MyButton[]{ accManage, recManage,invoiceManage,proManage};
	private MyButton back;
	
	private JLabel remind;
	private MyTable showTable;
	
	private ManagerUIController managerUIController;
	private String images_ori[] = new String[]{"Image/Manager/button/accManage.png","Image/Manager/button/recManage.png",
			"Image/Manager/button/invoiceManage.png","Image/Manager/button/proManage.png"};
	private String images_stop[] = new String[]{"Image/Manager/button/accManage_stop.png","Image/Manager/button/recManage_stop.png",
			"Image/Manager/button/invoiceManage_stop.png",	"Image/Manager/button/proManage_stop.png"};
	private String images_press_on[] = new String[]{"Image/Manager/button/accManage_press_on.png","Image/Manager/button/recManage_press_on.png",
			"Image/Manager/button/invoiceManage_press_on.png",	"Image/Manager/button/proManage_press_on.png"};
	
	private ColorFactory color = new ColorFactory();
	
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
	
		refresh = new MyButton("Image/refresh.png",25,514,"Image/refresh_stop.png","Image/refresh_stop.png");
		this.add(refresh);
		refresh.addMouseListener(listener);
	}
	
	
	private void getProInfo() {
		// TODO Auto-generated method stub
		
	}

	private void getInvoiceInfo() {
		// TODO Auto-generated method stub
		
	}

	private void getRecInfo() {
		// TODO Auto-generated method stub
		
	}

	private void getAccountInfo() {
		// TODO Auto-generated method stub
		ArrayList <String> info = new ArrayList<String>();
		info.add("a;b;c;e");
		info.add("s,r,t,h");
		info.add("w;t;x;h");
		info.add("gg");
		setTable(info);
	}

	private void setTable(ArrayList<String> info) {
		showTable = new MyTable();
		showTable.setColor(color.manTableColor,color.manBkColor, color.manColor,Color.white);
		showTable.setTable(info);
		this.add(showTable.tablePanel);
		this.repaint();
	}
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if (e.getSource() == refresh){
				remind = new JLabel(new ImageIcon("Image/remind.png"));
				remind.setBounds(32, 276,5,5);
				ManagerPanel.this.add(remind);
				ManagerPanel.this.repaint();
				System.out.println("fff");
			}//刷新数据，如果有新的审批单据返回情况，收支单据button上面会出现红点,
			else if(e.getSource() == details){
				
			}else if(e.getSource() == buttons[0]) {
				getAccountInfo();
			}else if(e.getSource() == buttons[1]) {
				getRecInfo();
			}else if(e.getSource() == buttons[2]) {
				getInvoiceInfo();
			}else if (e.getSource() == buttons[3]) {
				getProInfo();
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

	}
}
