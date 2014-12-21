package ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import po.PatchPO;
import junit.framework.Test;
import businesslogic.commoditybl.Commodity;
import businesslogic.commoditybl.CommodityController;
import businesslogicservice.commodityblservice.CommodityblService;
import ui.commodity.CommodityUIController;
import ui.commodity.storage.PatchDetailPanel;
import ui.setting.ColorFactory;
import ui.setting.Com;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyScrollPane;
import ui.setting.MySortTree;
import ui.setting.MyTable;
import ui.setting.SaveTempBills;
import ui.setting.ThirdPanel;
import ui.setting.Button.MyButton;
import ui.setting.Button.RemindButton;
import vo.CommodityVO;
import vo.SortVO;
import vo.bill.PatchVO;

//1 库存人员
public class CommodityPanel extends FatherPanel{
	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	public ThirdPanel commodityThirdPanel;
	MyButton comManage,sortManage,stockManage,invoiceManage,saveCheck;
	private MyButton [] buttons = new MyButton[]{comManage,sortManage,stockManage,invoiceManage,saveCheck};
	private MyButton refresh, warn,newBills,detail;
	
	private MyFrame frame;
	private CommodityUIController commodityUIController;
	private JLabel remindLabel;
	
	private JScrollPane scrollPane;
	
	private ArrayList<CommodityVO> warnCom = new ArrayList<CommodityVO>();
	private String images_ori[] = new String[]{"Image/Commodity/button/comManage.png",
			"Image/Commodity/button/sortManage.png","Image/Commodity/button/stockManage.png",
			"Image/Commodity/button/invoiceManage.png","Image/Commodity/button/saveCheck.png"};
	private String images_stop[] = new String[]{"Image/Commodity/button/comManage_stop.png",
			"Image/Commodity/button/sortManage_stop.png","Image/Commodity/button/stockManage_stop.png",
			"Image/Commodity/button/invoiceManage_stop.png","Image/Commodity/button/saveCheck_stop.png"};
	private String images_press_on[] = new String[]{"Image/Commodity/button/comManage_press_on.png",
			"Image/Commodity/button/sortManage_press_on.png","Image/Commodity/button/stockManage_press_on.png",
			"Image/Commodity/button/invoiceManage_press_on.png","Image/Commodity/button/saveCheck_press_on.png"};
	
	private FirstButtonListener listener = new FirstButtonListener();

	private RemindButton remind;
	private MySortTree comTree;
	
	private CommodityblService commodityblService;
	
	private SaveTempBills bills,draft;
	
	private MyTable showTable;
	
	private ArrayList<PatchVO> drafts = new ArrayList<PatchVO>();
	
	private ColorFactory color;
	public CommodityPanel(MyFrame frame, String url, UIController controller,
			CommodityUIController commodityUIController) {
		super(frame, url, controller);
		commodityThirdPanel = new ThirdPanel();
		this.add(commodityThirdPanel);
		
		this.commodityUIController= commodityUIController;
		this.frame = frame;
		
		color = new ColorFactory();
		scrollPane = new MyScrollPane();
		commodityblService = new CommodityController();
		remind = new RemindButton(this);
		this.addButton();

		}


	private void addButton() {
		remind.setLable();
		for(int i = 0 ;i < buttons.length;i++){
			buttons[i] = new MyButton(images_ori[i], firstX, firstY +i * inter,
					images_stop[i], images_press_on[i]);
			this.add(buttons[i]);
			buttons[i].addMouseListener(listener);
		}
		refresh = new MyButton("Image/refresh.png",70,555,"Image/refresh_stop.png","Image/refresh_stop.png");
		this.add(refresh);
		refresh.addMouseListener(listener);
	}
	
	
	private void setTree(ArrayList<SortVO> allCom) {
		System.out.println("lklk");
		commodityThirdPanel.removeAll();
		comTree = new MySortTree(allCom);
//		scrollPane =  new JScrollPane(comTree.tree);
//		scrollPane.setVisible(true);
//		scrollPane.setViewportView(comTree.tree);
//		scrollPane.setBounds(43,44,360,380);
//		scrollPane.setViewportView(comTree.tree);
//		commodityThirdPanel.add(comTree.tree);
//		commodityThirdPanel.add(scrollPane);
		commodityThirdPanel.add(comTree.scrollPane);
		commodityThirdPanel.repaint();
//		this.add(commodityThirdPanel);
		this.repaint();
		
	}
	
