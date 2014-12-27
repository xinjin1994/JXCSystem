package businesslogicservice.financialblservice;

import java.util.ArrayList;

import vo.ConditionVO;
import vo.SaleListConditionVO;
import vo.SalesDetailVO;
import vo.bill.AllBillConditionVO;
import vo.bill.AllBillVO;

public interface FinancialblService {
	
	//查看销售明细
	public ArrayList<SalesDetailVO> saleList_up(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, String warehouse);

	//查看经营历程
	public ArrayList<AllBillVO> allBill_up(String time1, String time2, String note_type,
			String customer_name, String clerk, String warehouse);

	//查看经营情况
	public ArrayList<ConditionVO> operatingCondition_up(String start_time, String end_time);

	//销售记录导出，未实现
	public int saleListExcel_up(ArrayList<SalesDetailVO> saleList_condition);
	
	//经营历程导出，未实现
	public int allBillExcel_up(ArrayList<AllBillVO> allBill_condition);
	
	//经营情况导出，未实现
	public int operatingConditionExcel_up(ArrayList<ConditionVO> oprating_condition);
	
	//单据的红冲操作
	public int redRush_up(AllBillVO allBill);
	
	//查看操作人员权限，true为有权限红冲
	public boolean hasPower_up();
	
	//获得操作员身份
	public String getOperator_up();
	
}
