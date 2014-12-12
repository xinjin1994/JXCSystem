package po;

import java.io.Serializable;

public class PatchPO extends InvoicePO implements Serializable{
	
	CommodityPO commodity;
	int number;//����
	String operator;
	
	public PatchPO(CommodityPO commodity, int number, String operator) {
		this.commodity=commodity;
		this.number = number;
		this.doc_type=6;
	}
	
	public PatchPO copy(){
		PatchPO po=new PatchPO(commodity.copy(), number,operator);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		po.setCondition(this.condition);
		po.setInvoiceNote(this.getInvoiceNote());
		return po;
	}

	
	public CommodityPO getCommodity(){
		return commodity;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getOperator(){
		return operator;
	}
	
}
