package ui.sales.impanel;

import ui.UIController;
import ui.setting.MyFrame;
import vo.bill.ImportMenuVO;

public class ImInDraftBill extends ImInPanel{
	
	protected ImportMenuVO importMenuVO;
	public ImInDraftBill(MyFrame frame, String url, UIController controller, ImportMenuVO importMenuVO) {
		super(frame, url, controller);
		this.importMenuVO = importMenuVO;
		setDraft();
	}

	public void setDraft(){
		id.setText(importMenuVO.commodityList.id);
		supplier.setSelectedItem(importMenuVO.supplier);
		warehouse.setText(importMenuVO.warehouse);
		remark.setText(importMenuVO.commodityList.remark);
		goodsName.setSelectedItem(importMenuVO.commodityList.name);
		goodsID.setText(importMenuVO.commodityList.id);
		goodsType.setSelectedItem(importMenuVO.commodityList.type);
		goodsPrice.setText(importMenuVO.commodityList.price + "");
		goodsNum.setText(importMenuVO.commodityList.num + "");
		goodsTotal.setText(importMenuVO.commodityList.total + "");
		person.setText(importMenuVO.person);
		operator.setText(importMenuVO.operator);
	}
}
