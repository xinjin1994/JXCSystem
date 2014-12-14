package ui.setting.resultPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
/**
 * 控制所有结果panel的新建及跳转
 * @author ZYC
 *
 */
public class ResultPanelController extends UIController implements ActionListener{
	
	FatherPanel resultPanel;
	UIController controller;
	MyFrame frame;
	MyLabel textLabel;
	MyButton forwardButton;
	AccountAllUIController accController ;
	ManagerAllUIController manController;
	
	
	FatherPanel backPanel;
	
	/**
	 * 返回到backPanel主界面
	 * @param frame
	 * @param backPanel
	 */
	public ResultPanelController(MyFrame frame,FatherPanel backPanel) {
		
		textLabel = new MyLabel(0, 263, 800, 55);
		this.frame = frame;
		this.backPanel = backPanel;
	}
	public void succeeded(String text,String type){
		resultPanel = new FatherPanel(frame, "Image/result/"+type+"_result.jpg", controller);
		setForward();
	
		textLabel.setText(text);

		setPanel();
	}

	public void failed(String text,String type){
		resultPanel = new FatherPanel(frame, "Image/result/"+type+"Failed.jpg", this);
		setForward();
		
		textLabel.setText(text);
		setPanel();
	}
	public void failedConfirm(String text, String type) {
		resultPanel = new FatherPanel(frame, "Image/result/"+type+"_failed.jpg", this);
		setForward();
	
		textLabel.setText(text);
		setPanel();
		
	}
	
	private void setPanel() {
		resultPanel.add(textLabel);
		resultPanel.add(forwardButton);
		
		frame.setPanel(resultPanel);
		frame.repaint();
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(382, 327);
		forwardButton = forward.forward_black;
		
		resultPanel.add(forwardButton);
		forwardButton.addActionListener(this);	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(resultPanel);
			frame.setPanel(backPanel);
			frame.repaint();
		}
	}
}