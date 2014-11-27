package data.initializationdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.AccountPO;
import po.CommodityPO;
import po.CustomerPO;
import po.InitializationPO;
import po.PaymentPO;
import dataservice.initializationdataservice.InitializationDataService;

public class InitializationDataService_Stub extends UnicastRemoteObject implements InitializationDataService{
	
	CustomerPO customer;
	CommodityPO commodity;
	AccountPO account;
	
	ArrayList<InitializationPO> initializationList=new ArrayList<InitializationPO>();
	
	public void writeInitializationList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("initializationList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(initializationList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readInitializationList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("initializationList.out");
			ois=new ObjectInputStream(fis);
			initializationList=(ArrayList<InitializationPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public InitializationDataService_Stub(CommodityPO commodity,CustomerPO customer,AccountPO account) throws RemoteException {
		this.commodity = commodity;
		this.customer = customer;
		this.account = account;
	}
	public InitializationPO getInfomation() {
		return new InitializationPO(commodity, customer, account);
	}

}
