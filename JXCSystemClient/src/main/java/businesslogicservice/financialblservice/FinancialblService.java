package businesslogicservice.financialblservice;

import java.util.ArrayList;

import vo.AllBillConditionVO;
import vo.AllBillVO;
import vo.ConditionVO;
import vo.SaleListConditionVO;
import vo.SalesDetailVO;

public interface FinancialblService {
	
	//查看销售明细
	public ArrayList<SalesDetailVO> saleList_up(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse);

	//查看经营历程
	public ArrayList<AllBillVO> allBill_up(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse);

	//查看经营情况
	public ConditionVO operatingCondition_up(String start_time, String end_time);

	//销售记录导出，未实现
	public int saleListExcel_up(SaleListConditionVO saleList_condition);
	
	//经营历程导出，未实现
	public int allBillExcel_up(AllBillConditionVO allBill_condition);
	
	//经营情况导出，未实现
	public int operatingConditionExcel_up(String start_time,String end_time);
	
	//单据的红冲操作
	public int redRush_up(AllBillVO allBill);
	
	//查看操作人员权限，true为有权限红冲
	public boolean hasPower_up();
	
	//获得操作员身份
	public int getClerk_up();
	
}
