package dataservice.salesdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PaymentPO;
import po.ReceiptPO;

public interface SalesDataService extends Remote {
	public boolean addCustomer(CustomerPO po) throws RemoteException;

	public boolean delCustomer(CustomerPO po) throws RemoteException;

	public boolean updateCustomer(CustomerPO po1, CustomerPO po2)
			throws RemoteException;

	public CustomerPO findCustomer(String name) throws RemoteException;

	public String getCustomerNote() throws RemoteException;

	public ArrayList<CustomerPO> getAllCustomer() throws RemoteException;

	/*
	 * 我是没完成的分割线
	 */

	public boolean addImport(ImportPO po) throws RemoteException;

	public boolean addImport_Return(Import_ReturnPO po) throws RemoteException;

	public boolean addDraftImport(ImportPO po) throws RemoteException;

	public boolean addDraftImport_Return(Import_ReturnPO po)
			throws RemoteException;

	public boolean addDraftExport(ExportPO po) throws RemoteException;

	public boolean addDraftExport_Return(Export_ReturnPO po)
			throws RemoteException;

	public boolean addExport(ExportPO po) throws RemoteException;

	public boolean addExport_Return(Export_ReturnPO po) throws RemoteException;

	public boolean delDraftImport(String note) throws RemoteException;

	public boolean delDraftImport_Return(String note) throws RemoteException;

	public boolean delDraftExport(String note) throws RemoteException;

	public boolean delDraftExport_Reutrn(String note) throws RemoteException;

	public ArrayList<ImportPO> getAllImport() throws RemoteException;

	public ArrayList<Import_ReturnPO> getAllImport_Return()
			throws RemoteException;

	public ArrayList<ImportPO> getAllDraftImport() throws RemoteException;

	public ArrayList<Import_ReturnPO> getAllDraftImport_Return()
			throws RemoteException;

	public ArrayList<ExportPO> getAllDraftExport() throws RemoteException;

	public ArrayList<Export_ReturnPO> getAllDraftExport_Return()
			throws RemoteException;

	public ArrayList<ExportPO> getAllExport() throws RemoteException;

	public ArrayList<Export_ReturnPO> getAllExport_Return()
			throws RemoteException;

	public ImportPO getImport(String note) throws RemoteException;

	public Import_ReturnPO getImport_Return(String note) throws RemoteException;

	public ImportPO getDraftImport(String note) throws RemoteException;

	public Import_ReturnPO getDraftImport_Return(String note)
			throws RemoteException;

	public ExportPO getDraftExport(String note) throws RemoteException;

	public Export_ReturnPO getDraftExport_Return(String note)
			throws RemoteException;

	public ExportPO getExport(String note) throws RemoteException;

	public Export_ReturnPO getExport_Return(String note) throws RemoteException;

	public String getImportNote() throws RemoteException;

	public String getImport_ReturnNote() throws RemoteException;

	public String getExportNote() throws RemoteException;

	public String getExport_ReturnNote() throws RemoteException;

	public boolean clear() throws RemoteException;

	public int getImport_ReturnMaxNumber(String old_note)
			throws RemoteException;

	public int getExport_ReturnMaxNumber(String old_note)
			throws RemoteException;

	public ArrayList<CustomerPO> getAllImportCustomer() throws RemoteException;

	public ArrayList<CustomerPO> getAllExportCustomer() throws RemoteException;

	public boolean passImport(ImportPO importPO) throws RemoteException;

	public boolean passImport_Return(Import_ReturnPO import_ReturnPO)
			throws RemoteException;

	public boolean passExport(ExportPO exportPO) throws RemoteException;

	public boolean passExport_Return(Export_ReturnPO export_ReturnPO)
			throws RemoteException;

	public boolean refuseImport(String note) throws RemoteException;

	public boolean refuseImport_Return(String note) throws RemoteException;

	public boolean refuseExport(String note) throws RemoteException;

	public boolean refuseExport_Return(String note) throws RemoteException;

	public boolean passReceipt(ReceiptPO receiptPO) throws RemoteException;

	public boolean passPayment(PaymentPO paymentPO) throws RemoteException;

	public String getImportOldNote(String cusName, String name, String type)
			throws RemoteException;

	public String getExportOldNote(String cusName, String name, String type)throws RemoteException;
}
