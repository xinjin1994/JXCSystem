package businesslogic.invoicebl;

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
	public boolean delInvoice(InvoicePO po) {
		// TODO Auto-generated method stub
		return false;
	}
	public InvoicePO[] getAllInvoice() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}

}
