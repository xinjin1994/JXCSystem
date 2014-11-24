package dataservice.userdataservice;

import po.UserPO;

public interface UserDataService {
	public boolean addUser(UserPO po);
	public boolean delUser(String string);
	public UserPO getUser(String name);
	public UserPO[] show();
	public boolean clear();
}
