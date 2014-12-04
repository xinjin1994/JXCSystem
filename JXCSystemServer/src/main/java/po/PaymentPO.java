package po;

import java.io.Serializable;
import java.util.ArrayList;


public class PaymentPO extends InvoicePO implements Serializable{	
	
	AccountPO account;
	String operator;
	ArrayList<ItemPO> item=new ArrayList<ItemPO>();
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
			array.add(new ItemPO(item.get(i).getItemName(),item.get(i).getMoney(),item.get(i).getPs()));
		}
		PaymentPO po=new PaymentPO(account.copy(),operator,array);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		return po;
	}
	
//	public PaymentPO(PayVO vo){
//		this.serialnum=vo.id;
//		this.operator=vo.operator;
//		this.name=vo.cusName;
//		int i=0;
//		account=new String[vo.itemList.length];
//		ps=new String[vo.itemList.length];
//		price=new int[vo.itemList.length];
//		for(i=0;i<vo.itemList.length;i++){
//			account[i]=vo.itemList[i].itemName;
//			ps[i]=vo.itemList[i].remark;
//			price[i]=(int) vo.itemList[i].money;
//		}
//	}
	
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
