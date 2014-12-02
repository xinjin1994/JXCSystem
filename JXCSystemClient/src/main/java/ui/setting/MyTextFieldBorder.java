package ui.setting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;

//对应于类似查找客户 有边框的
public class MyTextFieldBorder extends MyTextField{
	
	public MyTextFieldBorder(int x, int y) {
		super(x, y);
		
		this.setOpaque(false);
		Color borderColor = new Color(230, 230, 230);
		this.setBorder(new LineBorder(borderColor));
		this.setSize(319,37);
		Font font2 = new Font("微软雅黑", Font.PLAIN, 20);
		this.setFont(font2);
		this.setHorizontalAlignment(CENTER);
	}

}
