package vo;

public class ConditionVO {
	
	public double sales_income;
	public double com_income;
	public double discount;
	public double sales_outcome;
	public double com_outcome;
	public double profit;
	
	public double getProfit(){
		return sales_income+com_income-discount-sales_outcome-com_outcome;
	}

}
