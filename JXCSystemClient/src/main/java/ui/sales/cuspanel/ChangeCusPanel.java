package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
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
	protected MyLabel failLabel;
	
	public ChangeCusPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController){
		super(frame,url,controller);
		this.frame = frame;
		this.controller = controller;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		this.addSecondTextField();
		this.addRestButton();
		addLabel();
	}
	
	public void addSecondTextField(){
		cusName = new MyTextFieldBorder(254,223);
		this.add(cusName);
		
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
	
	public void addLabel() {
		failLabel = new MyLabel(254, 412, 200, 35);
		this.add(failLabel);
	}
	
	class ButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == secondCusBack){
				salesUIController.backPanel(ChangeCusPanel.this);
			}else if(e.getSource() == forward){
				if(cusName.getText().equals("")){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,ChangeCusPanel.this);
					salesResult.failed("存在您输入的信息为空！", "changeCusFailed");
				}else{
				String name = cusName.getText();
				SalesblService salesBlService = new SalesController();
				CustomerVO customerVO= salesBlService.searchExactCustomer_up(name);
				if(customerVO == null){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,ChangeCusPanel.this);
					salesResult.failed("您要更改的客户不存在！", "changeCusFailed");
				}else{
				frame.remove(ChangeCusPanel.this);
				frame.setPanel(new MakeSureChangeInfo(frame,"Image/Sales/对话框/二次确认/客户确认信息.jpg",controller,salesUIController,customerVO,ChangeCusPanel.this));
					}
				}
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
