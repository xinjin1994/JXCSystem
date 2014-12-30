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
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
import vo.SalesDetailVO;
import businesslogic.financialbl.FinancialController;
import businesslogicservice.financialblservice.FinancialblService;
/**
 * 销售明细查询panel
 * 查找结束后返回主界面，列表显示信息
 * @author ZYC
 *
 */
public class SalesListPanel extends FatherPanel implements ActionListener{
	private AccountAllUIController accountController;
	private ManagerAllUIController managerController;
	
	private MyButton forwardButton,excel;
	private MyTable showTable = new MyTable();
	private ColorFactory color = new ColorFactory();
	private MyTextFieldBorder timeBegin,timeFinish,commodity,stock,customer,agent;
	private FinancialblService financialblService;
	private MyFrame frame;
	private String type = "account";
	
	private String failedAddress;
	private ResultPanelController resController;
	
	ArrayList<SalesDetailVO> salesArray;
	public SalesListPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		resController = new ResultPanelController(frame, this);
		this.failedAddress = "acc/recManage/salesList";
		this.accountController = uiController;
		financialblService = new FinancialController();
		this.frame = frame;
		this.repaint();
		
		uiController.setBack_second(this,146,57);
		init();
		
	}
	
	public SalesListPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		resController = new ResultPanelController(frame, this);
		this.failedAddress = "manager/recManage/salesList";
		financialblService = new FinancialController();
		this.type = type;
		this.managerController = uiController;
		this.frame = frame;
		this.repaint();
		
		uiController.setBack_second(this,146,57);
		init();
	}
	
	private void init(){
		setForward();
		setTextField();

	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(677,492);
		forwardButton = forward.forward_white;

		this.add(forwardButton);
		forwardButton.addActionListener(this);

	}
	private void setTextField() {
		timeBegin = new MyTextFieldBorder(293,130);
		timeFinish = new MyTextFieldBorder(293,194);
		commodity = new MyTextFieldBorder(293, 269);
		stock = new MyTextFieldBorder(293,344);
		customer = new MyTextFieldBorder(293, 418);
		agent = new MyTextFieldBorder(293, 495);

		MyTextFieldBorder []typeIn = new MyTextFieldBorder[]{timeBegin,timeFinish,
				commodity,stock,customer,agent};

		for(int i = 0;i < typeIn.length;i++){
			typeIn[i].setForeground(new ColorFactory().greyFont);
			this.add(typeIn[i]);
		}

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
		if(e.getSource() == forwardButton){

			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();
			String good_name = commodity.getText();
			String customer_name = customer.getText();
			String clerk = agent.getText();
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

			if(!(time1.equals(""))&&!(time2.equals("")) ){
				if((new CheckTimeFormat(time1).check() && new CheckTimeFormat(time2).check()) == false ){
					System.out.println("count");
					frame.remove(this);

					resController.failed("时间输入格式错误！请按照“yyyy-mm-dd”格式输入！", failedAddress);
				}
			}

			else{
				ArrayList<String> sales = new ArrayList<String>();
				sales.add("时间;商品名称;型号;数量;单价;总额");
				
					
					frame.remove(this);
					salesArray = financialblService.saleList_up(time1,
							time2, good_name, "", customer_name, clerk, stock.getText());
				
					if(salesArray!= null){
					for(int i=0;i<salesArray.size();i++){
						String salesItem = salesArray.get(i).time+";"+salesArray.get(i).commodityName+";"+salesArray.get(i).type
								+";"+salesArray.get(i).num+";"+salesArray.get(i).unitPrice+";"+salesArray.get(i).total;
						sales.add(salesItem);
						}
					}
				
				if(sales.size() ==1){
					frame.remove(this);
					resController.failed("不存在符合该条件的单据！", failedAddress);
				}else{
					if (type.equals("account")) {
						setTableA(sales);
						
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
						
						
						setTableM(sales);
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

				}

			}
			frame.repaint();
		}
		else if(e.getSource() == excel){
			financialblService.saleListExcel_up(salesArray);
			if (type.equals("account")) {
				resController = new ResultPanelController(frame, accountController.getMainPanel());
				frame.remove(accountController.getMainPanel());
			}else {
				resController = new ResultPanelController(frame, managerController.getMainPanel());
				frame.remove(managerController.getMainPanel());
			}
			
			resController.succeeded("成功导出销售明细表！", type);
		}
	}
}
