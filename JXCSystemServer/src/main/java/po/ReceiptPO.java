package po;

import java.io.Serializable;
import java.util.ArrayList;


public class ReceiptPO extends InvoicePO implements Serializable{
	String operator;//����Ա
	CustomerPO customer;
	ArrayList<TransferPO> transfer;
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
		int i=0;
		ArrayList<TransferPO> array=new ArrayList<TransferPO>();
		for(i=0;i<transfer.size();i++){
			array.add(new TransferPO(transfer.get(i).getAccount(),transfer.get(i).getMoney(),transfer.get(i).getPs()));
		}
		ReceiptPO po=new ReceiptPO(operator,customer.copy(),array);
		po.setNote(this.getNote());
		po.setTime(this.getTime());
		return po;
	}
	
//	public ReceiptPO(GetVO vo){
//		this.setNote(vo.id);
//		this.operator=vo.operator;
//		this.name=vo.cusName;
//		account=new String[vo.transferList.length];
//		ps=new String[vo.transferList.length];
//		price=new int[vo.transferList.length];
//		int i=0;
//		for(i=0;i<vo.transferList.length;i++){
//			account[i]=vo.transferList[i].bankAccount;
//			ps[i]=vo.transferList[i].remark;
//			price[i]=(int) vo.transferList[i].transferValue;
//		}
//		total_money=(int) vo.total;
//	}
	
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
