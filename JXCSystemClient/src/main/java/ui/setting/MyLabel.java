package ui.setting;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 封装要使用的label，背景透明，设置字体
 * @author ZYC
 *
 */
public class MyLabel extends JLabel{
	public MyLabel(int x,int y,int width,int height) {
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setFont(new FontFactory().font20);
		this.setHorizontalAlignment(CENTER);
	}

}
