package vo;

public class InvoiceVO {
	
	public String invoice_note;
	public String note;
	int type;
	public String time;
	
	public InvoiceVO(String invoice_note,String note,int type,String time){
		this.invoice_note=invoice_note;
		this.note=note;
		this.type=type;
		this.time=time;
	}
	
	

}
