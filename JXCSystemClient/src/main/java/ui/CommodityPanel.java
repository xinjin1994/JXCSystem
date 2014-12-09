package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import ui.commodity.CommodityUIController;
import ui.setting.FatherPanel;
import ui.setting.MyButton;

//1 库存人员
public class CommodityPanel extends FatherPanel{
	private int firstX = 1;
	private int firstY = 110;
	private int inter = 54;
	
	MyButton comManage,sortManage,stockManage,recManage,invoiceManage;
	private MyButton [] buttons = new MyButton[]{comManage,sortManage,stockManage,recManage,invoiceManage};
	private MyButton detail, back;
	
	private CommodityUIController commodityUIController;
	private String images_ori[] = new String[]{"Image/Commodity/button/comManage.png",
			"Image/Commodity/button/sortManage.png","Image/Commodity/button/stockManage.png",
			"Image/Commodity/button/recManage.png","Image/Commodity/button/invoiceManage.png"};
	private String images_stop[] = new String[]{"Image/Commodity/button/comManage_stop.png",
			"Image/Commodity/button/sortManage_stop.png","Image/Commodity/button/stockManage_stop.png",
			"Image/Commodity/button/recManage_stop.png","Image/Commodity/button/invoiceManage_stop.png"};
	private String images_press_on[] = new String[]{"Image/Commodity/button/comManage_press_on.png",
			"Image/Commodity/button/sortManage_press_on.png","Image/Commodity/button/stockManage_press_on.png",
			"Image/Commodity/button/recManage_press_on.png","Image/Commodity/button/invoiceManage_press_on.png"};
	
	
	public CommodityPanel(JFrame frame, String url, UIController controller,
			CommodityUIController commodityUIController) {
		super(frame, url, controller);
		this.commodityUIController= commodityUIController;
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
				commodityUIController.toComPanel();
			}else if(e.getSource() == buttons[1]) {
				commodityUIController.toSortPanel();
			}else if(e.getSource() == buttons[2]) {
				commodityUIController.toStockPanel();
			}else if (e.getSource() == buttons[3]) {
				commodityUIController.toRecPanel();
			}else if (e.getSource() == buttons[4]) {
				commodityUIController.toInvoicePanel();
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
