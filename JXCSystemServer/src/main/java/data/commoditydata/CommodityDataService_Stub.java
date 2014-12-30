package data.commoditydata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import data.accountdata.AccountDataService_Stub;
import dataservice.commoditydataservice.CommodityDataService;

public class CommodityDataService_Stub extends UnicastRemoteObject implements CommodityDataService{

	ArrayList<SortPO> sortList=new ArrayList<SortPO>();
	ArrayList<PatchPO> patchList=new ArrayList<PatchPO>();
	ArrayList<CommodityPO> giftList=new ArrayList<CommodityPO>();
	ArrayList<PatchPO> draftPatchList=new ArrayList<PatchPO>();
	ArrayList<SendGiftPO> sendGiftList=new ArrayList<SendGiftPO>();
	SortPO tempSort=new SortPO("未分类商品");
	
	int comNote=0;
	int sortNote=0;
	int sendNote=0;
	int patchNote=0;
	
//	ArrayList<CommodityPO> sto=new ArrayList<CommodityPO>();
	
	public CommodityDataService_Stub() throws RemoteException {
		super();
//		this.writeSortList();
//		this.writePatchList();
//		this.writeGiftList();
//		this.writeDraftPatchList();
//		this.writeSendGiftList();
//		this.writeComNote();
//		this.writeSortNote();
//		this.writeSendNote();
//		this.writePatchNote();
//		this.writeTempSort();
		
		this.readSortList();
		this.readPatchList();
		this.readGiftList();
		this.readDraftPatchList();
		this.readSendGiftList();
		this.readComNote();
		this.readSortNote();
		this.readSendNote();
		this.readPatchNote();
		this.readTempSort();
	}

