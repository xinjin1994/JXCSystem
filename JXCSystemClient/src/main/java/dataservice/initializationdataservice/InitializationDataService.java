package dataservice.initializationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.InitializationPO;

public interface InitializationDataService extends Remote{
	public InitializationPO getInfomation() throws RemoteException;
	public boolean clear() throws RemoteException;
	public boolean doInitialization(InitializationPO po) throws RemoteException;
}
