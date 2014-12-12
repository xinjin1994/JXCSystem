package vo.bill;

public class CommodityListVO {
	public String id;
	public String name;
	public String type;
	public int num;
	public double price;
	public double total;
	public String remark;
	public CommodityListVO(String id, String name, String type, int num, double price, double total, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.num = num;
		this.price = price;
		this.total = total;
		this.remark = remark;
	}
}
