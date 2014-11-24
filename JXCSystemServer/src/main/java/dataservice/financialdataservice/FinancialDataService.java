package dataservice.financialdataservice;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;

public interface FinancialDataService {
	public SaleListPO[] getSaleList();
	public AllBillPO[] getAllBill();
	public OperatingConditionPO[] getOperatingCondition();
	public boolean addSaleList(SaleListPO po);
	public boolean addAllBill(AllBillPO po);
	public boolean addOperatingCondition(OperatingConditionPO po);
	public boolean clear();
}
