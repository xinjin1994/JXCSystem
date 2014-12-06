package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;

public interface AccountDataService extends Remote {
	public AccountPO getAccount() throws RemoteException;

	public boolean addAccount(AccountPO po) throws RemoteException;

	public boolean delAccount(AccountPO po) throws RemoteException;

	public boolean updateAccount(AccountPO po1, AccountPO po2) throws RemoteException;

	public AccountPO findAccount(String name) throws RemoteException;

	public ArrayList<AccountPO> getAllAccount() throws RemoteException;

	public boolean addReceipt(ReceiptPO po) throws RemoteException;
	
	public boolean addDraftReceipt(ReceiptPO po) throws RemoteException;

	public boolean addPayment(PaymentPO po) throws RemoteException;
	
	public boolean addDraftPayment(PaymentPO po) throws RemoteException;
	
	public boolean delDraftReceipt(String note) throws RemoteException;
	
	public boolean delDraftPayment(String note) throws RemoteException;
	
	public ReceiptPO findReceipt(String note) throws RemoteException;
	
	public PaymentPO findPayment(String note) throws RemoteException;
	
	public ReceiptPO findDraftReceipt(String note) throws RemoteException;
	
	public ReceiptPO findDraftPayment(String note) throws RemoteException;
	
	public ArrayList<ReceiptPO> getAllReceipt() throws RemoteException;
	
	public ArrayList<ReceiptPO> getAllDraftReceipt() throws RemoteException;

	public ArrayList<PaymentPO> getAllPayment() throws RemoteException;
	
	public ArrayList<PaymentPO> getAllDraftPayment() throws RemoteException;

	public boolean clear() throws RemoteException;
}
