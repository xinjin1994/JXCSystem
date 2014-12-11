package ui.commodity;

import ui.CommodityPanel;
import ui.UIController;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.SecondPanel;

public class CommodityUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	
	private SecondPanel commoditySecondPanel;
	private CommodityPanel commodityPanel;
	private MyButton addCom, delCom, changeCom, findCom;
	private MyButton addSort,delSort,changeSort;
	private MyButton examine,inventory;
	private MyButton gift,patch,warn;
	private MyButton approButton,disapButton;
	 
	private MyButton []comButtons = new MyButton[]{addCom, delCom, changeCom, findCom};
	private MyButton []sortButtons = new MyButton[]{addSort,delSort,changeSort};
	private MyButton []stockButtons = new MyButton[]{examine,inventory};
	private MyButton []recButtons = new MyButton[]{gift,patch,warn};
	private MyButton []invoiceButtons = new MyButton[]{approButton,disapButton};

	private MyFrame frame;
	private CommodityAllUIController uiController;
	
	public CommodityUIController(CommodityAllUIController uiController,MyFrame frame){
		this.uiController = uiController;
		this.frame = frame;
		this.commodityPanel = new CommodityPanel(frame, "Image/Commodity/commodity_背景.jpg",
				uiController, this);
		frame.setPanel(commodityPanel);
		
		uiController.setMainPanel(commodityPanel);
	}
	public void toComPanel() {
		String images_ori_com[] = new String[]{"Image/Commodity/button/comManage/addCom.png",
				"Image/Commodity/button/comManage/delCom.png","Image/Commodity/button/comManage/changeCom.png",
				"Image/Commodity/button/comManage/findCom.png"};
		String images_stop_com[] = new String[]{"Image/Commodity/button/comManage/addCom_stop.png",
				"Image/Commodity/button/comManage/delCom_stop.png","Image/Commodity/button/comManage/changeCom_stop.png",
				"Image/Commodity/button/comManage/findCom_stop.png"};
		String images_press_on_com[] = new String[]{"Image/Commodity/button/comManage/addCom_press_on.png",
				"Image/Commodity/button/comManage/delCom_press_on.png","Image/Commodity/button/comManage/changeCom_press_on.png",
				"Image/Commodity/button/comManage/findCom_press_on.png"};
		
		commoditySecondPanel = new SecondPanel();
		for(int i = 0;i < comButtons.length;i++){
			comButtons[i] = new MyButton(images_ori_com[i], secondX, secondY+i*inter,
					images_stop_com[i], images_press_on_com[i]);
			commoditySecondPanel.add(comButtons[i]);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
	}
	public void toInvoicePanel() {
		String images_ori_invoice[] = new String[]{"Image/Commodity/button/invoiceManage/approve.png",
				"Image/Commodity/button/invoiceManage/disapp.png"};
		String images_stop_invoice[] = new String[]{"Image/Commodity/button/invoiceManage/approve_stop.png",
		"Image/Commodity/button/invoiceManage/disapp_stop.png"};
		String images_press_on_invoice[] = new String[]{"Image/Commodity/button/invoiceManage/approve_press_on.png",
				"Image/Commodity/button/invoiceManage/disapp_press_on.png"};
		
		commoditySecondPanel = new SecondPanel();
		for(int i = 0;i < invoiceButtons.length;i++){
			invoiceButtons[i] = new MyButton(images_ori_invoice[i], secondX, secondY+i*inter,
					images_stop_invoice[i], images_press_on_invoice[i]);
			commoditySecondPanel.add(comButtons[i]);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
	}
	public void toSortPanel() {
		String images_ori_sort[] = new String[]{"Image/Commodity/button/sortManage/addSort.png",
				"Image/Commodity/button/sortManage/delSort.png","Image/Commodity/button/sortManage/changeSort.png"};
		String images_stop_sort[] = new String[]{"Image/Commodity/button/sortManage/addSort_stop.png",
				"Image/Commodity/button/sortManage/delSort_stop.png","Image/Commodity/button/sortManage/changeSort_stop.png"};
		String images_press_on_sort[] = new String[]{"Image/Commodity/button/sortManage/addSort_press_on.png",
				"Image/Commodity/button/sortManage/delSort_press_on.png","Image/Commodity/button/sortManage/changeSort_press_on.png"};
		
		commoditySecondPanel = new SecondPanel();
		for(int i = 0;i < comButtons.length;i++){
			comButtons[i] = new MyButton(images_ori_sort[i], secondX, secondY+i*inter,
					images_stop_sort[i], images_press_on_sort[i]);
			commoditySecondPanel.add(comButtons[i]);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
		
	}
	public void toRecPanel() {
		String images_ori_rec[] = new String[]{"Image/Commodity/button/recManage/gift.png",
				"Image/Commodity/button/recManage/patch.png","Image/Commodity/button/recManage/warn.png"};
		String images_stop_rec[] = new String[]{"Image/Commodity/button/recManage/gift_stop.png",
				"Image/Commodity/button/recManage/patch_stop.png","Image/Commodity/button/recManage/warn_stop.png"};
		String images_press_on_rec[] = new String[]{"Image/Commodity/button/recManage/gift_press_on.png",
				"Image/Commodity/button/recManage/patch_press_on.png","Image/Commodity/button/recManage/warn_press_on.png"};
		
		commoditySecondPanel = new SecondPanel();
		for(int i = 0;i < comButtons.length;i++){
			comButtons[i] = new MyButton(images_ori_rec[i], secondX, secondY+i*inter,
					images_stop_rec[i], images_press_on_rec[i]);
			commoditySecondPanel.add(comButtons[i]);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
		
	}
	public void toStockPanel() {
		String images_ori_stock[] = new String[]{"Image/Commodity/button/stockManage/examine.png",
				"Image/Commodity/button/stockManage/inventory.png"};
		String images_stop_stock[] = new String[]{"Image/Commodity/button/stockManage/examine_stop.png",
				"Image/Commodity/button/stockManage/inventory_stop.png"};
		String images_press_on_stock[] = new String[]{"Image/Commodity/button/stockManage/examine_press_on.png",
				"Image/Commodity/button/stockManage/inventory_press_on.png"};
		
		commoditySecondPanel = new SecondPanel();
		for(int i = 0;i < comButtons.length;i++){
			comButtons[i] = new MyButton(images_ori_stock[i], secondX, secondY+i*inter,
					images_stop_stock[i], images_press_on_stock[i]);
			commoditySecondPanel.add(comButtons[i]);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
		
	}
}
