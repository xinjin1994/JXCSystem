package ui.account.accBasic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;
import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;

/**
 * 增加账户，在该类里会判断是否能够添加账户
 * 
 * @author ZYC
 * @see ConfirmAccPanel
 */
public class AddAccountPanel extends FatherPanel implements ActionListener {
	AccountAllUIController accountController;
	ManagerAllUIController managerController;
	private String nameString;
	private double balance;
	// private MyLabel failLabel;

	AccountVO newAcc;
	private MyButton forwardButton;
	private MyTextFieldBorder name, price;
	private AccountblService accountblService;
	private ResultPanelController resController;
	String type = "account";
	private String failedAddress;

	public AddAccountPanel(MyFrame frame, String string, AccountAllUIController accountAllUIController) {
		super(frame, string, accountAllUIController);
		this.accountController = accountAllUIController;
		this.repaint();
		this.frame = frame;
		accountController.setBack_second(this, 199, 141);
		resController = new ResultPanelController(frame, this);
		accountblService = new AccountController();
		this.failedAddress = "acc/accManage/addAcc";
		// addLabel();
		init();
	}

	public AddAccountPanel(MyFrame frame, String string, ManagerAllUIController managerAllUIController, String type) {
		super(frame, string, managerAllUIController);
		this.managerController = managerAllUIController;
		this.repaint();
		this.frame = frame;
		this.type = type;
		;
		managerController.setBack_second(this, 199, 141);
		resController = new ResultPanelController(frame, this);
		accountblService = new AccountController();
		this.failedAddress = "manager/accManage/addAcc";
		init();

	}

	private void init() {
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

	// public void addLabel() {
	// failLabel = new MyLabel(275, 420, 200, 35);
	// this.add(failLabel);
	// }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			nameString = name.getText();
			String priceString = price.getText();

			if (nameString.equals("") || priceString.equals("")) {
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
			} else {
				try {
					balance = Double.parseDouble(priceString);
					newAcc = new AccountVO(nameString, balance);
					frame.remove(this);
					if (type.equals("account")) {
						accountController.setTempPanel(this);
						accountController.confirmAcc(newAcc, "add");// 跳转到确认界面（允许添加账户时）

					} else if (type.equals("manager")) {
						managerController.setTempPanel(this);
						managerController.confirmAcc(newAcc, "add");
					}

				} catch (Exception e2) {
					frame.remove(this);
					resController.failed("存在输入错误！", failedAddress);
				}
			}
		}

	}

}
