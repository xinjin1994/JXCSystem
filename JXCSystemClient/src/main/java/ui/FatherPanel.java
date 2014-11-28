package ui;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;

public class FatherPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = -4321340946565227856L;
	private ImageIcon background;
	private int width;
	private int height;

	public FatherPanel(){
		
	}
	public FatherPanel(String url) {
		this.addBackground(url);
		this.setOpaque(false);
		this.setLayout(new FlowLayout());
		this.setSize(width, height);
	}

	private void addBackground(String url) {
		background = new ImageIcon(url);
		JLabel label = new JLabel(background);
		width = background.getIconWidth();
		height = background.getIconHeight();
		label.setBounds(0, 0, width, height);
		this.add(label, new Integer(Integer.MIN_VALUE));
	}
}
