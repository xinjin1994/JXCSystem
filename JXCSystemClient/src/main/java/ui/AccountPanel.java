package ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import businesslogic.accountbl.AccountController;
import businesslogic.financialbl.FinancialController;
import businesslogic.invoicebl.InvoiceController;
import businesslogic.systemlogbl.SystemlogController;
import businesslogic.userbl.User;
import businesslogicservice.accountblservice.AccountblService;
import businesslogicservice.financialblservice.FinancialblService;
import businesslogicservice.invoiceblservice.InvoiceblService;
import businesslogicservice.systemlogblservice.SystemlogblService;
import ui.account.AccountUIController;
import ui.account.list.AllBillsPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.SaveTempBills;
import ui.setting.ThirdPanel;
import ui.setting.Button.ApproveButton;
import ui.setting.Button.ExcelButton;
import ui.setting.Button.MyButton;
import ui.setting.Button.RefreshButton;
import ui.setting.Button.RefuseButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.AccountVO;
import vo.ConditionVO;
import vo.SalesDetailVO;
import vo.SystemlogVO;
import vo.bill.AllBillVO;
import vo.bill.GetVO;
import vo.bill.InvoiceVO;
import vo.bill.PayVO;

//财务经理
public class AccountPanel extends FatherPanel{

	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	public ThirdPanel accountThirdPanel;
	MyButton accManage,finManage,recManage,invoiceManage,iniManage,saveCheck,systemLog;
	private MyButton [] buttons = new MyButton[]{ accManage, finManage, recManage,invoiceManage,saveCheck,systemLog};
	private MyButton refresh,output;
	private MyFrame frame;
	
	private MyTable showTable; 
	private ColorFactory colors = new ColorFactory();
	private AccountUIController accountUIController;
	
	private String images_ori[] = new String[]{"Image/Account/button/accManage.png",
			"Image/Account/button/finManage.png","Image/Account/button/recManage.png",
			"Image/Account/button/invoiceManage.png","Image/Account/button/saveCheck.png",
			"Image/Account/button/systemLog.png"};
	private String images_stop[] = new String[]{"Image/Account/button/accManage_stop.png",
			"Image/Account/button/finManage_stop.png","Image/Account/button/recManage_stop.png",
			"Image/Account/button/invoiceManage_stop.png","Image/Account/button/saveCheck_stop.png",
			"Image/Account/button/systemLog_stop.png"};
	private String images_press_on[] = new String[]{"Image/Account/button/accManage_press_on.png",
			"Image/Account/button/finManage_press_on.png","Image/Account/button/recManage_press_on.png",
			"Image/Account/button/invoiceManage_press_on.png",	"Image/Account/button/saveCheck_press_on.png",
			"Image/Account/button/systemLog_press_on.png"};
	
	private RefuseButton refuse;
	private ApproveButton approve;
	private InvoiceblService invoiceblService;
	private AccountblService accountblService;
	private FinancialblService financialblService;
	
	private ResultPanelController resController;
	private String failedAddress;
	
	private SystemlogblService systemlogblService;
	private SaveTempBills bills;
	
	private ArrayList<PayVO> payDraft = new ArrayList<PayVO>();
	private ArrayList<GetVO> getDraft = new ArrayList<GetVO>();
	
	public AccountPanel(MyFrame frame, String url, UIController controller,
			AccountUIController accountUIController) {
		super(frame, url, controller);
		accountThirdPanel = new ThirdPanel();
		this.add(accountThirdPanel);
		
		this.failedAddress = "account";
		this.frame = frame;
		this.accountUIController= accountUIController;
		
		refuse = new RefuseButton(this);
		approve = new ApproveButton(this);
		invoiceblService = new InvoiceController();
		accountblService = new AccountController();
		financialblService = new FinancialController();
		systemlogblService = new SystemlogController();
		this.addButton();
		
		}

