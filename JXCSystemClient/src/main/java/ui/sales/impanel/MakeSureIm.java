package ui.sales.impanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.sales.salespanel.SalesBackPanel;
import ui.sales.salespanel.SalesInPanel;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import vo.bill.CommodityListVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogic.salesbl.SalesController;
import businesslogicservice.salesblservice.SalesblService;

public class MakeSureIm extends FatherPanel {

	private static final long serialVersionUID = 7228611459299945797L;
	protected ButtonListener buttonListener;
	protected MyLabel supplier, warehouse, remark, id, goodsID, goodsPrice, goodsNum, goodsTotal, goodsName,
			goodsType, person, operator, newRemark, discount, voucher;
	protected MyButton back, forward, back2, forward2, backSales, forwardSales,backSales2,forwardSales2;
	protected SalesblService salesblService = new SalesController();
	protected ImportMenuVO importMenuVO;
	protected CommodityListVO commodityListVO;
	protected String personLabel, operatorLabel;
	protected MyFrame frame;
	protected ImInPanel imInPanel;
	protected ImBackPanel imBackPanel;
	protected SalesUIController salesUIController;
	protected ExportMenuVO exportMenuVO;
	protected SalesInPanel salesInPanel;
	protected SalesBackPanel salesBackPanel;

	public MakeSureIm(MyFrame frame, String url, UIController controller, ImportMenuVO importMenuVO,
			CommodityListVO commodityListVO, String personLabel, String operatorLabel, ImInPanel imInPanel,
			SalesUIController salesUIController) {
		super(frame, url, controller);
		this.frame = frame;
		this.imInPanel = imInPanel;
		this.importMenuVO = importMenuVO;
		this.commodityListVO = commodityListVO;
		this.personLabel = personLabel;
		this.operatorLabel = operatorLabel;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		addButton();
		addLabel();
		setLabel();
	}
	
	
	public MakeSureIm(MyFrame frame, String url, UIController controller, ImportMenuVO importMenuVO,
			CommodityListVO commodityListVO, String personLabel, String operatorLabel, ImBackPanel imBackPanel,
			SalesUIController salesUIController) {
		super(frame, url, controller);
		this.frame = frame;
		this.imBackPanel = imBackPanel;
		this.importMenuVO = importMenuVO;
		this.commodityListVO = commodityListVO;
		this.personLabel = personLabel;
		this.operatorLabel = operatorLabel;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		addLabel();
		setLabel();
		addBackButton();
	}

	public MakeSureIm(MyFrame frame, String url, UIController controller, ExportMenuVO exportMenuVO,
			CommodityListVO commodityListVO, String personLabel, String operatorLabel, SalesInPanel salesInPanel,
			SalesUIController salesUIController) {
		super(frame, url, controller);
		this.frame = frame;
		this.salesInPanel = salesInPanel;
		this.exportMenuVO = exportMenuVO;
		this.commodityListVO = commodityListVO;
		this.personLabel = personLabel;
		this.operatorLabel = operatorLabel;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		addLabel();
		this.remove(remark);
		addDis();
		setSalesLabel();
		addSalesButton();
	}
	public MakeSureIm(MyFrame frame, String url, UIController controller, ExportMenuVO exportMenuVO,
			CommodityListVO commodityListVO, String personLabel, String operatorLabel, SalesBackPanel salesBackPanel,
			SalesUIController salesUIController) {
		super(frame, url, controller);
		this.frame = frame;
		this.salesBackPanel = salesBackPanel;
		this.exportMenuVO = exportMenuVO;
		this.commodityListVO = commodityListVO;
		this.personLabel = personLabel;
		this.operatorLabel = operatorLabel;
		this.salesUIController = salesUIController;
		buttonListener = new ButtonListener();
		addLabel();
		this.remove(remark);
		addDis();
		setSalesLabel();
		addSalesBackButton();
	}
	
	public void addLabel() {
		id = new MyLabel(105, 173, 222, 36);
		supplier = new MyLabel(210, 255, 116, 42);
		warehouse = new MyLabel(210, 308, 116, 42);
		remark = new MyLabel(104, 420, 200, 118);
		goodsName = new MyLabel(488, 170, 237, 31);
		goodsID = new MyLabel(488, 211, 237, 31);
		goodsType = new MyLabel(488, 252, 237, 31);
		goodsPrice = new MyLabel(488, 293, 237, 31);
		goodsNum = new MyLabel(488, 334, 237, 31);
		goodsTotal = new MyLabel(488, 375, 237, 31);
		person = new MyLabel(408, 481, 147, 36);
		operator = new MyLabel(576, 481, 147, 36);
		this.add(id);
		this.add(supplier);
		this.add(warehouse);
		this.add(remark);
		this.add(goodsName);
		this.add(goodsID);
		this.add(goodsType);
		this.add(goodsPrice);
		this.add(goodsNum);
		this.add(goodsTotal);
		this.add(person);
		this.add(operator);
	}

