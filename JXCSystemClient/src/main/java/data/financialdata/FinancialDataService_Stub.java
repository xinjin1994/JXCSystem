package data.financialdata;

import java.util.ArrayList;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;
import dataservice.financialdataservice.FinancialDataService;

public class FinancialDataService_Stub implements FinancialDataService{

	public ArrayList<SaleListPO> getSaleList() {
		return new ArrayList<SaleListPO>();
	}

	public ArrayList<AllBillPO> getAllBill() {
		return new ArrayList<AllBillPO>();
	}

	public ArrayList<OperatingConditionPO> getOperatingCondition() {
		return new ArrayList<OperatingConditionPO>();
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
