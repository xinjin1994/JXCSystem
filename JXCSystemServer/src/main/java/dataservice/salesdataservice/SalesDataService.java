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
	public ArrayList<CustomerPO> getAllCustomer() throws RemoteException;
	
	public boolean addImport(ImportPO po) throws RemoteException;
	public boolean addDraftImport(ImportPO po) throws RemoteException;
	public boolean addImport_Return(Import_ReturnPO po) throws RemoteException;
	public boolean addDraftImport_Return(Import_ReturnPO po) throws RemoteException;
	public boolean addExport(ExportPO po) throws RemoteException;
	public boolean addDraftExport(ExportPO po) throws RemoteException;
	public boolean addExport_Return(Export_ReturnPO po) throws RemoteException;
	public boolean addDraftExport_Return(Export_ReturnPO po) throws RemoteException;
	public boolean delDraftImport(String note) throws RemoteException;
	public boolean delDraftImport_Return(String note) throws RemoteException;
	public boolean delDraftExport(String note) throws RemoteException;
	public boolean delDraftExport_Reutrn(String note) throws RemoteException; 
	public ArrayList<ImportPO> getAllImport() throws RemoteException;
	public ArrayList<ImportPO> getAllDraftImport() throws RemoteException;
	public ArrayList<Import_ReturnPO> getAllImport_Return() throws RemoteException;
	public ArrayList<Import_ReturnPO> getAllDraftImport_Return() throws RemoteException;
	public ArrayList<ExportPO> getAllExport() throws RemoteException;
	public ArrayList<ExportPO> getAllDraftExport() throws RemoteException;
	public ArrayList<Export_ReturnPO> getAllExport_Return() throws RemoteException;
	public ArrayList<Export_ReturnPO> getAllDraftExport_Return() throws RemoteException;
	public ImportPO getImport(String note) throws RemoteException;
	public ImportPO getDraftImport(String note) throws RemoteException;
	public Import_ReturnPO getImport_Return(String note) throws RemoteException;
	public Import_ReturnPO getDraftImport_Return(String note) throws RemoteException;
	public ExportPO getExport(String note) throws RemoteException;
	public ExportPO getDraftExport(String note) throws RemoteException;
	public Export_ReturnPO getExport_Return(String note) throws RemoteException;
	public Export_ReturnPO getDraftExport_Return(String note) throws RemoteException;
	public boolean clear() throws RemoteException;
}
