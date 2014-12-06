package vo;

public class GetVO {
	public String id;
	public String cusName;
	public String operator;
	public TransferListVO transferList;
//	public double total;
	public GetVO(String id, String cusName, String operator, TransferListVO transferList) {
//单据编号（SKD-yyyyMMdd-xxxxx），客户（同时包含供应商和销售商），操作员（当前登录用户），转账列表
		this.id=id;
		this.cusName=cusName;
		this.operator=operator;
		this.transferList=transferList;
//		this.total=total;
	}

}
