package po;

import java.io.Serializable;

public class OperatingConditionPO implements Serializable{

	int sale_income;//���ú�����
	int good_income;
	int sale_outcome;
	int good_outcome;
	int discount;//����
	int profit;//����
	
	public OperatingConditionPO(int sale_income,int good_income, int sale_outcome,int good_outcome,
			int discount) {
		super();
		this.sale_income = sale_income;
		this.good_income=good_income;
		this.sale_outcome=sale_outcome;
		this.good_outcome=good_outcome;
		this.discount = discount;
		profit=sale_income+good_income-sale_outcome-good_outcome-discount;
	}
	
	public OperatingConditionPO copy(){
		return new OperatingConditionPO(sale_income, good_income, sale_outcome, good_outcome, discount);
	}

	public int getSaleIncome(){
		return sale_income;
	}
	public int getGoodIncome(){
		return good_income;
	}
	public int getSaleOutcome(){
		return sale_outcome;
	}
	public int getGoodOutcome(){
		return good_outcome;
	}
	public int getDiscount(){
		return discount;
	}
	
	public int getProfit(){
		return profit;
	}
	
	
	public int getIncome() {
		return sale_income+good_income-discount;
	}

	public int getOutcome() {
		return sale_outcome+good_outcome;
	}
	
	public void add(OperatingConditionPO po){
		sale_income=po.sale_income+sale_income;
		good_income=po.good_income+good_income;
		sale_outcome=po.sale_outcome+sale_outcome;
		good_outcome=po.good_outcome+good_outcome;
		discount=po.discount+discount;
		profit=sale_income+good_income-sale_outcome-good_outcome-discount;
	}
	
}
