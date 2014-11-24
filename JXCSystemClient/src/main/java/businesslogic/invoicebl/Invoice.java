package businesslogic.invoicebl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.InvoicePO;
import po.PaymentPO;
import po.ReceiptPO;
import po.PatchPO;
import businesslogicservice.invoiceblservice.InvoiceblService;
import data.invoicedata.InvoiceDataService_Stub;
import dataservice.invoicedataservice.InvoiceDataService;

public class Invoice implements InvoiceblService, businesslogic.commoditybl.InvoiceInfo,
			businesslogic.accountbl.InvoiceInfo, businesslogic.salesbl.InvoiceInfo{

	public SalesInfo salesInfo;
	public InvoiceDataService invoice;
	
	public String show() {
		// TODO Auto-generated method stub
		InvoiceDataService invoice= new InvoiceDataService_Stub("1","2","3");
		if(invoice.getInvoice("note")!=null){
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String pass(String note) {
		
		InvoicePO tempInvoice = invoice.getInvoice(note);
		ImportPO importPO = (ImportPO)tempInvoice;
		return salesInfo.addImport(importPO);
		
	}

	public String refuse(String note) {
		
		InvoicePO tempInvoice = invoice.getInvoice(note);
		ImportPO importPO = (ImportPO)tempInvoice;
		return salesInfo.delImport(importPO);
	}


	public String add(PatchPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		invoice.addInvoice(invoicePO);
		return "�ɹ�";
	}//���籨��

	public String add(ImportPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		invoice.addInvoice(invoicePO);
		return "�ɹ�";
	}

	public String add(ExportPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		invoice.addInvoice(invoicePO);
		return "�ɹ�";
	}

	public String add(Import_ReturnPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		invoice.addInvoice(invoicePO);
		return "�ɹ�";
	}

	public String add(Export_ReturnPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		invoice.addInvoice(invoicePO);
		return "�ɹ�";
	}

	public String add(ReceiptPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		invoice.addInvoice(invoicePO);
		return "�ɹ�";
	}

	public String add(PaymentPO po) {
		InvoicePO invoicePO = (InvoicePO)po;
		invoice.addInvoice(invoicePO);
		return "�ɹ�";
	}

//	public String add(CommodityPO po) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}



