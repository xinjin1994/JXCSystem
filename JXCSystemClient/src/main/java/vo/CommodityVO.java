package vo;

//VO是逻辑层和界面层传递数据
public class CommodityVO {
	public String id;
	public String name;
	public String type;
	public int num;
	public double inValue;
	public double outValue;
	public double latestInValue;
	public double latestOutValue;
	
	public SortVO fatherSort;

	public CommodityVO(String id, String name, String type, int num, double inValue, double outValue,
			double latestInValue, double latestOutValue) {
		// 编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价
		this.id = id;
		this.name = name;
		this.type=type;
		this.num=num;
		this.inValue=inValue;
		this.outValue=outValue;
		this.latestInValue=latestInValue;
		this.latestOutValue=latestOutValue;

	}

}
