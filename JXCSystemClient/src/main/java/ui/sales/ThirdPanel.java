package ui.sales;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ThirdPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1109769876698373537L;
	private Image bgImage;
	private int x = 350, y = 75, width = 450, height = 525;
	public ThirdPanel(String url) {
		bgImage = new ImageIcon(url).getImage();
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setOpaque(false);
	}

	public void paint(Graphics g){
		g.drawImage(bgImage, 0, 0, this);
		super.paint(g);
	}
}
