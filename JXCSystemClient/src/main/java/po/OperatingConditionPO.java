package po;

import java.io.Serializable;

public class OperatingConditionPO implements Serializable{
	String old_note;
	public String time;
	double sale_income;//���ú�����
	double good_income;
	double sale_outcome;
	double good_outcome;
	double discount;//����
	double profit;//����
	
	public OperatingConditionPO(String note,String time,double sale_income,double good_income, double sale_outcome,double good_outcome,double discount) {
		this.old_note=note;
		this.time=time;
		this.sale_income = sale_income;
		this.good_income=good_income;
		this.sale_outcome=sale_outcome;
		this.good_outcome=good_outcome;
		this.discount = discount;
		profit=sale_income+good_income-sale_outcome-good_outcome-discount;
	}
	
	public OperatingConditionPO copy(){
		return new OperatingConditionPO(old_note,time,sale_income, good_income, sale_outcome, good_outcome, discount);
	}

	public double getSaleIncome(){
		return sale_income;
	}
	public double getGoodIncome(){
		return good_income;
	}
	public double getSaleOutcome(){
		return sale_outcome;
	}
	public double getGoodOutcome(){
		return good_outcome;
	}
	public double getDiscount(){
		return discount;
	}
	
	public double getProfit(){
		return profit;
	}
	public String getOldNote(){
		return old_note;
	}
	public String getTime(){
		return time;
	}
	
	
	public double getIncome() {
		return sale_income+good_income-discount;
	}

	public double getOutcome() {
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
