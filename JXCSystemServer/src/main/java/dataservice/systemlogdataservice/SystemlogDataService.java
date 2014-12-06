package dataservice.systemlogdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SystemlogPO;

public interface SystemlogDataService extends Remote {
	public ArrayList<SystemlogPO> get() throws RemoteException;
	public boolean add(SystemlogPO po) throws RemoteException;
	public boolean clear() throws RemoteException;
}
