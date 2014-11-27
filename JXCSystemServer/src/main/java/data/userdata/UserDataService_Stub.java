package data.userdata;

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
import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class UserDataService_Stub extends UnicastRemoteObject implements UserDataService{
	String n;
	String p;
	int d;
	
	ArrayList<UserPO> userList=new ArrayList<UserPO>();
	
	public UserDataService_Stub(String n, String p, int d) throws RemoteException{
		this.n = n;
		this.p = p;
		this.d = d;
	}
	
	public void writeUserList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("userList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);	
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
	public void readUserList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("userList.out");
			ois=new ObjectInputStream(fis);
			userList=(ArrayList<UserPO>) ois.readObject();
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
	
	public UserDataService_Stub() throws RemoteException {
		
	}
	
	public boolean addUser(UserPO po) {
		return true;
	}

	public boolean delUser(UserPO po) {
		return true;
	}

	public UserPO getUser(String name) {
		return new UserPO(n, p, d);
	}

	public ArrayList<UserPO> show() {
		return userList;
	}

	public boolean clear() {
		return true;
	}

	public boolean delUser(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
