package ui;

import ui.account.AccountAllUIController;
import ui.admin.AdminAllUIController;
import ui.commodity.CommodityAllUIController;
import ui.manager.ManagerAllUIController;
//import ui.sales.SalesAllUIController;
import ui.sales.SalesUIController;
import ui.setting.MyFrame;

public class UIController {

	private MyFrame frame;
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private AdminPanel admin;
	private AccountPanel accountPanel; // 财务管理界面
	private FinPersonPanel financialPerson; // 财务人员界面
	private ManagerPanel manager;
	private SalesPersonPanel salesPerson;
	
	
	static private FatherPanel tempMainPanel;
	public FatherPanel prePanel;
//	public UIController(){
//		
//	}
	public UIController() {

		this.frame = new MyFrame();
//	    this.welcomePanel();
//	    this.SalesManagerPanel();
	}
	
	public UIController(int i){
		this.frame = new MyFrame();

		this.CommodityPanel();
//	  	this.AccountPanel();
//		this.AccountPanel();

		this.SalesManagerPanel();

//		this.AdminPanel();

	}

	public void welcomePanel() {
		welcomePanel = new WelcomePanel(frame,"Image/welcome.jpg",this);
		frame.setPanel(welcomePanel);
	}

	public void loginPanel() {
		frame.remove(welcomePanel);
		loginPanel = new LoginPanel(frame,"Image/login.jpg",this);		
		frame.setPanel(loginPanel);
		frame.repaint();
	}
	public void backLoginPanel() {
		loginPanel = new LoginPanel(frame,"Image/login.jpg",this);
		frame.setPanel(loginPanel);
	}

	public void SalesManagerPanel() {
//		frame.remove(loginPanel);
		new SalesUIController(this, frame);
	}
	
	public void AdminPanel() {
	//	frame.remove(loginPanel);
		new AdminAllUIController(this, frame);
		frame.repaint();
	}
	

	public void AccountPanel() {
	//	frame.remove(loginPanel);
		new AccountAllUIController(this,frame);
		frame.repaint();
	}

	public void ManagerPanel() {
	//	frame.remove(loginPanel);
		new ManagerAllUIController(this, frame);
		frame.repaint();
	}
	
	public void FinPersonPanel() {
		financialPerson = new FinPersonPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(financialPerson);
	}

	public void CommodityPanel() {
//		frame.remove(loginPanel);
		new CommodityAllUIController(this, frame);
		frame.repaint();
	}
	
	public void FinManagerPanel() {
		//强迫症患者帮你们改bug o(╯□╰)o
		//qiang po zheng huan zhe bang ni men gai bug o(╯□╰)o
	}


	public void SalesPersonPanel() {
		salesPerson = new SalesPersonPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(salesPerson);
	}

	
	public void setMainPanel(FatherPanel mainPanel){
		tempMainPanel = mainPanel;
	}
	
	public FatherPanel getMainPanel(){
		return tempMainPanel;
	}



}
