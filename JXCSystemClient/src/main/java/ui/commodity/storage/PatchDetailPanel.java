package ui.commodity.storage;

import ui.FatherPanel;
import ui.UIController;
import ui.commodity.CommodityAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.CommodityVO;
import vo.bill.PatchVO;
/**
 * 库存报溢报损详细信息界面
 * @author ZYC
 *
 */
public class PatchDetailPanel extends FatherPanel{

	protected MyFrame frame;
	protected CommodityAllUIController commodityAllUIController;
	protected PatchVO patch;
	
	protected MyLabel labels[] = new MyLabel[6];
	protected ColorFactory color = new ColorFactory();
	
	public PatchDetailPanel(MyFrame frame, String string,
			CommodityAllUIController commodityAllUIController,PatchVO patch) {
		super(frame, string, commodityAllUIController);
		this.frame = frame;
		this.commodityAllUIController = commodityAllUIController;
		this.patch = patch;
		back();
		setLabels();
	}

	public PatchDetailPanel(MyFrame frame, String string,
			UIController uiController, PatchVO patch) {
		super(frame, string, uiController);
		this.patch = patch;
		this.frame = frame;
		setLabels();
		
		uiController.setBackBills(this);
	
	
	}

	protected void back(){
		commodityAllUIController.setBack_first(this);
	}
	
	protected void setLabels() {
		labels[0] = new MyLabel(94, 188, 269, 42);
		labels[1] = new MyLabel(94, 308, 269, 42);
		labels[2] = new MyLabel(94, 427, 269, 42);
		labels[3] = new MyLabel(427, 188, 269, 42);
		labels[4] = new MyLabel(427, 308, 269, 42);
		labels[5] = new MyLabel(427, 427, 269, 42);
		
		labels[0].setText(patch.note);
		labels[1].setText(patch.time);
		labels[2].setText(patch.operator);
		labels[3].setText(patch.name);
		labels[4].setText(patch.type);
		labels[5].setText(String.valueOf(patch.number));
		
		for(int i = 0;i < labels.length;i++){
			this.add(labels[i]);
			labels[i].setForeground(color.greyFont);
		}
		
	}

}
