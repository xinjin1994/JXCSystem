package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class MyFirstButton extends MyButton{
	JPanel panelBelow, panelAbove;
	private static final long serialVersionUID = 1L;

	public MyFirstButton(String image, int width, int height, String stopImage, String press_onImage) {
		super(image, width, height, stopImage, press_onImage);
	}

	public void showSecondPanel(JPanel panelBelow, JPanel panelAbove) {
		this.panelAbove = panelAbove;
		this.panelBelow = panelBelow;
		this.addMouseListener(new ButtonListener());
	}

	class ButtonListener implements MouseListener {

		int times = 0;

		public void mouseClicked(MouseEvent e) {
			times++;
			panelBelow.add(panelAbove);
			panelBelow.repaint();
		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			panelBelow.add(panelAbove);
			panelBelow.repaint();
		}

		public void mouseExited(MouseEvent e) {
			if (!(times > 0)) {
				panelBelow.remove(panelAbove);
				panelBelow.repaint();
			}
			times = 0;
		}

	}
}
