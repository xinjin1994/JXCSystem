package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyButton;
import ui.setting.MyStopButton;
import ui.setting.MyTextFieldFilled;
import ui.setting.MyTextFieldTrans;

public class AddCusPanel extends FatherPanel {

	private MyTextFieldTrans cusName, cusTel, cusAdd, cusEBox, cusCode, cusShouldPay;
	private int infoX1 = 488, infoX2 = 534, infoY = 170, infoInter = 41, infoWidth1 = 237, infoWidth2 = 190,
			infoHeight = 31;
	private int maxLevel = 6;
	private int levelX = 105, levelY = 328, levelInter = 42;
	private MyStopButton supplierButton, sellerButton;
	private MyButton secondCusBack, forward;
	private MyStopButton level1,level2,level3,level4,level5;
	private MyTextFieldFilled idField, salesManField;
	SalesUIController salesUIController;
	private ButtonListener buttonListener;

	public AddCusPanel(JFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame,url,controller);
		buttonListener = new ButtonListener();
		this.salesUIController = salesUIController;
		this.addIdButton();
		this.addLevelButton();
		this.addTextField();
		this.addRestButton();
	}

	public void addTextField() {
		cusName = new MyTextFieldTrans(infoX1, infoY, infoWidth1, infoHeight);
		cusTel = new MyTextFieldTrans(infoX2, infoY + infoInter, infoWidth2, infoHeight);
		cusAdd = new MyTextFieldTrans(infoX1, infoY + 2 * infoInter, infoWidth1, infoHeight);
		cusEBox = new MyTextFieldTrans(infoX2, infoY + 3 * infoInter, infoWidth2, infoHeight);
		cusCode = new MyTextFieldTrans(infoX1, infoY + 4 * infoInter, infoWidth1, infoHeight);
		cusShouldPay = new MyTextFieldTrans(infoX2, infoY + 5 * infoInter, infoWidth2, infoHeight);
		idField = new MyTextFieldFilled(105, 173, 222, 36);
		salesManField = new MyTextFieldFilled(418, 485, 204, 36);
		this.add(cusName);
		this.add(cusTel);
		this.add(cusAdd);
		this.add(cusEBox);
		this.add(cusCode);
		this.add(cusShouldPay);
		this.add(salesManField);
		this.add(idField);
	}

	public void addIdButton() {
		supplierButton = new MyStopButton("Image/Sales/对话框/images/供货商_ori.png", 105, 255,
				"Image/Sales/对话框/images/供货商_ori.png");
		sellerButton = new MyStopButton("Image/Sales/对话框/images/销售商_ori.png", 220, 255,
				"Image/Sales/对话框/images/销售商_ori.png");
		this.add(supplierButton);
		this.add(sellerButton);
		supplierButton.addMouseListener(buttonListener);
		sellerButton.addMouseListener(buttonListener);
	}

	public void addLevelButton() {
		level1 = new MyStopButton("Image/Sales/对话框/images/level1_ori.png",levelX,levelY,"Image/Sales/对话框/images/level1_ori.png");
		level2 = new MyStopButton("Image/Sales/对话框/images/level2_ori.png",levelX,levelY+levelInter,"Image/Sales/对话框/images/level2_ori.png");
		level3 = new MyStopButton("Image/Sales/对话框/images/level3_ori.png",levelX,levelY+2*levelInter,"Image/Sales/对话框/images/level3_ori.png");
		level4 = new MyStopButton("Image/Sales/对话框/images/level4_ori.png",levelX,levelY+3*levelInter,"Image/Sales/对话框/images/level4_ori.png");
		level5 = new MyStopButton("Image/Sales/对话框/images/level5_ori.png",levelX,levelY+4*levelInter,"Image/Sales/对话框/images/level5_ori.png");
		this.add(level1);
		this.add(level2);
		this.add(level3);
		this.add(level4);
		this.add(level5);
		level1.addMouseListener(buttonListener);
		level2.addMouseListener(buttonListener);
		level3.addMouseListener(buttonListener);
		level4.addMouseListener(buttonListener);
		level5.addMouseListener(buttonListener);
		
	}

	public void addRestButton() {
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 680, 458, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(secondCusBack);
		this.add(forward);
		secondCusBack.addMouseListener(buttonListener);
		forward.addMouseListener(buttonListener);
	}

	class ButtonListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == secondCusBack) {
				salesUIController.backPanel(AddCusPanel.this);
			} else if (e.getSource() == forward) {
				String ID = idField.getText();
			}else if(e.getSource() == supplierButton){
				supplierButton.setIcon(new ImageIcon("Image/Sales/对话框/images/供应商_press_on_03.png"));
			}else if(e.getSource() == sellerButton){
				sellerButton.setIcon(new ImageIcon("Image/Sales/对话框/images/销售商_press_on_05.png"));
			}else if(e.getSource() == level1){
				level1.setIcon(new ImageIcon("Image/Sales/对话框/images/level1_press_on.png"));
			}else if(e.getSource() == level2){
				level2.setIcon(new ImageIcon("Image/Sales/对话框/images/level2_press_on.png"));
			}else if(e.getSource() == level3){
				level3.setIcon(new ImageIcon("Image/Sales/对话框/images/level3_press_on.png"));
			}else if(e.getSource() == level4){
				level4.setIcon(new ImageIcon("Image/Sales/对话框/images/level4_press_on.png"));
			}else if(e.getSource() == level5){
				level5.setIcon(new ImageIcon("Image/Sales/对话框/images/level5_press_on.png"));
			}
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {
		}

	}
}
