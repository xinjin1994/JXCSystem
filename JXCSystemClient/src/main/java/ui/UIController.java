package ui;

import ui.account.AccountAllUIController;
import ui.admin.AdminAllUIController;
import ui.commodity.CommodityAllUIController;
import ui.manager.ManagerAllUIController;
//import ui.sales.SalesAllUIController;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;
import ui.setting.SetBack;
/**
 * 各个模块的跳转，控制SalesUIController，AdminAllUIController，CommodityAllUIController，ManagerAllUIController
 * AccountAllUIController
 * @author ZYC
 *
 */
public class UIController {

	static private MyFrame frame;
	private WelcomePanel welcomePanel;
	public LoginPanel loginPanel;
	private ConnectPanel connectPanel;
	private AdminPanel admin;
	private AccountPanel accountPanel; // 财务管理界面
	private ManagerPanel manager;
	
	
	public static AccountAllUIController accountAllUIController;
	public static CommodityAllUIController commodityAllUIController;
	
	static private FatherPanel tempMainPanel,tempPanel,logPanel;
	public FatherPanel prePanel;
	public UIController(){
		this.frame = frame;
	}
	
	public UIController(int i){
		this.frame = new MyFrame();
		this.welcomePanel();
	}

	public void welcomePanel() {
		welcomePanel = new WelcomePanel(frame,"Image/welcome.jpg",this);
		frame.setPanel(welcomePanel);
	}
	
	public void connectPanel(){
		frame.remove(welcomePanel);
		connectPanel = new ConnectPanel(frame, "Image/ip.jpg", this);
		frame.setPanel(connectPanel);
		frame.repaint();
	}

	public void loginPanel() {
		loginPanel = new LoginPanel(frame,"Image/login.jpg",this);		
		frame.setPanel(loginPanel);
		frame.repaint();
	}
	public void backLoginPanel() {
		loginPanel = new LoginPanel(frame,"Image/login.jpg",this);
		frame.setPanel(loginPanel);
	}

	public void SalesManagerPanel() {
		frame.remove(loginPanel);
		new SalesUIController(this, frame);
		
	}
	
	public void AdminPanel() {
		frame.remove(loginPanel);
		new AdminAllUIController(this, frame);
		frame.repaint();
	}
	

	public void AccountPanel() {
		frame.remove(loginPanel);
		accountAllUIController = new AccountAllUIController(this,frame);
		frame.repaint();
	}

	public void ManagerPanel() {
		frame.remove(loginPanel);
		new ManagerAllUIController(this, frame);
		frame.repaint();
	}
	

	public void CommodityPanel() {
		frame.remove(loginPanel);
		commodityAllUIController = new CommodityAllUIController(this, frame);
		frame.repaint();
	}
	
	public void FinManagerPanel() {
		//强迫症患者帮你们改bug o(╯□╰)o
		//qiang po zheng huan zhe bang ni men gai bug o(╯□╰)o
	}
	
	public void setMainPanel(FatherPanel mainPanel){
		this.tempMainPanel = mainPanel;
	}
	
	public FatherPanel getMainPanel(){
		return tempMainPanel;
	}
	
	public void setTempPanel(FatherPanel tempPanel){
		this.tempPanel = tempPanel;
	}
	public FatherPanel getPanel(){
		return tempPanel;
	}
	public void setBackBills(FatherPanel prePanel){
		new SetBack(frame, this, prePanel).setBack_first();
	}
	
//	public void setLogInPanel(FatherPanel logInPanel){
//		this.l
//	}



}
