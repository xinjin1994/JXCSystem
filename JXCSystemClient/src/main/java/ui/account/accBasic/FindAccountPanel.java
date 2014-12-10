package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/FindAccountPanel.java
import ui.FatherPanel;
import ui.UIController;
import ui.manager.ManagerAllUIController;
=======
import ui.account.AccountAllUIController;
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/FindAccountPanel.java
import ui.setting.ColorFactory;
import ui.setting.FatherPanel;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.MyTextFieldBorder;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 查找账户对话框
 * @author ZYC
 * 
 */
public class FindAccountPanel extends FatherPanel implements ActionListener{
<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/FindAccountPanel.java
	ManagerAllUIController managerController;
	AccountAllUIController accountController;
	
	private MyButton exactForwardButton,fuzzyForwardButton;
	private MyTextFieldBorder name,info;
	private String nameString,infoString;
	
	private String type = "account";
=======

	AccountAllUIController uiController;
	MyButton exactForwardButton,fuzzyForwardButton;
	MyTextFieldBorder name,info;
	String nameString,infoString;
	AccountblService accountblService;
	MyTable table;
	MyFrame frame;
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/FindAccountPanel.java
	
	public FindAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/FindAccountPanel.java
		this.accountController =uiController;
=======
		this.uiController = uiController;
		this.frame = frame;
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/FindAccountPanel.java
		this.repaint();
		accountblService = new AccountController();
		uiController.setBack_second(this,150,130);
		init();
	}
	
	public FindAccountPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		this.managerController =uiController;
		this.repaint();
		this.type = type;
		
		uiController.setBack_second(this,150,130);
		init();
	}
	
	private void init() {
		setForward();
		setTextField();
	}
	
	/**
	 * 前进按钮
	 * @param exactForwardButton 精确查找
	 * @param fuzzyForwardButton 模糊查找
	 * @see ForwardButton
	 */
	private void setForward() {
		ForwardButton exactForward = new ForwardButton(600, 231);
		ForwardButton fuzzyForward = new ForwardButton(600, 369);
		
		exactForwardButton = exactForward.forward_white;
		fuzzyForwardButton = fuzzyForward.forward_white;
		
		this.add(exactForwardButton);
		this.add(fuzzyForwardButton);
		
		exactForwardButton.addActionListener(this);
		fuzzyForwardButton.addActionListener(this);
	}
	/**
	 * 设置输入框
	 * @see MyTextFieldBoarder
	 * @see ColorFactory
	 */
	private void setTextField() {
		name = new MyTextFieldBorder(225, 234);
		info = new MyTextFieldBorder(225, 368);
		
		name.setForeground(new ColorFactory().greyFont);
		info.setForeground(new ColorFactory().greyFont);
		
		this.add(name);
		this.add(info);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exactForwardButton){
			nameString = name.getText();
			info.setText("");
			AccountVO foundAccVO = accountblService.searchAccurateAccount_up(nameString);
			frame.remove(FindAccountPanel.this);
<<<<<<< HEAD:JXCSystemClient/src/main/java/ui/account/FindAccountPanel.java
			if(type.equals("account")){
				accountController.accountDetail(getFoundAcc());
			}else if(type.equals("manager")){
				managerController.accountDetail(getFoundAcc());
			}
		}else if(e.getSource() == fuzzyForwardButton){
			infoString = info.getText();
			info.setText("");
			//返回主界面列表显示所有可能account
=======
			
			uiController.accountDetail(foundAccVO);
		}else if(e.getSource() == fuzzyForwardButton){
			infoString = info.getText();
			info.setText("");
			ArrayList<AccountVO> fuzzyAccVO = accountblService.searchFuzzyAccount_up(infoString);	
			TablePanel tablePanel = new TablePanel(frame,"Image/Sales/null.jpg",uiController,fuzzyAccVO,FindAccountPanel.this);
			//TODO change the picture;
			frame.remove(FindAccountPanel.this);
			frame.setPanel(tablePanel);
			frame.repaint();
>>>>>>> origin/master:JXCSystemClient/src/main/java/ui/account/accBasic/FindAccountPanel.java
		}
		
	}
	
	
	/*private AccountVO getFoundAcc() {
		AccountVO foundAcc = new AccountVO("ff", 123);//从bl层获得的Account
		
		return foundAcc;
	}*/
}
