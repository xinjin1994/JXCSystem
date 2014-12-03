package po;

import java.io.Serializable;
import java.util.ArrayList;

public class Import_ReturnPO extends InvoicePO implements Serializable{
	CustomerPO customer;
	String ps;//��
	String clerk;//Ĭ��ҵ��Ա
	String operator;//����Ա
	int wareHouse;//�ֿ�
	ArrayList<ImportGoodPO> importGoodList; 
	int total_money;//这个是进货的总价
	String old_note;
	
	public Import_ReturnPO(CustomerPO customer, ArrayList<ImportGoodPO> po,String ps, String clerk,
			String operator,int wareHouse, int total_money,String old_note) {
		this.customer = customer;
		this.importGoodList=po;
		this.ps = ps;
		this.clerk = clerk;
		this.operator = operator;
		this.wareHouse = wareHouse;
		this.total_money = total_money;
		this.old_note=old_note;
	}
	
	public Import_ReturnPO copy(){
		return new Import_ReturnPO(customer, importGoodList, ps, clerk, operator, wareHouse, total_money,old_note);
	}
	
	
	public CustomerPO getCustomer() {
		return customer;
	}
	public ArrayList<ImportGoodPO> getImportGoodList(){
		return importGoodList;
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

	public int getTotalMoney() {
		return total_money;
	}	
	public String getOldNote(){
		return old_note;
	}
	
	public void setOldNote(String old_note){
		this.old_note=old_note;
	}
	
}
