package ui.sales.impanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.impanel.MakeSureIm.ButtonListener;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import vo.bill.ImportMenuVO;

public class ImInBillPanel extends FatherPanel {

	protected MyLabel supplier, warehouse, remark, id, goodsID, goodsPrice, goodsNum, goodsTotal, goodsName,
			goodsType, person, operator, newRemark, discount, voucher;
	protected MyButton back;
	protected ImportMenuVO importMenuVO;
	private UIController controller;
	private MyFrame frame;
	
	public ImInBillPanel(MyFrame frame, String url, UIController controller, ImportMenuVO importMenuVO) {
		super(frame, url, controller);
		this.frame = frame;
		this.importMenuVO = importMenuVO;
		this.controller = controller;
		addButton();
		addLabel();
		setLabel();
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


	// (String id,String supplier,String warehouse,String operator,
	// CommodityListVO commodityList,String remark,double total,String time,int
	// bill_note,String invoice_note){
	// 编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
	public void setLabel() {
		id.setText(importMenuVO.id);
		supplier.setText(importMenuVO.supplier);
		warehouse.setText(importMenuVO.warehouse);
		remark.setText(importMenuVO.remark);
		goodsName.setText(importMenuVO.commodityList.name);
		goodsID.setText(importMenuVO.commodityList.id);
		goodsType.setText(importMenuVO.commodityList.type);
		goodsPrice.setText(importMenuVO.commodityList.price + "");
		goodsNum.setText(importMenuVO.commodityList.num + "");
		goodsTotal.setText(importMenuVO.commodityList.total + "");
		person.setText("");
		//如何获得这个业务员？
		operator.setText(importMenuVO.operator);
	}

	public void addButton() {
		back = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		this.add(back);
		back.addMouseListener(new MouListener());
	}

	class MouListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			controller.setBackBills(ImInBillPanel.this);
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
