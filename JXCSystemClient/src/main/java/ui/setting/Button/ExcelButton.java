package ui.setting.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import businesslogic.financialbl.FinancialController;
import businesslogicservice.financialblservice.FinancialblService;
import ui.FatherPanel;
import ui.setting.ThirdPanel;
import vo.ConditionVO;
import vo.SaleListConditionVO;
import vo.SalesDetailVO;
import vo.bill.AllBillConditionVO;
import vo.bill.AllBillVO;

public class ExcelButton extends MyButton implements ActionListener{
	FinancialblService financialblService = new FinancialController();
	ArrayList<AllBillVO> allBillVOs = new ArrayList<AllBillVO>();
	ArrayList<SalesDetailVO> salesDetailVOs = new ArrayList<SalesDetailVO>();
	ArrayList<ConditionVO> conditionVOs = new ArrayList<ConditionVO>();
	public MyButton excel;
	
	public ExcelButton(ArrayList<AllBillVO> allBillVOs) {
	excel = new MyButton("Image/Manager/button/proManage/approve.png", 290, 450,
			"Image/Manager/button/proManage/approve_stop.png", "Image/Manager/button/proManage/approve.png");	
//		excel = new MyButton("Image/output.png", 10, 10, "Image/output_stop.png", "Image/output_stop.png");
		this.allBillVOs = allBillVOs;
		this.setActionCommand("allBill");
		this.addActionListener(this);
	}
	
	public ExcelButton(ArrayList<SalesDetailVO> salesDetailVOs,int i) {
		excel = new MyButton("Image/output.png", 350, 450, "Image/output_stop.png", "Image/output_stop.png");	
		this.salesDetailVOs = salesDetailVOs;
		this.setActionCommand("saleList");
		this.addActionListener(this);
	}

	public ExcelButton(ArrayList<ConditionVO> conditionVOs,String s) {
		excel = new MyButton("Image/output.png", 350, 450, "Image/output_stop.png", "Image/output_stop.png");	
		this.conditionVOs = conditionVOs;
		this.setActionCommand("opeCon");
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("allBill")){
			financialblService.allBillExcel_up(allBillVOs);
		}else if (e.getActionCommand().equals("saleList")) {
			financialblService.saleListExcel_up(salesDetailVOs);
		}else if (e.getActionCommand().equals("opeCon")) {
			financialblService.operatingConditionExcel_up(conditionVOs);
		}
		
		
	}
	
}
