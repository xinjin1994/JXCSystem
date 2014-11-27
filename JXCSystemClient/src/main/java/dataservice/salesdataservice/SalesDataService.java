package dataservice.salesdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;

public interface SalesDataService extends Remote {
	public boolean addCustomer(CustomerPO po) throws RemoteException;
	public boolean delCustomer(CustomerPO po) throws RemoteException;
	public boolean updateCustomer(CustomerPO po1,CustomerPO po2) throws RemoteException;
	public CustomerPO findCustomer(String name) throws RemoteException;
	public boolean addImport(ImportPO po) throws RemoteException;
	public boolean addImport_Return(Import_ReturnPO po) throws RemoteException;
	public boolean addExport(ExportPO po) throws RemoteException;
	public boolean addExport_Return(Export_ReturnPO po) throws RemoteException;
	public ArrayList<CustomerPO> getAllCustomer() throws RemoteException;
	public ArrayList<ImportPO> getAllImport() throws RemoteException;
	public ArrayList<Import_ReturnPO> getAllImport_Return() throws RemoteException;
	public ArrayList<ExportPO> getAllExport() throws RemoteException;
	public ArrayList<Export_ReturnPO> getAllExport_Return() throws RemoteException;
	public boolean clear() throws RemoteException;
	
}
