package businesslogic.accountbl;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;
import businesslogic.invoicebl.Invoice;
import businesslogic.salesbl.Sales;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.accountblservice.AccountblService;
import data.accountdata.AccountDataService_Stub;
import dataservice.accountdataservice.AccountDataService;

public class Account implements AccountblService, businesslogic.financialbl.AccountInfo,
			businesslogic.initializationlbl.AccountInfo, businesslogic.invoicebl.AccountInfo {

	public AccountDataService account=new AccountDataService_Stub("mainAccount",0);
	public FinancialInfo financial;
	public InvoiceInfo invoice=new Invoice();
	public SalesInfo sales=new Sales();
	public SystemlogInfo systemlog=new Systemlog();
	
	public String checkAccount() {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		if (account.getAccount() != null) {
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addAccount(String name, int money) {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		AccountPO acc = new AccountPO(name, money);
		if (account.addAccount(acc)) {
			systemlog.add("addAccount:"+acc.getName()+","+acc.getMoney());
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String delAccount(String name) {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		AccountPO acc = account.findAccount(name);
		if (account.delAccount(acc)) {
			systemlog.add("delAccount:"+acc.getName());
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String updateAccount(String name1, String name2) {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		AccountPO acc1 = account.findAccount(name1);
		AccountPO acc2 = new AccountPO(name2, acc1.getMoney());
		if (account.updateAccount(acc1, acc2)) {
			systemlog.add("updateAccount:"+acc1.getName()+","+acc2.getName());
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String searchAccount(String word) {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		if (account.findAccount(word) != null) {
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String addReceipt(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
//		account=new AccountDataService_Stub("accountName",10);
		String[] accountList={account_name};
		int[] price={10};
		ReceiptPO po= new ReceiptPO("serialnum", "operator", "name", accountList, "ps", price);
		if(account.addReceipt(po)){
			invoice.add(po);
			systemlog.add("addReceipt:"+po.getOperator()+","+po.getName()+","+po.getTotal());
			return "�ɹ�";
		}
		return  "ʧ��";
	}

	public String addPayment(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
//		account=new AccountDataService_Stub("accountName",10);
		String[] accountList={account_name};
		int[] price={10};
		PaymentPO po= new PaymentPO("serialnum","operator", "Customer_name", accountList, "item", "ps", price);
		
		if(account.addPayment(po)){
			invoice.add(po);
			systemlog.add("addPayment:"+po.getOperator()+","+po.getName()+","+po.getTotal());
			return "�ɹ�";
		}
		return  "ʧ��";
	}
	
	public String addReceipt_Data(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
//		account=new AccountDataService_Stub("accountName",10);
		String[] accountList={account_name};
		int[] price={10};
		ReceiptPO po= new ReceiptPO("serialnum", "operator", "name", accountList, "ps", price);
		if(account.addReceipt(po)){
			return "�ɹ�";
		}
		return  "ʧ��";
	}

	public String addPayment_Data(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
//		account=new AccountDataService_Stub("accountName",10);
		String[] accountList={account_name};
		int[] price={10};
		PaymentPO po= new PaymentPO("serialnum","operator", "Customer_name", accountList, "item", "ps", price);
		if(account.addPayment(po)){
			return "�ɹ�";
		}
		return  "ʧ��";
	}
	
	public ReceiptPO[] getAllReceipt(){
//		account=new AccountDataService_Stub("accountName",10);
		return account.getAllReceipt();
	}
	
	public PaymentPO[] getAllPayment(){
//		AccountDataService account=new AccountDataService_Stub("accountName",10);
		return account.getAllPayment();
	}

	public String addReceipt_Data(ReceiptPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addPayment_Data(PaymentPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delReceipt_Data(ReceiptPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delPayment_Data(PaymentPO po) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
