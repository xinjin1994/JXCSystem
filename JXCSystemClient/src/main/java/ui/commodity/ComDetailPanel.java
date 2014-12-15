package ui.commodity;

import java.awt.Color;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import vo.CommodityVO;

public class ComDetailPanel extends FatherPanel{
	private MyFrame frame;
	private CommodityAllUIController commodityAllUIController;
	private CommodityVO com;
	
	private MyLabel labels[] = new MyLabel[10];
	private ColorFactory color = new ColorFactory();
	
	public ComDetailPanel(MyFrame frame, String url, CommodityAllUIController controller,CommodityVO com) {
		super(frame, url, controller);
		this.frame = frame;
		this.commodityAllUIController = controller;
		this.com = com;
		
		setLabels();
	}

	protected void initReturn () {
		commodityAllUIController.setBack_first(this);
	}
	private void setLabels() {
		labels[0] = new MyLabel(106, 165, 221, 55);
		setLabels_help(labels[0],24,color.accColor,com.id);
		
		labels[1] = new MyLabel(106,347,107,55);
		setLabels_help(labels[1], 24,color.greyFont,String.valueOf(com.latestInValue));
		
		labels[2] = new MyLabel(212, 347, 107, 55);
		setLabels_help(labels[2], 24, color.accColor, String.valueOf(com.latestOutValue));
		
		labels[3] = new MyLabel(106, 491, 226, 46);
		setLabels_help(labels[3], 24, color.accColor, String.valueOf(com.num));
		
		labels[4] = new MyLabel(534, 164, 166, 41);
		setLabels_help(labels[4], 20, color.accColor, com.name);
		
		labels[5] = new MyLabel(534, 205, 166, 41);
		setLabels_help(labels[5], 20, color.greyFont, com.type);
		
		labels[6] = new MyLabel(534, 245, 166, 41);
		setLabels_help(labels[6], 20, color.accColor, com.sort);
		
		labels[7] = new MyLabel(534, 286, 166, 41);
		setLabels_help(labels[7], 20, color.greyFont, String.valueOf(com.inValue));
		
		labels[8] = new MyLabel(534, 327, 166, 41);
		setLabels_help(labels[8], 20, color.accColor, String.valueOf(com.outValue));
	
		labels[9] = new MyLabel(405, 449, 225, 89);
		setLabels_help(labels[9], 24, color.accColor, String.valueOf(com.warnNumber));
	}
	
	private void setLabels_help(MyLabel label,int fontSize,Color fontColor,String text){
		label.setFont(new FontFactory(fontSize).font);
		label.setForeground(fontColor);
		label.setText(text);
		this.add(label);
	}

}
