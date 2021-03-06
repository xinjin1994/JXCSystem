package dataservice.invoicedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InvoicePO;

public interface InvoiceDataService extends Remote {
	public InvoicePO getInvoice(String note) throws RemoteException;
	public boolean addInvoice(InvoicePO po) throws RemoteException;
	public boolean passInvoice(InvoicePO po) throws RemoteException;
	public boolean refuseInvoice(InvoicePO po) throws RemoteException;
	public ArrayList<InvoicePO> getAllInvoice() throws RemoteException;
	public String getInvNote() throws RemoteException;
	public boolean clear() throws RemoteException;
}