	public void writeSortList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//sortList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(sortList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readSortList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//sortList.out");
			ois=new ObjectInputStream(fis);
			sortList=(ArrayList<SortPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writePatchList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//patchList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(patchList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readPatchList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//patchList.out");
			ois=new ObjectInputStream(fis);
			patchList=(ArrayList<PatchPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeDraftPatchList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//draftPatchList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(draftPatchList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readDraftPatchList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//draftPatchList.out");
			ois=new ObjectInputStream(fis);
			draftPatchList=(ArrayList<PatchPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	
	public void writeGiftList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//giftList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(giftList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readGiftList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//giftList.out");
			ois=new ObjectInputStream(fis);
			giftList=(ArrayList<CommodityPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeSendGiftList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//sendGiftList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(sendGiftList);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readSendGiftList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//sendGiftList.out");
			ois=new ObjectInputStream(fis);
			sendGiftList=(ArrayList<SendGiftPO>) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writeComNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//comNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(comNote);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readComNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//comNote.out");
			ois=new ObjectInputStream(fis);
			comNote=(Integer) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeSortNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//sortNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(sortNote);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readSortNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//sortNote.out");
			ois=new ObjectInputStream(fis);
			sortNote=(Integer) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writeSendNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//sendNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(sendNote);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readSendNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//sendNote.out");
			ois=new ObjectInputStream(fis);
			sendNote=(Integer) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void writePatchNote(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//patchNote.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(patchNote);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readPatchNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//patchNote.out");
			ois=new ObjectInputStream(fis);
			patchNote=(Integer) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void writeTempSort(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("out//tempSort.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(tempSort);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@SuppressWarnings("unchecked")
	public void readTempSort(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("out//tempSort.out");
			ois=new ObjectInputStream(fis);
			tempSort=(SortPO) ois.readObject();
			ois.close();
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	/*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑数据序列化以及构造方法↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/
	
	
	public CommodityPO findGood(String name, String type) {
		int i=0;
		for(i=0;i<sortList.size();i++){
			CommodityPO po=sortList.get(i).findCommodity_true(name, type);
			if(po!=null){
				System.out.println("findGood:"+po.getNote());
				return po.copy();
			}
		}
		return null;
	}

	public boolean addGood(CommodityPO po1, SortPO po2) {
		SortPO sort=findSort_true(po2.getName());
		if(sort!=null&&!sort.hasSort()){
			po1.father=po2.getName();
			sort.addCommodity(po1.copy());
			System.out.println("addGood:"+po1.getName()+" Note:"+po1.getNote());
			this.writeSortList();
			return true;
		}
		return false;
	}

	public boolean delGood(CommodityPO po) {
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		SortPO sort=findSort_true(po.father);
		CommodityPO gift=findGift(po.getName(),po.getType());
		
		if(po1==null){
			return false;
		}
		
		if(po1.number==0&&gift==null){
			if(sort.delCommodity(po1)){
				System.out.println("delGood:");
				this.writeSortList();
				return true;
			}
		}
		return false;
	}

	public boolean updateGood(CommodityPO po1, CommodityPO po2) {
		CommodityPO po=findGood_true(po1.getName(),po1.getType());
		if(po!=null){
			po.recent_in_price=po2.recent_in_price;
			po.recent_out_price=po2.recent_out_price;
			po.in_price=po2.in_price;
			po.out_price=po2.out_price;
			po.warn=po2.warn;
			System.out.println("updateGood:");
			this.writeSortList();
			return true;
		}
		return false;
	}
	
	public boolean updateGood(CommodityPO po1, SortPO po2) throws RemoteException {
		// TODO Auto-generated method stub
		SortPO po4=findSort_true(po2.getName());
		CommodityPO po3=po1.copy();
		if(po4!=null&&(!po4.hasSort())){
			if(delGood(po1)){
				addGood(po3,po4);
				System.out.println("updateGood:");
				this.writeSortList();
				return true;
			}
		}
		return false;
	}

	public boolean addSort(SortPO po1,SortPO po2) {
		SortPO po=findSort_true(po1.getName());
		if(po!=null){
			return false;
		}else if(po2!=null){
			po2=findSort_true(po2.getName());
			if(po2.hasCommodity()){
				return false;
			}
			
			if(po2.sortList==null){
				po2.sortList=new ArrayList<SortPO>();
			}
			po1.father=po2.getName();
			po2.sortList.add(po1.copy());
			System.out.println("addSort:");
			this.writeSortList();
			return true;
			
		}else{
			po1.father=null;
			sortList.add(po1);
			System.out.println("addSort:");
			this.writeSortList();
		}
		return true;
	}
///////////////////////////////////////////////////////////////
	public boolean delSort(SortPO po) {
		SortPO po1=findSort_true(po.getName());
		SortPO po_father=findSort_true(po.father);
		
		
		if(po1==null){
			return false;
		}
		
		if(po_father!=null){
			if(po_father.delSort(po1)){
				System.out.println("delSort:");
				this.writeSortList();
				return true;
			}
		}
		
		int i=0;
		for(i=0;i<sortList.size();i++){
			if(po1.getName().equals(sortList.get(i).getName())){
				if(!(po1.hasCommodity()||po1.hasSort())){
					sortList.remove(i);
					this.writeSortList();
					System.out.println("delSort:");
					return true;
				}
			}
		}
		return false;
	}

	public boolean updateSort(SortPO po1, SortPO po2) {
		SortPO po=findSort_true(po1.getName());
		if(po!=null){
			if(po2!=null){
				po.name=po2.name;
				this.writeSortList();
			}
			System.out.println("updateSort:");
			return true;
		}
		return false;
	}

	public boolean addGift(CommodityPO po,int number) {
		
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		
		if(po1!=null){
			if(!po1.isGift){
				if(po1.number>=number){
					po1.number=po1.number-number;
					po=po1.copy();
					po.isGift=true;
					po.number=number;
					giftList.add(po.copy());
					this.writeSortList();
					this.writeGiftList();
					return true;
				}
			}
		}
		return false;
	}

	public CommodityPO findGift(String name, String type) {
		int i=0;
		for(i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(name)&&
					giftList.get(i).getType().equals(type)){
				return giftList.get(i).copy();
			}
		}
		return null;
	}

	public boolean delGift(CommodityPO po){
		int i=0;
		for(i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(po.getName())&&
					giftList.get(i).getType().equals(po.getType())){
				CommodityPO po1=findGood_true(giftList.get(i).getName(),giftList.get(i).getType());
				
				if(po1!=null){
					po1.number=giftList.get(i).number+po1.number;
					giftList.remove(i);
					System.out.println("delGift:");
					this.writeSortList();
					this.writeGiftList();
					return true;
				}else{
					giftList.get(i).isGift=false;
					if(addGood(giftList.get(i),sortList.get(0))){
						this.writeGiftList();
						this.writeSortList();
						return true;
					}
				}
			}
		}
		return false;
	}

	public ArrayList<CommodityPO> getAll() {
		ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
		for(int i=0;i<sortList.size();i++){
			ArrayList<CommodityPO> lin=sortList.get(i).getAllCommodity();
			for(int j=0;j<lin.size();j++){
//				CommodityPO gift=findGift(lin.get(j).getName(),lin.get(j).getType());
//				if(gift!=null){
//					lin.get(j).number=lin.get(j).number+gift.getNumber();
//				}
				array.add(lin.get(j).copy());
			}
		}
		return array;
	}

	public boolean clear() {
		sortList=new ArrayList<SortPO>();
		patchList=new ArrayList<PatchPO>();
		giftList=new ArrayList<CommodityPO>();
		sendGiftList=new ArrayList<SendGiftPO>();
		draftPatchList=new ArrayList<PatchPO>();
		return true;
	}

	public ArrayList<SortPO> getAllSort() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<SortPO> sort=new ArrayList<SortPO>();
		int i=0;
		for(i=0;i<sortList.size();i++){
			sort.add(sortList.get(i).copy());
		}
		return sort;
	}
	
	public ArrayList<SortPO> getSort(SortPO po) throws RemoteException {
		ArrayList<SortPO> sort=new ArrayList<SortPO>();
		int i=0,j=0;
	
		if(po.hasSort()){
			for(i=0;i<po.sortList.size();i++){
				sort.add(po.sortList.get(i));
			
				if(!po.sortList.get(i).hasSort()){
					ArrayList<SortPO> lin=getSort(po.sortList.get(i));
					for(j=0;j<lin.size();j++){
						sort.add(lin.get(j));
					}
				
				}
				
			}
		}
		return sort;
	}

	public boolean updateSort_Mov(SortPO po1, SortPO po2) throws RemoteException {
		// TODO Auto-generated method stub
		String father;
		SortPO po3=findSort_true(po1.getName());
		SortPO po4=findSort_true(po2.getName());
		String[] str3=po3.getNote().split("-");
		
		if(po3.father==null){
			sortList.remove(po3);
		}else{
			SortPO po5=findSort_true(po3.father);
			po5.sortList.remove(po3);
		}

		if(po4==null){
			po3.note=str3[0]+str3[2];
			sortList.add(po3);
			this.writeSortList();
			System.out.println("updateSort_Mov");
			return true;
		}

		String[] str4=po4.getNote().split("-");
		
		if(po4.father!=null){
			father=str4[2];
		}else{
			father=str4[1];
		}
		
		po3.note=str3[0]+father+str3[2];
		if(po4.addSort(po3)){
			this.writeSortList();
			System.out.println("updateSort_Mov:");
			return true;
		}else{
			return false;
		}

	}

	public boolean addWarn(WarnPO po) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityPO po1=findGood_true(po.commodity.getName(),po.commodity.getType());
		if(po1!=null){
			po1.warn=po.warn_number+po1.warn;
			this.writeSortList();
			System.out.println("addWarn:");
			return true;
		}
		return false;
	}

	public boolean addDraftPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		draftPatchList.add(po);
		this.writeDraftPatchList();
		System.out.println("addDraftPatch:");
		return true;
	}

	public boolean delDraftPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<draftPatchList.size();i++){
			if(draftPatchList.get(i).getNote().equals(note)){
				draftPatchList.remove(i);
				this.writeDraftPatchList();
				System.out.println("delDraftPatch:");
				return true;
			}
		}
		return false;
	}

	public PatchPO getDraftPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<draftPatchList.size();i++){
			if(draftPatchList.get(i).getNote().equals(note)){
				System.out.println("getDraftPatch:");
				return draftPatchList.get(i).copy();
			}
		}
		return null;
	}

	public ArrayList<PatchPO> getAllDraftPatch() throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		ArrayList<PatchPO> array=new ArrayList<PatchPO>();
		for(i=0;i<draftPatchList.size();i++){
			array.add(draftPatchList.get(i));
		}
		System.out.println("getAllDraftPatch:");
		return array;
	}

	public boolean addPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		po.setTime(AccountDataService_Stub.getNowTime());
		patchList.add(po.copy());
		this.writePatchList();
		System.out.println("addPatch:");
		return true;
	}

	public boolean delPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<patchList.size();i++){
			if(patchList.get(i).getNote().equals(note)){
				patchList.remove(i);
				this.writePatchList();
				System.out.println("delPatch:");
				return true;
			}
		}
		return false;
	}

	public PatchPO getPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<patchList.size();i++){
			if(patchList.get(i).getNote().equals(note)){
				System.out.println("getPatch:");
				return patchList.get(i).copy();
			}
		}
		return null;
	}

	public ArrayList<PatchPO> getAllPatch() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PatchPO> array=new ArrayList<PatchPO>();
		for(int i=0;i<patchList.size();i++){
			array.add(patchList.get(i).copy());
		}
		System.out.println("getAllPatch:");
		return array;
	}

	public boolean addSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		po.setCondition(1);
		for(int i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(po.getCommodity().getName())&&giftList.get(i).getType().equals(po.getCommodity().getType())){
				if(giftList.get(i).getNumber()>=po.getNumber()){
					giftList.get(i).number=giftList.get(i).number-po.getNumber();
					sendGiftList.add(po.copy());
					this.writeGiftList();
					this.writeSendGiftList();
					System.out.println("addSendGift:");
					return true;
				}
			}
		}
		return false;
	}

	public SendGiftPO findSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(po.getNote())){
				System.out.println("findSendGift:");
				return sendGiftList.get(i).copy();
			}
		}
		return null;
	}

	public SendGiftPO findSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(note)){
				System.out.println("findSendGift:");
				return sendGiftList.get(i).copy();
			}
		}
		return null;
	}

	public boolean delSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(po.getNote())){
				sendGiftList.remove(i);
				this.writeSendGiftList();
				System.out.println("delSendGift:");
				return true;
			}
		}
		return false;
	}

	public boolean delSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(note)){
				sendGiftList.remove(i);
				this.writeSendGiftList();
				System.out.println("delSendGift:");
				return true;
			}
		}
		return false;
	}

	public CommodityPO findGift(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(po.getName())&&giftList.get(i).getType().equals(po.getType())){
				System.out.println("findGift:");
				return giftList.get(i).copy();
			}
		}
		return null;
	}
	
	public ArrayList<CommodityPO> getAllGift() throws RemoteException {
		ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
		
		for(int i=0;i<giftList.size();i++){
			array.add(giftList.get(i).copy());
		}
		System.out.println("getAllGift:");
		return array;
	}

	public String getGoodNote(SortPO po1) throws RemoteException {
		// TODO Auto-generated method stub
		po1=findSort_true(po1.getName());
		String[] sortNote=po1.getNote().split("-");
		String part1="COM";
		String part2="";;
		if(po1.father==null){
			part2=sortNote[1];
		}else{
			part2=sortNote[2];
		}
		String part3=Integer.toString(comNote);
		comNote++;
		this.writeComNote();
		System.out.println("getGoodNote:");
		return part1+"-"+part2+"-"+part3;	
		
	}

	public String getSortNote(SortPO po1) throws RemoteException {
		// TODO Auto-generated method stub
		po1=findSort_true(po1.getName());
		String part1="SORT";
		String part3=Integer.toString(sortNote);
		sortNote++;
		this.writeSortNote();
		System.out.println("getSortNote:");
		if(po1==null){
			return part1+"-"+part3;
		}
		String[] sortNote=po1.getNote().split("-");
		String part2;
		if(po1.father==null){
			part2=sortNote[1];
		}else{
			part2=sortNote[2];
		}
		
		return part1+"-"+part2+"-"+part3;
	}

	public String getPatchNote() throws RemoteException {
		// TODO Auto-generated method stub
		String part1="PAT";
		String part2=AccountDataService_Stub.getNoteTime();
		String part3=Integer.toString(patchNote);
		patchNote++;
		this.writePatchNote();
		System.out.println("getPatchNote:");
		return part1+"-"+part2+"-"+part3;
	}
	
	public String getSendGiftNote() throws RemoteException{
		String part1="PAT";
		String part2=AccountDataService_Stub.getNoteTime();
		String part3=Integer.toString(sendNote);
		sendNote++;
		this.writeSendNote();
		System.out.println("getSendGiftNote:");
		return part1+"-"+part2+"-"+part3;
	}
	
	public boolean addGoodNumber(CommodityPO po,int number) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		po1.number=po1.number+number;
		this.writeSortList();
		System.out.println("addGoodNumber:");
		return true;
	}	
	
	public SortPO findSort_true(String name){
		int i=0;
		System.out.println("findSort_true");
		for(i=0;i<sortList.size();i++){
			if(sortList.get(i).getName().equals(name)){
				return sortList.get(i);
			}
			if(sortList.get(i).hasSort()){
				SortPO po=sortList.get(i).findSort_In(name);
				if(po!=null){
					return po;
				}
			}
		}
		return null;
	}
	
	public CommodityPO findGood_true(String name, String type) {
		int i=0;
		System.out.println("findGood_true:");
		for(i=0;i<sortList.size();i++){
			CommodityPO po=sortList.get(i).findCommodity_true(name, type);
			if(po!=null){
				return po;
			}
		}
		return null;
	}

	public boolean passPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<patchList.size();i++){
			if(patchList.get(i).getNote().equals(po.getNote())){
				if(addGoodNumber(patchList.get(i).getCommodity(),po.getNumber())){
					patchList.get(i).setCondition(2);
					patchList.get(i).setNumber(po.getNumber());
					this.writePatchList();
					System.out.println("passPatch:");
					return true;
				}
			}
		}
		return false;
	}

	public boolean refusePatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<patchList.size();i++){
			if(patchList.get(i).getNote().equals(note)){
				patchList.get(i).setCondition(3);
				this.writePatchList();
				System.out.println("refusePatch:");
				return true;
			}
		}
		return false;
	}

	public boolean passSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(po.getNote())){
				if(po.getNumber()>(sendGiftList.get(i).getNumber()+findGift(po.getCommodity()).getNumber())){
					return false;
				}
				
				for(int j=0;j<giftList.size();j++){
					if(giftList.get(j).getName().equals(po.getCommodity().getName())&&giftList.get(j).getType().equals(po.getCommodity().getType())){
						giftList.get(j).number=giftList.get(j).number-po.getNumber()+sendGiftList.get(i).getNumber();
					}
				}
				sendGiftList.get(i).setCondition(2);
				sendGiftList.get(i).setNumber(po.getNumber());
				this.writeSendGiftList();
				this.writeGiftList();
				System.out.println("passSendGift:");
				return true;
			}
		}
		return false;
	}

	public boolean refuseSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(note)){
				if(addGoodNumber(sendGiftList.get(i).getCommodity(),sendGiftList.get(i).getNumber())){
					sendGiftList.get(i).setCondition(3);
					this.writeSendGiftList();
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean passImport(ImportPO po){
		CommodityPO com=findGood_true(po.getImportGoodList().get(0).getCommodity().getName(), po.getImportGoodList().get(0).getCommodity().getType());
		
		if(com==null){
			return false;
		}
		
		CommodityPO gift=findGift(po.getImportGoodList().get(0).getCommodity().getName(), po.getImportGoodList().get(0).getCommodity().getType());
		com.recent_in_price=po.getImportGoodList().get(0).getPrice();
		int number=com.getNumber();
		if(gift!=null){
			number=number+gift.getNumber();
		}
		com.number=com.number+po.getImportGoodList().get(0).getNumber();
		if((number+po.getImportGoodList().get(0).getNumber())!=0){
			com.mean=((number*com.mean)+po.getTotalMoney())/(number+po.getImportGoodList().get(0).getNumber());
		}
		
		for(int i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(com.getName())&&giftList.get(i).getType().equals(com.getType())){
				gift.recent_in_price=com.recent_in_price;
				gift.mean=com.mean;
			}
		}
		this.writeGiftList();
		this.writeSortList();
		System.out.println("passImport:");
		return true;
	}
	
	public boolean passImport_Return(Import_ReturnPO po){
		CommodityPO com=findGood_true(po.getImportGoodList().get(0).getCommodity().getName(), po.getImportGoodList().get(0).getCommodity().getType());
		
		if(com==null){
			return false;
		}
		
		CommodityPO gift=findGift(po.getImportGoodList().get(0).getCommodity().getName(), po.getImportGoodList().get(0).getCommodity().getType());
		int number=com.getNumber();
		if(gift!=null){
			number=number+gift.getNumber();
		}
		com.number=com.number-po.getImportGoodList().get(0).getNumber();
		if((number-po.getImportGoodList().get(0).getNumber())!=0){
			com.mean=((number*com.mean)-po.getTotalMoney())/(number-po.getImportGoodList().get(0).getNumber());
		}
		for(int i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(com.getName())&&giftList.get(i).getType().equals(com.getType())){
				gift.mean=com.mean;
			}
		}
		this.writeGiftList();
		this.writeSortList();
		System.out.println("passImport_Return:");
		return true;
	}
	
	public boolean passExport(ExportPO po){
		CommodityPO com=findGood_true(po.getExportGoodList().get(0).getCommodity().getName(), po.getExportGoodList().get(0).getCommodity().getType());
		
		if(com==null){
			return false;
		}
		
		CommodityPO gift=findGift(po.getExportGoodList().get(0).getCommodity().getName(), po.getExportGoodList().get(0).getCommodity().getType());
		com.recent_out_price=po.getExportGoodList().get(0).getPrice();
		com.number=com.number-po.getExportGoodList().get(0).getNumber();
		
		for(int i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(com.getName())&&giftList.get(i).getType().equals(com.getType())){
				gift.recent_out_price=com.recent_in_price;
			}
		}
		this.writeGiftList();
		this.writeSortList();
		System.out.println("passExport:");
		return true;
	}
	
	public boolean passExport_Return(Export_ReturnPO po){
	CommodityPO com=findGood_true(po.getExportGoodList().get(0).getCommodity().getName(), po.getExportGoodList().get(0).getCommodity().getType());
		
		if(com==null){
			return false;
		}
		
		com.number=com.number-po.getExportGoodList().get(0).getNumber();
		
		this.writeGiftList();
		this.writeSortList();
		System.out.println("passExport_Return:");
		return true;
	}

	public SortPO getTempSort() throws RemoteException {
		// TODO Auto-generated method stub
		return tempSort.copy();
	}

	public ArrayList<SendGiftPO> getAllSendGift() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<SendGiftPO> array=new ArrayList<SendGiftPO>();
		for(int i=0;i<sendGiftList.size();i++){
			array.add(sendGiftList.get(i).copy());
		}
		System.out.println("getAllSendGift:");
		return array;
	}



}
