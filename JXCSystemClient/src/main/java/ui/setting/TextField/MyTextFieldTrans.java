package ui.setting.TextField;

import ui.setting.FontFactory;


//对应于类似基本信息一栏 没有边框且透明的
public class MyTextFieldTrans extends MyTextField{

	public MyTextFieldTrans(int x, int y, 
			int width,int height) {
		
		super(x, y);
		this.setSize(width, height);
		this.setOpaque(false);
		
		this.setFont(new FontFactory(20).font);
		this.setBackground(null);
		this.setBorder(null);
		
	}
	
}
