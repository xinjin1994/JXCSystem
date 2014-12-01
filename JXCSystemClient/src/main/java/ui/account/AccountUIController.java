package ui.account;

import java.awt.Event;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.AccountPanel;
import ui.MyButton;
import ui.MyFrame;
import ui.UIController;
import ui.sales.SecondPanel;

public class AccountUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	
	
	private SecondPanel accountSecondPanel = new SecondPanel();;
	private AccountPanel accountPanel;
	private MyButton addAcc, delAcc, changeAcc, findAcc;
	private MyButton receipt,paymeent;
	private MyButton salesList,allBills,operatingCondition;
	private MyButton approButton,disapButton;
	private MyButton addComInfo,addCusInfo,addAccInfo,check;
	 
	private MyButton []accButtons = new MyButton[]{addAcc, delAcc, changeAcc, findAcc};
	private MyButton []finButtons = new MyButton[]{receipt,paymeent};
	private MyButton []recButtons = new MyButton[]{salesList,allBills,operatingCondition};
	private MyButton []invoiceButtons = new MyButton[]{approButton,disapButton};
	private MyButton []iniButtons = new MyButton[]{addComInfo,addCusInfo,addAccInfo,check};
	
	private AccountAllUIController uiController;
	private MyFrame frame;
	
	public AccountUIController(AccountAllUIController uiController,MyFrame frame){
		this.uiController = uiController;
		this.frame = frame;
		this.accountPanel = new AccountPanel(frame, "Image/Account/account_背景.jpg",
				uiController, this);
		frame.setPanel(accountPanel);
		
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
	
	class IniButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
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
			if(e.getSource() == invoiceButtons[0]){
				
			}else if(e.getSource() == invoiceButtons[1]){
				
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	
}
