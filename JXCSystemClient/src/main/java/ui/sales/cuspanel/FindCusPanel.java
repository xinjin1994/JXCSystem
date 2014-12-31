package ui.sales.cuspanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.ThirdPanel;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.CustomerVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class FindCusPanel extends FatherPanel {
/*
 * 查找客户界面
 */
	private static final long serialVersionUID = -4729036564058484629L;
	private ButtonListener buttonListener;
	private MyFrame frame;
	private MyButton secondCusBack, forward1, forward2;
	private SalesUIController salesUIController;
	protected MyTextFieldBorder cusName, cusExactFind;
	protected CustomerVO customerVO;
	private SalesblService salesBlService;
	private MyTable showTable; 
	private ColorFactory colors = new ColorFactory();
	ArrayList<String> infoArray = new ArrayList<String>();
	protected MyLabel failLabel;
	protected ThirdPanel thirdPanel;
	
	public FindCusPanel(MyFrame frame, String url, UIController controller, SalesUIController salesUIController,
			ThirdPanel thirdPanel) {
		super(frame, url, controller);
		salesBlService = new SalesController();
		this.frame = frame;
		this.thirdPanel = thirdPanel;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		this.addSecondTextField();
		this.addRestButton();
	}

	public void addSecondTextField() {
		cusName = new MyTextFieldBorder(254, 250);
		cusExactFind = new MyTextFieldBorder(254, 424);
		this.add(cusName);
		this.add(cusExactFind);

	}

	public void addRestButton() {
		secondCusBack = new MyButton("Image/Sales/Sales_image/返回.png", 177, 120, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward1 = new MyButton("Image/Sales/对话框/images/前进_黑.png", 629, 246, "Image/Sales/对话框/images/前进_黑.png",
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
	
	private void setTable(ArrayList<String> info){
		showTable = new MyTable();
		showTable.setColor(colors.saleColor,colors.greyFont,colors.salesBkColor,colors.greyFont);
		showTable.setTable(info);
		thirdPanel.add(MyTable.tablePanel);
		salesUIController.backPanel(this);
	}

	class ButtonListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == secondCusBack) {
				salesUIController.backPanel(FindCusPanel.this);
			} else if (e.getSource() == forward1) {
				if(cusName.getText().equals("")){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,FindCusPanel.this);
					salesResult.failed("存在输入为空！", "finComFailed");
				}else{
					ArrayList<String> cusStr = new ArrayList<String>();
					cusStr.add("编号;分类;级别;姓名;电话;地址;邮编;电子邮箱;应收额度;应收;应付;业务员");
				String name = cusName.getText();
				CustomerVO customerVO = salesBlService.searchExactCustomer_up(name);
				frame.remove(FindCusPanel.this);
				if(customerVO == null){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,FindCusPanel.this);
					salesResult.failed("您要查找的客户不存在！", "finComFailed");
				}else{
				String classification = "进货商";
				// String id,boolean classification,int level,String
				// cusName,String tel,String address,String zipCode,String
				// ezipCode,double mostOwe,double shouldGet,double
				// shouldPay,String person){
				// 编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、
				//地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
				// 0代表进货商，非0代表销售商
				if (customerVO.classification) {
					classification = "销售商";
				}
				String cusInTable = customerVO.id + ";" + classification + ";" + customerVO.level + ";"
						+ customerVO.cusName + ";" + customerVO.tel + ";" + customerVO.address + ";"
						+ customerVO.zipCode + ";" + customerVO.ezipCode + ";" + customerVO.mostOwe + ";"
						+ customerVO.shouldGet + ";" +customerVO.shouldPay + ";" + customerVO.person;
				cusStr.add(cusInTable);
				setTable(cusStr);
				frame.repaint();
				}
			}
			}else if (e.getSource() == forward2) {
				String info = cusExactFind.getText();
				if(info.equals("")){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,FindCusPanel.this);
					salesResult.failed("您的输入为空！", "finComFailed");
				}else{
				String classification = "进货商";
				ArrayList<CustomerVO> cusVOArray = salesBlService.searchFuzzyCustomer_up(info);
				frame.remove(FindCusPanel.this);
				if(cusVOArray == null){
					SalesResult salesResult = new SalesResult(frame,controller,salesUIController,FindCusPanel.this);
					salesResult.failed("您要查找的客户不存在！", "finComFailed");
				}else{
				ArrayList<String> cusStr = new ArrayList<String>();
				cusStr.add("编号;分类;级别;姓名;电话;地址;邮编;电子邮箱;应收额度;应收;应付;业务员");
				for(int i=0;i<cusVOArray.size();i++){
					CustomerVO customerVO = cusVOArray.get(i);
						if (customerVO.classification) {
					classification = "销售商";
				}
					String item = customerVO.id + ";"+classification + ";" + customerVO.level + ";"
							+ customerVO.cusName + ";" + customerVO.tel + ";" + customerVO.address + ";"
							+ customerVO.zipCode + ";" + customerVO.ezipCode + ";" + customerVO.mostOwe + ";"
							+ customerVO.shouldGet + ";" +customerVO.shouldPay+ ";" + customerVO.person;
					cusStr.add(item);
				}
				// 此次应该显示表格
				setTable(cusStr);
				frame.repaint();
					}
				}
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
