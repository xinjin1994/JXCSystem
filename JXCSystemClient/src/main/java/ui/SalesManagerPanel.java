package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import ui.sales.SalesUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.ThirdPanel;
import ui.setting.Button.MyButton;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;
import businesslogic.commoditybl.CommodityController;
import businesslogic.salesbl.SalesController;
import businesslogicservice.commodityblservice.CommodityblService;
import businesslogicservice.salesblservice.SalesblService;

/**
 * 3销售经理
 * 
 * @author lsy
 * @version 2014年11月29日下午2:54:20
 */
public class SalesManagerPanel extends FatherPanel {

	private static final long serialVersionUID = -4472929361380810275L;
	private int firstX = 2;
	private int firstY = 110;
	private int inter = 54;

	private MyButton cusManage, salesManage, importManage, warn, refresh, saveButton;
	private SalesUIController salesController;
	public MyFrame frame;
	private MyButton firstBack;
	private UIController controller;
	private CommodityblService commodityblService;
	private MyLabel label;
	private FirstButtonListener listener = new FirstButtonListener();
	private ArrayList<CommodityVO> commodityVO;
	private MyTable showTable;
	private ThirdPanel thirdPanel;
	private ColorFactory colors = new ColorFactory();
	private SalesblService salesblService;

	public SalesManagerPanel(MyFrame frame, String url, UIController controller,
			SalesUIController salesController, ThirdPanel thirdPanel) {
		super(frame, url, controller);
		this.frame = frame;
		this.controller = controller;
		this.thirdPanel = thirdPanel;
		this.salesController = salesController;
		salesblService = new SalesController();
		commodityblService = new CommodityController();
		this.addButton();
	}

	public void removeThis(JFrame frame) {
		frame.remove(this);
	}

	public void addButton() {

		cusManage = new MyButton("Image/Sales/Sales_image/客户管理.png", firstX, firstY,
				"Image/Sales/Sales_image/客户管理_stop.png", "Image/Sales/Sales_image/客户管理_press_on.png");
		salesManage = new MyButton("Image/Sales/Sales_image/销售管理.png", firstX - 2, firstY + inter,
				"Image/Sales/Sales_image/销售管理_stop.png", "Image/Sales/Sales_image/销售管理_press_on.png");
		importManage = new MyButton("Image/Sales/Sales_image/进货管理.png", firstX - 1, firstY + 2 * inter,
				"Image/Sales/Sales_image/进货管理_stop.png", "Image/Sales/Sales_image/进货管理_press_on.png");
		saveButton = new MyButton("Image/Sales/save/saveCheck.png", firstX - 2, firstY + 3 * inter,
				"Image/Sales/save/saveCheck_stop.png", "Image/Sales/save/saveCheck_press_on.png");
		firstBack = new MyButton("Image/Sales/Sales_image/返回.png", 13, 21, "Image/Sales/Sales_image/返回.png",
				"Image/Sales/Sales_image/返回_press_on.png");
		refresh = new MyButton("Image/refresh.png", 70, 555, "Image/refresh_stop.png", "Image/refresh_stop.png");
		this.add(refresh);
		this.add(firstBack);
		this.add(cusManage);
		this.add(salesManage);
		this.add(importManage);
		this.add(saveButton);
		firstBack.addMouseListener(listener);
		cusManage.addMouseListener(listener);
		salesManage.addMouseListener(listener);
		importManage.addMouseListener(listener);
		refresh.addMouseListener(listener);
		saveButton.addMouseListener(listener);
	}

	public void addWarn() {
		warn = new MyButton("Image/Commodity/button/warn.png", 26, 549, "Image/Commodity/button/warn.png",
				"Image/Commodity/button/warn.png");
		this.add(warn);
		warn.addMouseListener(listener);
	}

	private void setTable(ArrayList<String> info) {
		showTable = new MyTable();
		showTable.setColor(colors.saleColor, colors.greyFont, colors.salesBkColor, colors.greyFont);
		showTable.setTable(info);
		thirdPanel.add(MyTable.tablePanel);
		salesController.backPanel(this);
	}

