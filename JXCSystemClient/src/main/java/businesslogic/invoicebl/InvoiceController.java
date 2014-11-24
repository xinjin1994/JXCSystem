package businesslogic.invoicebl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;
import businesslogicservice.invoiceblservice.InvoiceblService;

public class InvoiceController implements InvoiceblService{
	
	public Invoice invoice=new Invoice();

	public String show() {
		// TODO Auto-generated method stub
		return invoice.show();
	}

	public String pass(String note) {
		// TODO Auto-generated method stub
		return invoice.pass(note);
	}

	public String refuse(String note) {
		// TODO Auto-generated method stub
		return invoice.refuse(note);
	}

	public String add(PatchPO po) {
		// TODO Auto-generated method stub
		return invoice.add(po);
	}

	public String add(ImportPO po) {
		// TODO Auto-generated method stub
		return invoice.add(po);
	}

	public String add(ExportPO po) {
		// TODO Auto-generated method stub
		return invoice.add(po);
	}

	public String add(Import_ReturnPO po) {
		// TODO Auto-generated method stub
		return invoice.add(po);
	}

	public String add(Export_ReturnPO po) {
		// TODO Auto-generated method stub
		return invoice.add(po);
	}

	public String add(ReceiptPO po) {
		// TODO Auto-generated method stub
		return invoice.add(po);
	}

	public String add(PaymentPO po) {
		// TODO Auto-generated method stub
		return invoice.add(po);
	}

}
