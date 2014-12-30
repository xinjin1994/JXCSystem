package ui.commodity;

import ui.CommodityPanel;
import ui.FatherPanel;
import ui.UIController;
import ui.commodity.manage.AddComPanel;
import ui.commodity.manage.ChaComDPanel;
import ui.commodity.manage.ChaComPanel;
import ui.commodity.manage.ComDetailPanel;
import ui.commodity.manage.ConfirmComPanel;
import ui.commodity.manage.DelComPanel;
import ui.commodity.manage.FinComPanel;
import ui.commodity.sort.AddSortPanel;
import ui.commodity.sort.ChaSortDPanel;
import ui.commodity.sort.ChaSortPanel;
import ui.commodity.sort.ConfirmSortPanel;
import ui.commodity.sort.DelSortPanel;
import ui.commodity.storage.AddPatchPanel;
import ui.commodity.storage.ConfirmPatchPanel;
import ui.commodity.storage.ExamineStockPanel;
import ui.commodity.storage.PatchDetailPanel;
import ui.setting.MyFrame;
import ui.setting.SetBack;
import ui.setting.Button.LogOutButton;
import vo.CommodityVO;
import vo.SortVO;
import vo.bill.PatchVO;

/**
 * 控制Commodity模块各个界面的跳转
 * @author ZYC
 *
 */
public class CommodityAllUIController extends UIController{
	private UIController uiController;
	private MyFrame frame;
	
	private AddComPanel addComPanel;
	private DelComPanel delComPanel;
	private FinComPanel finComPanel;
	private ChaComDPanel chaComDPanel;
	private ChaComPanel chaComPanel;
	private ComDetailPanel comDetailPanel;
	private ConfirmComPanel confirmComPanel;
	
	private AddSortPanel addSortPanel;
	private DelSortPanel delSortPanel;
	private ChaSortPanel chaSortPanel;
	private ConfirmSortPanel confirmSortPanel;
	private ChaSortDPanel chaSortDPanel; 

	private AddPatchPanel addPatchPanel;
	private ConfirmPatchPanel confitmPatchPanel;
	private PatchDetailPanel patchDetailPanel;
//	
	private ExamineStockPanel examainStockPanel;
	private InventoryPanel inventoryPanel;
	
	
	
	
	public CommodityAllUIController(UIController uiController,MyFrame frame) {
		this.frame = frame;
		this.uiController = uiController;
		addMainPanel();
	}


	public void addMainPanel() {
		new CommodityUIController(this, frame);
		frame.repaint();
	}


	public void addCom() {
		addComPanel = new AddComPanel(frame, "Image/Commodity/comManage/addCom.jpg", this);
		frame.setPanel(addComPanel);
		frame.repaint();
	}


	public void findCom() {
		finComPanel = new FinComPanel(frame, "Image/Commodity/comManage/finCom.jpg", this);
		frame.setPanel(finComPanel);
		frame.repaint();
	}
	
	public void changeComD(CommodityVO com){
		chaComDPanel = new ChaComDPanel(frame, "Image/Commodity/comManage/chaComD.jpg", this,com);
		frame.setPanel(chaComDPanel);
		frame.repaint();
	}

	public void changeCom() {
		chaComPanel = new ChaComPanel(frame, "Image/Commodity/comManage/chaCom.jpg", this);
		frame.setPanel(chaComPanel);
		frame.repaint();
	}

	public void delCom() {
		delComPanel = new DelComPanel(frame, "Image/Commodity/comManage/delCom.jpg", this);
		frame.setPanel(delComPanel);
		frame.repaint();
	}
	
	public void comDetail(CommodityVO com){
		comDetailPanel = new ComDetailPanel(frame,"Image/Commodity/comManage/comDetail.jpg",this,com);
		frame.setPanel(comDetailPanel);
		frame.repaint();
	}

	public void confirmCom(CommodityVO com,String type,SortVO sort){
		confirmComPanel = new ConfirmComPanel(frame, "Image/Commodity/comManage/confirmCom.jpg", this,com,type,sort);
		frame.setPanel(confirmComPanel);
		frame.repaint();
	}
	
