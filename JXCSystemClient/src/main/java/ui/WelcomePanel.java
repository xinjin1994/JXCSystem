package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WelcomePanel extends FatherPanel {

	private static final long serialVersionUID = -1660303715688708759L;
	private UIController controller;
	public WelcomePanel(String url, UIController controller) {
		super(url);
		this.controller = controller;
		this.addMouseListener(new JPanelListener());
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
