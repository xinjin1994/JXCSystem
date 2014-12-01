package vo;

import po.CommodityPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;

public class AllBillVO {
	
	public ImportPO importList;
	public Import_ReturnPO import_ReturnList; 
	public ExportPO exportList;
	public Export_ReturnPO export_ReturnList;
	public PaymentPO paymentList;
	public ReceiptPO receiptList;
	public PatchPO patch;
	public CommodityPO gift;
	public int note;         //1代表CommodityPO， 2代表ImportPO， 3代表Import_Return， 4代表ExportPO，
					  //5代表Export_Return， 6代表PatchPO， 7代表ReceiptPO， 8代表PaymentPO
	
	
	public AllBillVO(){
		note=0;
	}
	
    public AllBillVO(ImportPO importList){
    	note=2;
    	this.importList=importList;
    }
    
    public AllBillVO(ExportPO exportList){
    	note=4;
    	this.exportList=exportList;
    }
    
    public AllBillVO(Import_ReturnPO import_ReturnList){
    	note=3;
    	this.import_ReturnList=import_ReturnList;
    }
    
    public AllBillVO(Export_ReturnPO export_ReturnList){
    	note=5;
    	this.export_ReturnList=export_ReturnList;
    }
    
    public AllBillVO(ReceiptPO receiptList){
    	note=7;
    	this.receiptList=receiptList;
    }
    
    public AllBillVO(PaymentPO paymentList){
    	note=8;
    	this.paymentList=paymentList;
    }
    public AllBillVO(PatchPO patch){
    	note=6;
    	this.patch=patch;
    }
    public AllBillVO(CommodityPO gift){
    	note=1;
    	this.gift=gift;
    }

}
