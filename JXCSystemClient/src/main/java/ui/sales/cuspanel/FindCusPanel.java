package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class FindCusPanel extends FatherPanel{

	private ButtonListener buttonListener;
	private MyFrame frame;
	private UIController controller;
	private MyButton secondCusBack,forward1,forward2;
	private SalesUIController salesUIController;
	protected MyTextFieldBorder cusName,cusID,cusExactFind;
	protected CustomerVO customerVO;
	SalesblService salesBlService;
	
	public FindCusPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController){
		super(frame,url,controller);
		salesBlService = new SalesController();
		this.frame = frame;
		this.controller = controller;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		this.addSecondTextField();
		this.addRestButton();
	}
	
	public void addSecondTextField(){
		cusName = new MyTextFieldBorder(254,218);
		cusID = new MyTextFieldBorder(254,307);
		cusExactFind = new MyTextFieldBorder(254,424);
		this.add(cusName);
		this.add(cusID);
		this.add(cusExactFind);
		
	}
	public void addRestButton(){
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 177, 120, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward1 = new MyButton("Image/Sales/对话框/images/前进_黑.png", 630, 301, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		forward2 = new MyButton("Image/Sales/对话框/images/前进_黑.png",630,424,"Image/Sales/对话框/images/前进_黑.png","Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(secondCusBack);
		this.add(forward1);
		this.add(forward2);
		secondCusBack.addMouseListener(buttonListener);
		forward1.addMouseListener(buttonListener);
		forward2.addMouseListener(buttonListener);
	}
	
	class ButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == secondCusBack){
				salesUIController.backPanel(FindCusPanel.this);
			}else if(e.getSource() == forward1){
				String name = cusName.getText();
				String id = cusID.getText();
				CustomerVO customerVO= salesBlService.exactSearch(name);
				frame.remove(FindCusPanel.this);
//				此次应该显示表格
				//frame.setPanel(new MakeSureFindInfo(frame,"Image/Sales/对话框/二次确认/客户确认信息.jpg",controller,salesUIController,customerVO,FindCusPanel.this));
				frame.repaint();	
			}else if(e.getSource() == forward2){
				String info =cusExactFind.getText();
				ArrayList<CustomerVO> cusVOArray = salesBlService.searchCustomer(info);
//				此次应该显示表格
				frame.remove(FindCusPanel.this);
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
