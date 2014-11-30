package ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MyTextFieldBorder extends MyTextField{
	
	public MyTextFieldBorder(int width, int height,JPanel backPanel) {
		super(width, height,backPanel);
		
		this.setBackground(null);
		Color borderColor = new Color(230, 230, 230);
		this.setBorder(new LineBorder(borderColor));
		this.setSize(319,37);
		
	}

}
