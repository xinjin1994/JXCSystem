package data.accountdata;

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
