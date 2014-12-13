package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
/**
 * 删除账户，该类不直接删除账户
 * @author ZYC
 * @see ConfirmAccPanel
 */
public class DelAccountPanel extends FatherPanel implements ActionListener{
	AccountAllUIController accountController;
	ManagerAllUIController managerController;
	AccountblService accountblService;
	private MyTextFieldBorder name;
	private MyButton forwardButton;
	private String delAccString;
	AccountVO delAcc;
	private MyLabel failLabel;
	
	private String type = "account";
	public DelAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.accountController = uiController;
		this.repaint();
		accountblService = new AccountController();
		uiController.setBack_second(this,199,141);
		addLabel();
		init();
		
	}
	
	public DelAccountPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		this.managerController = uiController;
		this.type = type;
		this.repaint();
		
		uiController.setBack_second(this,199,141);

		init();
	}
	
	private void init(){
		setTextField();
		setForward();
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(550, 308);
		forwardButton = forward.forward_white;
		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}
	
	public void addLabel() {
		failLabel = new MyLabel(275, 320, 200, 35);
		this.add(failLabel);
	}
	private void setTextField() {
		name = new MyTextFieldBorder(275, 245);
		name.setForeground(new ColorFactory().greyFont);
		this.add(name);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			delAccString = name.getText();
			if(delAccString.equals("")){
				failLabel.setText("请正确输入信息!");
			}else{
			delAcc = accountblService.searchAccurateAccount_up(delAccString);
//			delAcc = new AccountVO(delAccString,20);//这个是从下层传回来的要删除的account，通过查找账户
			frame.remove(DelAccountPanel.this);
			if(type.endsWith("account")){
				accountController.confirmAcc(delAcc, "del");
			}else if(type.equals("manager")){
				managerController.confirmAcc(delAcc, "del");
			}
			
			name.setText("");
			}
			frame.repaint();
		}
	}
}
 