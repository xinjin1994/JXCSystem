package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import po.PaymentPO;
import po.ReceiptPO;
import vo.AccountVO;
import vo.GetVO;
import vo.PayVO;
import businesslogic.invoicebl.Invoice;
import businesslogic.salesbl.Sales;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.accountblservice.AccountblService;
import data.accountdata.AccountDataService_Stub;
import dataservice.accountdataservice.AccountDataService;


//-1 未知错误
//1 账户名称重复
//2 账户名不存在
//3 账户中仍存在余额，不能删除

public class Account implements AccountblService, businesslogic.financialbl.AccountInfo,
			businesslogic.initializationlbl.AccountInfo, businesslogic.invoicebl.AccountInfo {

	public AccountDataService account=new AccountDataService_Stub("mainAccount",0);
	public FinancialInfo financial;
	public InvoiceInfo invoice=new Invoice();
	public SalesInfo sales=new Sales();
	public SystemlogInfo systemlog=new Systemlog();
	
	public AccountVO checkAccount() {
		// TODO Auto-generated method stub
//		account = new AccountDataService_Stub("accountName",10);
		try {
			AccountPO po=account.getAccount();
			if (account.getAccount() != null) {
				AccountVO vo=new AccountVO(po);
				return vo;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		try {
			
			if(account.findAccount(vo.name)!=null){
				return 1;
			}
		
			AccountPO acc = new AccountPO(vo.name, (int) vo.balance);

			if (account.addAccount(acc)) {
				systemlog.add("addAccount:"+acc.getName()+","+acc.getMoney());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delAccount(AccountVO vo) {
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
				systemlog.add("delAccount:"+acc.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int updateAccount(AccountVO vo1,AccountVO vo2) {
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
				systemlog.add("updateAccount:"+acc1.getName()+","+acc2.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<AccountVO> searchAccount(String word) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> vo=new ArrayList<AccountVO>();
		try {	
			ArrayList<AccountPO> po=account.getAllAccount();
	


		
			AccountPO lin=account.findAccount(word);
			if(lin!=null){
				vo.add(new AccountVO(lin));
			}
			
			return vo;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public int addReceipt(GetVO vo) {
		// TODO Auto-generated method stub
		
		ReceiptPO po= new ReceiptPO(vo);
		
		invoice.add(po);
		systemlog.add("addReceipt:"+po.getOperator()+","+po.getName()+","+po.getTotal());
		
		return 0;
	}

	public int addPayment(PayVO vo) {
		// TODO Auto-generated method stub
		
		PaymentPO po= new PaymentPO(vo);
		
		invoice.add(po);
		systemlog.add("addPayment:"+po.getOperator()+","+po.getName()+","+po.getTotal());
		return 0;
	}
	
	public String addReceipt_Data(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
		String[] accountList={account_name};
		int[] price={10};
		String[] ps1={"ps"};
		ReceiptPO po= new ReceiptPO("serialnum", "operator", "name", accountList, ps1, price);
		
		systemlog.add("addPayment:"+po.getOperator()+","+po.getName()+","+po.getTotal());
		
		return  "ʧ��";
	}

	public String addPayment_Data(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
//		account=new AccountDataService_Stub("accountName",10);
		String[] accountList={account_name};
		int[] price={10};	
		String[] ps1={"ps"};
		PaymentPO po= new PaymentPO("serialnum","operator", "Customer_name", accountList, "item", ps1, price);
		
		try {
			if(account.addPayment(po)){
				return "�ɹ�";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  "ʧ��";
	}
	
	public ArrayList<ReceiptPO> getAllReceipt(){
//		account=new AccountDataService_Stub("accountName",10);
		try {
			return account.getAllReceipt();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<PaymentPO> getAllPayment(){
//		AccountDataService account=new AccountDataService_Stub("accountName",10);
		try {
			return account.getAllPayment();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String addReceipt_Data(ReceiptPO po) {
		// TODO Auto-generated method stub
		try {
			account.addReceipt(po);
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
			account.addPayment(po);
			return "成功";
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}
	
	public String addAccount(String name, int money) {
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
