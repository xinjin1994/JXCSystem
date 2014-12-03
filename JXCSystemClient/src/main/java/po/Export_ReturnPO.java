package po;

import java.io.Serializable;
import java.util.ArrayList;

public class Export_ReturnPO extends InvoicePO implements Serializable{
	
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
	String old_note;
	

	public Export_ReturnPO(CustomerPO customer, ArrayList<ExportGoodPO> po,String ps, String clerk,
			String operator,int wareHouse, int total_money_before,int total_money_after,
			int discount,int voucher,String old_note) {
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
		this.old_note=old_note;
	}
	
	
	public Export_ReturnPO copy(){
		return new Export_ReturnPO(customer, exportGoodList, ps, clerk, operator, wareHouse,
				total_money_before, total_money_after, discount, voucher,old_note);
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
	
	public String getOldNote(){
		return old_note;
	}
	public void setOldNote(String old_note){
		this.old_note=old_note;
	}
}
