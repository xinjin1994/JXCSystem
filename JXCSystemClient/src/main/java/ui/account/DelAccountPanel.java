package ui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;












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
 * 删除账户，该类不直接删除账户
 * @author ZYC
 * @see ConfirmAccPanel
 */
public class DelAccountPanel extends FatherPanel implements ActionListener{
	AccountAllUIController accountController;
	ManagerAllUIController managerController;
	
	private MyTextFieldBorder name;
	private MyButton forwardButton;
	private String delAccString;
	AccountVO delAcc;
	
	private String type = "account";
	public DelAccountPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.accountController = uiController;
		this.repaint();
		
		uiController.setBack_second(this,199,141);
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
	
	private void setTextField() {
		name = new MyTextFieldBorder(275, 245);
		name.setForeground(new ColorFactory().greyFont);
		this.add(name);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			delAccString = name.getText();
			delAcc = new AccountVO(delAccString,20);//这个是从下层传回来的要删除的account，通过查找账户
			frame.remove(DelAccountPanel.this);
			if(type.endsWith("account")){
				accountController.confirmAcc(delAcc, "del");
			}else if(type.equals("manager")){
				managerController.confirmAcc(delAcc, "del");
			}
			
			name.setText("");
		}
	}
}
 