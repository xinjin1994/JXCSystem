package ui.manager;

import java.awt.Color;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.ColorFactory;
import ui.setting.FontFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTextFieldTrans;
/**
 * 该类用于显示当前所有等级客户的优惠策略
 * @author ZYC
 *
 */
public class CheckProPanel extends FatherPanel{

	ManagerAllUIController uiController;
	MyFrame frame;
	MyLabel labels[][] = new MyLabel[5][8];
	
	public CheckProPanel(MyFrame frame, String url, ManagerAllUIController controller) {
		super(frame, url, controller);
		this.frame = frame;
		this.uiController = controller;
		this.repaint();
		
		uiController.setBack_first(this);
		setProLabels();
		setText();
	}
	/**
	 * 将现行的优惠策略显示，如果没有，数字的显示0，商品的显示无
	 */
	private void setText() {
		
	}
	private void setProLabels() {
		setLabels(98, 385, labels[0]);
		setLabels(247, 326, labels[1]);
		setLabels(401, 268, labels[2]);
		setLabels(550, 210, labels[3]);
		setLabels(698, 144, labels[4]);
		
		for(int i = 0;i < 5;i++){
			for(int j = 0;j < 8;j++){
				labels[i][j].setText("0");
				labels[i][j].setFont(new FontFactory(14).font);
				labels[i][j].setForeground(Color.white);
				this.add(labels[i][j]);
				
			}
		}
		for(int i = 0;i < 8;i++){
			labels[0][i].setForeground(new ColorFactory().greyFont);
		}
		for(int i = 0;i < 8;i++){
			labels[1][i].setForeground(new ColorFactory().greyFont);
		}
		for(int i = 0;i < 8;i++){
			
		}
		
		
	}
	
	private void setLabels(int x,int y,MyLabel[] la){
		la[0] = new MyLabel(x, y, 21, 14);
		la[1] = new MyLabel(x+42, y, 21, 14);
		la[2] = new MyLabel(x+14, y+30, 40, 14);
		la[3] = new MyLabel(x, y+55, 21, 14);
		la[4] = new MyLabel(x+42,y+55, 21, 14);
		la[5] = new MyLabel(x+14, y+93, 40, 14);
		la[6] = new MyLabel(x+14, y+115, 40, 14);
		la[7] = new MyLabel(x+14, y+150, 40, 14);
	}
	
}
