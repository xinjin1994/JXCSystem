package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.CustomerPO;
import po.PaymentPO;
import po.ReceiptPO;
import vo.AccountVO;
import businesslogic.financialbl.Financial;
import businesslogic.invoicebl.Invoice;
import businesslogic.userbl.User;
import data.accountdata.AccountDataService_Stub;
import dataservice.accountdataservice.AccountDataService;


//-1 未知错误
//1 账户名称重复
//2 账户名不存在
//3 账户中仍存在余额，不能删除

public class Account implements businesslogic.financialbl.AccountInfo,
			businesslogic.initializationlbl.AccountInfo, businesslogic.invoicebl.AccountInfo {

	public AccountDataService account=new AccountDataService_Stub("mainAccount",0);
	public FinancialInfo financial;
	public InvoiceInfo invoice;
	public SalesInfo sales;
	public SystemlogInfo systemlog;
	
	
	public void setInfo(FinancialInfo financial,InvoiceInfo invoice,SalesInfo sales,SystemlogInfo systemlog){
		this.financial=financial;
		this.invoice=invoice;
		this.sales=sales;
		this.systemlog=systemlog;
	}
	
	public AccountPO checkAccount_up() {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			AccountPO po=account.getAccount();
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int addAccount_up(AccountVO vo) {
		// TODO Auto-generated method stub
		try {
			
			if(account.findAccount(vo.name)!=null){
				return 1;
			}
		
			AccountPO acc = new AccountPO(vo.name, vo.balance);

			if (account.addAccount(acc)) {
				systemlog.add_up("addAccount:"+acc.getName()+","+acc.getMoney());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delAccount_up(AccountVO vo) {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		AccountPO acc;
		try {
			
			acc = account.findAccount(vo.name);
			
			if(acc==null){
				return 2;
			}
			
			if(acc.getMoney()!=0){
				return 3;
			}
			
			if (account.delAccount(acc)) {
				systemlog.add_up("delAccount:"+acc.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int updateAccount_up(AccountVO vo1,AccountVO vo2) {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		AccountPO acc1;
		AccountPO acc2;
		try {
			acc1 = account.findAccount(vo1.name);
			
			if(acc1==null){
				return 1;
			}
			
			acc2=account.findAccount(vo2.name);
			
			if(acc2!=null){
				return 2;
			}
	
			acc2 = new AccountPO(vo2.name, acc1.getMoney());

			if (account.updateAccount(acc1, acc2)) {
				systemlog.add_up("updateAccount:"+acc1.getName()+","+acc2.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<AccountPO> searchFuzzyAccount_up(String word) {
		// TODO Auto-generated method stub
		try {	
			ArrayList<AccountPO> po=account.getAllAccount();
			ArrayList<AccountPO> array=new ArrayList<AccountPO>();
			AccountPO lin=account.findAccount(word);
			array.add(lin);
			
			return po;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AccountPO>();
	}
	
	public AccountPO searchAccurateAccount_up(String name){
		
		try {
			AccountPO po=account.findAccount(name);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int addReceipt_up(ReceiptPO po) {
		// TODO Auto-generated method stub
	
		try {
			invoice.add(po);
			account.addReceipt(po);
			systemlog.add_up("addReceipt:"+po.getOperator()+","+po.getTotalMoney()+","+po.getNote());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addPayment_up(PaymentPO po) {
		// TODO Auto-generated method stub
		try{
		invoice.add(po);
		account.addPayment(po);
		systemlog.add_up("addPayment:"+po.getOperator()+","+po.getTotalMoney());
		} catch(RemoteException e){
			e.printStackTrace();
		}
		return 0;
	}
	
//	public String addReceipt_Data(String customer_name, String clerk,
//			String account_name, int money, int all_money, String ps) {
//		// TODO Auto-generated method stub
//		return  "ʧ��";
//	}
//
//	public String addPayment_Data(String customer_name, String clerk,
//			String account_name, int money, int all_money, String ps) {
//		// TODO Auto-generated method stub
//		return  "ʧ��";
//	}
	
	public ArrayList<ReceiptPO> getAllReceipt(){
//		account=new AccountDataService_Stub("accountName",10);
		try {
			return account.getAllReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<ReceiptPO>();
	}
	
	public ArrayList<PaymentPO> getAllPayment(){
//		AccountDataService account=new AccountDataService_Stub("accountName",10);
		try {
			return account.getAllPayment();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<PaymentPO>();
	}

	public String addReceipt_Data(ReceiptPO po) {
		// TODO Auto-generated method stub
		try {
			account.passReceipt(po);
			return "成功";
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String addPayment_Data(PaymentPO po) {
		// TODO Auto-generated method stub
		try {
			account.passPayment(po);
			return "成功";
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}
	
//	public String addAccount(String name, int money) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public String addAccount_Data(String name, int money) {
//		// TODO Auto-generated method stub
//		try {
//			AccountPO po1=account.findAccount(name);
//			AccountPO po2=po1.copy();
//			po2.money=po1.money+money;
//			if(account.updateAccount(po1, po2)){
//				return " ";
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public ArrayList<AccountPO> getAllAccount(){
		try {
			return account.getAllAccount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AccountPO>();
	}

	public String getOperator() {
		// TODO Auto-generated method stub
		return User.operator;
	}

	public ArrayList<CustomerPO> getAllCustomer() {
		// TODO Auto-generated method stub
		return sales.getAllCustomer();
	}

	public String getReceiptNote() {
		// TODO Auto-generated method stub
		try {
			return account.getReceiptNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getPaymentNote() {
		// TODO Auto-generated method stub
		try {
			return account.getPaymentNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int addDraftReceipt(ReceiptPO po) {
		// TODO Auto-generated method stub
	
		try {
			po.setCondition(0);
			account.addDraftReceipt(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<ReceiptPO> getAllDraftReceipt() {
		// TODO Auto-generated method stub
		try {
			return account.getAllDraftReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<ReceiptPO>();
	}

	public ReceiptPO searchDraftReceipt(String note) {
		// TODO Auto-generated method stub
		try {
			return account.findDraftReceipt(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PaymentPO searchDraftPayment(String note) {
		// TODO Auto-generated method stub
		try {
			return account.findPayment(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PaymentPO> getAllDraftPayment() {
		// TODO Auto-generated method stub
		try {
			return account.getAllDraftPayment();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<PaymentPO>();
	}

	public int addDraftPayment(PaymentPO po) {
		// TODO Auto-generated method stub

		try {
			po.setCondition(0);
			account.addDraftPayment(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public String refuseReceipt_Data(String note) {
		// TODO Auto-generated method stub
		try {
			if(account.refuseReceipt(note)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String refusePayment_Data(String note) {
		// TODO Auto-generated method stub
		try {
			if(account.refusePayment(note)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String addAccount(String name, double money) {
		// TODO Auto-generated method stub
		return null;
	}

//	public String delReceipt_Data(ReceiptPO po) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public String delPayment_Data(PaymentPO po) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
