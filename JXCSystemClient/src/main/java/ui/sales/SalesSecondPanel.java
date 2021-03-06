package ui.sales;

import javax.swing.JPanel;


/**
 * 二级界面的父类（主界面中的第二列）
 * @author lsy
 * @version 2014年12月31日下午3:27:49
 */
public class SalesSecondPanel extends JPanel {
	
	private int secPanelX = 176, secPanelY = 75, secPanelWidth = 174, secPanelHeight = 525;
	protected int secondX = 1;
	protected int secondY = 35;
	protected int inter = 54;
	protected SalesUIController salesUIController;
	public SalesSecondPanel(SalesUIController salesUIController) {
		this.salesUIController = salesUIController;
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(secPanelX, secPanelY, secPanelWidth, secPanelHeight);
	}
}