	public void confirmCom(CommodityVO com,String type,SortVO sort,CommodityVO oldVO){
		confirmComPanel = new ConfirmComPanel(frame, "Image/Commodity/comManage/confirmCom.jpg", this,com,type,sort,oldVO);
		frame.setPanel(confirmComPanel);
		frame.repaint();
	}
	
	public void changeSort() {
		chaSortPanel = new ChaSortPanel(frame, "Image/Commodity/sortManage/chaSort.jpg", this);
		frame.setPanel(chaSortPanel);
		frame.repaint();
	}


	public void delSort() {
		delSortPanel = new DelSortPanel(frame,"Image/Commodity/sortManage/delSort.jpg", this);
		frame.setPanel(delSortPanel);
		frame.repaint();
	}


	public void addSort() {
		addSortPanel = new AddSortPanel(frame, "Image/Commodity/sortManage/addSort.jpg",this);
		frame.setPanel(addSortPanel);
		frame.repaint();
	}
	
	public void confirmSort(SortVO sort,String type){
		confirmSortPanel = new ConfirmSortPanel(frame,"Image/Commodity/sortManage/confirmSort.jpg",this,sort,type);
		frame.setPanel(confirmSortPanel);
		frame.repaint();
	}
	public void confirmSort(SortVO sort,String type, String fatherSort){
		confirmSortPanel = new ConfirmSortPanel(frame,"Image/Commodity/sortManage/confirmSort.jpg",this,sort,type,fatherSort);
		frame.setPanel(confirmSortPanel);
		frame.repaint();
	}

	public void confirmSort(SortVO sort,String type,SortVO oldSort){
		confirmSortPanel = new ConfirmSortPanel(frame,"Image/Commodity/sortManage/confirmSort.jpg",this,sort,type,oldSort);
		frame.setPanel(confirmSortPanel);
		frame.repaint();
	}
	public void chaSortD(SortVO sort){
		chaSortDPanel = new ChaSortDPanel(frame, "Image/Commodity/sortManage/chaSortD.jpg", this,sort);
		frame.setPanel(chaSortDPanel);
		frame.repaint();
	}

	public void examineStock() {
		examainStockPanel = new ExamineStockPanel(frame, "Image/Commodity/stockManage/examineStock.jpg", this);		
		frame.setPanel(examainStockPanel);
		frame.repaint();
	}


	public void inventory() {
		inventoryPanel = new InventoryPanel(frame, "Image/Commodity/stockManage/inventory.jpg", this);
		frame.setPanel(inventoryPanel);
		frame.repaint();
	}


	public void gift() {
		// TODO Auto-generated method stub
		
	}


	public void patch() {
		addPatchPanel = new AddPatchPanel(frame,"Image/Commodity/stockManage/patch.jpg", this);
		frame.setPanel(addPatchPanel);
		frame.repaint();
	}
	

	public void patchDraft(PatchVO bill) {
		addPatchPanel = new AddPatchPanel(frame,"Image/Commodity/stockManage/patch.jpg", this,bill);
		frame.setPanel(addPatchPanel);
		frame.repaint();
	}
	
	public void confirmPatch(PatchVO newPatch) {
		confitmPatchPanel = new ConfirmPatchPanel(frame,"Image/Commodity/stockManage/confirmPatch.jpg",this,newPatch);
		frame.setPanel(confitmPatchPanel);
		frame.repaint();
	}
	public void patchDetail(PatchVO patch){
		patchDetailPanel = new PatchDetailPanel(frame,"Image/Commodity/stockManage/confirmPatch.jpg",this,patch);
		frame.setPanel(patchDetailPanel);
		frame.repaint();
	}
	
	public void logOut(CommodityPanel panel){
		new LogOutButton(frame, panel, "commodity", uiController);
	}
	/**
	 * 以下两个是commodity模块中的返回按钮，都会返回到主界面
	 * @param prePanel
	 */
	
	public void setBack_first(FatherPanel prePanel){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_first();
	}

	public void setBack_second(FatherPanel prePanel,int x,int y){
		this.prePanel = prePanel;
		new SetBack(frame,this,prePanel).setBack_second(x, y);
	}
	public void setBack_third(FatherPanel prePanel){
		this.prePanel = prePanel;
		new SetBack(frame, this, prePanel).setBack_third();
	}


}
