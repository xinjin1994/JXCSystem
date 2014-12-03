package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private int exitWidth = 27;
	private int exitHeight = 27;
	private int exitX = 759;
	private int exitY = 1;
	private int miniX = 711;
	private JLabel close1, close2;
	private JLabel minimize1, minimize2;
	private ImageIcon closeImage, closeImage2, miniImage1, miniImage2;
	
	
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
		this.addCloseLabel();
		this.addMiniLabel();
		this.setOpaque(false);
		this.repaint();
	}
	private void addMiniLabel() {
		miniImage1 = new ImageIcon("Image/mini.png");
		miniImage2 = new ImageIcon("Image/mini-pressON.png");
		minimize1 = new JLabel(miniImage1);
		minimize1.setBounds(miniX, exitY, exitWidth, exitHeight);
		minimize1.addMouseListener(new MiniListener());
		this.add(minimize1);
		minimize2 = new JLabel(miniImage2);
		minimize2.setBounds(exitX, exitY, exitWidth, exitHeight);
		minimize2.setVisible(false);
		this.add(minimize2);
	}

	class MiniListener implements MouseListener {

		int times = 0;

		public void mouseClicked(MouseEvent e) {
			frame.setExtendedState(JFrame.ICONIFIED);// 最小化
		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			if (times == 0 || times == 1) {
				minimize1.setVisible(false);
				minimize2.setVisible(true);
			}
			times++;
		}

		public void mouseExited(MouseEvent e) {
			minimize2.setVisible(false);
			minimize1.setVisible(true);
			times = 0;
		}

	}

	private void addCloseLabel() {
		closeImage = new ImageIcon("Image/exit.png");
		closeImage2 = new ImageIcon("Image/exit-pressON.png");
		close1 = new JLabel(closeImage);
		close1.setBounds(exitX, exitY, exitWidth, exitHeight);
		close1.addMouseListener(new closeListener());
		this.add(close1);
		close2 = new JLabel(closeImage2);
		close2.setBounds(exitX, exitY, exitWidth, exitHeight);
		close2.setVisible(false);
		this.add(close2);
	}

	class closeListener implements MouseListener {

		int times = 0;

		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			if (times == 0 || times == 1) {
				close1.setVisible(false);
				close2.setVisible(true);
			}
			times++;
		}

		public void mouseExited(MouseEvent e) {
			close2.setVisible(false);
			close1.setVisible(true);
			times = 0;
		}

	}

	public void paint(Graphics g){
		g.drawImage(bgImage, 0, 0, this);
		super.paint(g);
	}
	
	 
	
}
