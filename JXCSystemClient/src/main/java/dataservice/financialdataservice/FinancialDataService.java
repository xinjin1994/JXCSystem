package dataservice.financialdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;

public interface FinancialDataService extends Remote {
	public SaleListPO[] getSaleList() throws RemoteException;
	public AllBillPO[] getAllBill() throws RemoteException;
	public OperatingConditionPO[] getOperatingCondition() throws RemoteException;
	public boolean addSaleList(SaleListPO po) throws RemoteException;
	public boolean addAllBill(AllBillPO po) throws RemoteException;
	public boolean addOperatingCondition(OperatingConditionPO po) throws RemoteException;
	public boolean clear() throws RemoteException;
}
