package businesslogic.financialbl;

import businesslogicservice.financialblservice.FinancialblService;

public class FinancialController implements FinancialblService{
	
	public Financial financial=new Financial();

	public String saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse) {
		// TODO Auto-generated method stub
		return financial.saleList(time1, time2, good_name, good_type, customer_name, clerk, warehouse);
	}

	public String allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse) {
		// TODO Auto-generated method stub
		return financial.allBill(time1, time2, note_type, customer_name, clerk, warehouse);
	}

	public String operatingCondition(String time1, String time2) {
		// TODO Auto-generated method stub
		return financial.operatingCondition(time1, time2);
	}

}
