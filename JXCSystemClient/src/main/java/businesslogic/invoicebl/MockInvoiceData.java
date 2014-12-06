package businesslogic.invoicebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.invoicedataservice.InvoiceDataService;
import po.InvoicePO;

public class MockInvoiceData implements InvoiceDataService{
	
	InvoicePO invoicePO ;
	
	public MockInvoiceData(InvoicePO invoicePO) {
		this.invoicePO = invoicePO;
	}
	public InvoicePO getInvoice(String note) {
		return invoicePO;
	}
	
	
	public boolean addInvoice(InvoicePO po) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean passInvoice(InvoicePO po) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<InvoicePO> getAllInvoice() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean refuseInvoice(InvoicePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
