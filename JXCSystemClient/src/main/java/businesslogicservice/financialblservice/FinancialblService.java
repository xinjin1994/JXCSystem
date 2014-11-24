package businesslogicservice.financialblservice;

public interface FinancialblService {
	public String saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse);

	public String allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse);

	public String operatingCondition(String time1, String time2);

}
