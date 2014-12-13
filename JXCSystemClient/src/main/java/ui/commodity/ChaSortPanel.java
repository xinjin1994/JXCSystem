package ui.commodity;

import java.awt.event.ActionEvent;

import ui.setting.MyFrame;

public class ChaSortPanel extends DelSortPanel{

	public ChaSortPanel(MyFrame frame, String url, CommodityAllUIController controller) {
		super(frame, url, controller);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			getSort();
		//	sort = new SortVO(nameString, "dd", "12");
			commodityAllUIController.chaSortD(sort);
		}
	}

}
