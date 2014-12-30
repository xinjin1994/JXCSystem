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
	
	AccountPO nowAccount=new AccountPO("name",0);
	
	public ArrayList<AccountPO> accountList=new ArrayList<AccountPO>();
	ArrayList<ReceiptPO> receiptList=new ArrayList<ReceiptPO>();
	ArrayList<PaymentPO> paymentList=new ArrayList<PaymentPO>();
	ArrayList<ReceiptPO> draftReceiptList=new ArrayList<ReceiptPO>();
	ArrayList<PaymentPO> draftPaymentList=new ArrayList<PaymentPO>();
	int skdNote=0;
	int fkdNote=0;
	
	
	public void writeSKDNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//skdNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(skdNote);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readSKDNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//skdNote.out");
			ois=new ObjectInputStream(fis);
			skdNote=(Integer) ois.readObject();
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
	
	public void writeFKDNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//fkdNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(fkdNote);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readFKDNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//fkdNote.out");
			ois=new ObjectInputStream(fis);
			fkdNote=(Integer) ois.readObject();
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
	
	public void writeNowAccount(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//nowAccount.out");
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
	
	public void readNowAccount(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//nowAccount.out");
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
			fos = new FileOutputStream("out//accountList.out");
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
			
			fis=new FileInputStream("out//accountList.out");
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
			fos = new FileOutputStream("out//receiptList.out");
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
			
			fis=new FileInputStream("out//receiptList.out");
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
			fos = new FileOutputStream("out//paymentList.out");
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
			
			fis=new FileInputStream("out//paymentList.out");
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
	
	public void writeDraftReceiptList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//draftReceiptList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftReceiptList);	
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
	public void readDraftReceiptList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//draftReceiptList.out");
			ois=new ObjectInputStream(fis);
			draftReceiptList=(ArrayList<ReceiptPO>) ois.readObject();
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
	
	public void writeDraftPaymentList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//draftPaymentList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftPaymentList);	
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
	public void readDraftPaymentList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//draftPaymentList.out");
			ois=new ObjectInputStream(fis);
			draftPaymentList=(ArrayList<PaymentPO>) ois.readObject();
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
//		this.writeNowAccount();
//		this.writeAccountList();
//		this.writeReceiptList();
//		this.writePaymentList();
//		this.writeDraftReceiptList();
//		this.writeDraftPaymentList();
//		this.writeSKDNote();
//		this.writeFKDNote();
		
		this.readNowAccount();
		this.readAccountList();
		this.readReceiptList();
		this.readPaymentList();
		this.readDraftReceiptList();
		this.readDraftPaymentList();
		this.readSKDNote();
		this.readFKDNote();
	}
	
	/*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑数据序列化方法以及构造方法↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/

	public boolean addAccount(AccountPO po) {
		if(findAccount_true(po.getName())==null){
			AccountPO po1=po.copy();
			this.accountList.add(po1);
			this.writeAccountList();
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
				this.writeAccountList();
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
			this.writeAccountList();
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
		
		po=po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());
		
		receiptList.add(po);
		this.writeReceiptList();
		return true;
	}

	public boolean addPayment(PaymentPO po) {
		po=po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());
		
		paymentList.add(po);
		this.writePaymentList();
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

	public boolean addDraftReceipt(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		po=po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());
		
		draftReceiptList.add(po);
		this.writeDraftReceiptList();
		return true;
	}

	public boolean addDraftPayment(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		po=po.copy();
		po.setTime(AccountDataService_Stub.getNowTime());
		
		draftPaymentList.add(po);
		this.writeDraftPaymentList();
		return true;
	}

	public boolean delDraftReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		ReceiptPO po=findDraftReceipt_true(note);
		draftReceiptList.remove(po);
		this.writeDraftReceiptList();
		return true;
	}

	public boolean delDraftPayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		PaymentPO po=findDraftPayment_true(note);
		draftPaymentList.remove(po);
		this.writeDraftPaymentList();
		return true;
	}

	public ReceiptPO findReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<receiptList.size();i++){
			if(note.equals(receiptList.get(i))){
				return receiptList.get(i).copy();
			}
		}
		return null;
	}

	public PaymentPO findPayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<paymentList.size();i++){
			if(note.equals(paymentList.get(i))){
				return paymentList.get(i).copy();
			}
		}
		return null;
	}

	public ReceiptPO findDraftReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		ReceiptPO po=findDraftReceipt_true(note);
		
		if(po==null){
			return null;
		}
		
		po=po.copy();
		return po;
	}

	public PaymentPO findDraftPayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		PaymentPO po=findDraftPayment_true(note);
		
		if(po==null){
			return null;
		}
		
		po=po.copy();
		return po;
	}

	public ArrayList<ReceiptPO> getAllDraftReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> array=new ArrayList<ReceiptPO>();
		int i=0;
		for(i=0;i<draftReceiptList.size();i++){
			array.add(draftReceiptList.get(i).copy());
		}
		return array;
	}

	public ArrayList<PaymentPO> getAllDraftPayment() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO> array=new ArrayList<PaymentPO>();
		int i=0;
		for(i=0;i<draftPaymentList.size();i++){
			array.add(draftPaymentList.get(i).copy());
		}
		return array;
	}

	public boolean addMoney(AccountPO po, double money) throws RemoteException {
		// TODO Auto-generated method stub
		AccountPO po1=findAccount_true(po.name);
		po1.money= po1.money+(int)money;
		this.writeAccountList();
		return true;
	}

	public boolean delMoney(AccountPO po, double money) throws RemoteException {
		// TODO Auto-generated method stub
		AccountPO po1=findAccount_true(po.name);
		po1.money=po1.money-(int)money;
		this.writeAccountList();
		return true;
	}

	public String getReceiptNote() throws RemoteException {
		// TODO Auto-generated method stub
		String a="SKD";
		String b=AccountDataService_Stub.getNoteTime();
		String c=Integer.toString(skdNote);
		skdNote++;
		this.writeSKDNote();
		return a+"-"+b+"-"+c;
	}

	public String getPaymentNote() throws RemoteException {
		// TODO Auto-generated method stub
		String a="FKD";
		String b=AccountDataService_Stub.getNoteTime();
		String c=Integer.toString(fkdNote);
		fkdNote++;
		this.writeFKDNote();
		return a+"-"+b+"-"+c;
	}
	
	public boolean clear() {
		accountList=new ArrayList<AccountPO>();
		receiptList=new ArrayList<ReceiptPO>();
		paymentList=new ArrayList<PaymentPO>();
		draftReceiptList=new ArrayList<ReceiptPO>();
		draftPaymentList=new ArrayList<PaymentPO>();
		nowAccount=new AccountPO(nowAccount.getName(),0);
		return true;
	}
	
	
	
	/*↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓数据层自用方法↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓*/
	
	public ReceiptPO findDraftReceipt_true(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<draftReceiptList.size();i++){
			if(note.equals(draftReceiptList.get(i).getNote())){
				return draftReceiptList.get(i);
			}
		}
		return null;
	}

	public PaymentPO findDraftPayment_true(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<draftPaymentList.size();i++){
			if(note.equals(draftPaymentList.get(i).getNote())){
				return draftPaymentList.get(i);
			}
		}
		return null;
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
	
	public static String getNowTime(){
		 Calendar rightNow = Calendar.getInstance();
		 SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		 String sysDatetime = fmt.format(rightNow.getTime());
		 return sysDatetime; 
	}
	
	public static String getNoteTime(){
		 Calendar rightNow = Calendar.getInstance();
		 SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		 String sysDatetime = fmt.format(rightNow.getTime());
		 return sysDatetime; 
	}

	public boolean passReceipt(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<receiptList.size();i++){
			if(receiptList.get(i).getNote().equals(po.getNote())){
				receiptList.get(i).transfer=new ArrayList<TransferPO>();
				receiptList.get(i).customer=po.getCustomer().copy();
				for(int z=0;z<po.getTransfer().size();z++){
					TransferPO tra=po.getTransfer().get(z).copy();
					receiptList.get(i).transfer.add(tra);
				}
				
				ArrayList<TransferPO> trans=receiptList.get(i).getTransfer();
				for(int j=0;j<trans.size();j++){
					AccountPO acc=findAccount_true(trans.get(j).getAccount());
					addMoney(acc,trans.get(j).getMoney());
				}
				receiptList.get(i).setCondition(2);
				return true;
			}
		}
		return false;
	}

	public boolean passPayment(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<paymentList.size();i++){
			if(paymentList.get(i).getNote().equals(po.getNote())){
				
				paymentList.get(i).item=new ArrayList<ItemPO>();
				for(int z=0;z<po.getItem().size();z++){
					ItemPO tra=po.getItem().get(z).copy();
					paymentList.get(i).item.add(tra);
				}
				
				ArrayList<ItemPO> trans=paymentList.get(i).getItem();
				for(int j=0;j<trans.size();j++){
					delMoney(paymentList.get(i).getAccount(),trans.get(j).getMoney());
				}
				paymentList.get(i).setCondition(2);
				return true;
			}
		}
		return false;
	}

	public boolean refuseReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<receiptList.size();i++){
			if(receiptList.get(i).getNote().equals(note)){
				receiptList.get(i).setCondition(3);
				return true;
			}
		}
		return false;
	}

	public boolean refusePayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<paymentList.size();i++){
			if(paymentList.get(i).getNote().equals(note)){
				paymentList.get(i).setCondition(3);
				return true;
			}
		}
		return false;
	}
	


}
