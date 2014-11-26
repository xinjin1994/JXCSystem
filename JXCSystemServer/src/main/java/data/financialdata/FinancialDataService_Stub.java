package data.financialdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;
import dataservice.financialdataservice.FinancialDataService;

public class FinancialDataService_Stub extends UnicastRemoteObject implements FinancialDataService{

	public FinancialDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

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
