package data.commoditydata;

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

public class CommodityDataService_Stub implements CommodityDataService{
//	Boolean g;
//	String n;
//	String t;
//	int i;
//	int o;
//	int no;
//	int rei;
//	int reo;
//	int num;
//	public CommodityDataService_Stub(Boolean g, String n, String t, int i,
//			int o, int no, int rei, int reo, int num) {
//		super();
//		this.g = g;
//		this.n = n;
//		this.t = t;
//		this.i = i;
//		this.o = o;
//		this.no = no;
//		this.rei = rei;
//		this.reo = reo;
//		this.num = num;
//	}

	
	public CommodityPO findGood(String name, String type) {
		
		return new CommodityPO(true,"name","type",10,10,"10",20,20,100);
	}

	public CommodityPO findName(String name) {

		return new CommodityPO(true,"name","type",10,10,"10",20,20,100);
	}

	public CommodityPO findType(String type) {
		return new CommodityPO(true,"name","type",10,10,"10",20,20,100);
	}

	public boolean addGood(CommodityPO po1, SortPO po2) {
		return true;
	}

	public boolean delGood(CommodityPO po) {
		return true;
	}

	public boolean updateGood(CommodityPO po1, CommodityPO po2) {
		return true;
	}

	public boolean addSort(SortPO po1,SortPO po2) {
		return true;
	}

	public boolean delSort(SortPO po) {
		return true;
	}

	public boolean updateSort(SortPO po1, SortPO po2) {
		return true;
	}

	public boolean addGift(CommodityPO po) {
		return true;
	}

	public CommodityPO findGift(String name, String type) {
		return new CommodityPO(true,"name","type",10,10,"10",20,20,100);
	}

	public boolean delGift(CommodityPO po){
		return true;
	}

	public ArrayList<CommodityPO> getAll() {
		CommodityPO com=new CommodityPO(true,"name","type",10,10,"10",20,20,100);
		ArrayList<CommodityPO> coms=new ArrayList<CommodityPO>();
		coms.add(com);
		return coms;
	}

	public boolean clear() {
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

	public boolean addGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public SendGiftPO findGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public SendGiftPO findGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
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

	public CommodityPO findGift(CommodityPO po) throws RemoteException {
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

}
