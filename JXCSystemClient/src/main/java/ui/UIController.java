package ui;

import ui.sales.SalesUIController;

public class UIController {

	private MyFrame frame;
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private AdminPanel admin;
	private FinManagerPanel financialManager; // 财务管理界面
	private FinPersonPanel financialPerson; // 财务人员界面
	private ManagerPanel manager;
	private SalesPersonPanel salesPerson;
	private StockPersonPanel stockPerson;
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
		//frame.repaint();
		loginPanel = new LoginPanel(frame,"Image/login.jpg",this);
		frame.setPanel(loginPanel);
		frame.repaint();
	}

	public void SalesManagerPanel() {
		frame.remove(loginPanel);
		new SalesUIController(this, frame);
	}
	public void AdminPanel() {
		admin = new AdminPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(admin);
	}

	public void FinManagerPanel() {
		financialManager = new FinManagerPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(financialManager);
	}

	public void FinPersonPanel() {
		financialPerson = new FinPersonPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(financialPerson);
	}

	public void ManagerPanel() {
		manager = new ManagerPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(manager);
	}


	public void SalesPersonPanel() {
		salesPerson = new SalesPersonPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(salesPerson);
	}

	public void StockPersonPanel() {
		stockPerson = new StockPersonPanel(frame,"",this);
		frame.remove(loginPanel);
		frame.setPanel(stockPerson);
	}


}
