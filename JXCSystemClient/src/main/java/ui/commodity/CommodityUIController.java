package ui.commodity;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import ui.CommodityPanel;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.SaveTempBills;
import ui.setting.SecondPanel;
import ui.setting.Button.MyButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.InvoiceVO;
import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.invoiceblservice.InvoiceblService;
/**
 * 控制Commodity二级界面SecondPAnel的显示跳转
 * @author ZYC
 *
 */
public class CommodityUIController {
	private int secondX = 1;
	private int secondY = 35;
	private int inter = 54;
	private String item,itemName;
	private ColorFactory colors = new ColorFactory();
	MyTable showTable;
	private SecondPanel commoditySecondPanel = new SecondPanel();
	private CommodityPanel commodityPanel;
	
	 
	private MyButton []comButtons = new MyButton[4];
	private MyButton []sortButtons = new MyButton[3];
	private MyButton []stockButtons = new MyButton[3];
	private MyButton []invoiceButtons = new MyButton[2];

	private MyFrame frame;
	private ResultPanelController resController;
	private CommodityAllUIController uiController;
	private InvoiceblService invoiceblService;	
	
	private SaveTempBills infos;
	ArrayList<InvoiceVO> billsArray = new ArrayList<InvoiceVO>() ;
	public CommodityUIController(CommodityAllUIController uiController,MyFrame frame){
		this.uiController = uiController;
		this.frame = frame;
		this.commodityPanel = new CommodityPanel(frame, "Image/Commodity/commodity.jpg",
				uiController, this);
		uiController.logOut(commodityPanel);
		commodityPanel.repaint();
		frame.setPanel(commodityPanel);
		resController = new ResultPanelController(frame,commodityPanel);
		invoiceblService = new InvoiceController();
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
	
//	private void setTable(ArrayList<String> info){
//		showTable = new MyTable();
//		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
//		showTable.setTable(info);
//		frame.remove(commodityPanel);
//		frame.add(showTable.tablePanel);
//		uiController.addMainPanel();
//		frame.repaint();
//	}
	class InvoiceListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			uiController.setMainPanel(commodityPanel);
			String type = "待处理";
			if(e.getSource() == invoiceButtons[0]){
				billsArray = invoiceblService.show_up();
			}else if(e.getSource() == invoiceButtons[1]){
				billsArray = invoiceblService.show_refuse();
				type = "拒绝";
			}

			try {
				ArrayList<String> bills = new ArrayList<String>();
				bills.add("单据编号;单据类型");
				for(int i=0;i<billsArray.size();i++){
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
					default:
						break;
					}
					item = billsArray.get(i).note+";"+itemName;
					bills.add(item);
				}
				infos = new SaveTempBills(frame, billsArray, uiController);
				commodityPanel.setTable(bills,infos);
				
			} catch (Exception e2) {
				frame.remove(commodityPanel);
				resController.failed("无新"+type+"单据！", "commodity");
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
