package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ui.commodity.CommodityUIController;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;

//1 库存人员
public class CommodityPanel extends FatherPanel{
	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	MyButton comManage,sortManage,stockManage,invoiceManage;
	private MyButton [] buttons = new MyButton[]{comManage,sortManage,stockManage,invoiceManage};
	private MyButton refresh, warn,newBills,detail;
	
	private CommodityUIController commodityUIController;
	private JLabel remindLabel;
	private String images_ori[] = new String[]{"Image/Commodity/button/comManage.png",
			"Image/Commodity/button/sortManage.png","Image/Commodity/button/stockManage.png",
			"Image/Commodity/button/invoiceManage.png"};
	private String images_stop[] = new String[]{"Image/Commodity/button/comManage_stop.png",
			"Image/Commodity/button/sortManage_stop.png","Image/Commodity/button/stockManage_stop.png",
			"Image/Commodity/button/invoiceManage_stop.png"};
	private String images_press_on[] = new String[]{"Image/Commodity/button/comManage_press_on.png",
			"Image/Commodity/button/sortManage_press_on.png","Image/Commodity/button/stockManage_press_on.png",
			"Image/Commodity/button/invoiceManage_press_on.png"};
	
	private FirstButtonListener listener = new FirstButtonListener();
	public CommodityPanel(JFrame frame, String url, UIController controller,
			CommodityUIController commodityUIController) {
		super(frame, url, controller);
		this.commodityUIController= commodityUIController;
		this.setRemind();
		this.addButton();

		}


	private void setRemind() {
		remindLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon("Image/remind_ori.png");
		remindLabel.setBounds(120, 555, imageIcon.getIconWidth(),imageIcon.getIconHeight());
		remindLabel.setIcon(imageIcon);
		remindLabel.setVisible(true);
		this.add(remindLabel);
		
	}


	private void addButton() {
		
		for(int i = 0 ;i < buttons.length;i++){
			buttons[i] = new MyButton(images_ori[i], firstX, firstY +i * inter,
					images_stop[i], images_press_on[i]);
			this.add(buttons[i]);
			buttons[i].addMouseListener(listener);
		}
		refresh = new MyButton("Image/refresh.png",70,555,"Image/refresh_stop.png","Image/refresh_stop.png");
		this.add(refresh);
		refresh.addMouseListener(listener);
		
		

	}
	/**
	 * 库存报警时该按钮亮,点击后按钮消失
	 */
	private void setWarn() {
		// TODO Auto-generated method stub
		warn = new MyButton("Image/Commodity/button/warn.png",26,549,"Image/Commodity/button/warn.png",
				"Image/Commodity/button/warn.png");
		this.add(warn);
		warn.addMouseListener(listener);
		this.repaint();
	}
	/**
	 * 当有新单据要处理时该按钮亮，点击后按钮消失
	 */
	private void newBills() {
		newBills = new MyButton("Image/remind.png",120,555,"Image/remind.png","Image/remind.png");
		this.add(newBills);
		newBills.addMouseListener(listener);
		this.repaint();
		
	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				
			}else if(e.getSource() == buttons[1]) {
	
			}else if(e.getSource() == buttons[2]) {
			
			}else if (e.getSource() == buttons[3]) {
			
			}else if(e.getSource() == refresh){
				setWarn();
				newBills();
			}else if(e.getSource() == warn){
				CommodityPanel.this.remove(warn);
				CommodityPanel.this.repaint();
			}else if(e.getSource() == newBills){
				CommodityPanel.this.remove(newBills);
				CommodityPanel.this.repaint();
			}
		}

		

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				commodityUIController.toComPanel();
			}else if(e.getSource() == buttons[1]) {
				commodityUIController.toSortPanel();
			}else if(e.getSource() == buttons[2]) {
				commodityUIController.toStockPanel();
			}else if (e.getSource() == buttons[3]) {
				commodityUIController.toInvoicePanel();
			}
			
		}

		public void mouseExited(MouseEvent e) {
		}
		
	}

	public void addRestButton() {
		detail = new MyButton("Image/Sales/Sales_image/details.png", 670, 537,
				"Image/Sales/Sales_image/details.png", "Image/Sales/Sales_image/details_press_on.png");
		this.add(detail);
	}
}
