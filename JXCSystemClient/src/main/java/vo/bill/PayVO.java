package vo.bill;


//付款单
public class PayVO extends InvoiceVO{
//	public String cusName;
	public String bankAccount;
	public ItemList itemList;
//	public double total;
	public PayVO(String id,String operator,String bankAccount,ItemList itemList,String time,String invoice_note) {
         //单据编号（XJFYD-yyyyMMdd-xxxxx）,操作员（当前登录用户），银行账户，条目清单
		super(invoice_note,id,8,time,operator);
		this.bankAccount=bankAccount;
		this.itemList=itemList;
	}
	
	public PayVO(String note,String bankAccount,ItemList itemList){
		super(note,8);
		this.bankAccount=bankAccount;
		this.itemList=itemList;
	}
	
}
