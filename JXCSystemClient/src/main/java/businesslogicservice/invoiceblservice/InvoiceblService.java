package businesslogicservice.invoiceblservice;

import po.*;

public interface InvoiceblService {

	public String show();
	
	public String pass(String note);
	
	public String refuse(String note);
	
	public String add(PatchPO po);
	
	public String add(ImportPO po);
	
	public String add(ExportPO po);
	
	public String add(Import_ReturnPO po);
	
	public String add(Export_ReturnPO po);
	
	public String add(ReceiptPO po);
	
	public String add(PaymentPO po);

	
}
