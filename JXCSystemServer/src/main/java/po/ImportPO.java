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
		this.doc_type=2;
	}
	
	public ImportPO copy(){
		ArrayList<ImportGoodPO> array=new ArrayList<ImportGoodPO>();
		for(int i=0;i<importGoodList.size();i++){
			array.add(importGoodList.get(i).copy());
		}
		ImportPO po=new ImportPO(customer.copy(), array, ps, clerk, operator, wareHouse, total_money);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		po.setCondition(this.condition);
		po.setInvoiceNote(this.getInvoiceNote());
		return po;
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
