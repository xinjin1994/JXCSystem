package vo;

public class ConditionPayVO {
	// 查看经营历程表支出类
	public double salesCost;
	public double commodityDamage;
	public double commodityGift;
	public double totalPay;

	// 销售成本、商品报损 商品赠出.总支出
	public ConditionPayVO(double salesCost, double commodityDamage, double commodityGift, double totalPay) {
		this.salesCost = salesCost;
		this.commodityDamage = commodityDamage;
		this.commodityGift = commodityGift;
		this.totalPay = totalPay;
	}

}
