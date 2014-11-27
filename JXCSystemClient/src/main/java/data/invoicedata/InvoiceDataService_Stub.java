package data.invoicedata;

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
		return new InvoicePO(invoiceType,invoiceNum,condition);
	}

	public boolean addInvoice(InvoicePO po) {
		return true;
	}

	public boolean delInvoice(InvoicePO po) {
		return true;
	}

	public ArrayList<InvoicePO> getAllInvoice() {
		return new ArrayList<InvoicePO>();
	}

	public boolean clear() {
		return true;
	}

}
