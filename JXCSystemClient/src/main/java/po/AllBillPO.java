package po;

import java.io.Serializable;

public class AllBillPO implements Serializable{
	
	ImportPO importList;
	Import_ReturnPO import_ReturnList; 
	ExportPO exportList;
	Export_ReturnPO export_ReturnList;
	PaymentPO paymentList;
	ReceiptPO receiptList;
	PatchPO patch;
	CommodityPO gift;
	int note;         //1代表CommodityPO， 2代表ImportPO， 3代表Import_Return， 4代表ExportPO，
					  //5代表Export_Return， 6代表PatchPO， 7代表ReceiptPO， 8代表PaymentPO

    public AllBillPO(ImportPO importList, Import_ReturnPO import_ReturnList,
			ExportPO exportList, Export_ReturnPO export_ReturnList,
			PaymentPO paymentList, ReceiptPO receiptList, PatchPO patch, CommodityPO gift) {
		this.importList = importList;
		this.import_ReturnList = import_ReturnList;
		this.exportList = exportList;
		this.export_ReturnList = export_ReturnList;
		this.paymentList = paymentList;
		this.receiptList = receiptList;
		this.patch=patch;
		this.gift=gift;
		note=0;
	}
    
    public AllBillPO(ImportPO importList){
    	note=2;
    	this.importList=importList;
    }
    
    public AllBillPO(ExportPO exportList){
    	note=4;
    	this.exportList=exportList;
    }
    
    public AllBillPO(Import_ReturnPO import_ReturnList){
    	note=3;
    	this.import_ReturnList=import_ReturnList;
    }
    
    public AllBillPO(Export_ReturnPO export_ReturnList){
    	note=5;
    	this.export_ReturnList=export_ReturnList;
    }
    
    public AllBillPO(ReceiptPO receiptList){
    	note=7;
    	this.receiptList=receiptList;
    }
    
    public AllBillPO(PaymentPO paymentList){
    	note=8;
    	this.paymentList=paymentList;
    }
    public AllBillPO(PatchPO patch){
    	note=6;
    	this.patch=patch;
    }
    public AllBillPO(CommodityPO gift){
    	note=1;
    	this.gift=gift;
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
	
	public PatchPO getPatch(){
		return patch;
	}
	
	public CommodityPO getGift(){
		return gift;
	}
	
	public AllBillPO copy(){
		AllBillPO po=new AllBillPO(importList.copy(), import_ReturnList.copy(),exportList.copy(),
				export_ReturnList.copy(),paymentList.copy(), receiptList.copy(), patch.copy(),
				gift.copy());
		po.note=note;
		return po;
	}

	public int getNote() {
		// TODO Auto-generated method stub
		return note;
	}
	
//	public String getTime(){
//		
//		switch(note){
//		case 1:  
//		
//		
//		
//		}
//	}
	

}
