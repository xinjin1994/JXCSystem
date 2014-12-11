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
	
	ArrayList<UserPO> userList=new ArrayList<UserPO>();
	int user_note=0;
	
	public UserDataService_Stub() throws RemoteException{
		this.readUserList();
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
	
	public void writeUserNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("user_note.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(user_note);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readUserNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("user_note.out");
			ois=new ObjectInputStream(fis);
			user_note=(Integer) ois.readObject();
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
	
	
	
	public boolean addUser(UserPO po) {
		return true;
	}

	public boolean delUser(UserPO po) {
		return true;
	}

	public UserPO getUser(String name) {
		return new UserPO(name, name, 0);
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

	public UserPO login(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
