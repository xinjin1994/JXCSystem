package businesslogic.userbl;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class MockGetUser implements UserDataService{
	String n;
	String p;
	int d;

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
		return new UserPO(n, p, d);
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
