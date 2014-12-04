package businesslogicservice.financialblservice;

import java.util.ArrayList;

import vo.AllBillVO;
import vo.ConditionVO;
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
	public int saleListExcel_up();
	
	//经营历程导出，未实现
	public int allBillExcel_up();
	
	//经营情况导出，未实现
	public int operatingConditionExcel_up(String start_time,String end_time);
}
