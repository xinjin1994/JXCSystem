package Test_rmi;

import java.rmi.RemoteException;

import po.AccountPO;
import data.accountdata.AccountDataService_Stub;

public class Test_Serializable {
	
	public static void main(String[] args){
		
		AccountDataService_Stub acc;
		try {
			acc = new AccountDataService_Stub("name1",10001);

		
			acc.accountList.add(new AccountPO("name",1000));
//			System.out.println(acc.accountList.get(0).getName());
			acc.writeAccountList();
			
			acc.readAccountList();
			System.out.println(acc.accountList.get(0).getName()+123);
		
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
