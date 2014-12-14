package ui.setting;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
 
	private static final long serialVersionUID = -2308734636856199114L;

	public MyFrame(){
		this.setResizable(false);
		this.setLayout(null);
//		this.setBounds(300, 100, 800, 600);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int frameWidth = 800;
		int frameHeight = 600;
		this.setBounds((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2, frameWidth, frameHeight);
		this.setUndecorated(true);
	}
	
	public void setPanel(JPanel panel){
		this.add(panel);
		this.setVisible(true);
	}

}

