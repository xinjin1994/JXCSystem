package ui;

import javax.swing.JPanel;

public class BackButton {
	JPanel prePanel;
	JPanel nextPanel;
	public BackButton(JPanel prePanel,JPanel nextPanel) {
		this.prePanel = prePanel;
		this.nextPanel = nextPanel;
		setButton();
	}
	public void setButton() {
		MyButton fatherButton = new MyButton(null, 0, 0, null, null);
	}
}
