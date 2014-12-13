package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class FindCusPanel extends FatherPanel {

	private ButtonListener buttonListener;
	private MyFrame frame;
	private UIController controller;
	private MyButton secondCusBack, forward1, forward2;
	private SalesUIController salesUIController;
	protected MyTextFieldBorder cusName, cusID, cusExactFind;
	protected CustomerVO customerVO;
	SalesblService salesBlService;
	protected MyLabel failLabel;

	public FindCusPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController) {
		super(frame, url, controller);
		salesBlService = new SalesController();
		this.frame = frame;
		this.controller = controller;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		this.addSecondTextField();
		this.addRestButton();
	}

	public void addSecondTextField() {
		cusName = new MyTextFieldBorder(254, 218);
		cusID = new MyTextFieldBorder(254, 307);
		cusExactFind = new MyTextFieldBorder(254, 424);
		this.add(cusName);
		this.add(cusID);
		this.add(cusExactFind);

	}

	public void addRestButton() {
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 177, 120, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward1 = new MyButton("Image/Sales/对话框/images/前进_黑.png", 630, 301, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		forward2 = new MyButton("Image/Sales/对话框/images/前进_黑.png", 630, 424, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(secondCusBack);
		this.add(forward1);
		this.add(forward2);
		secondCusBack.addMouseListener(buttonListener);
		forward1.addMouseListener(buttonListener);
		forward2.addMouseListener(buttonListener);
	}
	
	public void addLabel() {
		failLabel = new MyLabel(254, 500, 200, 35);
		this.add(failLabel);
	}

	class ButtonListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == secondCusBack) {
				salesUIController.backPanel(FindCusPanel.this);
			} else if (e.getSource() == forward1) {
				if(cusName.getText().equals("")||cusID.getText().equals("")){
					failLabel.setText("请正确输入信息！");
				}else{
				String name = cusName.getText();
				String id = cusID.getText();
				CustomerVO customerVO = salesBlService.searchExactCustomer_up(name);
				frame.remove(FindCusPanel.this);
				String classification = "进货商";
				// String id,boolean classification,int level,String
				// cusName,String tel,String address,String zipCode,String
				// ezipCode,double mostOwe,double shouldGet,double
				// shouldPay,String person){
				// 编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、
				//地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
				// 0代表进货商，非0代表销售商
			/*	if (customerVO.classification) {
					classification = "销售商";
				}*/
			/*	String cusInTable = customerVO.id + ";" + classification + ";" + customerVO.level + ";"
						+ customerVO.cusName + ";" + customerVO.tel + ";" + customerVO.address + ";"
						+ customerVO.zipCode + ";" + customerVO.ezipCode + ";" + customerVO.mostOwe + ";"
						+ customerVO.shouldGet + ";" + customerVO.shouldPay + ";" + customerVO.person;*/
				String cusInTable = "1;2;3;4;5;6;7;8;9;10";
				frame.setPanel(new MakeSureFindInfo(frame,"Image/Sales/对话框/null.jpg",controller,FindCusPanel.this,cusInTable,salesUIController));
				}
				frame.repaint();
				// 此次应该显示表格
				// frame.setPanel(new
				// MakeSureFindInfo(frame,"Image/Sales/对话框/二次确认/客户确认信息.jpg",controller,salesUIController,customerVO,FindCusPanel.this));
			} else if (e.getSource() == forward2) {
				String info = cusExactFind.getText();
				ArrayList<CustomerVO> cusVOArray = salesBlService.searchFuzzyCustomer_up(info);
				ArrayList<String> cusStr = new ArrayList<String>();
				cusStr.add("编号;分类;级别;姓名;电话;地址;邮编;电子邮箱;应收额度;应收;应付;业务员");
				for(int i=0;i<cusVOArray.size();i++){
					CustomerVO customerVO = cusVOArray.get(i);
					String item = customerVO.id + customerVO.classification + ";" + customerVO.level + ";"
							+ customerVO.cusName + ";" + customerVO.tel + ";" + customerVO.address + ";"
							+ customerVO.zipCode + ";" + customerVO.ezipCode + ";" + customerVO.mostOwe + ";"
							+ customerVO.shouldGet + ";" + customerVO.shouldPay + ";" + customerVO.person;
					cusStr.add(item);
				}
				// 此次应该显示表格
				frame.remove(FindCusPanel.this);
				frame.setPanel(new MakeSureFindInfo(frame,"Image/Sales/对话框/null.jpg",controller,FindCusPanel.this,cusStr,salesUIController));
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
