package ui.sales.salespanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.sales.impanel.ImInBillPanel;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.MyButton;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;

public class SalesBillPanel extends FatherPanel{
	/*
	 * 总经理审批销售单及销售退货单草稿界面
	 */
	
	protected ExportMenuVO exportMenuVO;
	private UIController controller;
	private MyFrame frame;
	protected MyLabel supplier, warehouse, id, goodsID, goodsPrice, goodsNum, goodsTotal, goodsName,
	goodsType, person, operator, newRemark, discount, voucher;
	private MyButton backSales;

	public SalesBillPanel(MyFrame frame, String url, UIController controller,ExportMenuVO exportMenuVO) {
		super(frame, url, controller);
		this.frame = frame;
		this.controller = controller;
		this.exportMenuVO = exportMenuVO;
		addLabel();
		addDis();
		setSalesLabel();
		back();
	}
	
	public void back(){
		controller.setBackBills(this);
		
	}
	public void addLabel() {
		id = new MyLabel(105, 173, 222, 36);
		supplier = new MyLabel(210, 255, 116, 42);
		warehouse = new MyLabel(210, 308, 116, 42);
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
		this.add(goodsName);
		this.add(goodsID);
		this.add(goodsType);
		this.add(goodsPrice);
		this.add(goodsNum);
		this.add(goodsTotal);
		this.add(person);
		this.add(operator);
	}

	public void addDis() {
		newRemark = new MyLabel(104, 420, 104, 118);
		discount = new MyLabel(235, 421, 91, 37);
		voucher = new MyLabel(235, 500, 91, 27);
		this.add(newRemark);
		this.add(discount);
		this.add(voucher);
	}
	
	public void setSalesLabel() {
		id.setText(exportMenuVO.id);
		supplier.setText(exportMenuVO.cusName);
		warehouse.setText(exportMenuVO.warehouse);
		newRemark.setText(exportMenuVO.commodityList.remark);
		goodsName.setText(exportMenuVO.commodityList.name);
		goodsID.setText(exportMenuVO.commodityList.id);
		goodsType.setText(exportMenuVO.commodityList.type);
		goodsPrice.setText(exportMenuVO.commodityList.price + "");
		goodsNum.setText(exportMenuVO.commodityList.num + "");
		goodsTotal.setText(exportMenuVO.afterValue + "");
		person.setText(exportMenuVO.salesMan);
		operator.setText(exportMenuVO.operator);
		discount.setText(exportMenuVO.discount + "");
		voucher.setText(exportMenuVO.voucherPrice + "");

	}

}
