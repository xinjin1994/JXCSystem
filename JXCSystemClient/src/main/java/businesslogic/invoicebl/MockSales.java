package businesslogic.invoicebl;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PaymentPO;
import po.ReceiptPO;


public class MockSales implements SalesInfo{

	public String addImport(ImportPO importPO) {
		return "�ɹ�";
	}
	public String addImport_Return(Import_ReturnPO import_ReturnPO) {
		return "�ɹ�";
	}

	public String addExport(ExportPO exportPO) {
		return "�ɹ�";
	}

	public String addExport_Return(Export_ReturnPO export_ReturnPO) {
		return "�ɹ�";
	}

	public String delImport(ImportPO importPO) {
		return "�ɹ�";
	}

	public String delImport_Return(Import_ReturnPO import_ReturnPO) {
		return "�ɹ�";
	}

	public String delExport(ExportPO exportPO) {
		return "�ɹ�";
	}

	public String delExport_Return(Export_ReturnPO export_ReturnPO) {
		return "�ɹ�";
	}
	public String passImport(ImportPO importPO) {
		// TODO Auto-generated method stub
		return null;
	}
	public String passImport_Return(Import_ReturnPO import_ReturnPO) {
		// TODO Auto-generated method stub
		return null;
	}
	public String passExport(ExportPO exportPO) {
		// TODO Auto-generated method stub
		return null;
	}
	public String passExport_Return(Export_ReturnPO export_ReturnPO) {
		// TODO Auto-generated method stub
		return null;
	}
	public String refuseImport(String note) {
		// TODO Auto-generated method stub
		return null;
	}
	public String refuseImport_Return(String note) {
		// TODO Auto-generated method stub
		return null;
	}
	public String refuseExport(String note) {
		// TODO Auto-generated method stub
		return null;
	}
	public String refuseExport_Return(String note) {
		// TODO Auto-generated method stub
		return null;
	}
	public String passReceipt(ReceiptPO receiptPO) {
		// TODO Auto-generated method stub
		return null;
	}
	public String passPayment(PaymentPO paymentPO) {
		// TODO Auto-generated method stub
		return null;
	}

}
