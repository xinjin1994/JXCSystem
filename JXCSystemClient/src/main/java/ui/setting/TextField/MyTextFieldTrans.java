package ui.setting.TextField;

import ui.setting.FontFactory;


/**
 * 没有边框且透明的textField
 * @author ZYC
 *
 */
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
