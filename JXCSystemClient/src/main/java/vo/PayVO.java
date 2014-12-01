package vo;
//付款单
public class PayVO {
	public String id;
	public String operator;
	public String cusName;
	public String bankAccount;
	public ItemList[] itemList;
	public double total;
	public PayVO(String id,String operator,String cusName, String bankAccount,ItemList[] itemList,double total) {
         //单据编号（XJFYD-yyyyMMdd-xxxxx）,操作员（当前登录用户），银行账户，条目清单，总额。
		this.id=id;
		this.operator=operator;
		this.cusName=cusName;
		this.bankAccount=bankAccount;
		this.itemList=itemList;
		this.total=total;
	}
}
