package ui.account.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
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
	private ColorFactory colors;
	MyTable showTable;
	private MyTextFieldBorder timeBegin, timeFinish;
	private MyButton forwardButton;
	private MyFrame frame;
	private String type = "account";

	private String failedAddress;
	private ResultPanelController resController;
	public OpeConPanel(MyFrame frame, String url, AccountAllUIController uiController) {
		super(frame, url, uiController);
		this.frame = frame;
		resController = new ResultPanelController(frame, this);
		this.accountController = uiController;
		this.failedAddress = "acc/recManage/opeCon";
		this.repaint();
		colors = new ColorFactory();
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
	
	private void setTable(ArrayList<String> info){
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
		showTable.setTable(info);
		frame.remove(this);
		frame.add(showTable.tablePanel);
		accountController.addMainPanel();
		frame.repaint();
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			String time1 = timeBegin.getText();
			String time2 = timeBegin.getText();

			SimpleDateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			boolean isLegal = true;
			try{
				dateFormat.parse(time1);
				isLegal = true;
			}catch(Exception e2){
				isLegal = false;
			}

			if(time1.equals("")||time2.equals("")){
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
			}else if(isLegal == false){
				frame.remove(this);
				resController.failed("时间输入格式错误！请按照“yyyy-mm-dd”格式输入！", failedAddress);
			}
			else{
				ArrayList<ConditionVO> conditionVO= financialblService.operatingCondition_up(time1, time2);
				ArrayList<String> info = new ArrayList<String>();
				info.add("单据编号;銷售收入;商品类收入;折扣;销售成本;商品类支出;利润");
				for(int i=0;i<conditionVO.size();i++){
					info.add(conditionVO.get(i).getProfit()+"");
				}
				if(info.size() == 1){
					frame.remove(this);
					resController.failed("不存在符合该条件的单据！", failedAddress);
				}else{
					setTable(info);
				}
				if (type.equals("account")) {
					//				frame.setPanel(accountController.getMainPanel());
				} else if (type.equals("manager")) {
					//				frame.setPanel(managerController.getMainPanel());
				}
			}
		}
	}
}
