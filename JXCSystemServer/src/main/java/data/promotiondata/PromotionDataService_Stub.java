package data.promotiondata;

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
import po.DiscountPO;
import po.PaymentPO;
import po.ProGiftPO;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDataService_Stub extends UnicastRemoteObject implements PromotionDataService{

	ProGiftPO nowProGift;
	DiscountPO nowDiscount;
	
	ArrayList<ProGiftPO> proGiftList=new ArrayList<ProGiftPO>();
	ArrayList<DiscountPO> discountList=new ArrayList<DiscountPO>();
	
	
	public void writeNowDiscount(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("nowDiscount.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nowDiscount);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readNowDiscount(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("nowDiscount.out");
			ois=new ObjectInputStream(fis);
			nowDiscount=(DiscountPO) ois.readObject();
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
	
	public void writeNowProGift(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("nowProGift.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nowProGift);	
			oos.close();
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void readNowProGift(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("nowProGift.out");
			ois=new ObjectInputStream(fis);
			nowProGift=(ProGiftPO) ois.readObject();
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
	
	public void writeProGiftList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("proGiftList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(proGiftList);	
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
	public void readProGiftList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("proGiftList.out");
			ois=new ObjectInputStream(fis);
			proGiftList=(ArrayList<ProGiftPO>) ois.readObject();
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
	
	
	public void writeDiscountList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("discountList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(discountList);	
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
	public void readDiscountList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("discountList.out");
			ois=new ObjectInputStream(fis);
			discountList=(ArrayList<DiscountPO>) ois.readObject();
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

	public PromotionDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean addDiscount(DiscountPO po) {
		return true;
	}

	public boolean addGift(ProGiftPO po) {
		return true;
	}

	public boolean delDiscount(DiscountPO po) {
		return true;
	}

	public boolean delGift(ProGiftPO po) {
		return true;
	}

	public DiscountPO getDiscount() {
		return new DiscountPO(1,"t1","t2",1000,2000,50);
	}

	public ProGiftPO getGift() {
		CommodityPO gift=new CommodityPO(true, "n", "t", 10, 10, 10, 10, 10, 10);
		return new ProGiftPO(gift, "time1", "time2");
	}

	public ArrayList<DiscountPO> showDiscount() {
		return discountList;
	}

	public ArrayList<ProGiftPO> showProGift() {
		return proGiftList;
	}

}
