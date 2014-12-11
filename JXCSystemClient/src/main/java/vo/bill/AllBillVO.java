package vo.bill;

import po.CommodityPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;

public class AllBillVO {
	
//	public ImportPO importList;
//	public Import_ReturnPO import_ReturnList; 
//	public ExportPO exportList;
//	public Export_ReturnPO export_ReturnList;
//	public PaymentPO paymentList;
//	public ReceiptPO receiptList;
//	public PatchPO patch;
//	public CommodityPO gift;
	public String note;
	public String operator;
	public String time;
	
	public int bill_note;       
						//1代表SendGiftVO，                  2代表ImportVO，  3代表Import_ReturnVO， 4代表ExportVO，
						//5代表Export_ReturnVO， 6代表PatchVO，     7代表ReceiptVO，                      8代表PaymentVO
	
	public AllBillVO(String note,String operator,String time,int bill_note){
		this.bill_note=bill_note;
		this.note=note;
		this.operator=operator;
		this.time=time;
	}
	
	public AllBillVO(String note,int bill_note){
		this.note=note;
		this.bill_note=bill_note;
	}

	
	
	public AllBillVO(){
		bill_note=0;
	}
	
//    public AllBillVO(ImportPO importList){
//    	note=2;
//    	this.importList=importList;
//    }
//    
//    public AllBillVO(ExportPO exportList){
//    	note=4;
//    	this.exportList=exportList;
//    }
//    
//    public AllBillVO(Import_ReturnPO import_ReturnList){
//    	note=3;
//    	this.import_ReturnList=import_ReturnList;
//    }
//    
//    public AllBillVO(Export_ReturnPO export_ReturnList){
//    	note=5;
//    	this.export_ReturnList=export_ReturnList;
//    }
//    
//    public AllBillVO(ReceiptPO receiptList){
//    	note=7;
//    	this.receiptList=receiptList;
//    }
//    
//    public AllBillVO(PaymentPO paymentList){
//    	note=8;
//    	this.paymentList=paymentList;
//    }
//    public AllBillVO(PatchPO patch){
//    	note=6;
//    	this.patch=patch;
//    }
//    public AllBillVO(CommodityPO gift){
//    	note=1;
//    	this.gift=gift;
//    }

}
