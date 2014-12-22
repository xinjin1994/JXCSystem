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

public class DelCusPanel extends FatherPanel {
	private ButtonListener buttonListener;
	private MyFrame frame;
	private UIController controller;
	private MyButton secondCusBack, forward;
	private SalesUIController salesUIController;
	protected MyTextFieldBorder cusName, cusID;
	protected CustomerVO customerVO;
	private MyLabel failLabel;

	public DelCusPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller);
		this.frame = frame;
		this.controller = controller;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		this.addSecondTextField();
		this.addRestButton();
		addLabel();
	}

	public void addSecondTextField() {
		cusName = new MyTextFieldBorder(254, 223);
		cusID = new MyTextFieldBorder(254, 312);
		this.add(cusName);
		this.add(cusID);

	}

	public void addLabel() {
		failLabel = new MyLabel(254, 412, 200, 35);
		this.add(failLabel);
	}

	public void addRestButton() {
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 177, 120, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 585, 374, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(secondCusBack);
		this.add(forward);
		secondCusBack.addMouseListener(buttonListener);
		forward.addMouseListener(buttonListener);
	}

	class ButtonListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == secondCusBack) {
				salesUIController.backPanel(DelCusPanel.this);
			} else if (e.getSource() == forward) {
				if (cusName.getText().equals("") || cusID.getText().equals("")) {
					failLabel.setText("请确认输入信息！");
				} else {
					try {
						String name = cusName.getText();
						String id = cusID.getText();
						SalesblService salesBlService = new SalesController();
						CustomerVO customerVO = salesBlService.searchExactCustomer_up(name);
						if(customerVO.equals(null)){
							SalesResult salesResult = new SalesResult(frame,controller,salesUIController,DelCusPanel.this);
							salesResult.failed("您要删除的客户不存在！", "delCusFailed");
						}else{
//						CustomerVO customerVO = new CustomerVO("id",true,1,"gg","123","add","zip","e",30,40,"me");
						
						frame.remove(DelCusPanel.this);
						frame.setPanel(new MakeSureDelInfo(frame, "Image/Sales/对话框/二次确认/客户确认信息.jpg", controller,
								salesUIController, customerVO, DelCusPanel.this));
						}
					} catch (Exception e2) {
						SalesResult salesResult = new SalesResult(frame,controller,salesUIController,DelCusPanel.this);
						salesResult.failed("请重新确认输入信息！", "delCusFailed");
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
