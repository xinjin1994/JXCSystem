package vo.bill;


public class InvoiceVO extends AllBillVO{
	
	public String invoice_note;
	
	public InvoiceVO(String invoice_note,String note,int bill_note,String time,String operator){
		super(note,operator,time,bill_note);
		this.invoice_note=invoice_note;
	}
	public InvoiceVO(String note,int bill_note){
		super(note,bill_note);
		this.invoice_note=null;
	}
	
}
