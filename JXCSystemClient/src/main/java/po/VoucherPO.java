package po;

import java.io.Serializable;


//代金券促销策略PO对象
public class VoucherPO extends PromotionPO implements Serializable{

	double voucherMoney;
	
	public VoucherPO(String start_time,String end_time,double start_money,double end_money, double voucherMoney,int level){
		super(start_time,end_time,level,start_money,end_money);
		this.voucherMoney=voucherMoney;
	}
	

	public double getVoucherMoney(){
		return voucherMoney;
	}
	
	public VoucherPO copy(){
		return new VoucherPO(start_time,end_time,start_money,end_money, voucherMoney, level);
	}
	
}
