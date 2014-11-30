package ui.sales;

import javax.swing.JPanel;

public class SecondPanel extends JPanel {
	
	private int secPanelX = 176, secPanelY = 75, secPanelWidth = 174, secPanelHeight = 525;
	public SecondPanel() {
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(secPanelX, secPanelY, secPanelWidth, secPanelHeight);
	}
}
