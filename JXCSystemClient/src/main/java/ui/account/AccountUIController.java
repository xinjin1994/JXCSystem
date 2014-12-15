package ui.account;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.AccountPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.SecondPanel;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.InvoiceVO;
import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.invoiceblservice.InvoiceblService;

public class AccountUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	private String item,itemName;
	private ColorFactory colors;
	MyTable showTable;
	private SecondPanel accountSecondPanel = new SecondPanel();;
	private AccountPanel accountPanel;
	private MyButton addAcc, delAcc, changeAcc, findAcc;
	private MyButton receipt,paymeent;
	private MyButton salesList,allBills,operatingCondition;
	private MyButton approButton,disapButton;
	private MyButton addComInfo,addCusInfo,addAccInfo,check;
	private InvoiceblService invoiceblService;
	private MyButton []accButtons = new MyButton[]{addAcc, delAcc, changeAcc, findAcc};
	private MyButton []finButtons = new MyButton[]{receipt,paymeent};
	private MyButton []recButtons = new MyButton[]{salesList,allBills,operatingCondition};
	private MyButton []invoiceButtons = new MyButton[]{approButton,disapButton};
	private MyButton []iniButtons = new MyButton[]{addComInfo,addCusInfo,addAccInfo,check};
	ArrayList<InvoiceVO> billsArray = new ArrayList<InvoiceVO>() ;
	private AccountAllUIController uiController;
	private MyFrame frame;
	private ResultPanelController resController;
	
	public AccountUIController(AccountAllUIController uiController,MyFrame frame){
		this.uiController = uiController;
		this.frame = frame;
		this.accountPanel = new AccountPanel(frame, "Image/Account/account_背景.jpg",
				uiController, this);
		invoiceblService = new InvoiceController();
		colors = new ColorFactory();
		frame.setPanel(accountPanel);
		resController = new ResultPanelController(frame,accountPanel);
		uiController.setMainPanel(accountPanel);
	}
	
	public void toAccPanel() {
		accountSecondPanel.removeAll();
		AccButtonListener accListener = new AccButtonListener();
		
		String images_ori_acc[] = new String[]{"Image/Account/button/accManage/addAcc.png",
				"Image/Account/button/accManage/delAcc.png","Image/Account/button/accManage/changeAcc.png",
				"Image/Account/button/accManage/findAcc.png"};
		String images_stop_acc[] = new String[]{"Image/Account/button/accManage/addAcc_stop.png",
				"Image/Account/button/accManage/delAcc_stop.png","Image/Account/button/accManage/changeAcc_stop.png",
				"Image/Account/button/accManage/findAcc_stop.png"};
		String images_press_on_acc[] = new String[]{"Image/Account/button/accManage/addAcc_press_on.png",
				"Image/Account/button/accManage/delAcc_press_on.png","Image/Account/button/accManage/changeAcc_press_on.png",
				"Image/Account/button/accManage/findAcc_press_on.png"};
		
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_acc[i], secondX, secondY+i*inter,
					images_stop_acc[i], images_press_on_acc[i]);
			accountSecondPanel.add(accButtons[i]);
			accButtons[i].addMouseListener(accListener);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
	}
	public void toInvoicePanel() {
		accountSecondPanel.removeAll();
		InvoiceButtonListener invoiceListener = new InvoiceButtonListener();
		
		String images_ori_invoice[] = new String[]{"Image/Account/button/invoiceManage/approve.png",
				"Image/Account/button/invoiceManage/disapp.png"};
		String images_stop_invoice[] = new String[]{"Image/Account/button/invoiceManage/approve_stop.png",
		"Image/Account/button/invoiceManage/disapp_stop.png"};
		String images_press_on_invoice[] = new String[]{"Image/Account/button/invoiceManage/approve_press_on.png",
				"Image/Account/button/invoiceManage/disapp_press_on.png"};
		
		for(int i = 0;i < invoiceButtons.length;i++){
			invoiceButtons[i] = new MyButton(images_ori_invoice[i], secondX, secondY+i*inter,
					images_stop_invoice[i], images_press_on_invoice[i]);
			accountSecondPanel.add(invoiceButtons[i]);
			invoiceButtons[i].addMouseListener(invoiceListener);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
	}
	public void toFinPanel() {
		accountSecondPanel.removeAll();
		FinButtonListener finListener = new FinButtonListener();
		
		String images_ori_fin[] = new String[]{"Image/Account/button/finManage/receipt.png",
		"Image/Account/button/finManage/payment.png"};
		String images_stop_fin[] = new String[]{"Image/Account/button/finManage/receipt_stop.png",
		"Image/Account/button/finManage/payment_stop.png"};
		String images_press_on_fin[] = new String[]{"Image/Account/button/finManage/receipt_press_on.png",
		"Image/Account/button/finManage/payment_press_on.png"};

		for(int i = 0;i < finButtons.length;i++){
			finButtons[i] = new MyButton(images_ori_fin[i], secondX, secondY+i*inter,
					images_stop_fin[i], images_press_on_fin[i]);
			accountSecondPanel.add(finButtons[i]);
			finButtons[i].addMouseListener(finListener);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
		
	}
	public void toRecPanel() {
		accountSecondPanel.removeAll();
		RecButtonListener recListener = new RecButtonListener();
		
		String images_ori_rec[] = new String[]{"Image/Account/button/recManage/salesList.png",
				"Image/Account/button/recManage/allBills.png","Image/Account/button/recManage/opeCon.png"};
		String images_stop_rec[] = new String[]{"Image/Account/button/recManage/salesList_stop.png",
				"Image/Account/button/recManage/allBills_stop.png","Image/Account/button/recManage/opeCon_stop.png"};
		String images_press_on_rec[] = new String[]{"Image/Account/button/recManage/salesList_press_on.png",
				"Image/Account/button/recManage/allBills_press_on.png","Image/Account/button/recManage/opeCon_press_on.png"};
		
		for(int i = 0;i < recButtons.length;i++){
			recButtons[i] = new MyButton(images_ori_rec[i], secondX, secondY+i*inter,
					images_stop_rec[i], images_press_on_rec[i]);
			accountSecondPanel.add(recButtons[i]);
			recButtons[i].addMouseListener(recListener);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
		
	}
	public void toIniPanel() {
		accountSecondPanel.removeAll();
		IniButtonListener iniListener = new IniButtonListener();
		
		String images_ori_ini[] = new String[]{"Image/Account/button/iniManage/comInfo.png",
				"Image/Account/button/iniManage/cusInfo.png","Image/Account/button/iniManage/accInfo.png",
				"Image/Account/button/iniManage/check.png"};
		String images_stop_ini[] = new String[]{"Image/Account/button/iniManage/comInfo_stop.png",
				"Image/Account/button/iniManage/cusInfo_stop.png","Image/Account/button/iniManage/accInfo_stop.png",
				"Image/Account/button/iniManage/check_stop.png"};
		String images_press_on_ini[] = new String[]{"Image/Account/button/iniManage/comInfo_press_on.png",
				"Image/Account/button/iniManage/cusInfo_press_on.png","Image/Account/button/iniManage/accInfo_press_on.png",
			"Image/Account/button/iniManage/check_press_on.png"};
		
		
		for(int i = 0;i < iniButtons.length;i++){
			System.out.println(i);
			iniButtons[i] = new MyButton(images_ori_ini[i], secondX, secondY+i*inter,
					images_stop_ini[i], images_press_on_ini[i]);
			accountSecondPanel.add(iniButtons[i]);
			iniButtons[i].addMouseListener(iniListener);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
		
	}
	
	class AccButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent event) {
		}
		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
			uiController.setMainPanel(accountPanel);
			frame.remove(accountPanel);	
			if(event.getSource() == accButtons[0]){
				uiController.addAccount();
			}else if(event.getSource() == accButtons[1]){
				uiController.delAccount();
			}else if(event.getSource() == accButtons[2]){
				uiController.changeAccount();
			}else if(event.getSource() == accButtons[3]){
				uiController.findAccount();
			}
		}

		public void mouseReleased(MouseEvent event) {
		}
	}
	
	class FinButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
			
		}
		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(accountPanel);
			frame.remove(accountPanel);
			if(e.getSource() == finButtons[0]){
				uiController.addReceipt();
			}else if(e.getSource() == finButtons[1]){
				uiController.addPayment();
			}
		}

		public void mouseReleased(MouseEvent e) {
		}
	}
	
	class RecButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(accountPanel);
			frame.remove(accountPanel);
			if(e.getSource() == recButtons[0]){
				uiController.salesList();
			}else if(e.getSource() == recButtons[1]){
				uiController.allBills();
			}else if(e.getSource() == recButtons[2]){
				uiController.opeCon();
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	private void setTable(ArrayList<String> info){
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
		showTable.setTable(info);
		frame.add(showTable.tablePanel);
//		uiController.addMainPanel();
		frame.repaint();
	}
	class IniButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(accountPanel);
			frame.remove(accountPanel);
		
			if(e.getSource() == iniButtons[0]){
				uiController.iniCom();
			}else if(e.getSource() == iniButtons[1]){
				uiController.iniCus();
			}else if(e.getSource() == iniButtons[2]){
				uiController.iniAcc();
			}else if(e.getSource() == iniButtons[3]){
				
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	class InvoiceButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			String type = "通过";
			if(e.getSource() == invoiceButtons[0]){
				billsArray = invoiceblService.show_pass();
			}else if(e.getSource() == invoiceButtons[1]){
				billsArray = invoiceblService.show_refuse();
				type = "拒绝";
			}

			try {
				ArrayList<String> bills = new ArrayList<String>();
				bills.add("单据编号;单据类型");

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
					item = billsArray.get(i).note+itemName;
					bills.add(item);
					setTable(bills);

				}
			} catch (Exception e2) {
				frame.remove(accountPanel);
				resController.failed("无新审批"+type+"单据！", "account");
			}

		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	
}
