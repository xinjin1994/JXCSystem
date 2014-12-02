package ui.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.FatherPanel;

public class BackButton extends MyButton{
	public MyButton back;
	public FatherPanel prePanel;
	public BackButton(FatherPanel prePanel) {
		back = new MyButton("Image/Sales/Sales_image/返回_白.png", 13, 21, "Image/Sales/Sales_image/返回_press_on.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		prePanel.add(back);
	}
}
