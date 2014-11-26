package data.invoicedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.InvoicePO;
import dataservice.invoicedataservice.InvoiceDataService;

public class InvoiceDataService_Stub extends UnicastRemoteObject implements InvoiceDataService{
	String invoiceType;
	String invoiceNum;
	String condition;
	
	public InvoiceDataService_Stub(String invoiceType,
			String invoiceNum, String condition) throws RemoteException{
		this.invoiceNum = invoiceNum;
		this.invoiceType = invoiceType;
		this.condition = condition;
	}

	public InvoicePO getInvoice(String note) {
		return new InvoicePO(invoiceType,invoiceNum,condition);
	}

	public boolean addInvoice(InvoicePO po) {
		return true;
	}

	public boolean delInvoice(InvoicePO po) {
		return true;
	}

	public InvoicePO[] getAllInvoice() {
		return new InvoicePO[1];
	}

	public boolean clear() {
		return true;
	}

}
