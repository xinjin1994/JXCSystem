package po;

import java.io.Serializable;
import java.util.ArrayList;

public class ExportPO extends InvoicePO implements Serializable{
	
	CustomerPO customer;
	String ps;//��
	String clerk;//Ĭ��ҵ��Ա
	String operator;//����Ա
	int wareHouse;//�ֿ�
	ArrayList<ExportGoodPO> exportGoodList; 
	int total_money_before;//这个是折让前的总价
	int total_money_after;//这个是这让后的总价
	int discount;//折扣金额
	int voucher;//使用代金券金额
	

	public ExportPO(CustomerPO customer, ArrayList<ExportGoodPO> po,String ps, String clerk,
			String operator,int wareHouse, int total_money_before,int total_money_after,int discount,int voucher) {
		this.customer = customer;
		this.exportGoodList=po;
		this.ps = ps;
		this.clerk = clerk;
		this.operator = operator;
		this.wareHouse = wareHouse;
		this.total_money_before = total_money_before;
		this.total_money_after=total_money_after;
		this.discount=discount;
		this.voucher=voucher;
	}
	
	
	public ExportPO copy(){
		return new ExportPO(customer, exportGoodList, ps, clerk, operator, wareHouse,
				total_money_before, total_money_after, discount, voucher);
	}
	
	
	public CustomerPO getCustomer() {
		return customer;
	}
	public ArrayList<ExportGoodPO> getImportGoodList(){
		return exportGoodList;
	}

	public String getPs() {
		return ps;
	}

	public String getClerk() {
		return clerk;
	}

	public String getOperator() {
		return operator;
	}

	public int getWareHouse() {
		return wareHouse;
	}

	public int getTotalMoneyBefore() {
		return total_money_before;
	}	
	public int getTotalMoneyAfter(){
		return total_money_after;
	}
	public int getDiscount(){
		return discount;
	}
	public int getVoucher(){
		return voucher;
	}
}
