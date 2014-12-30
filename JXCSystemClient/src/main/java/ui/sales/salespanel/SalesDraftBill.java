package ui.sales.salespanel;

import ui.UIController;
import ui.setting.MyFrame;
import vo.bill.ExportMenuVO;

public class SalesDraftBill extends SalesInPanel{

	protected ExportMenuVO exportMenuVO;
	public SalesDraftBill(MyFrame frame, String url, UIController controller,ExportMenuVO exportMenuVO) {
		super(frame, url, controller);
		this.exportMenuVO = exportMenuVO;
		setSalesLabel();
	}
	public void setSalesLabel() {
		id.setText(exportMenuVO.commodityList.id);
		newSupplier.setSelectedItem(exportMenuVO.cusName);
		warehouse.setText(exportMenuVO.warehouse);
		newRemark.setText(exportMenuVO.commodityList.remark);
		goodsName.setSelectedItem(exportMenuVO.commodityList.name);
		goodsID.setText(exportMenuVO.commodityList.id);
		goodsType.setSelectedItem(exportMenuVO.commodityList.type);
		goodsPrice.setText(exportMenuVO.commodityList.price + "");
		goodsNum.setText(exportMenuVO.commodityList.num + "");
		goodsTotal.setText(exportMenuVO.afterValue + "");
		person.setText(exportMenuVO.person);
		operator.setText(exportMenuVO.operator);
		discount.setText(exportMenuVO.discount + "");
		voucher.setText(exportMenuVO.voucherPrice + "");

	}
	

}
