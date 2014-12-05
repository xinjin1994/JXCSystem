package data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;
import dataservice.accountdataservice.AccountDataService;

public class AccountDataService_Stub implements AccountDataService{
	
	String name;
	int money;
	public AccountDataService_Stub(String name, int money) {
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

	public ArrayList<AccountPO> getAllAccount() {

		return new ArrayList<AccountPO>();
	}

	public boolean addReceipt(ReceiptPO po) {
		return true;
	}

	public boolean addPayment(PaymentPO po) {
		return true;
	}

	public ArrayList<ReceiptPO> getAllReceipt() {
		return new ArrayList<ReceiptPO>();
	}

	public ArrayList<PaymentPO> getAllPayment() {
		return new ArrayList<PaymentPO>();
	}

	public boolean clear() {
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

}
