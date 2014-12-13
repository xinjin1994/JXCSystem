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
import po.PatchPO;
import po.PaymentPO;
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
	
	int comNote=0;
	int sortNote=0;
	int sendNote=0;
	int patchNote=0;
	
//	ArrayList<CommodityPO> sto=new ArrayList<CommodityPO>();
	
	public CommodityDataService_Stub() throws RemoteException {
		super();
		this.readSortList();
		this.readPatchList();
		this.readGiftList();
		this.readDraftPatchList();
		this.readSendGiftList();
		this.readComNote();
		this.readSortNote();
		this.readSendNote();
		this.readPatchNote();
		// TODO Auto-generated constructor stub
	}

	public void writeSortList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("sortList.out");
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
			
			fis=new FileInputStream("sortList.out");
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
			fos = new FileOutputStream("patchList.out");
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
			
			fis=new FileInputStream("patchList.out");
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
			fos = new FileOutputStream("draftPatchList.out");
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
			
			fis=new FileInputStream("draftPatchList.out");
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
			fos = new FileOutputStream("giftList.out");
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
			
			fis=new FileInputStream("giftList.out");
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
			fos = new FileOutputStream("sendGiftList.out");
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
			
			fis=new FileInputStream("sendGiftList.out");
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
			fos = new FileOutputStream("comNote.out");
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
	
	@SuppressWarnings("unchecked")
	public void readComNote(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("comNote.out");
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
			fos = new FileOutputStream("sortNote.out");
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
			
			fis=new FileInputStream("sortNote.out");
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
			fos = new FileOutputStream("sendNote.out");
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
			
			fis=new FileInputStream("sendNote.out");
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
			fos = new FileOutputStream("patchNote.out");
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
			
			fis=new FileInputStream("patchNote.out");
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
	
	
	/*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑数据序列化以及构造方法↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/
	
	
	public CommodityPO findGood(String name, String type) {
		int i=0;
		for(i=0;i<sortList.size();i++){
			CommodityPO po=sortList.get(i).findCommodity_true(name, type);
			if(po!=null){
				return po.copy();
			}
		}
		return null;
	}

	public boolean addGood(CommodityPO po1, SortPO po2) {
		SortPO sort=findSort_true(po2.getName());
		if(sort!=null&&sort.hasSort()){
			sort.addCommodity(po1);
			System.out.println("Add Success!");
			this.writeSortList();
			return true;
		}
		return false;
	}

	public boolean delGood(CommodityPO po) {
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		int i=0;
		if(po1.number==0){
			for(i=0;i<sortList.size();i++){
				if(sortList.get(i).delCommodity(po1)){
					this.writeSortList();
					return true;
				}
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
			this.writeSortList();
			return true;
		}
		return false;
	}
	
	public boolean updateGood(CommodityPO po1, SortPO po2) throws RemoteException {
		// TODO Auto-generated method stub
		SortPO po4=findSort_true(po2.getName());
		CommodityPO po3=po1.copy();
		delGood(po1);
		if(po4!=null){
			addGood(po3,po4);
			return true;
		}
		return false;
	}

	public boolean addSort(SortPO po1,SortPO po2) {
		SortPO po=findSort_true(po1.getName());
		if(po!=null){
			return false;
		}else if(po2!=null){
			if(po2.hasSort()){
				return false;
			}
			
			if(po2.sortList==null){
				po2.sortList=new ArrayList<SortPO>();
			}
			po2.sortList.add(po1.copy());
			this.writeSortList();
			return true;
			
		}else{
			sortList.add(po1);
			this.writeSortList();
		}
		return true;
	}

	public boolean delSort(SortPO po) {
		SortPO po1=findSort_true(po.getName());
		
		int i=0;
		for(i=0;i<sortList.size();i++){
			if(po1.getName().equals(sortList.get(i).getName())){
				sortList.remove(po1);
				this.writeSortList();
				return true;
			}else{
				if(sortList.get(i).delSort(po1)){
					this.writeSortList();
					return true;
				}
			}
		}
		return false;
	}

	public boolean updateSort(SortPO po1, SortPO po2) {
		SortPO po=findSort_true(po1.getName());
		if(po!=null){
			if(po2.name!=null){
			po1.name=po2.name;
			}
			this.writeSortList();
			return true;
		}
		return false;
	}

	public boolean addGift(CommodityPO po) {
		
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		
		if(po1!=null){
			if(!po1.isGift){
				if(po1.number>=po.number){
					po1.number=po1.number-po.number;
					po.isGift=true;
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
		CommodityPO com=new CommodityPO(null, null, null, 0, 0, null, 0, 0, 0);
		ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
		array.add(com);
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
		int i=0,j=0;
		for(i=0;i<sortList.size();i++){
			sort.add(sortList.get(i).copy());
			
			if(!sortList.get(i).hasSort()){
				ArrayList<SortPO> lin=getSort(sortList.get(i));
				for(j=0;j<lin.size();j++){
					sort.add(lin.get(j).copy());
				}
			}
				
		}
		
		return sort;
	}
	
	public ArrayList<SortPO> getSort(SortPO po) throws RemoteException {
		ArrayList<SortPO> sort=new ArrayList<SortPO>();
		int i=0,j=0;
	
		if(!po.hasSort()){
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
		String[] str4=po4.getNote().split("-");
		
		if(po4.father!=null){
			father=str4[2];
		}else{
			father=str4[1];
		}
		if(po4!=null){
			SortPO po5=findSort_true(po1.father);
			po5.sortList.remove(po3);
			po3.note=str3[0]+father+str3[2];
			addSort(po3,po4);
			this.writeSortList();
			return true;
		}
		
		return false;
	}

	public boolean addWarn(WarnPO po) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityPO po1=findGood_true(po.commodity.getName(),po.commodity.getType());
		if(po1!=null){
			po1.warn=po.warn_number;
			this.writeSortList();
			return true;
		}
		return false;
	}

	public boolean addDraftPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		draftPatchList.add(po);
		this.writePatchList();
		return false;
	}

	public boolean delDraftPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<draftPatchList.size();i++){
			if(draftPatchList.get(i).getNote().equals(note)){
				draftPatchList.remove(i);
				this.writeDraftPatchList();
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
		return array;
	}

	public boolean addPatch(PatchPO po) throws RemoteException {
		// TODO Auto-generated method stub
		patchList.add(po.copy());
		return true;
	}

	public boolean delPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<patchList.size();i++){
			if(patchList.get(i).getNote().equals(note)){
				patchList.remove(i);
				return true;
			}
		}
		return false;
	}

	public PatchPO getPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<patchList.size();i++){
			if(patchList.get(i).getNote().equals(note)){
				return patchList.get(i).copy();
			}
		}
		return null;
	}

	public ArrayList<PatchPO> getAllPatch() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PatchPO> array=new ArrayList<PatchPO>();
		for(int i=0;i<patchList.size();i++){
			array.add(patchList.get(i));
		}
		return array;
	}

	public boolean addSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		sendGiftList.add(po.copy());
		return true;
	}

	public SendGiftPO findSendGift(SendGiftPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(po.getNote())){
				return sendGiftList.get(i).copy();
			}
		}
		return null;
	}

	public SendGiftPO findSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(note)){
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
				return true;
			}
		}
		return false;
	}

	public CommodityPO findGift(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<giftList.size();i++){
			if(giftList.get(i).getName().equals(po.getName())&&giftList.get(i).getType().equals(po.getType())){
				return giftList.get(i).copy();
			}
		}
		return null;
	}

	public String getGoodNote(SortPO po1) throws RemoteException {
		// TODO Auto-generated method stub
		String[] sortNote=po1.getNote().split("-");
		String part1="COM";
		String part2="SORT"+sortNote[1];
		String part3=Integer.toString(comNote);
		comNote++;
		return part1+"-"+part2+"-"+part3;
	}

	public String getSortNote(SortPO po1) throws RemoteException {
		// TODO Auto-generated method stub
		String part1="SORT";
		String part3=Integer.toString(sortNote);
		sortNote++;
		return part1+"-"+part3;

	}

	public String getPatchNote() throws RemoteException {
		// TODO Auto-generated method stub
		String part1="PAT";
		String part2=AccountDataService_Stub.getNoteTime();
		String part3=Integer.toString(patchNote);
		patchNote++;
		return part1+"-"+part2+"-"+part3;
	}
	
	public String getSendGiftNote() throws RemoteException{
		String part1="PAT";
		String part2=AccountDataService_Stub.getNoteTime();
		String part3=Integer.toString(sendNote);
		sendNote++;
		return part1+"-"+part2+"-"+part3;
	}
	
	public boolean addGoodNumber(CommodityPO po,int number) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityPO po1=findGood_true(po.getName(),po.getType());
		po1.number=po1.number+number;
		return true;
	}	
	
	public SortPO findSort_true(String name){
		int i=0;
		for(i=0;i<sortList.size();i++){
			if(sortList.get(i).getName().equals(name)){
				return sortList.get(i);
			}
			if(!sortList.get(i).hasSort()){
				SortPO po=sortList.get(i).findSort_true(name);
				if(po!=null){
					return po;
				}
				
			}
		}
		return null;
	}
	
	public CommodityPO findGood_true(String name, String type) {
		int i=0;
		for(i=0;i<sortList.size();i++){
			CommodityPO po=sortList.get(i).findCommodity_true(name, type);
			if(po!=null){
				return po.copy();
			}
		}
		return null;
	}

	public boolean passPatch(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<patchList.size();i++){
			if(patchList.get(i).getNote().equals(note)){
				if(addGoodNumber(patchList.get(i).getCommodity(),patchList.get(i).getNumber())){
					patchList.get(i).setCondition(2);
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
				return true;
			}
		}
		return false;
	}

	public boolean passSendGift(String note) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<sendGiftList.size();i++){
			if(sendGiftList.get(i).getNote().equals(note)){
				sendGiftList.get(i).setCondition(2);
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
					return true;
				}
			}
		}
		return false;
	}



}
