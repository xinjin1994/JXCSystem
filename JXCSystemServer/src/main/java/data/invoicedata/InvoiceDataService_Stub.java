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
		int i=0;
		for(i=0;i<invoiceList.size();i++){
			if(invoiceList.get(i).getNote_Invoice().equals(note)){
				return invoiceList.get(i).copy();
			}
		}
		return null;
	}

	public boolean addInvoice(InvoicePO po) {
		InvoicePO po1=findInvoice_true(po.getNote_Invoice());
		if(po1==null){
			invoiceList.add(po.copy());
			return true;
		}
		return false;
	}

	public boolean delInvoice(InvoicePO po) {
		InvoicePO po1=findInvoice_true(po.getNote_Invoice());
		if(po1!=null){
			invoiceList.remove(po1);
			return true;
		}
		return false;
	}

	public ArrayList<InvoicePO> getAllInvoice() {
		ArrayList<InvoicePO> po=new ArrayList<InvoicePO>();
		int i=0;
		for(i=0;i<invoiceList.size();i++){
			po.add(invoiceList.get(i));
		}
		return po;
	}

	public boolean clear() {
		invoiceList=new ArrayList<InvoicePO>();
		return true;
	}
	
	public InvoicePO findInvoice_true(String note){
		int i=0;
		for(i=0;i<invoiceList.size();i++){
			if(invoiceList.get(i).getNote_Invoice().equals(note)){
				return invoiceList.get(i);
			}
		}
		return null;
	}

}
