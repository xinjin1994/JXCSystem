package businesslogic.userbl;

import java.util.ArrayList;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class MockAddUser implements UserDataService{

	public boolean addUser(UserPO po) {
		return true;
	}

	public boolean delUser(UserPO po) {
		// TODO Auto-generated method stub
		return true;
	}

	public UserPO getUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserPO> show() {
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

}
