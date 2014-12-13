package vo.bill;


//销售单
public class ExportMenuVO extends InvoiceVO{
	public String cusName;
	public String salesMan;
	public String warehouse;
	public CommodityListVO commodityList;
	public double beforeValue;
	public double discount;
	public double voucherPrice;
	public double afterValue;
	String remark;
	
	public ExportMenuVO(String id,String cusName,String salesMan,String operator,String warehouse,
			CommodityListVO commodityList,double beforeValue,double discount,double voucherPrice,
			double afterValue,String remark,String time,int bill_note,String invoice_note){
		//单据编号（XSD-yyyyMMdd-xxxxx），客户（仅显示销售商），业务员（和这个客户打交道的公司员工，可以设置一个客户的默认业务员），操作员（当前登录系统的用户），仓库，出货商品清单，折让前总额，折让，使用代金卷金额，折让后总额，备注
		super(invoice_note,id,bill_note,time,operator);
		this.cusName=cusName;
		this.salesMan=salesMan;
		this.warehouse=warehouse;
		this.commodityList=commodityList;
		this.beforeValue=beforeValue;
		this.discount=discount;
		this.voucherPrice=voucherPrice;
		this.afterValue=afterValue;
		this.remark=remark;
	}
	// CommodityListVO(String id, String name, String type, int num, double price(折让前总价), double total, String remark)
	public ExportMenuVO(String note,String cusName,String salesMan,String warehouse,
			CommodityListVO commodityList,double discount,double voucherPrice,
			double afterValue,int bill_note){
		super(note,bill_note);
		this.cusName=cusName;
		this.salesMan=salesMan;
		this.warehouse=warehouse;
		this.commodityList=commodityList;
		this.discount=discount;
		this.voucherPrice=voucherPrice;
		this.afterValue=afterValue;
	}
}
