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
	
	public void setTime(String time){
		this.time=time;
	}
	public void setNote(String note){
		this.note=note;
	}
}
