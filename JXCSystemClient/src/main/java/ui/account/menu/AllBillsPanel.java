package ui.account.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.account.AccountAllUIController;
import ui.setting.ColorFactory;
import ui.setting.FatherPanel;
import ui.setting.ForwardButton;
import ui.setting.MyButton;
import ui.setting.MyFrame;
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
	AccountAllUIController uiController;
	MyButton forwardButton;
	MyTextFieldBorder timeBegin,timeFinish,stock,billType,customer,agent;
	FinancialblService financialblService;
	
	public AllBillsPanel(MyFrame frame,String url,
			AccountAllUIController uiController){
		super(frame,url,uiController);
		this.uiController = uiController;
		this.repaint();
		financialblService = new FinancialController();
		uiController.setBack_second(this,141,57);
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
				stock,billType,customer,agent};
		
		for(int i = 0;i < typeIn.length;i++){
			typeIn[i].setForeground(new ColorFactory().greyFont);
			this.add(typeIn[i]);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == forwardButton){
			////查看经营历程
			//public ArrayList<AllBillVO> allBill_up(String time1, String time2, String note_type,
				//	String customer_name, String clerk, int warehouse);
			String time1 = timeBegin.getText();
			String time2 = timeFinish.getText();
			String note_type = billType.getText();
			String customer_name = customer.getText();
			String clerk = agent.getText();
			int warehouse = Integer.parseInt(stock.getText());
			ArrayList<String> bills = new ArrayList<String>();
//			bills.add("时间;商品;名称;型号;数量;单价;总额");
			ArrayList<AllBillVO> billsArray = financialblService.allBill_up(time1, time2, note_type, 
					customer_name, clerk, warehouse);
			//TODO 因为allbillvo太奇怪了 不知道这里该做什么( ╯□╰ )
			frame.remove(this);
			uiController.addMainPanel();
		}
		
	}
}
