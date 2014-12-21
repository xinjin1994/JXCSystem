package vo.bill;


//进货单
public class ImportMenuVO extends InvoiceVO{
	public String supplier;
	public String warehouse;
	public CommodityListVO commodityList;
	public String remark;
	public double total;
	public String id,operator,time,invoice_note;
	public int bill_note;

	public ImportMenuVO(String id,String supplier,String warehouse,String operator,
			CommodityListVO commodityList,String remark,double total,String time,int bill_note,String invoice_note){
	//编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员
		super(invoice_note,id,bill_note,time,operator);
		this.id = id;
		this.supplier=supplier;
		this.warehouse=warehouse;
		this.operator = operator;
		this.commodityList=commodityList;
		this.remark=remark;
		this.total=total;
		this.time = time;
		this.bill_note = bill_note;
		this.invoice_note = invoice_note;
	}
	//ImportMenuVO(String note,String supplier,String warehouse,String commodityList,int bill_note)
	//CommodityListVO(String id, String name, String type, int num, double price, double total, String remark)
	public ImportMenuVO(String note,String supplier,String warehouse,CommodityListVO commodityList,int bill_note){
		super(note,bill_note);
		this.supplier=supplier;
		this.warehouse=warehouse;
		this.commodityList=commodityList;
	}
	
}


