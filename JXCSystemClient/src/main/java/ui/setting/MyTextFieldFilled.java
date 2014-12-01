package ui.setting;

import java.awt.Color;

//对应于类似业务员 纯白没有边框的
public class MyTextFieldFilled extends MyTextField{

	public MyTextFieldFilled(int x, int y, int width,int height) {
		super(x, y);
		this.setSize(width, height);
		this.setBorder(null);
		this.setBackground(Color.white);	
	}
}
