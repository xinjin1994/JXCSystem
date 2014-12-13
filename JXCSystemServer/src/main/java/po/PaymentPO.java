package po;

import java.io.Serializable;
import java.util.ArrayList;


public class PaymentPO extends InvoicePO implements Serializable{	
	
	AccountPO account;
	String operator;
	public ArrayList<ItemPO> item=new ArrayList<ItemPO>();
	int total_money;//�����ܶ�
	
	public PaymentPO(AccountPO account, String operator, ArrayList<ItemPO> item) {
		this.operator = operator;
		this.account = account;
		this.item = item;
		for(ItemPO pri:item){
			this.total_money=this.total_money+pri.getMoney();
		}
		this.doc_type=8;
	}
	
	public PaymentPO copy(){
		int i=0;
		ArrayList<ItemPO> array=new ArrayList<ItemPO>();
		for(i=0;i<item.size();i++){
			array.add(item.get(i).copy());
		}
		PaymentPO po=new PaymentPO(account.copy(),operator,array);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		po.setCondition(this.condition);
		po.setInvoiceNote(this.getInvoiceNote());
		return po;
	}
	
	public String getOperator() {
		return operator;
	}
	public AccountPO getAccount(){
		return account;
	}

	public ArrayList<ItemPO> getItem() {
		return item;
	}
	public ArrayList<String> getPs() {
		int i=0;
		ArrayList<String> array=new ArrayList<String>();
		for(i=0;i<item.size();i++){
			array.add(item.get(i).getPs());
		}
		return array;
	}
	public ArrayList<Integer> getPrice() {
		int i=0;
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(i=0;i<item.size();i++){
			array.add(item.get(i).getMoney());
		}
		return array;
	}
	public ArrayList<String> getItemName(){
		int i=0;
		ArrayList<String> array=new ArrayList<String>();
		for(i=0;i<item.size();i++){
			array.add(item.get(i).getItemName());
		}
		return array;
	}
	
	public int getTotalMoney(){
		return total_money;
	}
}
