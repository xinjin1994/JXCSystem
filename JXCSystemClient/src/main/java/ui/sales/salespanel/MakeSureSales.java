package ui.sales.salespanel;

import ui.UIController;
import ui.sales.SalesUIController;
import ui.sales.impanel.ImBackPanel;
import ui.sales.impanel.MakeSureIm;
import ui.setting.MyFrame;
import vo.bill.CommodityListVO;
import vo.bill.ImportMenuVO;

public class MakeSureSales extends MakeSureIm{

	public MakeSureSales(MyFrame frame, String url, UIController controller, ImportMenuVO importMenuVO,
			CommodityListVO commodityListVO, String personLabel, String operatorLabel, ImBackPanel imBackPanel,
			SalesUIController salesUIController) {
		super(frame, url, controller, importMenuVO, commodityListVO, personLabel, operatorLabel, imBackPanel,
				salesUIController);
	}
	

}
