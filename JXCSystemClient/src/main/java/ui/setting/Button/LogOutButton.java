package ui.setting.Button;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.resultPanels.ResultPanelController;
/**
 * 封装注销按钮
 * @author ZYC
 *
 */
public class LogOutButton implements ActionListener{
	private MyButton logOutButton;
	private FatherPanel prePanel;
	private MyFrame frame;
	private String type;
	private UIController controller;
	private BackButton backButton;
	
	private ResultPanelController resController;
	/**
	 * 
	 * @param frame
	 * @param prePanel add返回注销按钮
	 * @param type  commodity Or account Or manager Or user Or sales
	 * @param controller
	 */
	public LogOutButton(MyFrame frame,FatherPanel prePanel,String type,UIController controller) {
		this.prePanel = prePanel;
		this.frame = frame;
		this.type = type;
		this.controller = controller;

		resController = new ResultPanelController(frame, prePanel);
		backButton = new BackButton();
		setButton();
	}

	private void setButton() {
		logOutButton = backButton.back_white;
		logOutButton.addActionListener(this);
		prePanel.add(logOutButton);
		prePanel.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logOutButton) {
			frame.remove(prePanel);
			
			
			frame.setPanel(controller.loginPanel);
			frame.repaint();
		}
	}
}
