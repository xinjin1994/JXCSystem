package ui.account.list;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ui.AccountPanel;
import ui.FatherPanel;
import ui.ManagerPanel;
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.CheckTimeFormat;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.SaveTempBills;
import ui.setting.SetTable;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.AllBillVO;
import vo.bill.InvoiceVO;
import businesslogic.financialbl.FinancialController;
import businesslogicservice.financialblservice.FinancialblService;
/**
 * 查询经营历程对话框
 * 查找结束后返回主界面列表显示
 * @author ZYC
 * 
 */
public class AllBillsPanel extends FatherPanel implements ActionListener{
	private static final ArrayList<String> sales = null;
	private AccountAllUIController accountController;
	private ManagerAllUIController managerController;
	FinancialblService financialblService;
	private ColorFactory color = new ColorFactory();
	MyTable showTable = new MyTable();
	private MyButton forwardButton,excel;
	private MyTextFieldBorder timeBegin,timeFinish,stock,billType,customer,agent;
	private String itemName,item;
	private String type = "account";
	private MyFrame frame;

	private String failedAddress;
	private ResultPanelController resController;
	ArrayList<AllBillVO> billsArray;
	ArrayList<InvoiceVO> billIn;
	public AllBillsPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		financialblService = new FinancialController();
		resController = new ResultPanelController(frame, this);
		this.accountController = uiController;
		this.frame = frame;
		this.failedAddress = "acc/recManage/allBills";
		this.repaint();
		uiController.setBack_second(this,141,57);
		init();

	}
	
	public AllBillsPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		financialblService = new FinancialController();
		resController = new ResultPanelController(frame, this);
		this.managerController = uiController;
		this.frame = frame;
		this.type = type;
		this.failedAddress = "manager/recManage/allBills";
		this.repaint();
		
		uiController.setBack_second(this,141,57);
		init();
	}
	
	private void init(){
		setTextField();
		setForward();
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
		billType = new MyTextFieldBorder(293, 269);
		stock = new MyTextFieldBorder(293,344);
		customer = new MyTextFieldBorder(293, 418);
		agent = new MyTextFieldBorder(293, 495);
	
		MyTextFieldBorder []typeIn = new MyTextFieldBorder[]{timeBegin,timeFinish,
				billType,stock,customer,agent};
		
		for(int i = 0;i < typeIn.length;i++){
			typeIn[i].setForeground(new ColorFactory().greyFont);
			this.add(typeIn[i]);
		}
	}
	private void setTableM(ArrayList<String> info){
		SaveTempBills bills = new SaveTempBills(frame, billIn, managerController);
		ManagerPanel temp = (ManagerPanel)(managerController.getMainPanel());
		temp.setTable(info, bills);
		frame.setPanel(temp);
		frame.repaint();
		managerController.setMainPanel(temp);
	}
	
	private void setTableA(ArrayList<String> info){
		
		SaveTempBills bills = new SaveTempBills(frame, billIn, accountController);
		AccountPanel temp = (AccountPanel)(accountController.getMainPanel());
		temp.setTable(info, bills);
		frame.setPanel(temp);
		frame.repaint();
		accountController.setMainPanel(temp);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();
			String note_type = billType.getText();
			String customer_name = customer.getText();
			String clerk = agent.getText();
//
//			SimpleDateFormat dateFormat = null;
//			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			dateFormat.setLenient(false);
//			boolean isLegal = true;
//			try{
//				dateFormat.parse(time1);
//				isLegal = true;
//			}catch(Exception e2){
//				isLegal = false;
//						}
			
			if(!(time1.equals(""))&&!(time2.equals("")) ){
				if((new CheckTimeFormat(time1).check() && new CheckTimeFormat(time2).check()) == false ){
					frame.remove(this);
					resController.failed("时间输入格式错误！请按照“yyyy-mm-dd”格式输入！", failedAddress);
				}
			}
			else{
				ArrayList<String> bills = new ArrayList<String>();
				try{
					String warehouse = stock.getText();
					
					billsArray = financialblService.allBill_up(time1, time2, note_type, 
							customer_name, clerk, warehouse);

					bills.add("时间;单据编号;单据类型");
					for(int i=0;i<billsArray.size();i++){
						switch(billsArray.get(i).bill_note) {
						//1代表SendGiftVO，                  2代表ImportVO，  3代表Import_ReturnVO， 4代表ExportVO，
						//5代表Export_ReturnVO， 6代表PatchVO，     7代表ReceiptVO，                      8代表PaymentVO
						case 1:
							itemName = "商品赠送单";
							break;
						case 2:
							itemName = "进货单";
							break;
						case 3:
							itemName = "进货退货单";
							break;
						case 4:
							itemName = "销售单";
							break;
						case 5:
							itemName = "销售退货单";
							break;
						case 6:
							itemName = "报溢报损单";
							break;
						case 7:
							itemName = "收款单";
							break;
						case 8:
							itemName = "付款单";
							break;	
						}
						item = billsArray.get(i).time+";"+billsArray.get(i).note+";"+itemName;
						bills.add(item);
						billIn.add((InvoiceVO)(billsArray.get(i)));
					}}catch(Exception e2){
						System.out.println(bills.get(0));
						e2.printStackTrace();
						frame.remove(this);
						resController.failed("存在输入错误！", failedAddress);
					}
				
				if(bills.size() == 1){
					frame.remove(this);
					resController.failed("不存在符合该条件的单据！", failedAddress);
				}else{

					frame.remove(this);
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
				frame.repaint();
			}

		}else if (e.getSource() == excel) {
			financialblService.allBillExcel_up(billsArray);
			if (type.equals("account")) {
				resController = new ResultPanelController(frame, accountController.getMainPanel());
				frame.remove(accountController.getMainPanel());
			}else {
				resController = new ResultPanelController(frame, managerController.getMainPanel());
				frame.remove(managerController.getMainPanel());
			}
			
			resController.succeeded("成功导出经营历程表！", type);
		}
	}
}

