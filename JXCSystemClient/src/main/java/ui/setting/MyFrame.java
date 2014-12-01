package ui.setting;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
 
	private static final long serialVersionUID = -2308734636856199114L;

	public MyFrame(){
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300, 100, 800, 600);
		this.setUndecorated(true);
	}
	
	public void setPanel(JPanel panel){
		this.add(panel);
		this.setVisible(true);
	}

}

