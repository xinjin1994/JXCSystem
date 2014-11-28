package ui;

public class UIController {

	private MyFrame frame;
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private AdminPanel admin;
	private FinManagerPanel financialManager; // 财务管理界面
	private FinPersonPanel financialPerson; // 财务人员界面
	private ManagerPanel manager;
	private SalesManagerPanel salesManager;
	private SalesPersonPanel salesPerson;
	private StockPersonPanel stockPerson;

	public UIController() {
		this.frame = new MyFrame();
	    this.welcomePanel();
	    //this.loginPanel();
	}

	public void welcomePanel() {
		welcomePanel = new WelcomePanel("Image/welcome.jpg", this);
		frame.setPanel(welcomePanel);
	}

	public void loginPanel() {
		frame.remove(welcomePanel);
		frame.repaint();
		loginPanel = new LoginPanel("Image/login.jpg", this);
		frame.setPanel(loginPanel);
	}

	public void AdminPanel() {
		admin = new AdminPanel(" ", this);
		frame.remove(loginPanel);
		frame.setPanel(admin);
	}

	public void FinManagerPanel() {
		financialManager = new FinManagerPanel(" ", this);
		frame.remove(loginPanel);
		frame.setPanel(financialManager);
	}

	public void FinPersonPanel() {
		financialPerson = new FinPersonPanel(" ", this);
		frame.remove(loginPanel);
		frame.setPanel(financialPerson);
	}

	public void ManagerPanel() {
		manager = new ManagerPanel("", this);
		frame.remove(loginPanel);
		frame.setPanel(manager);
	}

	public void SalesManagerPanel() {
		salesManager = new SalesManagerPanel("", this);
		frame.remove(loginPanel);
		frame.setPanel(salesManager);
	}

	public void SalesPersonPanel() {
		salesPerson = new SalesPersonPanel("", this);
		frame.remove(loginPanel);
		frame.setPanel(salesPerson);
	}

	public void StockPersonPanel() {
		stockPerson = new StockPersonPanel("", this);
		frame.remove(loginPanel);
		frame.setPanel(stockPerson);
	}


}
