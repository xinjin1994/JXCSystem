package dataservice.systemlogdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.SystemlogPO;

public interface SystemlogDataService extends Remote {
	public SystemlogPO[] get() throws RemoteException;
	public boolean add(SystemlogPO po) throws RemoteException;
	public boolean clear() throws RemoteException;
}