	public void addButton() {
		refuse.setLable();
		approve.setLable();
		FirstButtonListener listener = new FirstButtonListener();
		for(int i = 0 ;i < buttons.length;i++){
			buttons[i] = new MyButton(images_ori[i], firstX, firstY +i * inter,
					images_stop[i], images_press_on[i]);
			this.add(buttons[i]);
			buttons[i].addMouseListener(listener);
		}
		
		refresh = new RefreshButton(this).refreshButton;
		this.add(refresh);
		refresh.addMouseListener(listener);

	}
	/**
	 * 该方法用于显示table
	 * @param info 要显示的数据
	 */
	public void setTable(ArrayList<String> info,String type){
		accountThirdPanel.removeAll();
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
//		System.out.println(info.get(1));
		showTable.setTable(info);
//		if(type.equals("acc")){
			showTable.table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		}else if (type.equals("log")) {
//			showTable.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		}
		accountThirdPanel.add(showTable.tablePanel);
		accountThirdPanel.repaint();
		this.repaint();
	}
	
	public void setTable(ArrayList<String> info,SaveTempBills bills) {
		this.bills = bills;
		accountThirdPanel.removeAll();
		showTable = new MyTable();
		showTable.setInfo(bills);
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
//		showTable.setColor(colors.manTableColor,colors.manBkColor, colors.manColor,Color.white);
		showTable.setTable(info);
		showTable.table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		accountThirdPanel.add(showTable.tablePanel);
		accountThirdPanel.repaint();
		this.repaint();
	}
	
	public void setExcelButtonAllBill(ArrayList<AllBillVO> all){
		ExcelButton excelButton = new ExcelButton(accountThirdPanel, all);
		accountThirdPanel.repaint();
	}
	
	public void setExcelButtonSaleList(ArrayList<SalesDetailVO> salesDetailVOs){
		ExcelButton excelButton = new ExcelButton(accountThirdPanel, salesDetailVOs,0);
		accountThirdPanel.repaint();
	}
	public void setExcelButtonOpeCon(ArrayList<ConditionVO> conditionVOs){
		ExcelButton excelButton = new ExcelButton(accountThirdPanel, conditionVOs,"");
		accountThirdPanel.repaint();
	}
	
	
	
	/**
	 * 该方法用于从下曾获得被审批的单据数据
	 */
//	private void getInvoiceInfo() {
//		ArrayList <String> info = new ArrayList<String>();
//		info.add("a;b;c;e");
//		info.add("s,r,t,h");
//		info.add("w;t;x;h");
//		info.add("gg");
//		setTable(info);
//	}
	/**
	 * 该方法用于获得当前期初的信息
	 */
	private void getInitialInfo() {
		
	}
	/**
	 * 查看表单最初的表格应该显示什么呢？？？不造啊T-T
	 */
	private void getReceiptInfo() {
		
	}
	/**
	 * 该方法用于获得收款单和付款单的信息，按时间排序
	 */
	public void getFinanceInfo() {
		ArrayList <String> info = new ArrayList<String>();
		info.add("时间;单据编号;单据类型");
		
		ArrayList<PayVO> payments = new ArrayList<PayVO>();
		ArrayList<GetVO> receipts = new ArrayList<GetVO>();
		ArrayList<InvoiceVO> finBills = new ArrayList<InvoiceVO>();
		
		
		payments = accountblService.getAllPayment_up();
		receipts = accountblService.getAllReceipt_up();
		
		try {
			for(PayVO temp:payments){
				finBills.add(temp);
//				info.add(temp.time+";"+temp.note+";"+checkBill(temp.bill_note));
			}
			for(GetVO temp: receipts){
				finBills.add(temp);
//				info.add(temp.time+";"+temp.note+";"+checkBill(temp.bill_note));
			}
			
			for(InvoiceVO temp:finBills){
				info.add(temp.time+";"+temp.note+";"+checkBill(temp.bill_note));
			}
			SaveTempBills bills = new SaveTempBills(frame, finBills,accountUIController );
			
			setTable(info, bills);
		} catch (Exception e) {
			setTable(info, "");
			e.printStackTrace();
		}
		
	}
	private String checkBill(int bill_node) {
		String type = "";
		switch (bill_node) {
		case 7:
			type = "收款单";
			break;

		case 8:
			type = "付款单";
			break;
		}
		return type;
	}

