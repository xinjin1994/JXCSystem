package ui.commodity;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.CommodityPanel;
import ui.UIController;
import ui.setting.MyFrame;
import ui.setting.SecondPanel;
import ui.setting.Button.MyButton;

public class CommodityUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	
	private SecondPanel commoditySecondPanel = new SecondPanel();
	private CommodityPanel commodityPanel;
	
	 
	private MyButton []comButtons = new MyButton[4];
	private MyButton []sortButtons = new MyButton[3];
	private MyButton []stockButtons = new MyButton[3];
	private MyButton []invoiceButtons = new MyButton[2];

	private MyFrame frame;
	private CommodityAllUIController uiController;
	
	public CommodityUIController(CommodityAllUIController uiController,MyFrame frame){
		this.uiController = uiController;
		this.frame = frame;
		this.commodityPanel = new CommodityPanel(frame, "Image/Commodity/commodity.jpg",
				uiController, this);
		frame.setPanel(commodityPanel);
		
		uiController.setMainPanel(commodityPanel);
	}
	public void toComPanel() {
		commoditySecondPanel.removeAll();
		CommodityListener listener = new CommodityListener();
		
		String images_ori_com[] = new String[]{"Image/Commodity/button/comManage/addCom.png",
				"Image/Commodity/button/comManage/delCom.png","Image/Commodity/button/comManage/changeCom.png",
				"Image/Commodity/button/comManage/findCom.png"};
		String images_stop_com[] = new String[]{"Image/Commodity/button/comManage/addCom_stop.png",
				"Image/Commodity/button/comManage/delCom_stop.png","Image/Commodity/button/comManage/changeCom_stop.png",
				"Image/Commodity/button/comManage/findCom_stop.png"};
		String images_press_on_com[] = new String[]{"Image/Commodity/button/comManage/addCom_press_on.png",
				"Image/Commodity/button/comManage/delCom_press_on.png","Image/Commodity/button/comManage/changeCom_press_on.png",
				"Image/Commodity/button/comManage/findCom_press_on.png"};
		
		for(int i = 0;i < comButtons.length;i++){
			comButtons[i] = new MyButton(images_ori_com[i], secondX, secondY+i*inter,
					images_stop_com[i], images_press_on_com[i]);
			commoditySecondPanel.add(comButtons[i]);
			comButtons[i].addMouseListener(listener);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
	}
	public void toInvoicePanel() {
		commoditySecondPanel.removeAll();
		InvoiceListener listener = new InvoiceListener();
		
		String images_ori_invoice[] = new String[]{"Image/Commodity/button/invoiceManage/pending.png",
				"Image/Commodity/button/invoiceManage/disapp.png"};
		String images_stop_invoice[] = new String[]{"Image/Commodity/button/invoiceManage/pending_stop.png",
				"Image/Commodity/button/invoiceManage/disapp_stop.png"};
		String images_press_on_invoice[] = new String[]{"Image/Commodity/button/invoiceManage/pending_press_on.png",
				"Image/Commodity/button/invoiceManage/disapp_press_on.png"};
		
		for(int i = 0;i < invoiceButtons.length;i++){
			invoiceButtons[i] = new MyButton(images_ori_invoice[i], secondX, secondY+i*inter,
					images_stop_invoice[i], images_press_on_invoice[i]);
			commoditySecondPanel.add(invoiceButtons[i]);
			invoiceButtons[i].addMouseListener(listener);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
	}
	public void toSortPanel() {
		commoditySecondPanel.removeAll();
		SortListener listener = new SortListener();
		
		String images_ori_sort[] = new String[]{"Image/Commodity/button/sortManage/addSort.png",
				"Image/Commodity/button/sortManage/delSort.png","Image/Commodity/button/sortManage/changeSort.png"};
		String images_stop_sort[] = new String[]{"Image/Commodity/button/sortManage/addSort_stop.png",
				"Image/Commodity/button/sortManage/delSort_stop.png","Image/Commodity/button/sortManage/changeSort_stop.png"};
		String images_press_on_sort[] = new String[]{"Image/Commodity/button/sortManage/addSort_press_on.png",
				"Image/Commodity/button/sortManage/delSort_press_on.png","Image/Commodity/button/sortManage/changeSort_press_on.png"};
		
		for(int i = 0;i < sortButtons.length;i++){
			sortButtons[i] = new MyButton(images_ori_sort[i], secondX, secondY+i*inter,
					images_stop_sort[i], images_press_on_sort[i]);
			commoditySecondPanel.add(sortButtons[i]);
			sortButtons[i].addMouseListener(listener);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
		
	}

	public void toStockPanel() {
		commoditySecondPanel.removeAll();
		StockListener listener = new StockListener();
		
		String images_ori_stock[] = new String[]{"Image/Commodity/button/stockManage/examine.png",
				"Image/Commodity/button/stockManage/inventory.png",	"Image/Commodity/button/stockManage/patch.png"};
		String images_stop_stock[] = new String[]{"Image/Commodity/button/stockManage/examine_stop.png",
				"Image/Commodity/button/stockManage/inventory_stop.png","Image/Commodity/button/stockManage/patch_stop.png"};
		String images_press_on_stock[] = new String[]{"Image/Commodity/button/stockManage/examine_press_on.png",
				"Image/Commodity/button/stockManage/inventory_press_on.png",
				"Image/Commodity/button/stockManage/patch_press_on.png"};
		
		for(int i = 0;i < stockButtons.length;i++){
			stockButtons[i] = new MyButton(images_ori_stock[i], secondX, secondY+i*inter,
					images_stop_stock[i], images_press_on_stock[i]);
			commoditySecondPanel.add(stockButtons[i]);
			stockButtons[i].addMouseListener(listener);
		}
		commodityPanel.add(commoditySecondPanel);
		commodityPanel.repaint();
		
	}
	
	class CommodityListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(commodityPanel);
			frame.remove(commodityPanel);
			if(e.getSource() == comButtons[0]){
				uiController.addCom();
			}else if(e.getSource() == comButtons[1]){
				uiController.delCom();
			}else if(e.getSource() == comButtons[2]){
				uiController.changeCom();
			}else if(e.getSource() == comButtons[3]){
				uiController.findCom();
			}
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	class SortListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(commodityPanel);
			frame.remove(commodityPanel);
			if(e.getSource() == sortButtons[0]){
				uiController.addSort();
			}else if(e.getSource() == sortButtons[1]){
				uiController.delSort();
			}else if(e.getSource() == sortButtons[2]){
				uiController.changeSort();
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class InvoiceListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(commodityPanel);
			if(e.getSource() == invoiceButtons[0]){
				
			}else if(e.getSource() == invoiceButtons[1]){
				
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	class StockListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(commodityPanel);
			if(e.getSource() == stockButtons[0]){
				frame.remove(commodityPanel);
				uiController.examineStock();
			}else if(e.getSource() == stockButtons[1]){
				frame.remove(commodityPanel);
				uiController.inventory();
			}else if(e.getSource() == stockButtons[2]){
				frame.remove(commodityPanel);
				uiController.patch();
			}
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
}
