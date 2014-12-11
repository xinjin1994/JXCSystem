package po;

import java.io.Serializable;


//这个是所有单据PO的父类
public class AllBillPO implements Serializable{

	String time;
	String note;
	int doc_type;    //1代表SendGiftPO，                     2代表ImportPO，                3代表Import_Return，         4代表ExportPO，
					 //5代表Export_ReturnPO，   6代表PatchPO，                    7代表ReceiptPO，                       8代表PaymentPO
					 //9代表WarnPO           10代表SystemlogPO
	
	public String getTime(){
		return time;
	}
	public String getNote(){
		return note;
	}
	public int getDocType(){
		return doc_type;
	}
	
	public void setTime(String time){
		this.time=time;
	}
	public void setNote(String note){
		this.note=note;
	}
	
	public AllBillPO copy(){
		switch(doc_type){
		case 1:return (AllBillPO) ((SendGiftPO) this).copy();
		case 2:return (AllBillPO) ((ImportPO) this).copy();
		case 3:return (AllBillPO) ((Import_ReturnPO) this).copy();
		case 4:return (AllBillPO) ((ExportPO) this).copy();
		case 5:return (AllBillPO) ((Export_ReturnPO) this).copy();
		case 6:return (AllBillPO) ((PatchPO) this).copy();
		case 7:return (AllBillPO) ((ReceiptPO) this).copy();
		case 8:return (AllBillPO) ((PaymentPO) this).copy();
		case 9:return (AllBillPO) ((WarnPO) this).copy();
		case 10:return (AllBillPO) ((SystemlogPO) this).copy();
		}
		return null;
	}
	
}
