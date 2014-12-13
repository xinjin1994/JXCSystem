package ui.setting.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton{
	int x;
	int y;//坐标
	
	public MyButton(){
		
	}
	
	public MyButton(String image,int x,int y,String stopImage,String press_onImage) {
		this.x = x;
		this.y = y;
		
		ImageIcon imageIcon = new ImageIcon(image);
		ImageIcon imageIconstop = new ImageIcon(stopImage);
		ImageIcon imageIconpresson = new ImageIcon(press_onImage);
		
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);// 设置透明
		this.setIcon(imageIcon);
		this.setBounds(x, y, imageIcon.getImage().getWidth(null),
				imageIcon.getImage().getHeight(null));	
		this.setVisible(true);
		
		this.setRolloverIcon(imageIconstop);
		this.setPressedIcon(imageIconpresson);
		
		
		
	}
}
