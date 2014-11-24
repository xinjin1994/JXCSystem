package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CommodityPO;
import po.SortPO;

public interface CommodityDataService extends Remote{
	public CommodityPO findGood(String name,String type) throws RemoteException;
	public CommodityPO findName(String name) throws RemoteException;
	public CommodityPO findType(String type) throws RemoteException;
	public boolean addGood(CommodityPO po1,SortPO po2) throws RemoteException;
	public boolean delGood(CommodityPO po) throws RemoteException;
	public boolean updateGood(CommodityPO po1,CommodityPO po2) throws RemoteException;
	public boolean addSort(SortPO po) throws RemoteException;
	public boolean delSort(SortPO po) throws RemoteException;
	public boolean updateSort(SortPO po1,SortPO po2) throws RemoteException;
	public boolean addGift(CommodityPO po) throws RemoteException;
	public CommodityPO findGift(String name,String type) throws RemoteException;
	public boolean delGift(CommodityPO po) throws RemoteException;
	public CommodityPO[] getAll() throws RemoteException;
	public boolean clear() throws RemoteException;
}