	public void setTable(ArrayList<String> info,SaveTempBills bills) {
		this.bills = bills;
		commodityThirdPanel.removeAll();
		showTable = new MyTable();
		showTable.setInfo(bills);
		showTable.setColor(color.comColor,color.greyFont, color.comColor,Color.white);
		showTable.setTable(info);
		
		commodityThirdPanel.add(showTable.tablePanel);
		commodityThirdPanel.repaint();
		this.repaint();
	}
	public void setTable(ArrayList<String> info) {
		commodityThirdPanel.removeAll();
		showTable = new MyTable();
		showTable.setColor(color.comColor,color.greyFont, color.comColor,Color.white);
		showTable.setTable(info);
		
		commodityThirdPanel.add(showTable.tablePanel);
		commodityThirdPanel.repaint();
		this.repaint();
	}
	
	
	/**
	 * 库存报警时该按钮亮,点击后按钮消失
	 */
	private void setWarn() {
		// TODO Auto-generated method stub
		warn = new MyButton("Image/Commodity/button/warn.png",26,549,"Image/Commodity/button/warn.png",
				"Image/Commodity/button/warn.png");
		this.add(warn);
		warn.addMouseListener(listener);
		this.repaint();
	}
	
	private boolean checkWarn() {
		warnCom = commodityblService.getAllWarnGood_up();
		if(warnCom.size() != 0){
			return true;
		}
		return false;
	}
	/**
	 * 当有新单据要处理时该按钮亮，点击后按钮消失
	 */
	private void newBills() {
		newBills = new MyButton("Image/remind.png",120,555,"Image/remind.png","Image/remind.png");
		this.add(newBills);
		newBills.addMouseListener(listener);
		this.repaint();
	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
//				setTree(commodityblService.getAllSort_up());
			System.out.println("llkl");
				setTree(new Com().allSorts);
			}else if(e.getSource() == buttons[1]) {
				setTree(new Com().allSorts);
			}else if(e.getSource() == buttons[2]) {
			
			}else if (e.getSource() == buttons[3]) {
			
			}else if (e.getSource() == buttons[4]) {
				drafts = commodityblService.getAllDraftPatch_up();
				ArrayList<String> infos = new ArrayList<String>();
				infos.add("单据编号;时间;单据类型");
				for(int i = 0;i < drafts.size();i++){

				
				}
//				draft = new SaveTempBills(frame,drafts, controller);
				setTable(infos, bills);
			}
			else if(e.getSource() == refresh){
				if(checkWarn()){
					setWarn();
				}
			
//				remind.setButton();
			}else if(e.getSource() == warn){
				CommodityPanel.this.remove(warn);
				CommodityPanel.this.repaint();
				ArrayList<String> infos = new ArrayList<String>();
				infos.add("商品编号;商品名称;商品型号;库存数量;警戒数量");
				try {
					for(int i = 0;i < warnCom.size();i++){
						CommodityVO temp = warnCom.get(i);
						infos.add(temp.id+";"+temp.name+";"+temp.type+";"+temp.num+";"+temp.warn+";");
						setTable(infos);
					}
				} catch (Exception e2) {

				}
			}else if(e.getSource() == newBills){
				CommodityPanel.this.remove(newBills);
				CommodityPanel.this.repaint();
			}
		}

		


	

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				commodityUIController.toComPanel();
			}else if(e.getSource() == buttons[1]) {
				commodityUIController.toSortPanel();
			}else if(e.getSource() == buttons[2]) {
				commodityUIController.toStockPanel();
			}else if (e.getSource() == buttons[3]) {
				commodityUIController.toInvoicePanel();
			}
			
		}

		public void mouseExited(MouseEvent e) {
		}
		
	}

	public void addRestButton() {
		detail = new MyButton("Image/Sales/Sales_image/details.png", 670, 537,
				"Image/Sales/Sales_image/details.png", "Image/Sales/Sales_image/details_press_on.png");
		this.add(detail);
	}
}
