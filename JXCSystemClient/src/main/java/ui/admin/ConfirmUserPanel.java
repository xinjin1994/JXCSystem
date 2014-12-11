package ui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.resultPanels.ResultPanelController;
import vo.UserVO;

public class ConfirmUserPanel extends FatherPanel implements ActionListener{
	private MyButton forwardButton;
	private ResultPanelController resController;
	private AdminAllUIController adminAllUIController;
	private UserVO user;
	private String type;
	
	private MyLabel[] infoLabels = new MyLabel[3]; 
	
	public ConfirmUserPanel(MyFrame frame, String url, AdminAllUIController controller,
			UserVO user,String type) {
		super(frame, url, controller);
		
		this.type = type;
		this.user = user;
		this.adminAllUIController = controller;
		setForward();
		setInfoLabel();
	}
	
	private void setForward() {
		ForwardButton forward = new ForwardButton(270, 300);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	private void addCloseLabel(){
		
	}
	
	private void addMinLabel(){
		
	}
/**
 * 将待确认信息加到label上
 */
	private void setInfoLabel(){
		for(int i = 0;i < infoLabels.length;i++){
			infoLabels[i] = new MyLabel(101, 89+72*i, 212, 35);
			this.add(infoLabels[i]);
			infoLabels[i].setForeground(new ColorFactory().greyFont);
		//	infoLabels[i].setText(""+i);
		}
		infoLabels[0].setText("1");
		infoLabels[1].setText("2");
		infoLabels[2].setText("3");
		this.repaint();
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == forwardButton){
			adminAllUIController.setResult(type);
		}
	}
	
}
