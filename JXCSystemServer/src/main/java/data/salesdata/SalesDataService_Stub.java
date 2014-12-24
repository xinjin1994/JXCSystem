package data.salesdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import po.AccountPO;
import po.CustomerPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PaymentPO;
import po.ReceiptPO;
import data.accountdata.AccountDataService_Stub;
import dataservice.salesdataservice.SalesDataService;

public class SalesDataService_Stub extends UnicastRemoteObject implements
		SalesDataService {

	ArrayList<CustomerPO> customerList = new ArrayList<CustomerPO>();
	ArrayList<ImportPO> importList = new ArrayList<ImportPO>();
	ArrayList<ExportPO> exportList = new ArrayList<ExportPO>();
	ArrayList<Import_ReturnPO> import_returnList = new ArrayList<Import_ReturnPO>();
	ArrayList<Export_ReturnPO> export_returnList = new ArrayList<Export_ReturnPO>();
	ArrayList<ImportPO> draftImportList = new ArrayList<ImportPO>();
	ArrayList<ExportPO> draftExportList = new ArrayList<ExportPO>();
	ArrayList<Import_ReturnPO> draftImport_returnList = new ArrayList<Import_ReturnPO>();
	ArrayList<Export_ReturnPO> draftExport_returnList = new ArrayList<Export_ReturnPO>();

	int jhdNote = 0;
	int xsdNote = 0;
	int jhthdNote = 0;
	int xsthdNote = 0;
	int khbhNote = 0;

	public void writeKHBHNote() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("khbhNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(khbhNote);
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
	public void readKHBHNote() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("khbhNote.out");
			ois = new ObjectInputStream(fis);
			khbhNote = (Integer) ois.readObject();
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

	public void writeXSTHDNote() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("xsthdNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(xsthdNote);
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
	public void readXSTHDNote() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("xsthdNote.out");
			ois = new ObjectInputStream(fis);
			xsthdNote = (Integer) ois.readObject();
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

	public void writeXSDNote() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("xsdNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(xsdNote);
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
	public void readXSDNote() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("xsdNote.out");
			ois = new ObjectInputStream(fis);
			xsdNote = (Integer) ois.readObject();
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

	public void writeJHDNote() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("jhdNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(jhdNote);
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
	public void readJHDNote() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("jhdNote.out");
			ois = new ObjectInputStream(fis);
			jhdNote = (Integer) ois.readObject();
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

	public void writeJHTHDNote() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("jhthdNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(jhthdNote);
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
	public void readJHTHDNote() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("jhthdNote.out");
			ois = new ObjectInputStream(fis);
			jhthdNote = (Integer) ois.readObject();
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

	public void writeCustomerList() {

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
	public void readCustomerList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("customerList.out");
			ois = new ObjectInputStream(fis);
			customerList = (ArrayList<CustomerPO>) ois.readObject();
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

	public void writeImportList() {

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
	public void readImportList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("importList.out");
			ois = new ObjectInputStream(fis);
			importList = (ArrayList<ImportPO>) ois.readObject();
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

	public void writeImport_ReturnList() {

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
	public void readImport_ReturnList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("import_returnList.out");
			ois = new ObjectInputStream(fis);
			import_returnList = (ArrayList<Import_ReturnPO>) ois.readObject();
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

	public void writeExportList() {

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
	public void readExportList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("exportList.out");
			ois = new ObjectInputStream(fis);
			exportList = (ArrayList<ExportPO>) ois.readObject();
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

	public void writeExport_ReturnList() {

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
	public void readExport_ReturnList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("export_returnList.out");
			ois = new ObjectInputStream(fis);
			export_returnList = (ArrayList<Export_ReturnPO>) ois.readObject();
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

	public void writeDraftImportList() {

		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftImportList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftImportList);
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
	public void readDraftImportList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("draftImportList.out");
			ois = new ObjectInputStream(fis);
			draftImportList = (ArrayList<ImportPO>) ois.readObject();
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

	public void writeDraftImport_ReturnList() {

		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftImport_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftImport_returnList);
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
	public void readDraftImport_ReturnList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("draftImport_returnList.out");
			ois = new ObjectInputStream(fis);
			draftImport_returnList = (ArrayList<Import_ReturnPO>) ois
					.readObject();
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

	public void writeDraftExportList() {

		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftExportList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftExportList);
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
	public void readDraftExportList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("draftExportList.out");
			ois = new ObjectInputStream(fis);
			draftExportList = (ArrayList<ExportPO>) ois.readObject();
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

	public void writeDraftExport_ReturnList() {

		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("draftExport_returnList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftExport_returnList);
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
	public void readDraftExport_ReturnList() {

		FileInputStream fis;
		ObjectInputStream ois;

		try {

			fis = new FileInputStream("draftExport_returnList.out");
			ois = new ObjectInputStream(fis);
			draftExport_returnList = (ArrayList<Export_ReturnPO>) ois
					.readObject();
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
		
		this.writeCustomerList();
		this.writeDraftImportList();
		this.writeDraftImport_ReturnList();
		this.writeDraftExportList();
		this.writeDraftExport_ReturnList();
		this.writeImportList();
		this.writeImport_ReturnList();
		this.writeExportList();
		this.writeExport_ReturnList();
		this.writeJHDNote();
		this.writeJHTHDNote();
		this.writeKHBHNote();
		this.writeXSDNote();
		this.writeXSTHDNote();
		
		this.readCustomerList();
		this.readDraftImportList();
		this.readDraftImport_ReturnList();
		this.readDraftExportList();
		this.readDraftExport_ReturnList();
		this.readImportList();
		this.readImport_ReturnList();
		this.readExportList();
		this.readExport_ReturnList();
		this.readJHDNote();
		this.readJHTHDNote();
		this.readKHBHNote();
		this.readXSDNote();
		this.readXSTHDNote();
		// TODO Auto-generated constructor stub
	}

	public boolean addCustomer(CustomerPO po) {
		if (findCustomer_true(po.getName()) == null) {
			CustomerPO po1 = po.copy();
			this.customerList.add(po1);
			this.writeCustomerList();
			return true;
		}
		return false;

	}

	public boolean delCustomer(CustomerPO po) {

		CustomerPO po1 = findCustomer_true(po.getName());
		if (po1 != null) {
			if ((po1.getMoneyIn() == 0)&&(po1.getMoneyOut()==0)) {
				customerList.remove(po1);
				this.writeCustomerList();
				return true;
			}
		}
		return false;
	}

	public boolean updateCustomer(CustomerPO po1, CustomerPO po2) {

		CustomerPO po = findCustomer_true(po1.getName());
		CustomerPO poo = findCustomer_true(po2.getName());
		if ((po != null) && (poo == null)) {
			po.address = po2.getAddress();
			po.amount = po2.getAmount();
			po.clerk = po2.getClerk();
			po.level = po2.getLevel();
			po.mail = po2.getMail();
			po.phone = po2.getPhone();
			po.type = po2.getType();
			po.zip = po2.getZip();
			this.writeCustomerList();
			return true;
		}
		return false;
	}

	public CustomerPO findCustomer(String name) {
		int i = 0;
		for (i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName().equals(name)) {
				return customerList.get(i).copy();
			}
		}
		return null;

	}

	public boolean addImport(ImportPO po) {
		po = po.copy();
		po.setTime(SalesDataService_Stub.getNowTime());

		importList.add(po);
		this.writeImportList();
		return true;
	}

	public boolean addImport_Return(Import_ReturnPO po) {
		po = po.copy();
		po.setTime(SalesDataService_Stub.getNowTime());

		import_returnList.add(po);
		this.writeImport_ReturnList();
		return true;
	}

	public boolean addExport(ExportPO po) {
		po = po.copy();
		po.setTime(SalesDataService_Stub.getNowTime());

		exportList.add(po);
		this.writeExportList();
		return true;
	}

	public boolean addExport_Return(Export_ReturnPO po) {
		po = po.copy();
		po.setTime(SalesDataService_Stub.getNowTime());

		export_returnList.add(po);
		this.writeExport_ReturnList();
		return true;
	}

	public ArrayList<CustomerPO> getAllCustomer() {
		int i = 0;
		ArrayList<CustomerPO> array = new ArrayList<CustomerPO>();
		for (i = 0; i < customerList.size(); i++) {
			array.add(customerList.get(i).copy());
		}
		return array;
	}

	public ArrayList<ImportPO> getAllImport() {
		int i = 0;
		ArrayList<ImportPO> array = new ArrayList<ImportPO>();
		for (i = 0; i < importList.size(); i++) {
			array.add(importList.get(i).copy());
		}
		return array;
	}

	public ArrayList<Import_ReturnPO> getAllImport_Return() {
		int i = 0;
		ArrayList<Import_ReturnPO> array = new ArrayList<Import_ReturnPO>();
		for (i = 0; i < import_returnList.size(); i++) {
			array.add(import_returnList.get(i).copy());
		}
		return array;
	}

	public ArrayList<ExportPO> getAllExport() {
		int i = 0;
		ArrayList<ExportPO> array = new ArrayList<ExportPO>();
		for (i = 0; i < exportList.size(); i++) {
			array.add(exportList.get(i).copy());
		}
		return array;
	}

	public ArrayList<Export_ReturnPO> getAllExport_Return() {
		int i = 0;
		ArrayList<Export_ReturnPO> array = new ArrayList<Export_ReturnPO>();
		for (i = 0; i < export_returnList.size(); i++) {
			array.add(export_returnList.get(i).copy());
		}
		return array;
	}

	public boolean clear() {
		customerList = new ArrayList<CustomerPO>();
		importList = new ArrayList<ImportPO>();
		exportList = new ArrayList<ExportPO>();
		import_returnList = new ArrayList<Import_ReturnPO>();
		export_returnList = new ArrayList<Export_ReturnPO>();
		draftImportList = new ArrayList<ImportPO>();
		draftExportList = new ArrayList<ExportPO>();
		draftImport_returnList = new ArrayList<Import_ReturnPO>();
		draftExport_returnList = new ArrayList<Export_ReturnPO>();
		return true;
	}

	public boolean addDraftImport(ImportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		po = po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());

		draftImportList.add(po);
		this.writeDraftImportList();
		return true;
	}

	public boolean addDraftImport_Return(Import_ReturnPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		po = po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());

		draftImport_returnList.add(po);
		this.writeDraftImport_ReturnList();
		return true;
	}

	public boolean addDraftExport(ExportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		po = po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());

		draftExportList.add(po);
		this.writeDraftExportList();
		return true;
	}

	public boolean addDraftExport_Return(Export_ReturnPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		po = po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());

		draftExport_returnList.add(po);
		this.writeDraftExport_ReturnList();
		return true;
	}

	public boolean delDraftImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		ImportPO po = findDraftImport_true(note);
		draftImportList.remove(po);
		this.writeDraftImportList();
		return true;
	}

	public boolean delDraftImport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		Import_ReturnPO po = findDraftImport_Return_true(note);
		draftImport_returnList.remove(po);
		this.writeDraftImport_ReturnList();
		return true;
	}

	public boolean delDraftExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		ExportPO po = findDraftExport_true(note);
		draftExportList.remove(po);
		this.writeDraftExportList();
		return true;
	}

	public boolean delDraftExport_Reutrn(String note) throws RemoteException {
		// TODO Auto-generated method stub
		Export_ReturnPO po = findDraftExport_Return_true(note);
		draftExport_returnList.remove(po);
		this.writeDraftExport_ReturnList();
		return true;
	}

	public ArrayList<ImportPO> getAllDraftImport() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ImportPO> array = new ArrayList<ImportPO>();
		int i = 0;
		for (i = 0; i < draftImportList.size(); i++) {
			array.add(draftImportList.get(i).copy());
		}
		return array;
	}

	public ArrayList<Import_ReturnPO> getAllDraftImport_Return()
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Import_ReturnPO> array = new ArrayList<Import_ReturnPO>();
		int i = 0;
		for (i = 0; i < draftImport_returnList.size(); i++) {
			array.add(draftImport_returnList.get(i).copy());
		}
		return array;
	}

	public ArrayList<ExportPO> getAllDraftExport() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ExportPO> array = new ArrayList<ExportPO>();
		int i = 0;
		for (i = 0; i < draftExportList.size(); i++) {
			array.add(draftExportList.get(i).copy());
		}
		return array;
	}

	public ArrayList<Export_ReturnPO> getAllDraftExport_Return()
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Export_ReturnPO> array = new ArrayList<Export_ReturnPO>();
		int i = 0;
		for (i = 0; i < draftExport_returnList.size(); i++) {
			array.add(draftExport_returnList.get(i).copy());
		}
		return array;
	}

	public ImportPO getImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < importList.size(); i++) {
			if (note.equals(importList.get(i))) {
				return importList.get(i);
			}
		}
		return null;
	}

	public ImportPO getDraftImport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftImportList.size(); i++) {
			if (note.equals(draftImportList.get(i))) {
				return draftImportList.get(i);
			}
		}
		return null;
	}

	public Import_ReturnPO getImport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < import_returnList.size(); i++) {
			if (note.equals(import_returnList.get(i))) {
				return import_returnList.get(i);
			}
		}
		return null;
	}

	public Import_ReturnPO getDraftImport_Return(String note)
			throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftImport_returnList.size(); i++) {
			if (note.equals(draftImport_returnList.get(i))) {
				return draftImport_returnList.get(i);
			}
		}
		return null;
	}

	public ExportPO getExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < exportList.size(); i++) {
			if (note.equals(exportList.get(i))) {
				return exportList.get(i);
			}
		}
		return null;
	}

	public ExportPO getDraftExport(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftExportList.size(); i++) {
			if (note.equals(draftExportList.get(i))) {
				return draftExportList.get(i);
			}
		}
		return null;
	}

	public Export_ReturnPO getExport_Return(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < export_returnList.size(); i++) {
			if (note.equals(export_returnList.get(i))) {
				return export_returnList.get(i);
			}
		}
		return null;
	}

	public Export_ReturnPO getDraftExport_Return(String note)
			throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftExport_returnList.size(); i++) {
			if (note.equals(draftExport_returnList.get(i))) {
				return draftExport_returnList.get(i);
			}
		}
		return null;
	}

	public String getImportNote() throws RemoteException {
		// TODO Auto-generated method stub
		String a = "JHD";
		String b = SalesDataService_Stub.getNoteTime();
		String c = Integer.toString(jhdNote);
		jhdNote++;
		this.writeJHDNote();
		return a + "-" + b + "-" + c;
	}

	public String getImport_ReturnNote() throws RemoteException {
		// TODO Auto-generated method stub
		String a = "JHTHD";
		String b = SalesDataService_Stub.getNoteTime();
		String c = Integer.toString(jhthdNote);
		jhthdNote++;
		this.writeJHTHDNote();
		return a + "-" + b + "-" + c;
	}

	public String getExportNote() throws RemoteException {
		// TODO Auto-generated method stub
		String a = "XSD";
		String b = SalesDataService_Stub.getNoteTime();
		String c = Integer.toString(xsdNote);
		xsdNote++;
		this.writeXSDNote();
		return a + "-" + b + "-" + c;
	}

	public String getExport_ReturnNote() throws RemoteException {
		// TODO Auto-generated method stub
		String a = "XSTHD";
		String b = SalesDataService_Stub.getNoteTime();
		String c = Integer.toString(xsthdNote);
		xsthdNote++;
		this.writeXSTHDNote();
		return a + "-" + b + "-" + c;

	}

	public String getCustomerNote() throws RemoteException {
		// TODO Auto-generated method stub
		String a = "KHBH";
		String b = SalesDataService_Stub.getNoteTime();
		String c = Integer.toString(khbhNote);
		khbhNote++;
		this.writeKHBHNote();
		return a + "-" + b + "-" + c;
	}

	// 以下方法是类内调用
	public CustomerPO findCustomer_true(String name) {
		int i = 0;
		for (i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getName().equals(name)) {
				return customerList.get(i);
			}
		}
		return null;
	}

	public static String getNowTime() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		String sysDatetime = fmt.format(rightNow.getTime());
		return sysDatetime;
	}

	public static String getNoteTime() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		String sysDatetime = fmt.format(rightNow.getTime());
		return sysDatetime;
	}

	private Export_ReturnPO findDraftExport_Return_true(String note) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftExport_returnList.size(); i++) {
			if (note.equals(draftExport_returnList.get(i))) {
				return draftExport_returnList.get(i);
			}
		}
		return null;
	}

	private ImportPO findDraftImport_true(String note) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftImportList.size(); i++) {
			if (note.equals(draftImportList.get(i))) {
				return draftImportList.get(i);
			}
		}
		return null;
	}

	private ExportPO findDraftExport_true(String note) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftExportList.size(); i++) {
			if (note.equals(draftExportList.get(i))) {
				return draftExportList.get(i);
			}
		}
		return null;
	}

	private Import_ReturnPO findDraftImport_Return_true(String note) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < draftImport_returnList.size(); i++) {
			if (note.equals(draftImport_returnList.get(i))) {
				return draftImport_returnList.get(i);
			}
		}
		return null;
	}

}
