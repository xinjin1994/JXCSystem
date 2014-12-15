package ui.commodity;

import java.awt.event.ActionEvent;

import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;

public class ChaSortPanel extends DelSortPanel{
	
	public ChaSortPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
		
	}
	
	protected void setFailedAddress(){
		failedAddress = "com/chaSort";
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			commodityAllUIController.setTempPanel(this);
			frame.remove(this);
			getSort();
		//	sort = new SortVO(nameString, "dd", "12");
			commodityAllUIController.chaSortD(sort);
		}
	}

}
