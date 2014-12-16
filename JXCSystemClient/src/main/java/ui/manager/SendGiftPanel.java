package ui.manager;

import javax.swing.JFrame;

import po.SendGiftPO;
import ui.CommodityPanel;
import ui.FatherPanel;
import ui.UIController;
import ui.commodity.CommodityAllUIController;
import ui.commodity.PatchDetailPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.SendGiftVO;
import vo.bill.PatchVO;

public class SendGiftPanel extends FatherPanel{
	protected MyFrame frame;
	protected SendGiftVO sendGift;
	
	private ManagerAllUIController managerAllUIController;
	private UIController uiController;
	
	protected MyLabel labels[] = new MyLabel[6];
	protected ColorFactory color = new ColorFactory();
	
	public SendGiftPanel(MyFrame frame, String url,
			ManagerAllUIController managerAllUIController,SendGiftVO gift) {
		super(frame, url, managerAllUIController);
		this.frame = frame;
		this.managerAllUIController = managerAllUIController;
		back();
		setLabels();
	}
	
	public SendGiftPanel(MyFrame frame, String url,
			UIController uiController,SendGiftVO gift) {
		super(frame, url, uiController);
		this.frame = frame;
		this.uiController = uiController;
		uiController.setBackBills(this);
		setLabels();
	}
	

	protected void back(){
		managerAllUIController.setBack_first(this);
	}
	
	protected void setLabels() {
		labels[0] = new MyLabel(94, 188, 269, 42);
		labels[1] = new MyLabel(94, 308, 269, 42);
		labels[2] = new MyLabel(94, 427, 269, 42);
		labels[3] = new MyLabel(427, 188, 269, 42);
		labels[4] = new MyLabel(427, 308, 269, 42);
		labels[5] = new MyLabel(427, 427, 269, 42);
		
		labels[0].setText(sendGift.note);
		labels[1].setText(sendGift.time);
		labels[2].setText(sendGift.operator);
		labels[3].setText(sendGift.name);
		labels[4].setText(sendGift.type);
		labels[5].setText(String.valueOf(sendGift.number));
		
		for(int i = 0;i < labels.length;i++){
			this.add(labels[i]);
			labels[i].setForeground(color.greyFont);
		}
		
	}

}

	

