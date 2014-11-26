package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;

public interface AccountDataService extends Remote{
	public AccountPO getAccount() throws RemoteException;

	public boolean addAccount(AccountPO po) throws RemoteException;

	public boolean delAccount(AccountPO po) throws RemoteException;

	public boolean updateAccount(AccountPO po1, AccountPO po2) throws RemoteException;

	public AccountPO findAccount(String name) throws RemoteException;

	public AccountPO[] getAllAccount() throws RemoteException;

	public boolean addReceipt(ReceiptPO po) throws RemoteException;

	public boolean addPayment(PaymentPO po) throws RemoteException;

	public ReceiptPO[] getAllReceipt() throws RemoteException;

	public PaymentPO[] getAllPayment() throws RemoteException;

	public boolean clear() throws RemoteException;
}
