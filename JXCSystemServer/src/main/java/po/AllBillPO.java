package po;

import java.io.Serializable;

public class AllBillPO implements Serializable{
	
	ImportPO importList;
	Import_ReturnPO import_ReturnList; 
	ExportPO exportList;
	Export_ReturnPO export_ReturnList;
	PaymentPO paymentList;
	ReceiptPO receiptList;

    public AllBillPO(ImportPO importList, Import_ReturnPO import_ReturnList,
			ExportPO exportList, Export_ReturnPO export_ReturnList,
			PaymentPO paymentList, ReceiptPO receiptList) {
		this.importList = importList;
		this.import_ReturnList = import_ReturnList;
		this.exportList = exportList;
		this.export_ReturnList = export_ReturnList;
		this.paymentList = paymentList;
		this.receiptList = receiptList;
	}
    
    public AllBillPO(ImportPO importList){
    	this.importList=importList;
    }
    
    public AllBillPO(ExportPO exportList){
    	this.exportList=exportList;
    }
    
    public AllBillPO(Import_ReturnPO import_ReturnList){
    	this.import_ReturnList=import_ReturnList;
    }
    
    public AllBillPO(Export_ReturnPO export_ReturnList){
    	this.export_ReturnList=export_ReturnList;
    }
    
    public AllBillPO(ReceiptPO receiptList){
    	this.receiptList=receiptList;
    }
    
    public AllBillPO(PaymentPO paymentList){
    	this.paymentList=paymentList;
    }
    
    public ImportPO getImportList() {
		return importList;
	}

	public Import_ReturnPO getImport_ReturnList() {
		return import_ReturnList;
	}

	public ExportPO getExportList() {
		return exportList;
	}

	public Export_ReturnPO getExport_ReturnList() {
		return export_ReturnList;
	}

	public PaymentPO getPaymentList() {
		return paymentList;
	}

	public ReceiptPO getReceiptList() {
		return receiptList;
	}
	

}
