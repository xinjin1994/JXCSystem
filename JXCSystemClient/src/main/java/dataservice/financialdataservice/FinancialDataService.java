package dataservice.financialdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.SaleListPO;

public interface FinancialDataService extends Remote {
	public ArrayList<SaleListPO> getSaleList() throws RemoteException;
	public ArrayList<AllBillPO> getAllBill() throws RemoteException;
	public ArrayList<OperatingConditionPO> getOperatingCondition() throws RemoteException;
	public boolean addSaleList(SaleListPO po) throws RemoteException;
	public boolean addAllBill(AllBillPO po) throws RemoteException;
	public boolean addOperatingCondition(OperatingConditionPO po) throws RemoteException;
	public boolean clear() throws RemoteException;
}
