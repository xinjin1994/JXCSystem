package ui.account;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import vo.AccountVO;
/**
 * 增加账户，在该类里会判断是否能够添加账户
 * @author ZYC
 * @see ConfirmAccPanel
 */
public class AddAccountPanel extends FatherPanel implements ActionListener{
	AccountAllUIController uiController;
	String nameString;
	double balance;
	
	AccountVO newAcc;
	MyButton forwardButton;
	MyTextFieldBorder name,price;
	public AddAccountPanel(MyFrame frame, String string,
			AccountAllUIController accountAllUIController) {
		super(frame,string,accountAllUIController);
		this.uiController = accountAllUIController;
		this.repaint();
		
		uiController.setBack_second(this,199,141);
		setTextField();
		setForward();
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(607, 393);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
		
	}
	private void setTextField() {
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
			System.out.println(newAcc.name);
			
			name.setText("");
			price.setText("");
			
			frame.remove(this);
			
			uiController.confirmAcc(newAcc,"add");//跳转到确认界面（允许添加账户时）
			
		}
		
	}

}
