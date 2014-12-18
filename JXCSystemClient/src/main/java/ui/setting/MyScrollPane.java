package ui.setting;

import javax.swing.JScrollPane;

public class MyScrollPane extends JScrollPane{
	public MyScrollPane() {
		this.setBounds(43,44,360,380);
		this.getViewport().setOpaque(false);
		this.setOpaque(false);
	}
}
