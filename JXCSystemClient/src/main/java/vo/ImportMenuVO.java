package vo;
//进货单
public class ImportMenuVO {
	public String id;
	public String supplier;
	public String warehouse;
	public String operator;
	public String commodityList;
	public String remark;
	public double total;
public ImportMenuVO(String id,String supplier,String warehouse,String operator,String commodityList,String remark,double total){
	//编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
	this.id=id;
	this.supplier=supplier;
	this.warehouse=warehouse;
	this.operator=operator;
	this.commodityList=commodityList;
	this.remark=remark;
	this.total=total;
	
}
}


