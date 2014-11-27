package data.userdata;

import java.util.ArrayList;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class UserDataService_Stub implements UserDataService{
	String n;
	String p;
	int d;
	
	public UserDataService_Stub(String n, String p, int d) {
		this.n = n;
		this.p = p;
		this.d = d;
	}
	
	public UserDataService_Stub(){
		
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
		ArrayList<UserPO> array=new ArrayList<UserPO>();
		array.add(new UserPO("name","123",1));
		return array;
	}

	public boolean clear() {
		return true;
	}

	public boolean delUser(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
