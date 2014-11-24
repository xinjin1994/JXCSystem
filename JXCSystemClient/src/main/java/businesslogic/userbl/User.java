package businesslogic.userbl;

import po.UserPO;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.userblservice.UserblService;
import data.userdata.UserDataService_Stub;
import dataservice.userdataservice.UserDataService;

public class User implements UserblService {
	
	UserDataService us=new UserDataService_Stub("password", "duty", 10);
	SystemlogInfo systemlog=new Systemlog();
	
	public UserDataService getUser() {
		return us;
	}
	public void setUser(UserDataService us) {
		this.us = us;
	}
	
	public String addUser(String name, String password, int duty) {
		// TODO Auto-generated method stub
		UserPO user = new UserPO(name, password, duty);
		
		if (us.addUser(user)) {
			systemlog.add("AddUser:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String delUser(String name) {
		// TODO Auto-generated method stub
		if(us.getUser("user")!=null){
			systemlog.add("DelUser:");
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String show() {
		// TODO Auto-generated method stub
		if(us.show()!=null){
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String login(String name, String password) {
		// TODO Auto-generated method stub
		if(us.getUser("user")!=null){
			return "�ɹ�";
		}
		return "ʧ��";
	}

}
