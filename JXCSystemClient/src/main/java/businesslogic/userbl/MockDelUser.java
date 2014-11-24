package businesslogic.userbl;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class MockDelUser implements UserDataService{
	
	
	public boolean delUser(UserPO po) {
		return true;
	}

	public boolean addUser(UserPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserPO getUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO[] show() {
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
