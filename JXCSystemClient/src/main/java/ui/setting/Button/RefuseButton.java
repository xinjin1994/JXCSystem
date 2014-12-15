package ui.setting.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.FatherPanel;

public class RefuseButton implements ActionListener{
	public MyButton refuse;
	FatherPanel panel;
	public JLabel label;
	public RefuseButton(FatherPanel panel) {
		this.panel = panel;
	}
	public void setLable(){
		label = new JLabel();
		ImageIcon imageIcon = new ImageIcon("Image/refuse_ori.png");
		label.setBounds(26,553,imageIcon.getIconWidth(),imageIcon.getIconHeight());
		label.setIcon(imageIcon);
		label.setVisible(true);
		panel.add(label);
	}
	public void setButton(){
		panel.remove(label);
		refuse = new MyButton("Image/refuse.png",26,553,"Image/refuse.png","Image/refuse.png");
		panel.add(refuse);
		refuse.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == refuse){
			panel.remove(refuse);
			panel.add(label);
			panel.repaint();
		}
	}
}
