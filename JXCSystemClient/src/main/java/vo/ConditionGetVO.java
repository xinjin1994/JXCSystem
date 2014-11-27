package vo;

public class ConditionGetVO {
//查看经营历程表收入类
	public double salesGet;
	public double commodityOverGet;
	public double changePriceGet;
	public double inOutfPrice;
	public double voucherGetPrice;
	public double totalPrice;
	//销售收入、商品报溢收入 成本调价收入 进货退货差价 代金券与实际收款差额收入.折让后总收入
	public ConditionGetVO(double salesGet, double commodityOverGet, double changePriceGet, double inOutfPrice,
			double voucherGetPrice, double totalPrice) {
		this.salesGet = salesGet;
		this.commodityOverGet = commodityOverGet;
		this.changePriceGet = changePriceGet;
		this.inOutfPrice = inOutfPrice;
		this.voucherGetPrice = voucherGetPrice;
		this.totalPrice = totalPrice;
	}
	
}
