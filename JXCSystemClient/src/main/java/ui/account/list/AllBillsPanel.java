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
import vo.AllBillVO;
import businesslogic.financialbl.FinancialController;
import businesslogicservice.financialblservice.FinancialblService;
/**
 * 查询经营历程对话框
 * 查找结束后返回主界面列表显示
 * @author ZYC
 * 
 */
public class AllBillsPanel extends FatherPanel implements ActionListener{
	private AccountAllUIController accountController;
	private ManagerAllUIController managerController;
	FinancialblService financialblService;
	private ColorFactory colors;
	MyTable showTable;
	private MyButton forwardButton;
	private MyTextFieldBorder timeBegin,timeFinish,stock,billType,customer,agent;
	private String itemName,item;
	private String type = "account";
	private MyFrame frame;
	public AllBillsPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		colors = new ColorFactory();
		financialblService = new FinancialController();
		this.accountController = uiController;
		this.frame = frame;
		this.repaint();
		
		uiController.setBack_second(this,141,57);
		init();

	}
	
	public AllBillsPanel(MyFrame frame,String url,
			ManagerAllUIController uiController,String type){
		super(frame,url,uiController);
		this.managerController = uiController;
		this.frame = frame;
		this.type = type;
		this.repaint();
		
		
		uiController.setBack_second(this,141,57);
		init();
	}
	
	private void init(){
		setTextField();
		setForward();
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
		billType = new MyTextFieldBorder(293, 269);
		stock = new MyTextFieldBorder(293,344);
		customer = new MyTextFieldBorder(293, 418);
		agent = new MyTextFieldBorder(293, 495);
	
		MyTextFieldBorder []typeIn = new MyTextFieldBorder[]{timeBegin,timeFinish,
				billType,stock,customer,agent};
		
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
			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();
			String note_type = billType.getText();
			String customer_name = customer.getText();
			String clerk = agent.getText();
			int warehouse = Integer.parseInt(stock.getText());
			ArrayList<AllBillVO> billsArray = financialblService.allBill_up(time1, time2, note_type, 
					customer_name, clerk, warehouse);
			ArrayList<String> bills = new ArrayList<String>();
			bills.add("单据编号;单据类型");
			for(int i=0;i<billsArray.size();i++){
				switch(billsArray.get(i).bill_note) {
				//1代表SendGiftVO，                  2代表ImportVO，  3代表Import_ReturnVO， 4代表ExportVO，
				//5代表Export_ReturnVO， 6代表PatchVO，     7代表ReceiptVO，                      8代表PaymentVO
				case 1:
					itemName = "商品赠送单";
					break;
				case 2:
					itemName = "进货单";
					break;
				case 3:
					itemName = "进货退货单";
					break;
				case 4:
					itemName = "销售单";
					break;
				case 5:
					itemName = "销售退货单";
					break;
				case 6:
					itemName = "报溢报损单";
					break;
				case 7:
					itemName = "收款单";
					break;
				case 8:
					itemName = "付款单";
					break;	
				}
				item = billsArray.get(i).note+itemName;
				bills.add(item);
			}
			setTable(bills);
			frame.remove(this);
			if(type.equals("account")){
//				frame.setPanel(accountController.getMainPanel());
			}else if(type.equals("manager")){
//				frame.setPanel(managerController.getMainPanel());
			}
			frame.repaint();
		}
		
	}
}
