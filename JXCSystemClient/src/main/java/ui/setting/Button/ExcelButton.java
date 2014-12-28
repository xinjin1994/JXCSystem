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
	
	public ExcelButton(ThirdPanel prePanel,ArrayList<AllBillVO> allBillVOs) {
		super("Image/output.png", 10, 10, "Image/output_stop.png", "Image/output_stop.png");
		this.allBillVOs = allBillVOs;
		prePanel.add(this);
		this.setActionCommand("allBill");
		this.addActionListener(this);
	}
	
	public ExcelButton(ThirdPanel prePanel,ArrayList<SalesDetailVO> salesDetailVOs,int i) {
		super("Image/output.png", 400, 390, "Image/output_stop.png", "Image/output_stop.png");
		this.salesDetailVOs = salesDetailVOs;
		prePanel.add(this);
		this.setActionCommand("saleList");
		this.addActionListener(this);
	}

	public ExcelButton(ThirdPanel prePanel,ArrayList<ConditionVO> conditionVOs,String s) {
		super("Image/output.png", 400, 390, "Image/output_stop.png", "Image/output_stop.png");
		this.conditionVOs = conditionVOs;
		prePanel.add(this);
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
