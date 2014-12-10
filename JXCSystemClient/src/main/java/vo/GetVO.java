package vo;

public class GetVO extends InvoiceVO{
	public String cusName;
	public TransferListVO transferList;
	public double total;
	
	public GetVO(String id, String cusName, String operator, TransferListVO transferList,String time,String invoice_note) {
//单据编号（SKD-yyyyMMdd-xxxxx），客户（同时包含供应商和销售商），操作员（当前登录用户），转账列表
		super(invoice_note,id,7,time,operator);
		this.cusName=cusName;
		this.transferList=transferList;
	}
	
	public GetVO(String note,String cusName,TransferListVO transferList){
		super(note,7);
		this.cusName=cusName;
		this.transferList=transferList;
	}

}
