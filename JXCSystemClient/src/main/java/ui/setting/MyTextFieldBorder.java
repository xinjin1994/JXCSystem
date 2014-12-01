package ui.setting;

import java.awt.Color;

import javax.swing.border.LineBorder;

//对应于类似查找客户 有边框的
public class MyTextFieldBorder extends MyTextField{
	
	public MyTextFieldBorder(int width, int height) {
		super(width, height);
		
		this.setBackground(null);
		Color borderColor = new Color(230, 230, 230);
		this.setBorder(new LineBorder(borderColor));
		this.setSize(319,37);
		
	}

}
