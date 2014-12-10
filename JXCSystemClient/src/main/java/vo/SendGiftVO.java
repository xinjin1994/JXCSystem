package vo;

public class SendGiftVO extends InvoiceVO{
	

	public String name;
	public String type;
	public int number;
	
	public SendGiftVO(String note, String time,String operator,String name,String type,int number,String invoice_note) {
		super(invoice_note, note, 1, time, operator);
		this.name=name;
		this.type=type;
		this.number=number;
		// TODO Auto-generated constructor stub
	}
	
	public SendGiftVO(String note,String name,String type, int number){
		super(note,1);
		this.name=name;
		this.type=type;
		this.number=number;
	}
	
}
