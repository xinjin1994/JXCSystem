package data.financialdata;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;
import dataservice.financialdataservice.FinancialDataService;

public class FinancialDataService_Stub implements FinancialDataService{

	public SaleListPO[] getSaleList() {
		return new SaleListPO[1];
	}

	public AllBillPO[] getAllBill() {
		return new AllBillPO[1];
	}

	public OperatingConditionPO[] getOperatingCondition() {
		return new OperatingConditionPO[1];
	}

	public boolean addSaleList(SaleListPO po) {
		return true;
	}

	public boolean addAllBill(AllBillPO po) {
		return true;
	}

	public boolean addOperatingCondition(OperatingConditionPO po) {
		return true;
	}

	public boolean clear() {
		return true;
	}

}
