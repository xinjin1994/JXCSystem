package ui.setting.resultPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD
import javax.swing.JFrame;

import ui.FatherPanel;
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
=======
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.setting.FatherPanel;
>>>>>>> origin/master
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
//>>>>>>> fdfb8769613779b5e4559f17a4e848d418dcd06d
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
	 * 
	 * @param controller  其他界面的controller
	 */
<<<<<<< HEAD
	/**
	 * 
	 * @param controller
	 * @param frame
	 */
=======
	private AccountblService accountblService;
//	private AccountVO vo;
	
>>>>>>> origin/master
	public ResultPanelController(UIController controller,MyFrame frame) {
		textLabel = new MyLabel(0, 263, 800, 55);
		this.controller = controller;
		this.frame = frame;
//		this.vo = vo;
		accountblService = new AccountController();
	}
	
	public ResultPanelController(MyFrame frame,FatherPanel backPanel) {
		
		textLabel = new MyLabel(0, 263, 800, 55);
		this.frame = frame;
		this.backPanel = backPanel;
	}
	

	
	public void successed(String text,String type){
	//	accController = (AccountAllUIController)controller;
		resultPanel = new FatherPanel(frame, "Image/result/"+"account"+"_result.jpg", accController);
		setForward();
	
		textLabel.setText(text);

		setPanel();
	}

	public void failed(String text,String url){
		resultPanel = new FatherPanel(frame, url, this);
		setForward();
		
		forwardButton.setActionCommand("failed");
		textLabel.setText(text);
		setPanel();
	}
	
	private void setPanel() {
		resultPanel.add(textLabel);
		resultPanel.add(forwardButton);
		
		frame.setPanel(resultPanel);
		frame.repaint();
	}
//<<<<<<< HEAD
	public void addAcc() {
		AccountAllUIController accController = (AccountAllUIController)controller;
		accController.addMainPanel();
	/*	switch(accountblService.addAccount_up(vo)){
		case -1:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}*/
	}
//=======

	private void setForward() {
		ForwardButton forward = new ForwardButton(382, 327);
		forwardButton = forward.forward_black;
		
		resultPanel.add(forwardButton);
		forwardButton.setActionCommand("succ");
		forwardButton.addActionListener(this);	
//>>>>>>> fdfb8769613779b5e4559f17a4e848d418dcd06d
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("succ")){
			frame.remove(resultPanel);
			frame.setPanel(controller.getMainPanel());		
			frame.repaint();
		}else if(e.getActionCommand().equals("failed")){
			frame.remove(resultPanel);
			frame.setPanel(backPanel);
			frame.repaint();
		}
		
	}

	
	
}
