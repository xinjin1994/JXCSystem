package data.systemlogdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.PaymentPO;
import po.SystemlogPO;
import dataservice.systemlogdataservice.SystemlogDataService;

public class SystemlogDataService_Stub extends UnicastRemoteObject implements SystemlogDataService{

	ArrayList<SystemlogPO> systemlogList=new ArrayList<SystemlogPO>();
	
	public void writeSystemlogList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("systemlogList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(systemlogList);	
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
	public void readSystemlogList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("systemlogList.out");
			ois=new ObjectInputStream(fis);
			systemlogList=(ArrayList<SystemlogPO>) ois.readObject();
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
	
	public SystemlogDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemlogPO[] get() {
		return new SystemlogPO[1];
	}

	public boolean add(SystemlogPO po) {
		return true;
	}

	public boolean clear() {
		return true;
	}

}
