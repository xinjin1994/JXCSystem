package ui.account.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.MyFrame;
import ui.setting.MyLabel;
import ui.setting.MyTable;
import ui.setting.Button.ForwardButton;
import ui.setting.Button.MyButton;
import ui.setting.TextField.MyTextFieldBorder;
import vo.SalesDetailVO;
import businesslogic.financialbl.FinancialController;
import businesslogicservice.financialblservice.FinancialblService;
/**
 * 销售明细查询panel
 * 查找结束后返回主界面，列表显示信息
 * @author ZYC
 *
 */
public class SalesListPanel extends FatherPanel implements ActionListener{
	private AccountAllUIController accountController;
	private ManagerAllUIController managerController;
	private MyTable showTable;
	private MyButton forwardButton;
	private ColorFactory colors;
	private MyTextFieldBorder timeBegin,timeFinish,commodity,stock,customer,agent;
	private FinancialblService financialblService;
	private MyFrame frame;
	private String type = "account";
	private MyLabel failLabel;
	
	public SalesListPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.accountController = uiController;
		colors = new ColorFactory();
		financialblService = new FinancialController();
		this.frame = frame;
		this.repaint();
		
		uiController.setBack_second(this,146,57);
		addLabel();
		init();
		
	}
	
	public SalesListPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		
		this.type = type;
		this.managerController = uiController;
		this.frame = frame;
		this.repaint();
		
		uiController.setBack_second(this,146,57);
		init();
	}
	
	private void init(){
		setForward();
		setTextField();
		
	}
	private void setForward() {
		ForwardButton forward = new ForwardButton(677,492);
		forwardButton = forward.forward_white;
		
		this.add(forwardButton);
		forwardButton.addActionListener(this);
		
	}
	private void setTextField() {
		timeBegin = new MyTextFieldBorder(293,130);
		timeFinish = new MyTextFieldBorder(293,194);
		commodity = new MyTextFieldBorder(293, 269);
		stock = new MyTextFieldBorder(293,344);
		customer = new MyTextFieldBorder(293, 418);
		agent = new MyTextFieldBorder(293, 495);
		
		MyTextFieldBorder []typeIn = new MyTextFieldBorder[]{timeBegin,timeFinish,
				commodity,stock,customer,agent};
		
		for(int i = 0;i < typeIn.length;i++){
			typeIn[i].setForeground(new ColorFactory().greyFont);
			this.add(typeIn[i]);
		}
		
	}
	private void setTable(ArrayList<String> info){
		showTable = new MyTable();
		showTable.setColor(colors.accTableColor,colors.greyFont,colors.accColor,colors.greyFont);
		showTable.setTable(info);
		frame.remove(this);
		frame.add(showTable.tablePanel);
		accountController.addMainPanel();
		frame.repaint();
	}
	
	public void addLabel() {
		failLabel = new MyLabel(293, 550, 200, 35);
		this.add(failLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			
			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();
			String good_name = commodity.getText();
			String customer_name = customer.getText();
			String clerk = agent.getText();
			SimpleDateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			boolean isLegal = true;
			try{
				dateFormat.parse(time1);
				isLegal = true;
			}catch(Exception e2){
				isLegal = false;
			}
			
			if(time1.equals("")||time2.equals("")||good_name.equals("")||customer_name.equals("")
					||clerk.equals("")||isLegal == false){
				failLabel.setText("请正确输入信息！");
			}else{
			try{
			int warehouse = Integer.parseInt(stock.getText());
			frame.remove(this);
			ArrayList<SalesDetailVO> salesArray = financialblService.saleList_up(time1,
					time2, good_name, "", customer_name, clerk, warehouse);
			ArrayList<String> sales = new ArrayList<String>();
			sales.add("时间;商品名称;型号;数量;单价;总额");
			for(int i=0;i<salesArray.size();i++){
				String salesItem = salesArray.get(i).time+";"+salesArray.get(i).commodityName+";"+salesArray.get(i).type
						+";"+salesArray.get(i).num+";"+salesArray.get(i).unitPrice+";"+salesArray.get(i).total;
				sales.add(salesItem);
			}
			if(type.equals("account")){
				
				setTable(sales);
//				frame.setPanel(accountController.getMainPanel());
			}else if(type.equals("manager")){
//				frame.setPanel(managerController.getMainPanel());
				setTable(sales);
				}
			}catch(Exception e2){
				failLabel.setText("请正确输入信息！");
			}
			}
			frame.repaint();
		}
	}
}
