package ui;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FatherPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -4321340946565227856L;
	protected UIController controller;
	protected int width;
	protected int height;
	protected Image bgImage ;
	
	public FatherPanel(){
		
	}
	
	public FatherPanel(String url, UIController controller) {
		this.controller = controller;
		bgImage = new ImageIcon(url).getImage();
		this.width = bgImage.getWidth(null);
		this.height = bgImage.getHeight(null);
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(width, height);
		this.setOpaque(false);
		this.repaint();
	}

	/*public void addBackground(String url) {
		background = new ImageIcon(url);
		JLabel label = new JLabel(background);
		width = background.getIconWidth();
		height = background.getIconHeight();
		label.setBounds(0, 0, width, height);
		this.add(label, new Integer(Integer.MIN_VALUE));
	}*/

	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bgImage, 0, 0, this);
	}
	
}
