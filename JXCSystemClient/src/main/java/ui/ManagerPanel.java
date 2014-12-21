package ui;

import java.awt.Color;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.invoiceblservice.InvoiceblService;
import ui.manager.ManagerUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.SaveTempBills;
import ui.setting.ThirdPanel;
import ui.setting.Button.MyButton;
import ui.setting.Button.RefreshButton;
import ui.setting.Button.RemindButton;
import ui.setting.resultPanels.ResultPanelController;
import vo.bill.InvoiceVO;
import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.invoiceblservice.InvoiceblService;

/**
 * 6 总经理
 * @author lsy
 * @version 2014年11月28日下午4:21:03
 */
public class ManagerPanel extends FatherPanel{
	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	private MyButton accManage,recManage,invoiceManage,proManage,systemLog,details,refresh;
	private MyButton approveButton,refuseButton;
	private MyButton [] buttons = new MyButton[]{ accManage, recManage,invoiceManage,proManage,systemLog};
	private MyButton back;
	

	public MyTable showTable;
	private MyFrame frame;
	
	public ThirdPanel managerThirdPanel;
	
	private RemindButton remind;
	private ManagerUIController managerUIController;
	
	private ResultPanelController resController;
	
	private String images_ori[] = new String[]{"Image/Manager/button/accManage.png","Image/Manager/button/recManage.png",
			"Image/Manager/button/invoiceManage.png","Image/Manager/button/proManage.png","Image/Manager/button/systemLog.png"};
	private String images_stop[] = new String[]{"Image/Manager/button/accManage_stop.png","Image/Manager/button/recManage_stop.png",
			"Image/Manager/button/invoiceManage_stop.png",	"Image/Manager/button/proManage_stop.png","Image/Manager/button/systemLog_stop.png"};
	private String images_press_on[] = new String[]{"Image/Manager/button/accManage_press_on.png","Image/Manager/button/recManage_press_on.png",
			"Image/Manager/button/invoiceManage_press_on.png",	"Image/Manager/button/proManage_press_on.png","Image/Manager/button/systemLog_press_on.png"};
	
	private ColorFactory color = new ColorFactory();
	private InvoiceblService invoiceblService;
	
	private String failedAddress;

	private SaveTempBills bills;
	public ManagerPanel(MyFrame frame, String url, UIController controller,
			ManagerUIController managerUIController) {
		super(frame, url, controller);
		managerThirdPanel = new ThirdPanel();
		invoiceblService = new InvoiceController();
		
		this.frame = frame;
		this.add(managerThirdPanel);
		this.managerUIController= managerUIController;
		this.failedAddress = "manager";
		
		resController = new ResultPanelController(frame, this);
		remind = new RemindButton(this);
		this.addButton();

		}


	public void addButton() {
		remind.setLable();
		FirstButtonListener listener = new FirstButtonListener();
		for(int i = 0 ;i < buttons.length;i++){
			buttons[i] = new MyButton(images_ori[i], firstX, firstY +i * inter,
					images_stop[i], images_press_on[i]);
			this.add(buttons[i]);
			buttons[i].addMouseListener(listener);
		}
//		details = new MyButton("Image/details.png", 670, 537, "Image/Manager/details_m.png", "Image/Manager/details_m.png");
//		details.addMouseListener(listener);
//		this.add(details);
	
		refresh = new RefreshButton(this).refreshButton;
		this.add(refresh);
		refresh.addMouseListener(listener);
	}
	
	
	private void getProInfo() {
		// TODO Auto-generated method stub
		
	}

	private void getInvoiceInfo() {
		// TODO Auto-generated method stub
		
	}

	private void getRecInfo() {
		// TODO Auto-generated method stub
		
	}

	private void getAccountInfo() {
//		// TODO Auto-generated method stub
//		ArrayList <String> info = new ArrayList<String>();
//		info.add("a;b;c;e");
//		info.add("s,r,t,h");
//		info.add("w;t;x;h");
//		info.add("gg");
//		setTable(info);
	}

	public void setTable(ArrayList<String> info,SaveTempBills bills) {
		this.bills = bills;
		managerThirdPanel.removeAll();
		showTable = new MyTable();
		showTable.setInfo(bills);
		showTable.setColor(color.manTableColor,color.manBkColor, color.manColor,Color.white);
		showTable.setTable(info);
		
		managerThirdPanel.add(showTable.tablePanel);
		managerThirdPanel.repaint();
		this.repaint();
	}
	
	public void setThirdPanelButton(){
		InvoiceButtonListener listener = new InvoiceButtonListener();
		approveButton = new MyButton("Image/Manager/button/proManage/approve.png", 290, 450,
				"Image/Manager/button/proManage/approve_stop.png", "Image/Manager/button/proManage/approve.png");
		refuseButton = new MyButton("Image/Manager/button/proManage/refuse.png", 355, 450,
				"Image/Manager/button/proManage/refuse_stop.png","Image/Manager/button/proManage/refuse.png");
		managerThirdPanel.add(approveButton);
		managerThirdPanel.add(refuseButton);
		
		approveButton.addMouseListener(listener);
		refuseButton.addMouseListener(listener);
		
		managerThirdPanel.repaint();
		this.repaint();
	}
	
	private void check(int i,String type){
		switch(i){
		case 1:
			frame.remove(ManagerPanel.this);
			resController.failed("单据不存在！", failedAddress);
			break;
		case 0:
			frame.remove(ManagerPanel.this);
			resController.succeeded("审批"+type+"该单据！", "manager");
			break;
		case -1:
			frame.remove(ManagerPanel.this);
			resController.failed("审批单据出现错误！请检查操作！",failedAddress);
			break;
		default:
			break;
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
			InvoiceVO temp = bills.getInfo();
			if(temp == null){
				resController.failed("请选中要审批的单据",failedAddress);
			}
			else {
				if(e.getSource() == approveButton){
					check(invoiceblService.pass_up(temp),"通过");
				}else if (e.getSource() == refuseButton) {
					check(invoiceblService.refuse_up(temp.note),"拒绝");
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if (e.getSource() == refresh){
				if(invoiceblService.show_up() != null){
					remind.setButton();
					ManagerPanel.this.repaint();
				}
			}
			else if(e.getSource() == buttons[0]) {
				getAccountInfo();
			}else if(e.getSource() == buttons[1]) {
				getRecInfo();
			}else if(e.getSource() == buttons[2]) {
				getInvoiceInfo();
			}else if (e.getSource() == buttons[3]) {
				getProInfo();
			}else if(e.getSource() == buttons[4]){
				
			}
			
		}


		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				managerUIController.toAccPanel();
			}else if(e.getSource() == buttons[1]) {
				managerUIController.toRecPanel();
			}else if(e.getSource() == buttons[2]) {
				managerUIController.toInvoicePanel();
			}else if (e.getSource() == buttons[3]) {
				managerUIController.toProPanel();
			}
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}
}
