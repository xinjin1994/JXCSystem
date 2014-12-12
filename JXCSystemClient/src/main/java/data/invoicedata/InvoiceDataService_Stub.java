package data.invoicedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InvoicePO;
import dataservice.invoicedataservice.InvoiceDataService;

public class InvoiceDataService_Stub implements InvoiceDataService{
	String invoiceType;
	String invoiceNum;
	String condition;
	
	public InvoiceDataService_Stub(String invoiceType,
			String invoiceNum, String condition) {
		this.invoiceNum = invoiceNum;
		this.invoiceType = invoiceType;
		this.condition = condition;
	}

	public InvoicePO getInvoice(String note) {
		return new InvoicePO();
	}

	public boolean addInvoice(InvoicePO po) {
		return true;
	}

	public boolean passInvoice(InvoicePO po) {
		return true;
	}

	public ArrayList<InvoicePO> getAllInvoice() {
		return new ArrayList<InvoicePO>();
	}

	public boolean clear() {
		return true;
	}

	public boolean refuseInvoice(InvoicePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public String getInvNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
