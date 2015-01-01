package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import vo.AccountVO;

public class AccountManagement {
	
	public AccountDataService account;
	public FinancialInfo financial;
	public InvoiceInfo invoice;
	public SalesInfo sales;
	public SystemlogInfo systemlog;
	
	
	public void setInfo(FinancialInfo financial2,InvoiceInfo invoice,SalesInfo sales,SystemlogInfo systemlog){
		this.financial=financial2;
		this.invoice=invoice;
		this.sales=sales;
		this.systemlog=systemlog;
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
				return 2;
			}
			
			acc2=account.findAccount(vo2.name);
			
			if(acc2!=null){
				return 1;
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
	
}
