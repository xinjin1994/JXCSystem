package vo;

public class InitialCommodityVO {
	public String classification;
	public String name;
	public String type;
	public double purSales;
	public double latestInValue;
	public double latestOutValue;
	public InitialCommodityVO(String classification, String name, String type, double purSales,
			double latestInValue, double latestOutValue) {
		super();
		this.classification = classification;
		this.name = name;
		this.type = type;
		this.purSales = purSales;
		this.latestInValue = latestInValue;
		this.latestOutValue = latestOutValue;
	}

	// 添加商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空）
	
	
}
