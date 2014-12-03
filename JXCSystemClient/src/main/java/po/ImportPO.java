package po;

import java.io.Serializable;
import java.util.ArrayList;

public class ImportPO extends InvoicePO implements Serializable{
	CustomerPO customer;
	String ps;//��
	String clerk;//Ĭ��ҵ��Ա
	String operator;//����Ա
	int wareHouse;//�ֿ�
	ArrayList<ImportGoodPO> importGoodList; 
	int total_money;//这个是进货的总价
	
	public ImportPO(CustomerPO customer, ArrayList<ImportGoodPO> po,String ps, String clerk,
			String operator,int wareHouse, int total_money) {
		this.customer = customer;
		this.importGoodList=po;
		this.ps = ps;
		this.clerk = clerk;
		this.operator = operator;
		this.wareHouse = wareHouse;
		this.total_money = total_money;
	}
	
	public ImportPO copy(){
		return new ImportPO(customer, importGoodList, ps, clerk, operator, wareHouse, total_money);
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
	
}
