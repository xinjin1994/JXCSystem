package ui.manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.ManagerPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.SecondPanel;
import ui.setting.ThirdPanel;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.InvoiceVO;
import vo.promotion.DiscountVO;
import vo.promotion.ProGiftVO;
import vo.promotion.VoucherVO;
import businesslogic.invoicebl.InvoiceController;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.invoiceblservice.InvoiceblService;
import businesslogicservice.promotionblservice.PromotionblService;

public class ManagerUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	private InvoiceblService invoiceblService;
	
	private SecondPanel managerSecondPanel = new SecondPanel();
	public ThirdPanel managerThirdPanel = new ThirdPanel();
	
	private ManagerPanel managerPanel;
	private String item,itemName;
	private ColorFactory colors;
	MyTable showTable;
	private MyButton addAcc, delAcc, changeAcc, findAcc;
	private MyButton salesList,allBills,operatingCondition;
	private MyButton approButton,disapButton,backLogButton;
	private MyButton chePro,decPro;
	ArrayList<InvoiceVO> billsArray ;
	private MyButton []accButtons = new MyButton[]{addAcc, delAcc, changeAcc, findAcc};
	private MyButton []recButtons = new MyButton[]{salesList,allBills,operatingCondition};
	private MyButton []invoiceButtons = new MyButton[]{approButton,disapButton,backLogButton};
	private MyButton []proButtons = new MyButton[]{chePro,decPro};
	
	private PromotionblService promotionblService;
	private ManagerAllUIController uiController;
	private MyFrame frame;
	private ResultPanelController resController ;
	public ManagerUIController(ManagerAllUIController uiController,MyFrame frame){
		this.uiController = uiController;
		this.frame = frame;
		invoiceblService = new InvoiceController();
		colors = new ColorFactory();
		
		promotionblService = new PromotionController();
		this.managerPanel = new ManagerPanel(frame, "Image/Manager/manager.jpg",
				uiController, this);
		uiController.logOut(managerPanel);
		managerPanel.repaint();
		
		managerPanel.add(managerThirdPanel);
		frame.setPanel(managerPanel);
		resController = new ResultPanelController(frame, managerPanel);
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
		String images_press_on_pro[] = new String[]{"Image/Manager/button/proManage/chePro_press_on.png",
				"Image/Manager/button/proManage/chePro_press_on.png"};
		
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
			uiController.setMainPanel(managerPanel);
			frame.remove(managerPanel);
			if(event.getSource() == proButtons[0]){
				if(examine()){
					uiController.checkPro();
				}
			}else if (event.getSource() == proButtons[1]) {
				uiController.setPro();
			}
		}

		private boolean examine() {
			ArrayList<DiscountVO> discount = promotionblService.getDiscount_up();
			ArrayList<VoucherVO> voucher = promotionblService.getVoucher_up();
			ArrayList<ProGiftVO> gift = promotionblService.getProGift_up();
			if( (discount == null) && (voucher == null) && (gift == null)){
				frame.remove(managerPanel);
				resController.failed("当下无销售策略！", "manager");
				return false;
			}	
			return true;
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
			uiController.setMainPanel(managerPanel);
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
			uiController.setMainPanel(managerPanel);
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
			
			uiController.setMainPanel(managerPanel);
			
			String type = "审批通过";
			if(e.getSource() == invoiceButtons[0]){
				billsArray = invoiceblService.show_pass();
			}else if(e.getSource() == invoiceButtons[1]){
				billsArray = invoiceblService.show_refuse();
				type = "审批拒绝";
			}else if(e.getSource() == invoiceButtons[2]){
				System.out.println("0000");
				billsArray = invoiceblService.show_up();
				type = "待审批";	
			}
			
			try {
				ArrayList<String> bills = new ArrayList<String>();
				bills.add("单据编号;单据类型");
				System.out.println("101");
				for(int i=0;i<billsArray.size();i++){
					System.out.println("10");
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
				}
				managerPanel.setTable(bills);
			} catch (Exception e2) {
				frame.remove(managerPanel);
				resController.failed("无新审批"+type+"单据！", "manager");
			}
			if(e.getSource() == invoiceButtons[2]){
				new InvoiceBills(managerPanel);
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
}
