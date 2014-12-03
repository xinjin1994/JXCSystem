package po;


//代金券促销策略PO对象
public class VoucherPO extends PromotionPO {

	int voucherMoney;
	
	public VoucherPO(String start_time,String end_time,int start_money,int end_money, int voucherMoney){
		super(start_time,end_time,start_money,end_money);
		this.voucherMoney=voucherMoney;
	}
	
	
	public int getVoucherMoney(){
		return voucherMoney;
	}
	
}
