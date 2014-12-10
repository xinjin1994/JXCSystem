package ui.account;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.UIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import vo.AccountVO;
/**
 * 查找账户对话框
 * @author ZYC
 * 
 */
public class FindAccountPanel extends FatherPanel implements ActionListener{
	ManagerAllUIController managerController;
	AccountAllUIController accountController;
	
	private MyButton exactForwardButton,fuzzyForwardButton;
	private MyTextFieldBorder name,info;
	private String nameString,infoString;
	
	private String type = "account";
	
	public FindAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.accountController =uiController;
		this.repaint();
		
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
			name.setText("");
			
			frame.remove(FindAccountPanel.this);
			if(type.equals("account")){
				accountController.accountDetail(getFoundAcc());
			}else if(type.equals("manager")){
				managerController.accountDetail(getFoundAcc());
			}
		}else if(e.getSource() == fuzzyForwardButton){
			infoString = info.getText();
			info.setText("");
			//返回主界面列表显示所有可能account
		}
		
	}
	private AccountVO getFoundAcc() {
		AccountVO foundAcc = new AccountVO("ff", 123);//从bl层获得的Account
		return foundAcc;
	}
}
