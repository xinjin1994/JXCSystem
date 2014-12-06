package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.PatchPO;
import po.SendGiftPO;
import po.SortPO;
import po.WarnPO;

public interface CommodityDataService extends Remote{
	public CommodityPO findGood(String name,String type) throws RemoteException;
//	public CommodityPO findName(String name) throws RemoteException;
//	public CommodityPO findType(String type) throws RemoteException;
	public boolean addGood(CommodityPO po1,SortPO po2) throws RemoteException;
	public boolean delGood(CommodityPO po) throws RemoteException;
	public boolean updateGood(CommodityPO po1,CommodityPO po2) throws RemoteException;
	public boolean updateGood(CommodityPO po1,SortPO po2) throws RemoteException;
	public boolean getGoodNote(SortPO po1) throws RemoteException;

	public boolean addSort(SortPO po1,SortPO po2) throws RemoteException;
	public boolean delSort(SortPO po) throws RemoteException;
	public boolean updateSort(SortPO po1,SortPO po2) throws RemoteException;
	public boolean updateSort_Mov(SortPO po1,SortPO po2) throws RemoteException;
	public boolean getSortNote(SortPO po1) throws RemoteException;
	
	public boolean addSendGift(SendGiftPO po) throws RemoteException;
	public SendGiftPO findSendGift(SendGiftPO po) throws RemoteException;
	public SendGiftPO findSendGift(String note) throws RemoteException;
	public boolean delSendGift(SendGiftPO po) throws RemoteException;
	public boolean delSendGift(String note) throws RemoteException;
	
	public boolean addGift(CommodityPO po) throws RemoteException;
	public CommodityPO findGift(CommodityPO po) throws RemoteException;
	public CommodityPO findGift(String name,String type) throws RemoteException;
	public boolean delGift(CommodityPO po) throws RemoteException;
//	public boolean delGift(String note) throws RemoteException;
	
	public ArrayList<CommodityPO> getAll() throws RemoteException;
	public ArrayList<SortPO> getAllSort() throws RemoteException;
	public boolean addWarn(WarnPO po) throws RemoteException;
	
	public boolean addPatch(PatchPO po) throws RemoteException;
	public boolean delPatch(String note) throws RemoteException;
	public PatchPO getPatch(String note) throws RemoteException;
	public ArrayList<PatchPO> getAllPatch() throws RemoteException;	
	public String getPatchNote() throws RemoteException;
	
	public boolean addDraftPatch(PatchPO po) throws RemoteException;
	public boolean delDraftPatch(String note) throws RemoteException;
	public PatchPO getDraftPatch(String note) throws RemoteException;
	public ArrayList<PatchPO> getAllDraftPatch() throws RemoteException;
	public boolean clear() throws RemoteException;
}


