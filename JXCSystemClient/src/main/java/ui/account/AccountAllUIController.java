package ui.account;

import ui.MyFrame;
import ui.UIController;

public class AccountAllUIController extends UIController{
	private MyFrame frame;
	private UIController uiController;
	
	private FindAccountPanel findAccountPanel;
	
	
	public AccountAllUIController(UIController uiController,MyFrame frame) {
		this.frame = new MyFrame();
		new AccountUIController(this, frame);
	}
	
	public void findAccount(){
		findAccountPanel = new FindAccountPanel(frame,"Image/Account/查找账户.jpg",this);
		frame.setPanel(findAccountPanel);
		frame.repaint();
	}
}
