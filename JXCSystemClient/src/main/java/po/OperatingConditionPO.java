package po;

import java.io.Serializable;

public class OperatingConditionPO implements Serializable{

	int income;//折让后收入
	int discount;//折让
	int outcome;//支出
	int profit;//利润
	
	public OperatingConditionPO(int income, int discount, int outcome,
			int profit) {
		super();
		this.income = income;
		this.discount = discount;
		this.outcome = outcome;
		this.profit = profit;
	}

	public int getIncome() {
		return income;
	}

	public int getDiscount() {
		return discount;
	}

	public int getOutcome() {
		return outcome;
	}

	public int getProfit() {
		return profit;
	}
}
