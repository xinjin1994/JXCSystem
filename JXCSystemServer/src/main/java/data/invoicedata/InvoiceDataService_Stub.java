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
import data.accountdata.AccountDataService_Stub;
import dataservice.invoicedataservice.InvoiceDataService;

public class InvoiceDataService_Stub extends UnicastRemoteObject implements InvoiceDataService{
//	String invoiceType;
//	String invoiceNum;
//	String condition;
	
	ArrayList<InvoicePO> invoiceList=new ArrayList<InvoicePO>();
	int invNote=0;
	
	public InvoiceDataService_Stub() throws RemoteException{
		this.writeInvoiceList();
		this.writeInvNote();
		
		this.readInvoiceList();
		this.readInvNote();
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
	
	public void writeInvNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("invNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(invNote);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readInvNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("invNote.out");
			ois=new ObjectInputStream(fis);
			invNote=(Integer) ois.readObject();
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
			if(invoiceList.get(i).getNote().equals(note)){
				return invoiceList.get(i).copy();
			}
		}
		return null;
	}

	public boolean addInvoice(InvoicePO po) {
		InvoicePO po1=findInvoice_true(po.getNote());
		if(po1==null){
			invoiceList.add(po.copy());
			return true;
		}
		return false;
	}

	public boolean delInvoice(InvoicePO po) {
		for(int i=0;i<invoiceList.size();i++){
			if(invoiceList.get(i).getNote().equals(po.getNote())){
				invoiceList.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<InvoicePO> getAllInvoice() {
		ArrayList<InvoicePO> po=new ArrayList<InvoicePO>();
		int i=0;
		for(i=0;i<invoiceList.size();i++){
			po.add(invoiceList.get(i).copy());
		}
		return po;
	}

	public boolean clear() {
		invoiceList=new ArrayList<InvoicePO>();
		return true;
	}
	
	public InvoicePO findInvoice_true(String note){
		int i=0;
		
		if(note==null){
			System.out.println("note is null.");
			return null;
		}
		
		for(i=0;i<invoiceList.size();i++){
			if(invoiceList.get(i).getNote().equals(note)){
				return invoiceList.get(i);
			}
		}
		return null;
	}


	public boolean passInvoice(InvoicePO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<invoiceList.size();i++){
			if(invoiceList.get(i).getNote().equals(po.getNote())){
				po.setCondition(2);
				invoiceList.remove(i);
				invoiceList.add(po);
//				invoiceList.get(i).setCondition(2);
				return true;
			}
		}
		return false;
	}


	public boolean refuseInvoice(InvoicePO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<invoiceList.size();i++){
			if(invoiceList.get(i).getNote().equals(po.getNote())){
				invoiceList.get(i).setCondition(3);
				return true;
			}
		}
		return false;
	}
	
	public String getInvNote() throws RemoteException {
		String part1="INV";
		String part2=AccountDataService_Stub.getNoteTime();
		String part3=Integer.toString(invNote);
		invNote++;
		return part1+"-"+part2+"-"+part3;
	}

}
