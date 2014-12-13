package vo.bill;


public class PatchVO extends InvoiceVO{
	
	public String name;
	public String type;
	public int number;

	public PatchVO(String name,String type,int number,String id,String time,String operator,String invoice_note){
		super(invoice_note,id,6,time,operator);
		this.name=name;
		this.type=type;
		this.number=number;
	}
	
	public PatchVO(String name,String type,int number,String note){
		super(note,6);
		this.name=name;
		this.type=type;
		this.number=number;
	}

}
