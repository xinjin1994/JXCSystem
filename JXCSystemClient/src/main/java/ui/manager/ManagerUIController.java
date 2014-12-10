package ui.manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.ManagerPanel;
import ui.UIController;
import ui.account.AccountAllUIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.SecondPanel;

public class ManagerUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	
	private SecondPanel managerSecondPanel = new SecondPanel();
	private ManagerPanel managerPanel;
	
	private MyButton addAcc, delAcc, changeAcc, findAcc;
	private MyButton salesList,allBills,operatingCondition;
	private MyButton approButton,disapButton,backLogButton;
	private MyButton chePro,decPro;
	 
	private MyButton []accButtons = new MyButton[]{addAcc, delAcc, changeAcc, findAcc};
	private MyButton []recButtons = new MyButton[]{salesList,allBills,operatingCondition};
	private MyButton []invoiceButtons = new MyButton[]{approButton,disapButton,backLogButton};
	private MyButton []proButtons = new MyButton[]{chePro,decPro};
	
	private ManagerAllUIController uiController;
	private MyFrame frame;
	
	public ManagerUIController(ManagerAllUIController uiController,MyFrame frame){
		this.uiController = uiController;
		this.frame = frame;
		this.managerPanel = new ManagerPanel(frame, "Image/Manager/manager.jpg",
				uiController, this);
		
		frame.setPanel(managerPanel);
		
		uiController.setMainPanel(managerPanel);
		
	}
	public void toAccPanel() {
		managerSecondPanel.removeAll();
		AccButtonListener accListener = new AccButtonListener();
		String images_ori_acc[] = new String[]{"Image/Manager/button/accManage/accAdd.png",
				"Image/Manager/button/accManage/accDel.png","Image/Manager/button/accManage/accChange.png",
				"Image/Manager/button/accManage/accFind.png"};
		String images_stop_acc[] = new String[]{"Image/Manager/button/accManage/accAdd_stop.png",
				"Image/Manager/button/accManage/accDel_stop.png","Image/Manager/button/accManage/accChange_stop.png",
				"Image/Manager/button/accManage/accFind_stop.png"};
		String images_press_on_acc[] = new String[]{"Image/Manager/button/accManage/accAdd_press_on.png",
				"Image/Manager/button/accManage/accDel_press_on.png","Image/Manager/button/accManage/accChange_press_on.png",
				"Image/Manager/button/accManage/accFind_press_on.png"};
		
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_acc[i], secondX, secondY+i*inter,
					images_stop_acc[i], images_press_on_acc[i]);
			managerSecondPanel.add(accButtons[i]);
			accButtons[i].addMouseListener(accListener);
		}
		managerPanel.add(managerSecondPanel);
		managerPanel.repaint();
	}
	public void toInvoicePanel() {
		managerSecondPanel.removeAll();
		InvoiceButtonListener invoiceListener = new InvoiceButtonListener();
		
		String images_ori_invoice[] = new String[]{"Image/Manager/button/invoiceManage/appro.png",
		           "Image/Manager/button/invoiceManage/disapp.png","Image/Manager/button/invoiceManage/backLogRec.png"};
		String images_stop_invoice[] = new String[]{"Image/Manager/button/invoiceManage/appro_stop.png",
		           "Image/Manager/button/invoiceManage/disapp_stop.png","Image/Manager/button/invoiceManage/backLogRec_stop.png"};
		String images_press_on_invoice[] = new String[]{"Image/Manager/button/invoiceManage/appro_press_on.png",
	               "Image/Manager/button/invoiceManage/disapp_press_on.png","Image/Manager/button/invoiceManage/backLogRec_press_on.png"};
		
		for(int i = 0;i < invoiceButtons.length;i++){
			invoiceButtons[i] = new MyButton(images_ori_invoice[i], secondX, secondY+i*inter,
					images_stop_invoice[i], images_press_on_invoice[i]);
			managerSecondPanel.add(invoiceButtons[i]);
			invoiceButtons[i].addMouseListener(invoiceListener);
		}
		managerPanel.add(managerSecondPanel);
		managerPanel.repaint();
	}
	
	public void toRecPanel() {
		RecButtonListener recListener = new RecButtonListener();
		managerSecondPanel.removeAll();
		
		String images_ori_rec[] = new String[]{"Image/Manager/button/recManage/salesList.png",
				"Image/Manager/button/recManage/allBills.png","Image/Manager/button/recManage/opeCon.png"};
		String images_stop_rec[] = new String[]{"Image/Manager/button/recManage/salesList_stop.png",
				"Image/Manager/button/recManage/allBills_stop.png","Image/Manager/button/recManage/opeCon_stop.png"};
		String images_press_on_rec[] = new String[]{"Image/Manager/button/recManage/salesList_press_on.png",
				"Image/Manager/button/recManage/allBills_press_on.png","Image/Manager/button/recManage/opeCon_press_on.png"};
		
		for(int i = 0;i < recButtons.length;i++){
			recButtons[i] = new MyButton(images_ori_rec[i], secondX, secondY+i*inter,
					images_stop_rec[i], images_press_on_rec[i]);
			managerSecondPanel.add(recButtons[i]);
			recButtons[i].addMouseListener(recListener);
		}
		managerPanel.add(managerSecondPanel);
		
		managerPanel.repaint();
		
	}
	public void toProPanel() {
		managerSecondPanel.removeAll();
		ProButtonListener proListener = new ProButtonListener();
		
		String images_ori_pro[] = new String[]{"Image/Manager/button/proManage/chePro.png",
		        "Image/Manager/button/proManage/decPro.png"};
		String images_stop_pro[] = new String[]{"Image/Manager/button/proManage/chePro_stop.png",
				"Image/Manager/button/proManage/decPro_stop.png"};
		String images_press_on_pro[] = new String[]{"Imaege/Manager/button/proManage/chePro_press_on.png",
				"Image/Manager/button/proManager/decPro_press_on.png"};
		
		for(int i = 0;i < proButtons.length;i++){
			proButtons[i] = new MyButton(images_ori_pro[i], secondX, secondY+i*inter,
					images_stop_pro[i], images_press_on_pro[i]);
			managerSecondPanel.add(proButtons[i]);
			proButtons[i].addMouseListener(proListener);
		}
		managerPanel.add(managerSecondPanel);
		managerPanel.repaint();
		
	}
	class ProButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent event) {
			frame.remove(managerPanel);
			if(event.getSource() == proButtons[0]){
				
			}else if (event.getSource() == proButtons[1]) {
				uiController.setPro();
			}
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
			frame.remove(managerPanel);
			System.out.println("lka");
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
	
	class AccButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent event) {
		}
		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}

		public void mousePressed(MouseEvent event) {
			frame.remove(managerPanel);	
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