	// ImportMenuVO(String note,String supplier,String warehouse,String
	// commodityList,int bill_note)
	// CommodityListVO(String id, String name, String type, int num, double
	// price, double total, String remark)
	public void setLabel() {
		id.setText(commodityListVO.id);
		supplier.setText(importMenuVO.supplier);
		warehouse.setText(importMenuVO.warehouse);
		remark.setText(commodityListVO.remark);
		goodsName.setText(commodityListVO.name);
		goodsID.setText(commodityListVO.id);
		goodsType.setText(commodityListVO.type);
		goodsPrice.setText(commodityListVO.price + "");
		goodsNum.setText(commodityListVO.num + "");
		goodsTotal.setText(commodityListVO.total + "");
		person.setText(personLabel);
		operator.setText(operatorLabel);
	}

	public void setSalesLabel() {
		id.setText(commodityListVO.id);
		supplier.setText(exportMenuVO.cusName);
		warehouse.setText(exportMenuVO.warehouse);
		newRemark.setText(commodityListVO.remark);
		goodsName.setText(commodityListVO.name);
		goodsID.setText(commodityListVO.id);
		goodsType.setText(commodityListVO.type);
		goodsPrice.setText(commodityListVO.price + "");
		goodsNum.setText(commodityListVO.num + "");
		goodsTotal.setText(exportMenuVO.afterValue + "");
		person.setText(personLabel);
		operator.setText(operatorLabel);
		discount.setText(exportMenuVO.discount + "");
		voucher.setText(exportMenuVO.voucherPrice + "");

	}

	public void addDis() {
		newRemark = new MyLabel(104, 420, 104, 118);
		discount = new MyLabel(235, 421, 91, 37);
		voucher = new MyLabel(235, 500, 91, 27);
		this.add(newRemark);
		this.add(discount);
		this.add(voucher);
	}

	public void addButton() {
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back);
		this.add(forward);
		back.addActionListener(buttonListener);
		forward.addActionListener(buttonListener);
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			frame.remove(MakeSureIm.this);
			if (e.getSource() == back) {
				frame.setPanel(imInPanel);
				frame.repaint();
			} else if (e.getSource() == forward) {
				SalesResult salesResult = new SalesResult(frame, controller, salesUIController, imInPanel);
				switch (salesblService.addImport_up(importMenuVO)) {
				case 0:
					System.out.println(importMenuVO.person+"person");
					salesResult.succeeded("添加成功！");
					break;
				default:
					salesResult.failed("未知错误！", "import_failed");
				}
			} else if (e.getSource() == back2) {
				frame.setPanel(imBackPanel);
				frame.repaint();
			} else if (e.getSource() == forward2) {
				SalesResult salesResult = new SalesResult(frame, controller, salesUIController, imBackPanel);
				switch (salesblService.addImport_Return_up(importMenuVO)) {
				case 0:
					salesResult.succeeded("添加成功！");
					break;
				case 6:
					salesResult.failed("超过最大可退货数量！", "import_returnFailed");
					break;
				default:
					salesResult.failed("添加失败！", "import_return_failed");
				}
			} else if (e.getSource() == backSales) {
				frame.setPanel(salesInPanel);
				frame.repaint();
			} else if (e.getSource() == forwardSales) {
				SalesResult salesResult = new SalesResult(frame, controller, salesUIController, salesInPanel);
				int i = salesblService.addExport_up(exportMenuVO);
//				System.out.println(i);
				switch(i){
				case 0:
					salesResult.succeeded("添加成功！");
					break;
				case 7:
					salesResult.failed("库存不足！", "export_return_failed");
					break;
				default:
					salesResult.failed("添加失败！", "export_return_failed");
				}
			}else if(e.getSource() == backSales2){
				frame.setPanel(salesBackPanel);
				frame.repaint();
			}else if(e.getSource() == forwardSales2){
				SalesResult salesResult = new SalesResult(frame, controller, salesUIController, salesBackPanel);
				int i = salesblService.addExport_Return_up(exportMenuVO);
				System.out.println(i);
				switch(i){
				case 0:
					salesResult.succeeded("添加成功！");
					break;
				case 5:
					salesResult.failed("超过最大可退货数量！", "export_failed");
					break;
				default:
					salesResult.failed("添加失败！", "export_failed");
				}
			}
		}

	}

	public void addBackButton() {
		back2 = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(back2);
		back2.addActionListener(buttonListener);
		forward2 = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(forward2);
		forward2.addActionListener(buttonListener);

	}

	public void addSalesButton() {
		backSales = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(backSales);
		backSales.addActionListener(buttonListener);
		forwardSales = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538,
				"Image/Sales/对话框/images/前进_黑.png", "Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(forwardSales);
		forwardSales.addActionListener(buttonListener);

	}
	
	public void addSalesBackButton(){
		backSales2 = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(backSales2);
		backSales2.addActionListener(buttonListener);
		forwardSales2 = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538,
				"Image/Sales/对话框/images/前进_黑.png", "Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(forwardSales2);
		forwardSales2.addActionListener(buttonListener);
		
	}
}
