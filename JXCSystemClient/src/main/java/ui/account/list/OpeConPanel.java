package ui.account.list;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ui.AccountPanel;
import ui.FatherPanel;
import ui.ManagerPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.CheckTimeFormat;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.SetTable;
import ui.setting.Button.ExcelButton;
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
	private ColorFactory color = new ColorFactory();
	private MyTable showTable = new MyTable();
	
	private MyTextFieldBorder timeBegin, timeFinish;
	private MyButton forwardButton,excel;
	private MyFrame frame;
	private String type = "account";

	private String failedAddress;
	private ResultPanelController resController;
	
	ArrayList<ConditionVO> conditionVO;
	public OpeConPanel(MyFrame frame, String url, AccountAllUIController uiController) {
		super(frame, url, uiController);
		this.frame = frame;
		resController = new ResultPanelController(frame, this);
		this.accountController = uiController;
		this.failedAddress = "acc/recManage/opeCon";
		this.repaint();
		financialblService = new FinancialController();
		uiController.setBack_second(this, 149, 137);
		init();
	}

	public OpeConPanel(MyFrame frame, String url, ManagerAllUIController uiController, String type) {
		super(frame, url, uiController);
		this.frame = frame;
		resController = new ResultPanelController(frame, this);
		this.managerController = uiController;
		this.type = type;
		this.failedAddress = "manager/recManage/opeCon";
		this.repaint();
		
		financialblService = new FinancialController();
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

	private void setTableA(ArrayList<String> info){
		showTable.setColor(color.accTableColor,color.greyFont,color.accColor,color.greyFont);
		showTable.setTable(info);
		new SetTable(showTable, frame, accountController);
	}

	private void setTableM(ArrayList<String> info){
		showTable.setColor(color.manTableColor,color.manBkColor, color.manColor,Color.white);
		showTable.setTable(info);
		new SetTable(showTable, frame, managerController);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == forwardButton) {
			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();

//			SimpleDateFormat dateFormat = null;
//			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			dateFormat.setLenient(false);
//			boolean isLegal = true;
//			try{
//				dateFormat.parse(time1);
//				isLegal = true;
//			}catch(Exception e2){
//				isLegal = false;
//			}
			if(time1.equals("")||time2.equals("")){
				frame.remove(this);
				resController.failed("存在输入为空！", failedAddress);
			}else if(!(time1.equals(""))&&!(time2.equals("")) ){
				if((new CheckTimeFormat(time1).check() && new CheckTimeFormat(time2).check()) == false ){
					System.out.println("count");
					frame.remove(this);

					resController.failed("时间输入格式错误！请按照“yyyy-mm-dd”格式输入！", failedAddress);
				}
			}
			else{
				conditionVO= financialblService.operatingCondition_up(time1, time2);
				ArrayList<String> info = new ArrayList<String>();
				info.add("单据编号;銷售收入;商品类收入;折扣;销售成本;商品类支出;利润");
				for(int i=0;i<conditionVO.size();i++){
					info.add(conditionVO.get(i).getProfit()+"");
				}
//				if(info.size() == 1){
//					frame.remove(this);
//					resController.failed("不存在符合该条件的单据！", failedAddress);
//				}else{
				frame.remove(this);
					if (type.equals("account")) {
						setTableA(info);
						
						AccountPanel accountPanel = (AccountPanel)(accountController.getMainPanel());
						
						excel = new MyButton("Image/output.png", 350, 450, "Image/output_stop.png", "Image/output_stop.png");	
						accountPanel.accountThirdPanel.add(excel);
						excel.addActionListener(this);
						accountPanel.accountThirdPanel.repaint();
						this.repaint();
						accountController.setMainPanel(accountPanel);
						
						frame.setPanel(accountPanel);
						
						frame.repaint();
					} else if (type.equals("manager")) {
						
						
						setTableM(info);
						ManagerPanel managerPanel = (ManagerPanel)(managerController.getMainPanel());
						
						excel = new MyButton("Image/output.png", 350, 450, "Image/output_stop.png", "Image/output_stop.png");	
						managerPanel.managerThirdPanel.add(excel);
						excel.addActionListener(this);
						managerPanel.managerThirdPanel.repaint();
						this.repaint();
						managerController.setMainPanel(managerPanel);
						
						frame.setPanel(managerPanel);
						
						frame.repaint();
					}
//				}
			}
			frame.repaint();
		}
		else if (e.getSource() == excel) {
			financialblService.operatingConditionExcel_up(conditionVO);
			if (type.equals("account")) {
				resController = new ResultPanelController(frame, accountController.getMainPanel());
				frame.remove(accountController.getMainPanel());
			}else {
				resController = new ResultPanelController(frame, managerController.getMainPanel());
				frame.remove(managerController.getMainPanel());
			}
			
			resController.succeeded("成功导出经营情况表！", type);
		}
	}
}
