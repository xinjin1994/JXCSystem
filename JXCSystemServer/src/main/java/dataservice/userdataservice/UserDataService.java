package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;

public interface UserDataService extends Remote{
	public boolean addUser(UserPO po) throws RemoteException;
	public boolean delUser(String string) throws RemoteException;
	public UserPO getUser(String name) throws RemoteException;
	public ArrayList<UserPO> show() throws RemoteException;
	public boolean clear() throws RemoteException;
}
