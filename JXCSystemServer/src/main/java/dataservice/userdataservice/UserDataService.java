package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;


/*注意下面的login是验证账号密码的方法，传进去的PO只拥有name和password两个属性，不拥有duty
* 验证成功后，返回一个UserPO对象，即为该登陆用户，返回的PO只拥有name和duty两个属性，不拥有password
* 对象应该保存在客户端，代表这个客户端正在以这个身份登陆
* 验证失败后，返回一个null
*/
public interface UserDataService extends Remote {
	public boolean addUser(UserPO po) throws RemoteException;
	public boolean delUser(String string) throws RemoteException;
	public UserPO getUser(String name) throws RemoteException;
	public ArrayList<UserPO> show() throws RemoteException;
	public UserPO login(UserPO po) throws RemoteException;
	public boolean clear() throws RemoteException;
}
