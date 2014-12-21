package data.systemlogdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.PaymentPO;
import po.SystemlogPO;
import data.accountdata.AccountDataService_Stub;
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
		
		this.writeSystemlogList();
		
		this.readSystemlogList();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<SystemlogPO> get() throws RemoteException {
		ArrayList<SystemlogPO> po=new ArrayList<SystemlogPO>();
		for(int i=0;i<systemlogList.size();i++){
			po.add(systemlogList.get(i).copy());
		}
		return po;
	}

	public boolean add(SystemlogPO po) throws RemoteException {
		SystemlogPO po2=po.copy();
		po2.setTime(AccountDataService_Stub.getNoteTime());
		System.out.println("addSystemlog:"+po.getWord());
		systemlogList.add(po2);
		return true;
	}

	public boolean clear() throws RemoteException {
		systemlogList=new ArrayList<SystemlogPO>();
		return true;
	}

}
