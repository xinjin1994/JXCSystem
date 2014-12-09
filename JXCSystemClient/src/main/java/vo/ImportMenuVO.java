package vo;
//进货单
public class ImportMenuVO extends InvoiceVO{
	public String supplier;
	public String warehouse;
	public String commodityList;
	public String remark;
	public double total;

	public ImportMenuVO(String id,String supplier,String warehouse,String operator,
			String commodityList,String remark,double total,String time,int bill_note,String invoice_note){
	//编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
	super(invoice_note,id,bill_note,time,operator);
	this.supplier=supplier;
	this.warehouse=warehouse;
	this.commodityList=commodityList;
	this.remark=remark;
	this.total=total;
	}
	
}


