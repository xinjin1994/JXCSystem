package businesslogicservice.financialblservice;

public interface FinancialblService {
	
	//查看销售明细
	public String saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse);

	//查看经营历程
	public String allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse);

	//查看经营情况
	public String operatingCondition(String time1, String time2);

}
