package data.invoicedata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.InvoicePO;
import po.PaymentPO;
import dataservice.invoicedataservice.InvoiceDataService;

public class InvoiceDataService_Stub extends UnicastRemoteObject implements InvoiceDataService{
	String invoiceType;
	String invoiceNum;
	String condition;
	
	ArrayList<InvoicePO> invoiceList=new ArrayList<InvoicePO>();
	
	public InvoiceDataService_Stub(String invoiceType,
			String invoiceNum, String condition) throws RemoteException{
		this.invoiceNum = invoiceNum;
		this.invoiceType = invoiceType;
		this.condition = condition;
	}
	
	
	public void writeInvoiceList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("invoiceList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(invoiceList);	
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
	public void readInvoiceList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("InvoiceList.out");
			ois=new ObjectInputStream(fis);
			invoiceList=(ArrayList<InvoicePO>) ois.readObject();
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
	
	

	public InvoicePO getInvoice(String note) {
		return new InvoicePO(invoiceType,invoiceNum,condition);
	}

	public boolean addInvoice(InvoicePO po) {
		return true;
	}

	public boolean delInvoice(InvoicePO po) {
		return true;
	}

	public InvoicePO[] getAllInvoice() {
		return new InvoicePO[1];
	}

	public boolean clear() {
		return true;
	}

}
