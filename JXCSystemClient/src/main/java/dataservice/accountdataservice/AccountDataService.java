package dataservice.accountdataservice;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;

public interface AccountDataService {
	public AccountPO getAccount();

	public boolean addAccount(AccountPO po);

	public boolean delAccount(AccountPO po);

	public boolean updateAccount(AccountPO po1, AccountPO po2);

	public AccountPO findAccount(String name);

	public AccountPO[] getAllAccount();

	public boolean addReceipt(ReceiptPO po);

	public boolean addPayment(PaymentPO po);

	public ReceiptPO[] getAllReceipt();

	public PaymentPO[] getAllPayment();

	public boolean clear();
}
