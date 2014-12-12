package ui.commodity;

import ui.UIController;
import ui.setting.MyFrame;

public class CommodityAllUIController extends UIController{
	private UIController uiController;
	private MyFrame frame;
	
	private AddComPanel addComPanel;
	private DelComPanel delComPanel;
	private FinComPanel finComPanel;
	private ChaComPanel chaComPanel;
	private ComDetailPanel comDetailPanel;
	private ConfirmComPanel confirmComPanel;
	
	private AddSortPanel addSortPanel;
	private DelSortPanel delSortPanel;
	private ChaSortPanel chaSortPanel;
	private ComfirmSortPanel confirmSortPanel;
	
	private AddGiftPanel addGiftPanel;
	private ConfirmGiftPanel confirmGiftPanel;
	private GiftDetailPanel giftDetailPAnel;
	
	private AddPatchPanel addPatchPanel;
	private ConfirmPatchPanel confitmPatchPanel;
	private PatchDetailPanel patchDetailPanel;
	
	private ExmainStockPanel exmainStockPanel;
	private InventoryPanel inventoryPanel;
	
	
	
	
	public CommodityAllUIController(UIController uiController,MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		addMainPanel();
	}


	private void addMainPanel() {
		new CommodityUIController(this, frame);
		frame.repaint();
	}


	public void addCom() {
		// TODO Auto-generated method stub
		
	}


	public void findCom() {
		// TODO Auto-generated method stub
		
	}


	public void changeCom() {
		// TODO Auto-generated method stub
		
	}


	public void delCom() {
		// TODO Auto-generated method stub
		
	}


	public void changeSort() {
		// TODO Auto-generated method stub
		
	}


	public void delSort() {
		// TODO Auto-generated method stub
		
	}


	public void addSort() {
		// TODO Auto-generated method stub
		
	}


	public void examineStock() {
		// TODO Auto-generated method stub
		
	}


	public void inventory() {
		// TODO Auto-generated method stub
		
	}


	public void gift() {
		// TODO Auto-generated method stub
		
	}


	public void patch() {
		// TODO Auto-generated method stub
		
	}
	
	
}
