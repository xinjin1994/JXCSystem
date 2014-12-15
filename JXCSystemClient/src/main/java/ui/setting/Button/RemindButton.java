package ui.setting.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.FatherPanel;

public class RemindButton implements ActionListener{
	public MyButton remindButton;
	FatherPanel panel;
	public JLabel label;
	public RemindButton(FatherPanel panel) {
		this.panel = panel;
	}
	public void setLable(){
		label = new JLabel();
		ImageIcon imageIcon = new ImageIcon("Image/remind_ori.png");
		label.setBounds(120,554,imageIcon.getIconWidth(),imageIcon.getIconHeight());
		label.setIcon(imageIcon);
		label.setVisible(true);
		panel.add(label);
	}
	public void setButton(){
		panel.remove(label);
		remindButton = new MyButton("Image/remind.png",120,554,"Image/remind.png","Image/remind.png");
		panel.add(remindButton);
		remindButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == remindButton){
			panel.remove(remindButton);
			panel.add(label);
			panel.repaint();
		}
	}
	
}
