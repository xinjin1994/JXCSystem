package ui;

import java.awt.Color;

import javax.swing.JPanel;

public class MyTextFieldFilled extends MyTextField{

	public MyTextFieldFilled(int x, int y, JPanel backPanel,int width,int height) {
		super(x, y, backPanel);
		this.setSize(width, height);
		this.setBorder(null);
		this.setBackground(Color.white);	
	}
}
