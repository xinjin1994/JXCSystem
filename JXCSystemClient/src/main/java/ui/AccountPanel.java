package ui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ui.account.AccountUIController;
import ui.setting.MyButton;
import ui.setting.MyLabel;

//财务经理
public class AccountPanel extends FatherPanel{

	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	MyButton accManage,finManage,recManage,invoiceManage,iniManage;
	private MyButton [] buttons = new MyButton[]{ accManage, finManage, recManage,invoiceManage,iniManage};
	private MyButton detail, back,refresh;
	private JLabel remind;
	
	private AccountUIController accountUIController;
	private String images_ori[] = new String[]{"Image/Account/button/accManage.png",
			"Image/Account/button/finManage.png","Image/Account/button/recManage.png",
			"Image/Account/button/invoiceManage.png","Image/Account/button/iniManage.png"};
	private String images_stop[] = new String[]{"Image/Account/button/accManage_stop.png",
			"Image/Account/button/finManage_stop.png","Image/Account/button/recManage_stop.png",
			"Image/Account/button/invoiceManage_stop.png",	"Image/Account/button/iniManage_stop.png"};
	private String images_press_on[] = new String[]{"Image/Account/button/accManage_press_on.png",
			"Image/Account/button/finManage_press_on.png","Image/Account/button/recManage_press_on.png",
			"Image/Account/button/invoiceManage_press_on.png",	"Image/Account/button/iniManage_press_on.png"};
	
	
	public AccountPanel(JFrame frame, String url, UIController controller,
			AccountUIController accountUIController) {
		super(frame, url, controller);
		this.accountUIController= accountUIController;
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
		
		refresh = new MyButton("Image/refresh.png",25,514,"Image/refresh_stop.png","Image/refresh_stop.png");
		this.add(refresh);
		refresh.addMouseListener(listener);

	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if (e.getSource() == refresh){
				ImageIcon re = new ImageIcon("Image/remind.png");
				remind = new JLabel(re);
				remind.setBounds(32, 276,5,5);
				AccountPanel.this.add(remind);
				AccountPanel.this.repaint();
				System.out.println("fff");
			}//刷新数据，如果有新的审批单据返回情况，收支单据button上面会出现红点
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				accountUIController.toAccPanel();
			}else if(e.getSource() == buttons[1]) {
				accountUIController.toFinPanel();
			}else if(e.getSource() == buttons[2]) {
				accountUIController.toRecPanel();
			}else if (e.getSource() == buttons[3]) {
				accountUIController.toInvoicePanel();
			}else if (e.getSource() == buttons[4]) {
				accountUIController.toIniPanel();
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
