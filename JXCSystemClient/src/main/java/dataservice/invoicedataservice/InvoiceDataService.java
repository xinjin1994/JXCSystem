package dataservice.invoicedataservice;

import po.InvoicePO;

public interface InvoiceDataService {
	public InvoicePO getInvoice(String note);
	public boolean addInvoice(InvoicePO po);
	public boolean delInvoice(InvoicePO po);
	public InvoicePO[] getAllInvoice();
	public boolean clear();
}
