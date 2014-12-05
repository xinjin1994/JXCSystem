package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class MockShow implements UserDataService{
	
	
	public ArrayList<UserPO> show() {
		
		ArrayList<UserPO> user=new ArrayList<UserPO>();
		user.add(new UserPO("test","2222/2/2", 0));
		return user;
		
	}

	public boolean addUser(UserPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delUser(UserPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserPO getUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean clear() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delUser(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserPO login(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
