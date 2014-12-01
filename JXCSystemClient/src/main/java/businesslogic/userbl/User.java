package businesslogic.userbl;

import java.rmi.RemoteException;

import po.UserPO;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.userblservice.UserblService;
import data.userdata.UserDataService_Stub;
import dataservice.userdataservice.UserDataService;

public class User implements UserblService ,businesslogic.initializationlbl.UserInfo{
	
	public UserDataService us=new UserDataService_Stub("password", "duty", 10);
	SystemlogInfo systemlog=new Systemlog();
	
	public UserDataService getUser() {
		return us;
	}
	public void setUser(UserDataService us) {
		this.us = us;
	}
	
	public int addUser_Data(String name, String password, int duty) {
		// TODO Auto-generated method stub
		UserPO user = new UserPO(name, password, duty);
		
		try {
			if (us.addUser(user)) {
				systemlog.add("AddUser:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public String addUser(String name, String password, int duty) {
		// TODO Auto-generated method stub
		UserPO user = new UserPO(name, password, duty);
		
		try {
			if (us.addUser(user)) {
				systemlog.add("AddUser:");
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String delUser(String name) {
		// TODO Auto-generated method stub
		try {
			if(us.getUser("user")!=null){
				systemlog.add("DelUser:");
				return "�ɹ�";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ʧ��";
	}

	public String show() {
		// TODO Auto-generated method stub
		try {
			if(us.show()!=null){
				return "�ɹ�";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ʧ��";
	}

	public int login(String name, String password) {
		// TODO Auto-generated method stub
		try {
			if(us.getUser("user")!=null){
				return 1;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
