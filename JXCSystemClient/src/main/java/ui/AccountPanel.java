package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import businesslogic.invoicebl.InvoiceController;
import businesslogicservice.invoiceblservice.InvoiceblService;
import ui.account.AccountUIController;
import ui.setting.ColorFactory;
import ui.setting.MyTable;
import ui.setting.ThirdPanel;
import ui.setting.Button.ApproveButton;
import ui.setting.Button.MyButton;
import ui.setting.Button.RefreshButton;
import ui.setting.Button.RefuseButton;

//财务经理
public class AccountPanel extends FatherPanel{

	private int firstX = 0;
	private int firstY = 110;
	private int inter = 54;
	
	public ThirdPanel accountThirdPanel;
	MyButton accManage,finManage,recManage,invoiceManage,iniManage;
	private MyButton [] buttons = new MyButton[]{ accManage, finManage, recManage,invoiceManage,iniManage};
	private MyButton refresh;
	private MyTable showTable; 
	private ColorFactory colors = new ColorFactory();
	private AccountUIController accountUIController;
	
	private String images_ori[] = new String[]{"Image/Account/button/accManage.png",
			"Image/Account/button/finManage.png","Image/Account/button/recManage.png",
			"Image/Account/button/invoiceManage.png","Image/Account/button/iniManage.png"};
	private String images_stop[] = new String[]{"Image/Account/button/accManage_stop.png",
			"Image/Account/button/finManage_stop.png","Image/Account/button/recManage_stop.png",
			"Image/Account/button/invoiceManage_stop.png",	"Image/Account/button/iniManage_stop.png"};
	private String images_press_on[] = new String[]{"Image/Account/button/accManage_press_on.png",
			"Image/Account/button/finManage_press_on.png","Image/Account/button/recManage_press_on.png",
			"Image/Account/button/invoiceManage_press_on.png",	"Image/Account/button/iniManage_press_on.png"};
	
	private RefuseButton refuse;
	private ApproveButton approve;
	private InvoiceblService invoiceblService;
	
	public AccountPanel(JFrame frame, String url, UIController controller,
			AccountUIController accountUIController) {
		super(frame, url, controller);
		accountThirdPanel = new ThirdPanel();
		this.add(accountThirdPanel);
		this.accountUIController= accountUIController;
		refuse = new RefuseButton(this);
		approve = new ApproveButton(this);
		invoiceblService = new InvoiceController();
		this.addButton();
		}

	public void addButton() {
		refuse.setLable();
		approve.setLable();
		FirstButtonListener listener = new FirstButtonListener();
		for(int i = 0 ;i < buttons.length;i++){
			buttons[i] = new MyButton(images_ori[i], firstX, firstY +i * inter,
					images_stop[i], images_press_on[i]);
			this.add(buttons[i]);
			buttons[i].addMouseListener(listener);
		}
		
		refresh = new RefreshButton(this).refreshButton;
		this.add(refresh);
		refresh.addMouseListener(listener);

	}
	/**
	 * 该方法用于显示table
	 * @param info 要显示的数据
	 */
	public void setTable(ArrayList<String> info){
		accountThirdPanel.removeAll();
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
		showTable.setTable(info);
		accountThirdPanel.add(showTable.tablePanel);
		accountThirdPanel.repaint();
		this.repaint();
	}
	/**
	 * 该方法用于从下曾获得被审批的单据数据
	 */
	private void getInvoiceInfo() {
		ArrayList <String> info = new ArrayList<String>();
		info.add("a;b;c;e");
		info.add("s,r,t,h");
		info.add("w;t;x;h");
		info.add("gg");
		setTable(info);
	}
	/**
	 * 该方法用于获得当前期初的信息
	 */
	private void getInitialInfo() {
		
	}
	/**
	 * 查看表单最初的表格应该显示什么呢？？？不造啊T-T
	 */
	private void getReceiptInfo() {
		
	}
	/**
	 * 该方法用于获得收款单和付款单的信息，按时间排序
	 */
	private void getFinanceInfo() {
		
	}
	/**
	 * 该方法用于显示当前所有账户的信息，该方法要根据登陆人员的身份判断能否选择
	 */
	private void getAccountInfo() {
		ArrayList <String> info = new ArrayList<String>();
		info.add("a;b;c;e");
		info.add("s,r,t,h");
		info.add("w;t;x;h");
		info.add("gg");
		setTable(info);
	}

	
	class FirstButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if (e.getSource() == refresh){
				if(invoiceblService.show_pass() != null){
					approve.setButton();
					AccountPanel.this.repaint();
				}else if(invoiceblService.show_refuse() != null){
					refuse.setButton();
					AccountPanel.this.repaint();
				}
			}
			 else if(e.getSource() == buttons[0]){
				getAccountInfo();
			}else if(e.getSource() == buttons[1]){
				getFinanceInfo();
			}else if(e.getSource() == buttons[2]){
				getReceiptInfo();
			}else if(e.getSource() == buttons[3]){
				getInvoiceInfo();
			}else if(e.getSource() == buttons[4]){
				getInitialInfo();
			}
		}

	
		public void mouseReleased(MouseEvent e) {
	
		}

		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == buttons[0]) {
				accountUIController.toAccPanel();
			}else if(e.getSource() == buttons[1]) {
				accountUIController.toFinPanel();
			}else if(e.getSource() == buttons[2]) {
				accountUIController.toRecPanel();
			}else if (e.getSource() == buttons[3]) {
				accountUIController.toInvoicePanel();
			}else if (e.getSource() == buttons[4]) {
				accountUIController.toIniPanel();
			}
		}
		public void mouseExited(MouseEvent e) {
		
		}
		
	}
}
