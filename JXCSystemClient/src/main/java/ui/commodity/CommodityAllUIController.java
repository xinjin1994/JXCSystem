package ui.commodity;

import ui.FatherPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.SetBack;
import vo.CommodityVO;
import vo.SortVO;

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

//	private AddPatchPanel addPatchPanel;
//	private ConfirmPatchPanel confitmPatchPanel;
//	private PatchDetailPanel patchDetailPanel;
//	
//	private ExmainStockPanel exmainStockPanel;
//	private InventoryPanel inventoryPanel;
	
	
	
	
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

	public void confirmCom(CommodityVO com,String type){
		confirmComPanel = new ConfirmComPanel(frame, "Image/Commodity/comManage/confirmCom.jpg", this,com,type);
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

	public void chaSortD(SortVO sort){
		chaSortDPanel = new ChaSortDPanel(frame, "Image/Commodity/sortManage/chaSortD.jpg", this,sort);
		frame.setPanel(chaSortDPanel);
		frame.repaint();
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
	
}
