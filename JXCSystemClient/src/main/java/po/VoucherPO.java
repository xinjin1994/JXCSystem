package po;

import java.io.Serializable;


//代金券促销策略PO对象
public class VoucherPO extends PromotionPO implements Serializable{

	int voucherMoney;
	
	public VoucherPO(String start_time,String end_time,int start_money,int end_money, int voucherMoney,int level){
		super(start_time,end_time,level,start_money,end_money);
		this.voucherMoney=voucherMoney;
	}
	

	public int getVoucherMoney(){
		return voucherMoney;
	}
	
	public VoucherPO copy(){
		return new VoucherPO(start_time,end_time,start_money,end_money, voucherMoney, level);
	}
	
}
