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
	
	String name;
	int money;
	
	public ArrayList<AccountPO> accountList=new ArrayList<AccountPO>();
	ArrayList<ReceiptPO> receiptList=new ArrayList<ReceiptPO>();
	ArrayList<PaymentPO> paymentList=new ArrayList<PaymentPO>();
	
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
	public void readReceipt(){
		
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
	
	
	
	
	public AccountDataService_Stub(String name, int money) throws RemoteException {
		super();
		this.name = name;
		this.money = money;
	}
	
	public AccountPO getAccount() {
		return new AccountPO(name, money);
	}

	public boolean addAccount(AccountPO po) {
		return true;
	}

	public boolean delAccount(AccountPO po) {
		return true;
	}

	public boolean updateAccount(AccountPO po1, AccountPO po2) {
		return true;
	}

	public AccountPO findAccount(String name) {
		
		return new AccountPO(name,money);
	}

	public AccountPO[] getAllAccount() {

		return new AccountPO[1];
	}

	public boolean addReceipt(ReceiptPO po) {
		return true;
	}

	public boolean addPayment(PaymentPO po) {
		return true;
	}

	public ReceiptPO[] getAllReceipt() {
		return new ReceiptPO[1];
	}

	public PaymentPO[] getAllPayment() {
		return new PaymentPO[1];
	}

	public boolean clear() {
		return true;
	}

}
