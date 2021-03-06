package businesslogic.commoditybl;

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
import dataservice.commoditydataservice.CommodityDataService;

public class MockCommodityData implements CommodityDataService{
	
	public ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
	public ArrayList<SortPO> arr=new ArrayList<SortPO>();

	public CommodityPO findGood(String name, String type) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false, name, type, 50, 60, "99", 0, 0, 0);
		return com;
	}

	public CommodityPO findName(String name) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false, name, "type", 50, 60, "99", 0, 0, 0);
		return com;
	}

	public CommodityPO findType(String type) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false, "name", type, 50, 60, "99", 0, 0, 0);
		return com;
	}

	public boolean addGood(CommodityPO po1, SortPO po2) {
		// TODO Auto-generated method stub
		array.add(po1);
		return true;
	}

	public boolean delGood(CommodityPO po) {
		// TODO Auto-generated method stub
//		array.remove(po);
		return true;
	}

	public boolean updateGood(CommodityPO po1, CommodityPO po2) {
		// TODO Auto-generated method stub
		array.remove(po1);
		array.add(po2);
		return true;
	}

	public boolean addSort(SortPO po1,SortPO po2) {
		// TODO Auto-generated method stub
		arr.add(po1);
		return true;
	}

	public boolean delSort(SortPO po) {
		// TODO Auto-generated method stub
//		arr.remove(po);
		return true;
	}

	public boolean updateSort(SortPO po1, SortPO po2) {
		// TODO Auto-generated method stub
		arr.remove(po1);
		arr.add(po2);
		return true;
	}

	public boolean addGift(CommodityPO po) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(true, "name", "type", 50, 60, "99", 0, 0, 0);
		array.add(com);
		return true;
	}

	public CommodityPO findGift(String name, String type) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(true, name, "type", 50, 60, "99", 0, 0, 0);
		return com;
	}

	public boolean delGift(CommodityPO po) {
		// TODO Auto-generated method stub
//		CommodityPO com=new CommodityPO(true, "name", "type", 50, 60, 99, 0, 0, 0);
//		array.remove(com);
		return true;
	}

	public ArrayList<CommodityPO> getAll() {
		// TODO Auto-generated method stub
		CommodityPO[] com=new CommodityPO[1];
		com[0]=array.get(0);
		return new ArrayList<CommodityPO>();
	}

	public boolean clear() {
		// TODO Auto-generated method stub
		array.clear();
		return true;
	}

	public ArrayList<SortPO> getAllSort() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateGood(CommodityPO po1, SortPO po2)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateSort_Mov(SortPO po1, SortPO po2)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addWarn(WarnPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addDraftPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delDraftPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getDraftPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllDraftPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public SendGiftPO findSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public SendGiftPO findSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public CommodityPO findGift(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public PatchPO getPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PatchPO> getAllPatch() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delDraftPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public PatchPO getDraftPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PatchPO> getAllDraftPatch() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoodNote(SortPO po1) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSortNote(SortPO po1) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPatchNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSendGiftNote() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public SortPO getTempSort() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addGift(CommodityPO po, int number) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<CommodityPO> getAllGift() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean passPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean refusePatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean refuseSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addGoodNumber(CommodityPO po, int number)
			throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passImport(ImportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passImport_Return(Import_ReturnPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passExport(ExportPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passExport_Return(Export_ReturnPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<SendGiftPO> getAllSendGift() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
