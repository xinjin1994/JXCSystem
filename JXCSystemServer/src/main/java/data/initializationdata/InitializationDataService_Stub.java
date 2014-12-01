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
import po.UserPO;
import dataservice.initializationdataservice.InitializationDataService;

public class InitializationDataService_Stub extends UnicastRemoteObject implements InitializationDataService{
	
	ArrayList<InitializationPO> initializationList=new ArrayList<InitializationPO>();
	InitializationPO nowInitialization;
	
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
	
	
	public void writeNowInitialization(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("nowInitialization.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nowInitialization);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readNowInitialization(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("nowInitializationList.out");
			ois=new ObjectInputStream(fis);
			nowInitialization=(InitializationPO) ois.readObject();
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
	
	public InitializationDataService_Stub() throws RemoteException {
		readInitializationList();
		readNowInitialization();
	}
	
	public InitializationPO getInfomation() {
		return nowInitialization;
	}

	public boolean clear() throws RemoteException {
		// TODO Auto-generated method stub
		nowInitialization=new InitializationPO(new ArrayList<CommodityPO>(), new ArrayList<CustomerPO>(), new ArrayList<AccountPO>(),new ArrayList<UserPO>());
		return true;
	}

	public boolean doInitialization(InitializationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		nowInitialization=po.copy();
		initializationList.add(po);
		return true;
	}

}
