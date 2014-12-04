package data.accountdata;

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
import po.ItemPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.TransferPO;
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
		if(findAccount_true(po.getName())==null){
			AccountPO po1=po.copy();
			this.accountList.add(po1);
			return true;
		}
		return false;
	}

	public AccountPO getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		AccountPO po1=nowAccount.copy();
		return po1;
	}
	
	public boolean delAccount(AccountPO po) {
		AccountPO po1=findAccount_true(po.getName());
		if(po1!=null){
			if(po1.getMoney()==po.getMoney()){
				accountList.remove(po1);
				return true;
			}
		}
		return false;
	}

	public boolean updateAccount(AccountPO po1, AccountPO po2) {
		AccountPO po=findAccount_true(po1.getName());
		AccountPO poo=findAccount_true(po2.getName());
		if(po!=null&&poo==null){
			po.name=po2.getName();
			return true;
		}
		return false;
	}

	//此处将返回数据层对象的拷贝
	public AccountPO findAccount(String name) {
		int i=0;
		for(i=0;i<accountList.size();i++){
			if(accountList.get(i).getName().equals(name)){
				return accountList.get(i).copy();
			}
		}
		return null;
	}

	public ArrayList<AccountPO> getAllAccount() {
		int i=0;
		ArrayList<AccountPO> array=new ArrayList<AccountPO>();
		for(i=0;i<accountList.size();i++){
			array.add(accountList.get(i).copy());
		}
		return array;
	}

	public boolean addReceipt(ReceiptPO po) {
		ArrayList<TransferPO> transfer=po.getTransfer();
		int i=0;
		AccountPO lin;
		
		for(i=0;i<transfer.size();i++){
			lin=findAccount_true(transfer.get(i).getAccount());
			if(lin==null){
				return false;
			}
			lin.money=lin.money+transfer.get(i).getMoney();
		}
		po=po.copy();
		po.setTime(getNowTime());
		
		receiptList.add(po);
		return true;
	}

	public boolean addPayment(PaymentPO po) {
		AccountPO lin;
		
		lin=findAccount_true(po.getAccount().getName());
		if(lin==null){
			return false;		
		}
		lin.money=lin.money-po.getTotalMoney();
			
		po=po.copy();
		po.setTime(getNowTime());
		
		paymentList.add(po);
		return true;
	}

	public ArrayList<ReceiptPO> getAllReceipt() {
		int i=0;
		ArrayList<ReceiptPO> array=new ArrayList<ReceiptPO>();
		for(i=0;i<receiptList.size();i++){
			array.add(receiptList.get(i).copy());
		}
		return array;
	}

	public ArrayList<PaymentPO> getAllPayment() {
		int i=0;
		ArrayList<PaymentPO> array=new ArrayList<PaymentPO>();
		for(i=0;i<paymentList.size();i++){
			array.add(paymentList.get(i).copy());
		}
		return array;
	}

	public boolean clear() {
		accountList=new ArrayList<AccountPO>();
		receiptList=new ArrayList<ReceiptPO>();
		paymentList=new ArrayList<PaymentPO>();
		nowAccount=new AccountPO(nowAccount.getName(),0);
		return true;
	}
	
	private AccountPO findAccount_true(String name){
		int i=0;
		for(i=0;i<accountList.size();i++){
			if(accountList.get(i).getName().equals(name)){
				return accountList.get(i);
			}
		}
		return null;
	}
	
	public String getNowTime(){
		 Calendar rightNow = Calendar.getInstance();
		 SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 String sysDatetime = fmt.format(rightNow.getTime());
		 return sysDatetime; 
	}


}
