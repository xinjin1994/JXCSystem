package ui.commodity.sort;

import java.awt.event.ActionEvent;

import ui.commodity.CommodityAllUIController;
import ui.setting.MyFrame;
import vo.SortVO;

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
			resController.failed("请重新确认输入信息！", failedAddress);
		}else{
			try{
			frame.remove(this);
			/*sort = new SortVO(nameString);
			sort.note = "2";
			sort.fatherSort = "b";*/
			sort = commodityblService.searchSort_up(nameString);
			}catch(Exception e){
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
