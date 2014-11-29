package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FatherPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -4321340946565227856L;
	protected UIController controller;
	protected int width;
	protected int height;
	protected Image bgImage ;
	protected String url;
	protected JFrame frame;
	
	public FatherPanel(){
		
	}
	
	public FatherPanel(JFrame frame,String url,UIController controller) {
		this.controller = controller;
		this.url=url;
		this.frame=frame;
		bgImage = new ImageIcon(url).getImage();
		this.width = bgImage.getWidth(null);
		this.height = bgImage.getHeight(null);
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(width, height);
		this.setOpaque(false);
		this.repaint();
	}
	public void paint(Graphics g){
		g.drawImage(bgImage, 0, 0, this);
		super.paint(g);
	}
	
}
