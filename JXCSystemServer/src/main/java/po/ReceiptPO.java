package po;

import java.io.Serializable;
import java.util.ArrayList;


public class ReceiptPO extends InvoicePO implements Serializable{
	String operator;//����Ա
	public CustomerPO customer;
	public ArrayList<TransferPO> transfer;
	int total_money;//ת���ܶ�
	
	public ReceiptPO(String operator, CustomerPO customer,ArrayList<TransferPO> transfer) {
		this.transfer=transfer;
		this.operator = operator;
		this.customer=customer;
		for(TransferPO po:transfer){
			this.total_money=this.total_money+po.getMoney();
		}
		this.doc_type=7;
	}
	
	public ReceiptPO copy(){
		ArrayList<TransferPO> array=new ArrayList<TransferPO>();
		for(int i=0;i<transfer.size();i++){
			array.add(transfer.get(i).copy());
		}
		ReceiptPO po=new ReceiptPO(operator,customer.copy(),array);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		po.setCondition(this.condition);
		po.setInvoiceNote(this.getInvoiceNote());
		return po;
	}

	
	public String getOperator() {
		return operator;
	}
	public CustomerPO getCustomer() {
		return customer;
	}
	public ArrayList<TransferPO> getTransfer() {
		return transfer;
	}
	public int getTotalMoney(){
		return total_money;
	}
	public ArrayList<String> getAccountName(){
		ArrayList<String> array=new ArrayList<String>();
		int i=0;
		for(i=0;i<transfer.size();i++){
			array.add(transfer.get(i).getAccount());
		}
		return array;
	}
	public ArrayList<Integer> getPrice(){
		ArrayList<Integer> array=new ArrayList<Integer>();
		int i=0;
		for(i=0;i<transfer.size();i++){
			array.add(transfer.get(i).getMoney());
		}
		return array;
	}
	public ArrayList<String> getPs(){
		ArrayList<String> array=new ArrayList<String>();
		int i=0;
		for(i=0;i<transfer.size();i++){
			array.add(transfer.get(i).getPs());
		}
		return array;
	}
}