	public void setCustomer() {
		ArrayList<CustomerVO> cusVO = salesblService.getAllCustomer_up();
		String classification = "进货商";
		//false代表进货商，true代表销售商
		ArrayList<String> cusStr = new ArrayList<String>();
		cusStr.add("编号;分类;级别;姓名;电话;地址;邮编;电子邮箱;应收额度;应收;应付;业务员");
		for (int i = 0; i < cusVO.size(); i++) {
			CustomerVO customerVO = cusVO.get(i);
			if (customerVO.classification == true) {
				System.out.println(customerVO.cusName+" "+customerVO.classification);
				classification = "销售商";
			} else{
				System.out.println(customerVO.cusName+" "+customerVO.classification);
				classification = "进货商";
			}
			String item = customerVO.id + ";" + classification + ";" + customerVO.level + ";" + customerVO.cusName
					+ ";" + customerVO.tel + ";" + customerVO.address + ";" + customerVO.zipCode + ";"
					+ customerVO.ezipCode + ";" + customerVO.mostOwe + ";" + customerVO.shouldGet + ";"
					+ customerVO.shouldPay + ";" + customerVO.person;
			cusStr.add(item);
		}
		setTable(cusStr);
	}

	class FirstButtonListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == firstBack) {
				frame.remove(SalesManagerPanel.this);
				controller.backLoginPanel();
				frame.repaint();
			} else if (e.getSource() == refresh) {
				commodityVO = commodityblService.getAllWarnGood_up();
				if (commodityVO.size() == 0) {
				} else {
					addWarn();
				}
				SalesManagerPanel.this.repaint();
			} else if (e.getSource() == warn) {
				ArrayList<String> commodityStr = new ArrayList<String>();
				commodityStr.add("商品编号;商品名称;商品型号;库存数量;警戒数量");
				for (int i = 0; i < commodityVO.size(); i++) {
					CommodityVO commodityItem = commodityVO.get(i);
					String item = commodityItem.id + ";" + commodityItem.name + ";" + commodityItem.type + ";"
							+ commodityItem.num + ";" + commodityItem.warn;
					commodityStr.add(item);
				}
				thirdPanel.removeAll();
				setTable(commodityStr);
				SalesManagerPanel.this.remove(warn);
			} else if (e.getSource() == cusManage) {
				setCustomer();
			}else if(e.getSource() == saveButton) {
				// 获得所有的草稿进货退货单
				//public ArrayList<ImportMenuVO> getAllDraftImport_Return_up();
				ArrayList<ImportMenuVO> draftIm = salesblService.getAllDraftImport_up();
				ArrayList<ImportMenuVO> draftImBack = salesblService.getAllDraftImport_Return_up();
				ArrayList<ExportMenuVO> draftEx = salesblService.getAllDraftExport_up();
				ArrayList<ExportMenuVO> draftExBack = salesblService.getAllDraftExport_Return_up();
				ArrayList<String> draft = new ArrayList<String>();
				draft.add("单据类型;单据编号");
				for(int i =0; i<draftIm.size();i++){
					draft.add("进货单"+";"+draftIm.get(i).note);
				}
				for(int i = 0;i<draftImBack.size();i++){
					draft.add("进货退货单"+";"+draftImBack.get(i).note);
				}
				for(int i =0; i<draftEx.size();i++){
					draft.add("销售单"+";"+draftEx.get(i).note);
				}
				for(int i =0; i<draftExBack.size();i++){
					draft.add("进货退货单"+";"+draftExBack.get(i).note);
				}
				setTable(draft);
			}
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == cusManage) {
				salesController.toCusPanel();
			} else if (e.getSource() == salesManage) {
				thirdPanel.removeAll();
				salesController.toSalesPanel();
			} else if (e.getSource() == importManage) {
				thirdPanel.removeAll();
				salesController.toImPanel();
			}
		}

		public void mouseExited(MouseEvent e) {
		}

	}

}
