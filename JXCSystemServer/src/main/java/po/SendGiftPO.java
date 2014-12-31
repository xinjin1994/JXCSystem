package po;

import java.io.Serializable;


//这个是库存赠送单的PO
public class SendGiftPO extends InvoicePO implements Serializable{
	
	public CommodityPO commodity;
	public int number;
	public String customer;
//	public String note;
	
	public SendGiftPO(CommodityPO commodity,int number,String note,String customer){
		this.commodity=commodity;
		this.number=number;
		this.note=note;
		this.customer=customer;
		this.doc_type=1;
	}
	
	public CommodityPO getCommodity(){
		return commodity;
	}
	public int getNumber(){
		return number;
	}
	public String getCustomer(){
		return customer;
	}
	
	
	public SendGiftPO copy(){
		SendGiftPO po=new SendGiftPO(commodity.copy(),number,note,customer);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		po.setCondition(this.condition);
		po.setInvoiceNote(this.getInvoiceNote());
		return po;
	}
	
	public void setNumber(int number){
		this.number=number;
	}

}
