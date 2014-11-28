package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WelcomePanel extends FatherPanel {

	private static final long serialVersionUID = -1660303715688708759L;
	public WelcomePanel(String url, UIController controller) {
		super(url, controller);
		this.addMouseListener(new JPanelListener());
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bgImage, 0, 0, this);
	}
	
	class JPanelListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			controller.loginPanel();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
