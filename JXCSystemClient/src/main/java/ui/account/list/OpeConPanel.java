package ui.account.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTextFieldBorder;
import vo.ConditionVO;
import businesslogic.financialbl.FinancialController;
import businesslogicservice.financialblservice.FinancialblService;

/**
 * 经营情况查询panel 查询结束后返回主界面
 * 
 * @author ZYC
 * 
 */
public class OpeConPanel extends FatherPanel implements ActionListener {

	private static final long serialVersionUID = 5513148056627216583L;
	private AccountAllUIController accountController;
	private ManagerAllUIController managerController;
	FinancialblService financialblService;
	private MyTextFieldBorder timeBegin, timeFinish;
	private MyButton forwardButton;
	private MyFrame frame;
	private String type = "account";

	public OpeConPanel(MyFrame frame, String url, AccountAllUIController uiController) {
		super(frame, url, uiController);
		this.frame = frame;
		this.accountController = uiController;
		this.repaint();
		financialblService = new FinancialController();
		uiController.setBack_second(this, 149, 137);

		init();
	}

	public OpeConPanel(MyFrame frame, String url, ManagerAllUIController uiController, String type) {
		super(frame, url, uiController);
		this.frame = frame;
		this.managerController = uiController;
		this.type = type;
		this.repaint();

		uiController.setBack_second(this, 149, 137);
		init();
	}

	private void init() {
		setTextField();
		setForward();
	}

	private void setForward() {
		ForwardButton forward = new ForwardButton(635, 406);
		forwardButton = forward.forward_white;

		this.add(forwardButton);
		forwardButton.addActionListener(this);
	}

	private void setTextField() {
		timeBegin = new MyTextFieldBorder(297, 231);
		timeFinish = new MyTextFieldBorder(297, 333);

		timeBegin.setForeground(new ColorFactory().greyFont);
		timeFinish.setForeground(new ColorFactory().greyFont);

		this.add(timeBegin);
		this.add(timeFinish);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			String time1 = timeBegin.getText();
			String time2 = timeBegin.getText();
			ConditionVO conditionVO = financialblService.operatingCondition_up(time1, time2);
			frame.remove(this);
			if (type.equals("account")) {
				frame.setPanel(accountController.getMainPanel());
			} else if (type.equals("manager")) {
				frame.setPanel(managerController.getMainPanel());
			}
			frame.repaint();
		}
	}
}
