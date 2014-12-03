package businesslogicservice.financialblservice;

import java.util.ArrayList;

import vo.AllBillVO;
import vo.ConditionVO;
import vo.SalesDetailVO;

public interface FinancialblService {
	
	//查看销售明细
	public ArrayList<SalesDetailVO> saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse);

	//查看经营历程
	public ArrayList<AllBillVO> allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse);

	//查看经营情况
	public ConditionVO operatingCondition(String time1, String time2);

}
