package vo;

public class ConditionVO {
	
	public ConditionGetVO get;
	public ConditionPayVO pay;
	
	public double getProfit(){
		return get.totalPrice-pay.totalPay;
	}

}
