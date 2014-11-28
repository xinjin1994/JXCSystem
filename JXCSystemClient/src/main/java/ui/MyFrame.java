package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
 
	public MyFrame(){
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300, 100, 800, 600);
		//this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setPanel(JPanel panel){
		this.add(panel);
		this.setVisible(true);
	}

}

