package ui;

import ui.account.AccountUIController;
import ui.admin.AdminUIController;
import ui.commodity.CommodityUIController;
import ui.manager.ManagerUIController;
import ui.sales.SalesUIController;

public class UIController {

	private MyFrame frame;
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private AdminPanel admin;
	private AccountPanel accountPanel; // 财务管理界面
	private FinPersonPanel financialPerson; // 财务人员界面
	private ManagerPanel manager;
	private SalesPersonPanel salesPerson;
	public UIController() {
		this.frame = new MyFrame();
	    this.welcomePanel();
//	    this.SalesManagerPanel();
	}
	
	public UIController(int i){
		this.frame = new MyFrame();
		this.SalesManagerPanel();
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

	public void SalesManagerPanel() {
		System.out.println("Imhere");
		
		frame.remove(loginPanel);
		new SalesUIController(this, frame);
		frame.repaint();
	}
	public void AdminPanel() {
		frame.remove(loginPanel);
		new AdminUIController(this, frame);
		frame.repaint();
	}
	

	public void AccountPanel() {
		frame.remove(loginPanel);
		new AccountUIController(this,frame);
		frame.repaint();
	}

	public void ManagerPanel() {
		frame.remove(loginPanel);
		new ManagerUIController(this, frame);
		frame.repaint();
	}
	
	public void FinPersonPanel() {
		financialPerson = new FinPersonPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(financialPerson);
	}

	public void CommodityPanel() {
		frame.remove(loginPanel);
		new CommodityUIController(this, frame);
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




}
