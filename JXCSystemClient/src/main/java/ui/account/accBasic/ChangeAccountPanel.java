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
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;
import businesslogic.accountbl.AccountController;
import businesslogicservice.accountblservice.AccountblService;

/**
 * 
 * @author ZYC
 * 
 */
public class ChangeAccountPanel extends FatherPanel implements ActionListener {
	ManagerAllUIController managerController;
	AccountAllUIController accountController;
	AccountblService accountblService;
	private MyButton forwardButton;
	AccountVO acc, newAcc;
	private MyLabel failLabel;
	private MyTextFieldBorder formerName, changeName;

	private String type = "account";
	private String failedAddress;
	private ResultPanelController resController;
	public ChangeAccountPanel(MyFrame frame, String url, AccountAllUIController uiController) {
		super(frame, url, uiController);
		this.accountController = uiController;
		this.repaint();
		accountblService = new AccountController();
		uiController.setBack_second(this, 199, 141);
		resController = new ResultPanelController(frame, this);
		this.failedAddress = "acc/accManage/chaAcc";
		init();
	}

	public ChangeAccountPanel(MyFrame frame, String url, ManagerAllUIController uiController, String type) {
		super(frame, url, uiController);
		this.managerController = uiController;
		this.repaint();
		this.type = type;
		accountblService = new AccountController();
		uiController.setBack_second(this, 199, 141);
		resController = new ResultPanelController(frame, this);
		this.failedAddress = "manager/accManage/chaAcc";
		init();
	}

	private void init() {
		setTextField();
		setForward();
	}

	private void setTextField() {
		formerName = new MyTextFieldBorder(275, 244);
		changeName = new MyTextFieldBorder(275, 333);

		formerName.setForeground(new ColorFactory().greyFont);
		changeName.setForeground(new ColorFactory().greyFont);

		this.add(formerName);
		this.add(changeName);
	}

	

	private void setForward() {
		ForwardButton forward = new ForwardButton(606, 394);
		forwardButton = forward.forward_white;

		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			if (formerName.getText().equals("") || changeName.getText().equals("")) {
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
			} else {
				frame.remove(this);

				// 这里根据原有account从下层传回余额
				acc = accountblService.searchAccurateAccount_up(formerName.getText());
				newAcc = new AccountVO(changeName.getText(), acc.balance);
				// acc = new AccountVO(changeName.getText(),0);
				if (type.equals("account")) {
					accountController.setTempPanel(this);
					accountController.confirmAcc(acc, "change", newAcc);
				} else if (type.equals("manager")) {
					managerController.setTempPanel(this);
					managerController.confirmAcc(acc, "change", newAcc);
				}
			}
			frame.repaint();
		}
	}
}
