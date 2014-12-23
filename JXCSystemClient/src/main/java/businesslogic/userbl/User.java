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
	
	public UserDataService us;
	SystemlogInfo systemlog=new Systemlog();
	public static String operator;
	public static int duty;
	
//	public UserDataService getUser() {
//		return us;
//	}
//	public void setUser(UserDataService us) {
//		this.us = us;
//	}
	
	public void setInfo(SystemlogInfo systemlog){
		this.systemlog=systemlog;
	}
	
	public int addUser(String name, String password, int duty, String note) {
		// TODO Auto-generated method stub
		UserPO user = new UserPO(name, password, duty,note);
		
		try {
			
			ArrayList<UserPO> po=us.show();
			
			for(int i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)){
					return 1;
				}
			}
			
			if (us.addUser(user)) {
				System.out.println("addUser:"+name+" note:"+note);
				systemlog.add_up("addUser："+user.getName());
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delUser(String note) {
		// TODO Auto-generated method stub
		try {
			ArrayList<UserPO> po=us.show();
			for(int i=0;i<po.size();i++){
				if(po.get(i).getNote().equals(note)){
					us.delUser(note);
					return 0;
				}
			}
			return 2;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<UserPO> show() {
		// TODO Auto-generated method stub
		try {
			ArrayList<UserPO> po=us.show();
			if(po!=null){
				return po;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<UserPO>();
	}

	public int login(String name, String password) {
		// TODO Auto-generated method stub
		try {
			System.out.println("login:"+name+" "+password);
			UserPO po=new UserPO(name,password,0,"note");
			System.out.println("login_po:"+po.getName()+" "+po.getPassword());
			UserPO lin=us.login(po);
//			System.out.println("login_lin:"+lin.getName()+" "+lin.getPassword());
			if(lin!=null){
				User.operator=lin.getName();
				User.duty=lin.getDuty();
				return lin.getDuty();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public String getUserNote(){
		try {
			return us.getNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "User";
	}
	
	public ArrayList<UserPO> getUser_Note(String note){
		UserPO po;
		ArrayList<UserPO> array=new ArrayList<UserPO>();
		try {
			po=us.getUser(note);
			if(po!=null){
				array.add(po);
				System.out.println("User:"+po.getName()+" Note:"+po.getNote());
			}
			po=us.getUser_Note(note);
			if(po!=null){
				array.add(po);
			}
			return array;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
	public int addUser_Data(String name, String password, int duty) {
		// TODO Auto-generated method stub
		return 0;
	}

}
