package ui.setting;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyStopButton extends JButton{

	private int x,y;
	public MyStopButton(String image,int x,int y,String stopImage){
		this.x = x;
		this.y = y;
		
		ImageIcon imageIcon = new ImageIcon(image);
		ImageIcon imageIconstop = new ImageIcon(stopImage);
		
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);// 设置透明
		this.setIcon(imageIcon);
		this.setBounds(x, y, imageIcon.getImage().getWidth(null),
				imageIcon.getImage().getHeight(null));	
		this.setVisible(true);
		
		this.setRolloverIcon(imageIconstop);
	}
	public void setIcon(Icon icon){
		super.setIcon(icon);
		this.repaint();
	}
}
