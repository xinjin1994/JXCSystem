package vo;

public class ConditionVO {
	
	public double sales_income;
	public double com_income;
	public double discount;
	public double sales_outcome;
	public double com_outcome;
	public double profit;
	
	public ConditionVO(double sales_income,double com_income,double discount,double sales_outcome, double com_outcome){
		this.sales_income=sales_income;
		this.com_income=com_income;
		this.discount=discount;
		this.sales_outcome=sales_outcome;
		this.com_outcome=com_outcome;
		this.profit=sales_income+com_income-discount-sales_outcome-com_outcome;
	}
	
	public double getProfit(){
		return sales_income+com_income-discount-sales_outcome-com_outcome;
	}

}
