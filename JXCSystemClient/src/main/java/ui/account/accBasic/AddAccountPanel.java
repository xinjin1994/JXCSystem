package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;
import vo.initial.InitialCommodityVO;
/**
 * 增加账户，在该类里会判断是否能够添加账户
 * @author ZYC
 * @see ConfirmAccPanel
 */
public class AddAccountPanel extends FatherPanel implements ActionListener{
	AccountAllUIController accountController;
	ManagerAllUIController managerController;
	private String nameString;
	private double balance;
	
	AccountVO newAcc;
	private MyButton forwardButton;
	private MyTextFieldBorder name,price;
	
	private ResultPanelController resController;
	String type = "account";

	public AddAccountPanel(MyFrame frame, String string,
			AccountAllUIController accountAllUIController) {
		super(frame,string,accountAllUIController);
		this.accountController = accountAllUIController;
		this.repaint();
		this.frame = frame;
		accountController.setBack_second(this,199,141);
		resController = new ResultPanelController(frame, this);
		
		init();
	}
	
	
	
	public AddAccountPanel(MyFrame frame,String string,
			ManagerAllUIController managerAllUIController,String type){
		super(frame, string, managerAllUIController);
		this.managerController = managerAllUIController;
		this.repaint();
		this.frame = frame;
		this.type = type;;
		managerController.setBack_second(this, 199, 141);
		resController = new ResultPanelController(frame, this);
		init();
		
	}
	private void init(){
		setTextField();
		setForward();
	}
	
	protected void setForward() {
		ForwardButton forward = new ForwardButton(607, 393);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
		
	}
	protected void setTextField() {
		name = new MyTextFieldBorder(275, 245);
		price = new MyTextFieldBorder(275, 333);
		
		name.setForeground(new ColorFactory().greyFont);
		price.setForeground(new ColorFactory().greyFont);
		
		this.add(name);
		this.add(price);
		
	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			nameString = name.getText();
			String priceString = this.price.getText();
			balance = Double.parseDouble(priceString);
			
			newAcc = new AccountVO(nameString, balance);
//			System.out.println(newAcc.name);
			
			name.setText("");
			price.setText("");
			
			frame.remove(this);
			if(type.equals("account")){
				accountController.confirmAcc(newAcc,"add");//跳转到确认界面（允许添加账户时）
			}else if(type.equals("manager")){
				managerController.confirmAcc(newAcc, "add");
			}
		}
		
	}

}