	/**
	 * 该方法用于显示当前所有账户的信息，该方法要根据登陆人员的身份判断能否选择
	 */
	
	public void getAccountInfo() {
		ArrayList <String> info = new ArrayList<String>();
		info.add("账户名称;账户余额");
		ArrayList<AccountVO> accounts = new ArrayList<AccountVO>();
		accounts = accountblService.getAllAccount_up();
		try {
			for(AccountVO temp:accounts){
				info.add(temp.name+";"+temp.balance);
			}
			setTable(info,"acc");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getDraftInfo() {
		payDraft = accountblService.getAllDraftPayment_up();
		getDraft = accountblService.getAllDraftReceipt_up();
		
		ArrayList <String> info = new ArrayList<String>();
		info.add("时间;单据编号;单据类型");

		ArrayList<InvoiceVO> finBills = new ArrayList<InvoiceVO>();

		
		try {
			for(PayVO temp:payDraft){
				finBills.add(temp);
//				info.add(temp.time+";"+temp.note+";"+checkBill(temp.bill_note));
			}
			for(GetVO temp: getDraft){
				finBills.add(temp);
//				info.add(temp.time+";"+temp.note+";"+checkBill(temp.bill_note));
			}
			
			for(InvoiceVO temp:finBills){
				info.add(temp.time+";"+temp.note+";"+checkBill(temp.bill_note));
			}
			SaveTempBills bills = new SaveTempBills(frame, finBills,accountUIController );
			
			setTable(info, bills);
		} catch (Exception e) {
			setTable(info, "");
			
			frame.remove(this);
			resController = new ResultPanelController(frame, this);
			resController.failed("无新草稿单据！","account");
			frame.repaint();
			e.printStackTrace();
		}
			
	}

	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			
			if (e.getSource() == refresh){
				if(invoiceblService.show_pass() != null){
					approve.setButton();
					AccountPanel.this.repaint();
				}else if(invoiceblService.show_refuse() != null){
					refuse.setButton();
					AccountPanel.this.repaint();
				}
			}
		
			else if(e.getSource() == buttons[0]){
				if (User.duty!= 5) {
					System.out.println("here");
					resController = new ResultPanelController(frame, AccountPanel.this);
					frame.remove(AccountPanel.this);
					resController.failed("您没有账户管理的权限！", failedAddress);
					frame.repaint();
				}else {
					getAccountInfo();
				}

			}else if(e.getSource() == buttons[1]){
				getFinanceInfo();
			}else if(e.getSource() == buttons[2]){
				getReceiptInfo();
			}else if(e.getSource() == buttons[3]){
				//				getInvoiceInfo();
			}else if(e.getSource() == buttons[4]){
				getDraftInfo();
			}

		
				
			else if (e.getSource() == buttons[5]) {
				ArrayList<String> infos = new ArrayList<String>();
				infos.add("操作时间;操作员;操作内容");
				ArrayList<SystemlogVO> logs = new ArrayList<SystemlogVO>();
				logs = systemlogblService.show_up();
					
				System.out.println("logs"+logs.size());
				try {
					for(SystemlogVO temp:logs){
						infos.add(temp.time+";"+temp.operation+";"+temp.word);
					}
					setTable(infos,"log");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	
		

		public void mouseReleased(MouseEvent e) {
	
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				accountUIController.toAccPanel();
			}else if(e.getSource() == buttons[1]) {
				accountUIController.toFinPanel();
			}else if(e.getSource() == buttons[2]) {
				accountUIController.toRecPanel();
			}else if (e.getSource() == buttons[3]) {
				accountUIController.toInvoicePanel();
			}else if (e.getSource() == buttons[4]) {
				accountUIController.toSavePanel();
			}
		}
		public void mouseExited(MouseEvent e) {
		
		}
		
	}
}
