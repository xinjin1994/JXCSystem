package businesslogicservice.invoiceblservice;

import po.*;

public interface InvoiceblService {

	//显示所有待审批单据
	public String show();
	
	//通过审批
	public String pass(String note);
	
	//未通过审批
	public String refuse(String note);
	
	//添加单据
	public String add(PatchPO po);
	
	public String add(ImportPO po);
	
	public String add(ExportPO po);
	
	public String add(Import_ReturnPO po);
	
	public String add(Export_ReturnPO po);
	
	public String add(ReceiptPO po);
	
	public String add(PaymentPO po);

	
}
