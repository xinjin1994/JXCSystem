package ui.setting.TextField;

import java.awt.Color;

import ui.setting.FontFactory;

//对应于类似业务员 纯白没有边框的
public class MyTextFieldFilled extends MyTextField{

	public MyTextFieldFilled(int x, int y, int width,int height) {
		super(x, y);
		this.setSize(width, height);
		this.setBorder(null);
		this.setFont(new FontFactory(20).font);
		this.setBackground(Color.white);	
	}
}
