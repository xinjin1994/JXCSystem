package data.salesdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PaymentPO;
import dataservice.salesdataservice.SalesDataService;

public class SalesDataService_Stub extends UnicastRemoteObject implements SalesDataService{
	
	
	ArrayList<CustomerPO> customerList=new ArrayList<CustomerPO>();
	ArrayList<ImportPO> importList=new ArrayList<ImportPO>();
	ArrayList<ExportPO> exportList=new ArrayList<ExportPO>();
	ArrayList<Import_ReturnPO> import_returnList=new ArrayList<Import_ReturnPO>();
	ArrayList<Export_ReturnPO> export_returnList=new ArrayList<Export_ReturnPO>();
	
	public void writeCustomerList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("customerList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(customerList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readCustomerList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("customerList.out");
			ois=new ObjectInputStream(fis);
			customerList=(ArrayList<CustomerPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writeImportList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("importList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(importList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readImportList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("importList.out");
			ois=new ObjectInputStream(fis);
			importList=(ArrayList<ImportPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writeImport_ReturnList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("import_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(import_returnList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readImport_ReturnList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("import_returnList.out");
			ois=new ObjectInputStream(fis);
			import_returnList=(ArrayList<Import_ReturnPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writeExportList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("exportList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(exportList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readExportList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("exportList.out");
			ois=new ObjectInputStream(fis);
			exportList=(ArrayList<ExportPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writeExport_ReturnList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("export_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(export_returnList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readExport_ReturnList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("export_returnList.out");
			ois=new ObjectInputStream(fis);
			export_returnList=(ArrayList<Export_ReturnPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
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
