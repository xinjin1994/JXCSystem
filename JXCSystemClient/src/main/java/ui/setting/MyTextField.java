package ui.setting;

import java.awt.Font;

import javax.swing.JTextField;
/**
 * 封装TextField
 * @author ZYC
 *
 */
public class MyTextField extends JTextField{
	
	public MyTextField(int x,int y){
		this.setLocation(x, y);
		this.setHorizontalAlignment(CENTER);
	}
//	public MyTextField(String text){
//		super(text);
//	}
}
