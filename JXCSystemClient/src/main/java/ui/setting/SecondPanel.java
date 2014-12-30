package ui.setting;

import javax.swing.JPanel;
/**
 * 所有模块主界面二级按钮所属panel，鼠标驻停一级按钮二级按钮会改变
 * @author ZYC
 *
 */
public class SecondPanel extends JPanel {
	
	private int secPanelX = 176, secPanelY = 75, secPanelWidth = 174, secPanelHeight = 525;
	public SecondPanel() {
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(secPanelX, secPanelY, secPanelWidth, secPanelHeight);
	}
}
