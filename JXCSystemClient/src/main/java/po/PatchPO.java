package po;

import java.io.Serializable;

public class PatchPO extends InvoicePO implements Serializable{
	
	CommodityPO commodity;
	int number;//����
	
	public PatchPO(CommodityPO commodity, int number) {
		this.commodity=commodity;
		this.number = number;
		this.doc_type=6;
	}
	
	public PatchPO copy(){
		return new PatchPO(commodity.copy(), number);
	}

	
	public CommodityPO getCommodity(){
		return commodity;
	}
	
	public int getNumber() {
		return number;
	}
	
}
