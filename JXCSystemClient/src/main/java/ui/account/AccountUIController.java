package ui.account;

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
	
	private SecondPanel accountSecondPanel;
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
	

	
	public AccountUIController(UIController uiController,MyFrame frame){
		this.accountPanel = new AccountPanel(frame, "Image/Account/account_背景.jpg",
				uiController, this);
		frame.setPanel(accountPanel);
		
	}
	public void toAccPanel() {
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
		
		accountSecondPanel = new SecondPanel();
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_acc[i], secondX, secondY+i*inter,
					images_stop_acc[i], images_press_on_acc[i]);
			accountSecondPanel.add(accButtons[i]);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
	}
	public void toInvoicePanel() {
		String images_ori_invoice[] = new String[]{"Image/Account/button/invoiceManage/approve.png",
				"Image/Account/button/invoiceManage/disapp.png"};
		String images_stop_invoice[] = new String[]{"Image/Account/button/invoiceManage/approve_stop.png",
		"Image/Account/button/invoiceManage/disapp_stop.png"};
		String images_press_on_invoice[] = new String[]{"Image/Account/button/invoiceManage/approve_press_on.png",
				"Image/Account/button/invoiceManage/disapp_press_on.png"};
		
		accountSecondPanel = new SecondPanel();
		for(int i = 0;i < invoiceButtons.length;i++){
			invoiceButtons[i] = new MyButton(images_ori_invoice[i], secondX, secondY+i*inter,
					images_stop_invoice[i], images_press_on_invoice[i]);
			accountSecondPanel.add(accButtons[i]);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
	}
	public void toFinPanel() {
		
		String images_ori_fin[] = new String[]{"Image/Account/button/finManage/receipt.png",
		"Image/Account/button/finManage/payment.png"};
		String images_stop_fin[] = new String[]{"Image/Account/button/finManage/receipt_stop.png",
		"Image/Account/button/finManage/payment_stop.png"};
		String images_press_on_fin[] = new String[]{"Image/Account/button/finManage/receipt_press_on.png",
		"Image/Account/button/finManage/payment_press_on.png"};

		accountSecondPanel = new SecondPanel();
		for(int i = 0;i < invoiceButtons.length;i++){
			invoiceButtons[i] = new MyButton(images_ori_fin[i], secondX, secondY+i*inter,
					images_stop_fin[i], images_press_on_fin[i]);
			accountSecondPanel.add(accButtons[i]);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
		
	}
	public void toRecPanel() {
		String images_ori_rec[] = new String[]{"Image/Account/button/recManage/salesList.png",
				"Image/Account/button/recManage/allBills.png","Image/Account/button/recManage/opeCon.png"};
		String images_stop_rec[] = new String[]{"Image/Account/button/rccManage/salesList_stop.png",
				"Image/Account/button/recManage/allBills_stop.png","Image/Account/button/recManage/opeCon_stop.png"};
		String images_press_on_rec[] = new String[]{"Image/Account/button/recManage/salesList_press_on.png",
				"Image/Account/button/recManage/allBills_press_on.png","Image/Account/button/recManage/opeCon_press_on.png"};
		
		accountSecondPanel = new SecondPanel();
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_rec[i], secondX, secondY+i*inter,
					images_stop_rec[i], images_press_on_rec[i]);
			accountSecondPanel.add(accButtons[i]);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
		
	}
	public void toIniPanel() {
		
		String images_ori_ini[] = new String[]{"Image/Account/button/iniManage/comInfo.png",
				"Image/Account/button/iniManage/cusInfo.png","Image/Account/button/iniManage/accInfo.png",
				"Image/Account/button/iniManage/check"};
		String images_stop_ini[] = new String[]{"Image/Account/button/iniManage/comInfo_stop.png",
				"Image/Account/button/iniManage/cusInfo_stop.png","Image/Account/button/iniManage/accInfo_stop.png",
				"Image/Account/button/iniManage/check_stop"};
		String images_press_on_ini[] = new String[]{"Image/Account/button/iniManage/comInfo_press_on.png",
				"Image/Account/button/iniManage/cusInfo_press_on.png","Image/Account/button/iniManage/accInfo_press_on.png",
				"Image/Account/button/iniManage/check_press_on"};
		
		accountSecondPanel = new SecondPanel();
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_ini[i], secondX, secondY+i*inter,
					images_stop_ini[i], images_press_on_ini[i]);
			accountSecondPanel.add(accButtons[i]);
		}
		accountPanel.add(accountSecondPanel);
		accountPanel.repaint();
		
	}
	
	class AccButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
