package ui.manager;

import ui.ManagerPanel;
import ui.UIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.SecondPanel;

public class ManagerUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	
	private SecondPanel managerSecondPanel;
	private ManagerPanel managerPanel;
	
	private MyButton addAcc, delAcc, changeAcc, findAcc;
	private MyButton salesList,allBills,operatingCondition;
	private MyButton approButton,disapButton;
	private MyButton cus,com,highPri;
	 
	private MyButton []accButtons = new MyButton[]{addAcc, delAcc, changeAcc, findAcc};
	private MyButton []recButtons = new MyButton[]{salesList,allBills,operatingCondition};
	private MyButton []invoiceButtons = new MyButton[]{approButton,disapButton};
	private MyButton []proButtons = new MyButton[]{cus,com,highPri};
	

	
	public ManagerUIController(UIController uiController,MyFrame frame){
		this.managerPanel = new ManagerPanel(frame, "Image/Manager/manager_背景.jpg",
				uiController, this);
		frame.setPanel(managerPanel);
		
	}
	public void toAccPanel() {
		String images_ori_acc[] = new String[]{"Image/Manager/button/accManage/addAcc.png",
				"Image/Manager/button/accManage/delAcc.png","Image/Manager/button/accManage/changeAcc.png",
				"Image/Manager/button/accManage/findAcc.png"};
		String images_stop_acc[] = new String[]{"Image/Manager/button/accManage/addAcc_stop.png",
				"Image/Manager/button/accManage/delAcc_stop.png","Image/Manager/button/accManage/changeAcc_stop.png",
				"Image/Manager/button/accManage/findAcc_stop.png"};
		String images_press_on_acc[] = new String[]{"Image/Manager/button/accManage/addAcc_press_on.png",
				"Image/Manager/button/accManage/delAcc_press_on.png","Image/Manager/button/accManage/changeAcc_press_on.png",
				"Image/Manager/button/accManage/findAcc_press_on.png"};
		
		managerSecondPanel = new SecondPanel();
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_acc[i], secondX, secondY+i*inter,
					images_stop_acc[i], images_press_on_acc[i]);
			managerSecondPanel.add(accButtons[i]);
		}
		managerPanel.add(managerSecondPanel);
		managerPanel.repaint();
	}
	public void toInvoicePanel() {
		String images_ori_invoice[] = new String[]{"Image/Manager/button/invoiceManage/approve.png",
		           "Image/Manager/button/invoiceManage/disapp.png"};
		String images_stop_invoice[] = new String[]{"Image/Manager/button/invoiceManage/approve_stop.png",
		           "Image/Manager/button/invoiceManage/disapp_stop.png"};
		String images_press_on_invoice[] = new String[]{"Image/Manager/button/invoiceManage/approve_press_on.png",
	               "Image/Manager/button/invoiceManage/disapp_press_on.png"};
		
		managerSecondPanel = new SecondPanel();
		for(int i = 0;i < invoiceButtons.length;i++){
			invoiceButtons[i] = new MyButton(images_ori_invoice[i], secondX, secondY+i*inter,
					images_stop_invoice[i], images_press_on_invoice[i]);
			managerSecondPanel.add(accButtons[i]);
		}
		managerPanel.add(managerSecondPanel);
		managerPanel.repaint();
	}
	
	public void toRecPanel() {
		String images_ori_rec[] = new String[]{"Image/Manager/button/recManage/salesList.png",
				"Image/Manager/button/recManage/allBills.png","Image/Manager/button/recManage/opeCon.png"};
		String images_stop_rec[] = new String[]{"Image/Manager/button/rccManage/salesList_stop.png",
				"Image/Manager/button/recManage/allBills_stop.png","Image/Manager/button/recManage/opeCon_stop.png"};
		String images_press_on_rec[] = new String[]{"Image/Manager/button/recManage/salesList_press_on.png",
				"Image/Manager/button/recManage/allBills_press_on.png","Image/Manager/button/recManage/opeCon_press_on.png"};
		
		managerSecondPanel = new SecondPanel();
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_rec[i], secondX, secondY+i*inter,
					images_stop_rec[i], images_press_on_rec[i]);
			managerSecondPanel.add(accButtons[i]);
		}
		managerPanel.add(managerSecondPanel);
		managerPanel.repaint();
		
	}
	public void toProPanel() {
		String images_ori_pro[] = new String[]{"Image/Manager/button/proManage/cus.png",
				"Image/Manager/button/proManage/com.png","Image/Manager/button/proManage/highPri.png"};
		String images_stop_pro[] = new String[]{"Image/Manager/button/proManage/cus_stop.png",
				"Image/Manager/button/proManage/com_stop.png","Image/Manager/button/proManage/highPri_stop.png"};
		String images_press_on_pro[] = new String[]{"Image/Manager/button/proManage/cus_press_on.png",
				"Image/Manager/button/proManage/com_press_on.png","Image/Manager/button/proManager/highPri_press_on.png"};
		
		managerSecondPanel = new SecondPanel();
		for(int i = 0;i < accButtons.length;i++){
			accButtons[i] = new MyButton(images_ori_pro[i], secondX, secondY+i*inter,
					images_stop_pro[i], images_press_on_pro[i]);
			managerSecondPanel.add(accButtons[i]);
		}
		managerPanel.add(managerSecondPanel);
		managerPanel.repaint();
		
	}
}
