package data.salesdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import dataservice.salesdataservice.SalesDataService;

public class SalesDataService_Stub extends UnicastRemoteObject implements SalesDataService{
public SalesDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

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
		return new CustomerPO(1, name,1, "type", "phone", "zip", "mail", 1000, 2000, "clerk", "address");
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

	public CustomerPO[] getAllCustomer() {
		return new CustomerPO[1];
	}

	public ImportPO[] getAllImport() {
		return new ImportPO[1];
	}

	public Import_ReturnPO[] getAllImport_Return() {
		return new Import_ReturnPO[1];
	}

	public ExportPO[] getAllExport() {
		return new ExportPO[1];
	}

	public Export_ReturnPO[] getAllExport_Return() {
		return new Export_ReturnPO[1];
	}

	public boolean clear() {
		return true;
	}

}
