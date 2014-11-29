package po;

import java.io.Serializable;

public class InvoicePO implements Serializable{
//	String draft_condition;//�ݸ�
//	String submit_condition;//�ύ״̬
//	String approve_condition;//�����
	
	int condition;   //0 代表草稿，1代表待审批。2代表通过。3代表失败
	int type;        //1代表CommodityPO， 2代表ImportPO， 3代表Import_Return， 4代表ExportPO，
					 //5代表Export_Return， 6代表PatchPO， 7代表ReceiptPO， 8代表PaymentPO
	String note;
	

	public InvoicePO() {
		condition=0;
	}
	
	public InvoicePO copy(){
		
		switch(type){
		case 1: CommodityPO po1=(CommodityPO) this;
			
			break;
		case 2: ImportPO po2=(ImportPO) this;break;
		case 3: 
		}
		
		return null;
		
	}

	
	

}
