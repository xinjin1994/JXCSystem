package ui;

import javax.swing.JPanel;

public class MyTextFieldTrans extends MyTextField{

	public MyTextFieldTrans(int x, int y, 
			JPanel backPanel,int width,int height) {
		super(x, y, backPanel);
		this.setSize(width, height);
		
		this.setBackground(null);
		this.setBorder(null);
		
	}
	
}
