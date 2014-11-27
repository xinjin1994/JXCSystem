package data.accountdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;
import dataservice.accountdataservice.AccountDataService;

public class AccountDataService_Stub extends UnicastRemoteObject implements AccountDataService{
	
	AccountPO nowAccount=new AccountPO("name",1000);
	
	public ArrayList<AccountPO> accountList=new ArrayList<AccountPO>();
	ArrayList<ReceiptPO> receiptList=new ArrayList<ReceiptPO>();
	ArrayList<PaymentPO> paymentList=new ArrayList<PaymentPO>();
	
	
	public void writeNowAccount(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("nowAccount.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nowAccount);	
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
	public void readNowAccount(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("nowAccount.out");
			ois=new ObjectInputStream(fis);
			nowAccount=(AccountPO) ois.readObject();
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
	
	
	public void writeAccountList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("accountList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(accountList);	
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
	public void readAccountList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("accountList.out");
			ois=new ObjectInputStream(fis);
			accountList=(ArrayList<AccountPO>) ois.readObject();
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
	
	public void writeReceiptList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("receiptList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(receiptList);	
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
	public void readReceiptList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("receiptList.out");
			ois=new ObjectInputStream(fis);
			receiptList=(ArrayList<ReceiptPO>) ois.readObject();
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
	
	public void writePaymentList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("paymentList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(paymentList);	
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
	public void readPaymentList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("paymentList.out");
			ois=new ObjectInputStream(fis);
			paymentList=(ArrayList<PaymentPO>) ois.readObject();
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
	
	
	
	
	public AccountDataService_Stub() throws RemoteException {
		super();
		this.readNowAccount();
		this.readAccountList();
		this.readReceiptList();
		this.readPaymentList();
	}

	public boolean addAccount(AccountPO po) {
		this.accountList.add(po);
		return true;
	}

	public AccountPO getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return nowAccount;
	}
	
	public boolean delAccount(AccountPO po) {
		if(accountList.remove(po)){
			return true;
		}
		return false;
		
	}

	public boolean updateAccount(AccountPO po1, AccountPO po2) {
		return true;
	}

	public AccountPO findAccount(String name) {
		
		return new AccountPO(name);
	}

	public ArrayList<AccountPO> getAllAccount() {
		return accountList;
	}

	public boolean addReceipt(ReceiptPO po) {
		return true;
	}

	public boolean addPayment(PaymentPO po) {
		return true;
	}

	public ArrayList<ReceiptPO> getAllReceipt() {
		return receiptList;
	}

	public ArrayList<PaymentPO> getAllPayment() {
		return paymentList;
	}

	public boolean clear() {
		return true;
	}


}
