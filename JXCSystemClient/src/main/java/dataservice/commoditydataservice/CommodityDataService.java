package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.SendGiftPO;
import po.SortPO;
import po.WarnPO;

public interface CommodityDataService extends Remote{
	public CommodityPO findGood(String name,String type) throws RemoteException;
	public boolean addGood(CommodityPO po1,SortPO po2) throws RemoteException;
	public boolean delGood(CommodityPO po) throws RemoteException;
	public boolean updateGood(CommodityPO po1,CommodityPO po2) throws RemoteException;
	public boolean updateGood(CommodityPO po1,SortPO po2) throws RemoteException;
	public String getGoodNote(SortPO po1) throws RemoteException;

	public boolean addSort(SortPO po1,SortPO po2) throws RemoteException;
	public boolean delSort(SortPO po) throws RemoteException;
	public boolean updateSort(SortPO po1,SortPO po2) throws RemoteException;
	public boolean updateSort_Mov(SortPO po1,SortPO po2) throws RemoteException;
	public String getSortNote(SortPO po1) throws RemoteException;

	public SortPO getTempSort() throws RemoteException;
	
	public boolean addSendGift(SendGiftPO po) throws RemoteException;
	public SendGiftPO findSendGift(SendGiftPO po) throws RemoteException;
	public SendGiftPO findSendGift(String note) throws RemoteException;
	public boolean delSendGift(SendGiftPO po) throws RemoteException;
	public boolean delSendGift(String note) throws RemoteException;
	public String getSendGiftNote() throws RemoteException;
	public ArrayList<SendGiftPO> getAllSendGift() throws RemoteException;
	
	public boolean addGift(CommodityPO po,int number) throws RemoteException;
	public CommodityPO findGift(CommodityPO po) throws RemoteException;
	public CommodityPO findGift(String name,String type) throws RemoteException;
	public boolean delGift(CommodityPO po) throws RemoteException;
	public ArrayList<CommodityPO> getAllGift() throws RemoteException;
	
	public ArrayList<CommodityPO> getAll() throws RemoteException;
	public ArrayList<SortPO> getAllSort() throws RemoteException;
	public boolean addWarn(WarnPO po) throws RemoteException;
	
	public boolean addPatch(PatchPO po) throws RemoteException;
	public boolean delPatch(String note) throws RemoteException;
	public PatchPO getPatch(String note) throws RemoteException;
	public ArrayList<PatchPO> getAllPatch() throws RemoteException;
	public String getPatchNote() throws RemoteException;
	
	public boolean passPatch(PatchPO po) throws RemoteException;
	public boolean refusePatch(String note) throws RemoteException;
	public boolean passSendGift(SendGiftPO po) throws RemoteException;
	public boolean refuseSendGift(String note) throws RemoteException;
	public boolean passImport(ImportPO po) throws RemoteException;
	public boolean passImport_Return(Import_ReturnPO po) throws RemoteException;
	public boolean passExport(ExportPO po) throws RemoteException;
	public boolean passExport_Return(Export_ReturnPO po) throws RemoteException;
	
	public boolean addDraftPatch(PatchPO po) throws RemoteException;
	public boolean delDraftPatch(String note) throws RemoteException;
	public PatchPO getDraftPatch(String note) throws RemoteException;
	public ArrayList<PatchPO> getAllDraftPatch() throws RemoteException;
	
	public boolean addGoodNumber(CommodityPO po,int number) throws RemoteException;
	
	public boolean clear() throws RemoteException;
}


