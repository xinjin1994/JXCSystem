package ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyButton extends JButton{
	JPanel backPanel;
	JLabel stopLabel;
	
	int width;
	int height;//坐标
	
	public MyButton(String image,int width,int height,JPanel backPanel) {
		this.backPanel = backPanel;
		this.width = width;
		this.height = height;
		
		ImageIcon imageIcon = new ImageIcon(image);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);// 设置透明
		this.setBounds(width, height, imageIcon.getImage().getWidth(null),
				imageIcon.getImage().getHeight(null));	
	}
}
