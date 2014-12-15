package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import vo.UserVO;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.userblservice.UserblService;
import data.userdata.UserDataService_Stub;
import dataservice.userdataservice.UserDataService;

public class User implements businesslogic.initializationlbl.UserInfo{
	
	public UserDataService us=new UserDataService_Stub("password", "duty", 10);
	SystemlogInfo systemlog=new Systemlog();
	public static String operator;
	
	public UserDataService getUser() {
		return us;
	}
	public void setUser(UserDataService us) {
		this.us = us;
	}
	
	public int addUser_Data(String name, String password, int duty) {
		// TODO Auto-generated method stub
		UserPO user = new UserPO(name, password, duty,"note");
		
		try {
			if (us.addUser(user)) {
				systemlog.add_up("AddUser:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int addUser(String name, String password, int duty) {
		// TODO Auto-generated method stub
		UserPO user = new UserPO(name, password, duty,"note");
		
		try {
			if (us.addUser(user)) {
				systemlog.add_up("AddUser:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delUser(String name) {
		// TODO Auto-generated method stub
		try {
			if(us.getUser("user")!=null){
				systemlog.add_up("DelUser:");
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<UserVO> show() {
		// TODO Auto-generated method stub
		ArrayList<UserVO> vo=new ArrayList<UserVO>();
		try {
			if(us.show()!=null){
				return vo;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
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
