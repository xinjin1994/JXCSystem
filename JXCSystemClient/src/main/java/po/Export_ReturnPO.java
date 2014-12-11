package po;

import java.io.Serializable;
import java.util.ArrayList;

public class Export_ReturnPO extends InvoicePO implements Serializable{
	
	CustomerPO customer;
	String ps;//��
	String clerk;//Ĭ��ҵ��Ա
	String operator;//����Ա
	String wareHouse;//�ֿ�
	ArrayList<ExportGoodPO> exportGoodList; 
	double total_money_before;//这个是折让前的总价
	double total_money_after;//这个是这让后的总价
	double discount;//折扣金额
	double voucher;//使用代金券金额
	String old_note;
	

	public Export_ReturnPO(CustomerPO customer, ArrayList<ExportGoodPO> po,String ps, String clerk,
			String operator,String wareHouse, double total_money_before,double total_money_after,
			double discount,double voucher,String old_note) {
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
		this.condition=5;
	}
	
	
	public Export_ReturnPO copy(){
		ArrayList<ExportGoodPO> array=new ArrayList<ExportGoodPO>();
		for(int i=0;i<exportGoodList.size();i++){
			array.add(exportGoodList.get(i).copy());
		}
		Export_ReturnPO po=new Export_ReturnPO(customer.copy(), array, ps, clerk, operator, wareHouse,
				total_money_before, total_money_after, discount, voucher,old_note);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		po.setCondition(this.condition);
		po.setInvoiceNote(this.getInvoiceNote());
		return po;
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

	public String getWareHouse() {
		return wareHouse;
	}

	public double getTotalMoneyBefore() {
		return total_money_before;
	}	
	public double getTotalMoneyAfter(){
		return total_money_after;
	}
	public double getDiscount(){
		return discount;
	}
	public double getVoucher(){
		return voucher;
	}
	
	public String getOldNote(){
		return old_note;
	}
	public void setOldNote(String old_note){
		this.old_note=old_note;
	}
}
