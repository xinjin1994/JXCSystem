package po;

import java.io.Serializable;

public class DiscountPO implements Serializable{
	String time1;//��ʼʱ��
	String time2;//����ʱ��
	int start_money;//����ǰ�۸�
	int end_money;//���ú�۸�
	int discount;//���õĴ��ȯ�۸�
	int discountMoney;//���ý��
	
	public DiscountPO(int dm,String t1,String t2,int sm,int em,int d) {
		time1 = t1;
		time2 = t2;
		start_money = sm;
		end_money = em;
		discount = d;
		discountMoney = dm;
	}
	
	
	public DiscountPO copy(){
		return new DiscountPO(discountMoney, time1, time2, start_money, end_money, discount);
	}
	
	
	public String getTime1() {
		return time1;
	}

	public String getTime2() {
		return time2;
	}

	public int getStart_money() {
		return start_money;
	}

	public int getEnd_money() {
		return end_money;
	}

	public int getDiscount() {
		return discount;
	}
	
	public int getDiscountMoney() {
		return discountMoney;
	}
}

