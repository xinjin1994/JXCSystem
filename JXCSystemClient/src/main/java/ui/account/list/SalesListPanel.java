package ui.account.list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.FatherPanel;
import ui.account.AccountAllUIController;
import ui.manager.ManagerAllUIController;
import ui.setting.ColorFactory;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
import ui.setting.MyTable;
import ui.setting.MyTextFieldBorder;
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
	
	public SalesListPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.accountController = uiController;
		colors = new ColorFactory();
		financialblService = new FinancialController();
		this.frame = frame;
		this.repaint();
		
		uiController.setBack_second(this,146,57);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			frame.remove(this);
			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();
			String good_name = commodity.getText();
			int warehouse = Integer.parseInt(stock.getText());
			String customer_name = customer.getText();
			String clerk = agent.getText();
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
			frame.repaint();
		}
	}
}
