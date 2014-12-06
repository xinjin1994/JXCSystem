package data.salesdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import dataservice.salesdataservice.SalesDataService;

public class SaleDataService_Stub implements SalesDataService{
//	public SaleDataService_Stub(String address, String clerk, int amount,
//			int money, String mail, String zip, String phone, String type,
//			int level, int id) {
//		this.address = address;
//		this.clerk = clerk;
//		this.amount = amount;
//		this.money = money;
//		this.mail = mail;
//		this.zip = zip;
//		this.phone = phone;
//		this.type = type;
//		this.level = level;
//		this.id = id;
//	}
//
//	String address;
//	String clerk;
//	int amount;
//	int money;
//	String mail;
//	String zip;
//	String phone;
//	String type;
//	int level;
//	int id;

	public boolean addCustomer(CustomerPO po) {
		return true;
	}

	public boolean delCustomer(CustomerPO po) {
		return true;
	}

	public boolean updateCustomer(CustomerPO po1, CustomerPO po2) {
		return true;
	}

	public CustomerPO findCustomer(String name) {
		return new CustomerPO("1", name,1, false, "phone", "zip", "mail", 1000, 2000, "clerk", "address");
	}

	public boolean addImport(ImportPO po) {
		return true;
	}

	public boolean addImport_Return(Import_ReturnPO po) {
		return true;
	}

	public boolean addExport(ExportPO po) {
		return true;	}

	public boolean addExport_Return(Export_ReturnPO po) {
		return true;
	}

	public ArrayList<CustomerPO> getAllCustomer() {
		return new ArrayList<CustomerPO>();
	}

	public ArrayList<ImportPO> getAllImport() {
		return new ArrayList<ImportPO>();
	}

	public ArrayList<Import_ReturnPO> getAllImport_Return() {
		return new ArrayList<Import_ReturnPO>();
	}

	public ArrayList<ExportPO> getAllExport() {
		return new ArrayList<ExportPO>();
	}

	public ArrayList<Export_ReturnPO> getAllExport_Return() {
		return new ArrayList<Export_ReturnPO>();
	}

	public boolean clear() {
		return true;
	}

	public boolean addDraftImport(ImportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addDraftImport_Return(Import_ReturnPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addDraftExport(ExportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addDraftExport_Return(Export_ReturnPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ImportPO> getAllDraftImport() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Import_ReturnPO> getAllDraftImport_Return()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ExportPO> getAllDraftExport() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Export_ReturnPO> getAllDraftExport_Return()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportPO getImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportPO getDraftImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Import_ReturnPO getImport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Import_ReturnPO getDraftImport_Return(String note)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportPO getExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExportPO getDraftExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Export_ReturnPO getExport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Export_ReturnPO getDraftExport_Return(String note)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delDraftImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftImport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftExport_Reutrn(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public String getCustomerNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImportNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImport_ReturnNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExportNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExport_ReturnNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
