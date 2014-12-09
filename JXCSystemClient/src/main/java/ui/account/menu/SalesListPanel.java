package ui.account.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.AccountPanel;
import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.FatherPanel;
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
	AccountAllUIController uiController;
	MyButton forwardButton;
	MyTextFieldBorder timeBegin,timeFinish,commodity,stock,customer,agent;
	FinancialblService financialblService;
	MyTable showTable;
	MyFrame frame;
	private ColorFactory colors;
	
	public SalesListPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.frame = frame;
		colors = new ColorFactory();
		this.uiController = uiController;
		this.repaint();
		financialblService = new FinancialController();
		uiController.setBack_second(this,146,57);
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
		frame.getContentPane().add(showTable.tablePanel);
		frame.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			//String time1, String time2, String good_name,
			//String good_type, String customer_name, String clerk, int warehouse);
			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();
			String good_name = commodity.getText();
			String customer_name = customer.getText();
			String clerk = agent.getText();
			int warehouse = Integer.parseInt(stock.getText());
			ArrayList<String> sales = new ArrayList<String>();
			sales.add("时间;商品;名称;型号;数量;单价;总额");
			ArrayList<SalesDetailVO> salesArray = financialblService.saleList_up(time1, time2, good_name, "", customer_name, clerk, warehouse);
			//SalesDetailVO(String time,String commodityName,String type,int num,double unitPrice,double total){
	    	  //时间（精确到天），商品名，型号，数量，单价，总额
			for(int i=0;i<salesArray.size();i++){
				String salesItem = salesArray.get(i).time+";"+salesArray.get(i).commodityName+";"+salesArray.get(i).type
						+";"+salesArray.get(i).num+";"+salesArray.get(i).unitPrice+";"+salesArray.get(i).total;
				sales.add(salesItem);
			}
			frame.remove(this);
			setTable(sales);
			uiController.addMainPanel();
		}
	}
}
