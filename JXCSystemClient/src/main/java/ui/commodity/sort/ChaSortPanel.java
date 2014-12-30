package ui.commodity.sort;

import java.awt.event.ActionEvent;

import ui.commodity.CommodityAllUIController;
import ui.setting.MyFrame;
import vo.SortVO;
/**
 * 修改分类对话框，结束后前往修改商品具体界面
 * @author ZYC
 *
 */
public class ChaSortPanel extends DelSortPanel{
	
	public ChaSortPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		
	}
	
	protected void setFailedAddress(){
		failedAddress = "com/chaSort";
	}
	
	protected void getSort() {
		nameString = name.getText();
		if(nameString.equals("")){
			resController.failed("您要修改的分类不存在！", failedAddress);
		}else{
			frame.remove(this);
			sort = commodityblService.searchSort_up(nameString);
			if(sort == null) {
				resController.failed("您要修改的分类不存在！", failedAddress);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(this);
			getSort();
			commodityAllUIController.chaSortD(sort);
		}
	}

}
