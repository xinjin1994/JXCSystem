package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class ChangeCusPanel extends FatherPanel{
	private ButtonListener buttonListener;
	private MyFrame frame;
	private UIController controller;
	private MyButton secondCusBack,forward;
	private SalesUIController salesUIController;
	protected MyTextFieldBorder cusName,cusID;
	protected CustomerVO customerVO;
	
	public ChangeCusPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController){
		super(frame,url,controller);
		this.frame = frame;
		this.controller = controller;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		this.addSecondTextField();
		this.addRestButton();
	}
	
	public void addSecondTextField(){
		cusName = new MyTextFieldBorder(254,223);
		cusID = new MyTextFieldBorder(254,312);
		this.add(cusName);
		this.add(cusID);
		
	}
	public void addRestButton(){
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 177, 120, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 585, 374, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(secondCusBack);
		this.add(forward);
		secondCusBack.addMouseListener(buttonListener);
		forward.addMouseListener(buttonListener);
	}
	
	class ButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == secondCusBack){
				salesUIController.backPanel(ChangeCusPanel.this);
			}else if(e.getSource() == forward){
				String name = cusName.getText();
				String id = cusID.getText();
				SalesblService salesBlService = new SalesController();
				CustomerVO customerVO= salesBlService.searchExactCustomer_up(name);
				frame.remove(ChangeCusPanel.this);
				frame.setPanel(new MakeSureChangeInfo(frame,"Image/Sales/对话框/二次确认/客户确认信息.jpg",controller,salesUIController,customerVO,ChangeCusPanel.this));
				frame.repaint();
				
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
