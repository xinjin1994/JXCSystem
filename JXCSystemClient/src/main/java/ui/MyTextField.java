package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyTextField extends JTextField{
	
	JPanel backPanel;
	public MyTextField(int width,int height,JPanel backPanel){
		this.backPanel = backPanel;
		this.setLocation(width, height);
		backPanel.add(this);
	}
}
