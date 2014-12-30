package ui.setting.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.FatherPanel;
import ui.setting.MyLabel;

/**
 * 审批通过按钮
 * @author ZYC
 *
 */
public class ApproveButton implements ActionListener{
	public MyButton approveButton;
	FatherPanel panel;
	public JLabel label;
	public ApproveButton(FatherPanel panel) {
		this.panel = panel;
	}
	public void setLable(){
		label = new JLabel();
		ImageIcon imageIcon = new ImageIcon("Image/approve_ori.png");
		label.setBounds(120,553,imageIcon.getIconWidth(),imageIcon.getIconHeight());
		label.setIcon(imageIcon);
		label.setVisible(true);
		panel.add(label);
	}
	public void setButton(){
		panel.remove(label);
		approveButton = new MyButton("Image/approve.png",120,553,"Image/approve.png","Image/approve.png");
		panel.add(approveButton);
		approveButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == approveButton){
			panel.remove(approveButton);
			panel.add(label);
			panel.repaint();
		}
	}
}
