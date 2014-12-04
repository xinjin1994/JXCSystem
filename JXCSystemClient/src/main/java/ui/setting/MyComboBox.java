package ui.setting;

import javax.swing.JComboBox;
import javax.swing.JComponent;

public class MyComboBox extends JComboBox{
	public MyComboBox(String [] roleList,int x,int y,int width,int height) {
		super(roleList);
		this.setBounds(x, y, width, height);
		
		
	}
}
