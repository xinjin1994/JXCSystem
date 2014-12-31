package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;
import dataservice.accountdataservice.AccountDataService;

public class MockAccountData implements AccountDataService{
	
	String name;
	int money;
	ArrayList<AccountPO> array=new ArrayList<AccountPO>();
	ArrayList<ReceiptPO> arrayRec=new ArrayList<ReceiptPO>();
	ArrayList<PaymentPO> arrayPay=new ArrayList<PaymentPO>();
	
	public MockAccountData(String name, int money){
		this.name=name;
		this.money=money;
	}

	public AccountPO getAccount() {
		// TODO Auto-generated method stub
		AccountPO acc=new AccountPO("name",0);
		return acc;
	}

	public boolean addAccount(AccountPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean delAccount(AccountPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean updateAccount(AccountPO po1, AccountPO po2) {
		// TODO Auto-generated method stub
		return true;
	}

	public AccountPO findAccount(String name) {
		// TODO Auto-generated method stub
		AccountPO acc=new AccountPO("name",0);
		return null;
	}

	public ArrayList<AccountPO> getAllAccount() {
		// TODO Auto-generated method stub
		return new ArrayList<AccountPO>();
	}

	public boolean addReceipt(ReceiptPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean addPayment(PaymentPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<ReceiptPO> getAllReceipt() {
		// TODO Auto-generated method stub
		ReceiptPO[] rec=new ReceiptPO[1];
		rec[0]=arrayRec.get(0);
		return new ArrayList<ReceiptPO>();
	}

	public ArrayList<PaymentPO> getAllPayment() {
		// TODO Auto-generated method stub
		PaymentPO[] pay=new PaymentPO[1];
		pay[0]=arrayPay.get(0);
		return new ArrayList<PaymentPO>();
	}

	public boolean clear() {
		// TODO Auto-generated method stub
		array.clear();
		arrayRec.clear();
		arrayPay.clear();
		return true;
	}

	public boolean addDraftReceipt(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ReceiptPO> getAllDraftReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PaymentPO> getAllDraftPayment() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addDraftPayment(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftPayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ReceiptPO findReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentPO findPayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ReceiptPO findDraftReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentPO findDraftPayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addMoney(AccountPO po, double money) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delMoney(AccountPO po, double money) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public String getReceiptNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPaymentNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean passReceipt(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passPayment(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean refuseReceipt(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean refusePayment(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
