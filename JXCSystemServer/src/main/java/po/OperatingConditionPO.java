package po;

import java.io.Serializable;

public class OperatingConditionPO implements Serializable{

	int income;//���ú�����
	int discount;//����
	int outcome;//֧��
//	int profit;//����
	
	public OperatingConditionPO(int income, int discount, int outcome) {
		super();
		this.income = income;
		this.discount = discount;
		this.outcome = outcome;
	}
	
	public OperatingConditionPO copy(){
		return new OperatingConditionPO(income,discount,outcome);
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
	
	public int getProfit(){
		return income-outcome;
	}
	
	public void add(OperatingConditionPO po){
		income=po.income+income;
		outcome=po.outcome+outcome;
		discount=po.discount+discount;
	}
	
}
