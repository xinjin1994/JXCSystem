package businesslogic.financialbl;

import java.util.ArrayList;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;
import dataservice.financialdataservice.FinancialDataService;

public class MockFinancialData implements FinancialDataService{
	
	public ArrayList<SaleListPO> arraySale=new ArrayList<SaleListPO>();
	public ArrayList<AllBillPO> arrayAll=new ArrayList<AllBillPO>();
	public ArrayList<OperatingConditionPO> arrayOpe=new ArrayList<OperatingConditionPO>();

	public SaleListPO[] getSaleList() {
		// TODO Auto-generated method stub
		SaleListPO[] sale=new SaleListPO[1];
		sale[0]=arraySale.get(0);
		return sale;
	}

	public AllBillPO[] getAllBill() {
		// TODO Auto-generated method stub
		AllBillPO[] all=new AllBillPO[1];
		all[0]=arrayAll.get(0);
		return all;
	}

	public OperatingConditionPO[] getOperatingCondition() {
		// TODO Auto-generated method stub
		OperatingConditionPO[] ope=new OperatingConditionPO[1];
		ope[0]=arrayOpe.get(0);
		return ope;
	}

	public boolean addSaleList(SaleListPO po) {
		// TODO Auto-generated method stub
		arraySale.add(po);
		return true;
	}

	public boolean addAllBill(AllBillPO po) {
		// TODO Auto-generated method stub
		arrayAll.add(po);
		return true;
	}

	public boolean addOperatingCondition(OperatingConditionPO po) {
		// TODO Auto-generated method stub
		arrayOpe.add(po);
		return true;
	}

	public boolean clear() {
		// TODO Auto-generated method stub
		arraySale.clear();
		arrayAll.clear();
		arrayOpe.clear();
		return true;
	}

}
