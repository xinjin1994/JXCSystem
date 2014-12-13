package ui.sales.impanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.SalesResult;
import ui.sales.SalesUIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.bill.CommodityListVO;
import vo.bill.ImportMenuVO;
import businesslogicservice.salesblservice.SalesblService;

public class MakeSureIm extends FatherPanel {
	protected ButtonListener buttonListener;
	protected MyLabel supplier, warehouse, remark, id, goodsID, goodsPrice, goodsNum, goodsTotal, goodsName,
			goodsType, person, operator;
	protected MyButton back, forward, back2, forward2;
	protected SalesblService salesblService;
	protected ImportMenuVO importMenuVO;
	protected CommodityListVO commodityListVO;
	protected String personLabel, operatorLabel;
	protected MyFrame frame;
	protected ImInPanel imInPanel;
	protected ImBackPanel imBackPanel;
	protected SalesUIController salesUIController;

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

	public void addLabel() {
		id = new MyLabel(105, 173, 222, 36);
		supplier = new MyLabel(210, 255, 116, 42);
		warehouse = new MyLabel(210, 308, 116, 42);
		remark = new MyLabel(104, 420, 111, 118);
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
			if (e.getSource() == back) {
				frame.remove(MakeSureIm.this);
				frame.setPanel(imInPanel);
				frame.repaint();
			} else if (e.getSource() == forward) {
				// System.out.println("hello");
				SalesResult salesResult = new SalesResult(frame, controller, salesUIController, MakeSureIm.this);
				switch (salesblService.addImport_up(importMenuVO)) {
				case 0:
					salesResult.succeeded("添加成功！", "sales");
					break;
				}
			} else if (e.getSource() == back2) {
				frame.remove(MakeSureIm.this);
				frame.setPanel(imBackPanel);
				frame.repaint();
			}else if(e.getSource() == forward2){
				SalesResult salesResult = new SalesResult(frame, controller, salesUIController, MakeSureIm.this);
				switch (salesblService.addImport_Return_up(importMenuVO)) {
				case 0:
					salesResult.succeeded("添加成功！", "sales");
					break;
				}
			}
		}

	}

	public void addBackButton() {
		back2 = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		forward2 = new MyButton("Image/Sales/对话框/images/前进_黑.png", 735, 538, "Image/Sales/对话框/images/前进_黑.png",
				"Image/Sales/对话框/images/前进_stop_黑.png");
		this.add(back2);
		this.add(forward2);
		back2.addActionListener(buttonListener);
		forward2.addActionListener(buttonListener);

	}
}
