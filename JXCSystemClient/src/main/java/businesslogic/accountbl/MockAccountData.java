package businesslogic.accountbl;

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
		return acc;
	}

	public AccountPO[] getAllAccount() {
		// TODO Auto-generated method stub
		AccountPO[] acc=new AccountPO[1];
		acc[0]=array.get(0);
		return acc;
	}

	public boolean addReceipt(ReceiptPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean addPayment(PaymentPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	public ReceiptPO[] getAllReceipt() {
		// TODO Auto-generated method stub
		ReceiptPO[] rec=new ReceiptPO[1];
		rec[0]=arrayRec.get(0);
		return rec;
	}

	public PaymentPO[] getAllPayment() {
		// TODO Auto-generated method stub
		PaymentPO[] pay=new PaymentPO[1];
		pay[0]=arrayPay.get(0);
		return pay;
	}

	public boolean clear() {
		// TODO Auto-generated method stub
		array.clear();
		arrayRec.clear();
		arrayPay.clear();
		return true;
	}

}
