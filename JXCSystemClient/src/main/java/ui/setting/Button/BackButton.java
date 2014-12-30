package ui.setting.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.FatherPanel;

public class BackButton extends MyButton{
	public MyButton back_white,back_black;
	public BackButton() {
		back_white = new MyButton("Image/Sales/Sales_image/返回_白.png", 13, 21, "Image/Sales/Sales_image/返回_press_on.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		
	}
	public BackButton(int x,int y){
		back_black = new MyButton("Image/Sales/Sales_image/返回_白.png", x, y, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		back_white= new MyButton("Image/Sales/Sales_image/返回_白.png", x, y, "Image/Sales/Sales_image/返回_press_on.png",
				"Image/Sales/Sales_image/返回_press_on.png");
	}
}
