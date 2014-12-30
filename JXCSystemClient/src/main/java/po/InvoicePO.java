package po;

import java.io.Serializable;

public class InvoicePO extends AllBillPO implements Serializable{
//	String draft_condition;//�ݸ�
//	String submit_condition;//�ύ״̬
//	String approve_condition;//�����
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 900;
	int condition;   //0 代表草稿，1代表待审批。2代表通过。3代表失败
//	int invoice_type;        //1代表SendGoodPO， 2代表ImportPO， 3代表Import_Return， 4代表ExportPO，
//					 //5代表Export_Return， 6代表PatchPO， 7代表ReceiptPO， 8代表PaymentPO
	String invoice_note;
	

	public InvoicePO() {
		condition=0;
	}
	
	public InvoicePO copy(){
		return (InvoicePO) ((AllBillPO) this).copy();
	}
	
	public InvoicePO invoice_copy(InvoicePO po1,InvoicePO po2){
		po1.condition=po2.condition;
		po1.invoice_note=po2.invoice_note;
		return po1;
	}

	public String getInvoiceNote() {
		// TODO Auto-generated method stub
		return invoice_note;
	}
	
	public int getCondition(){
		return condition;
	}
	
	public void setInvoiceNote(String invoice_note){
		this.invoice_note=invoice_note;
	}
	
	public void setCondition(int condition){
		this.condition=condition;
	}

	
	

}
