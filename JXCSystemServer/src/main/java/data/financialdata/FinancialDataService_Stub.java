package data.financialdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.PaymentPO;
import po.SaleListPO;
import dataservice.financialdataservice.FinancialDataService;

public class FinancialDataService_Stub extends UnicastRemoteObject implements FinancialDataService{

	ArrayList<SaleListPO> saleListList=new ArrayList<SaleListPO>();
	ArrayList<AllBillPO> allBillList=new ArrayList<AllBillPO>();
	ArrayList<OperatingConditionPO> operatingConditionList=new ArrayList<OperatingConditionPO>();
	
	
	public void writeOperatingConditionList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("operatingConditionList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(operatingConditionList);	
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
	public void readOperatingConditionList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("operatingConditionList.out");
			ois=new ObjectInputStream(fis);
			operatingConditionList=(ArrayList<OperatingConditionPO>) ois.readObject();
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
	
	
	
	public void writeAllBillList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("allBillList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(allBillList);	
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
	public void readAllBillList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("allBillList.out");
			ois=new ObjectInputStream(fis);
			allBillList=(ArrayList<AllBillPO>) ois.readObject();
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
	
	
	public void writeSaleListList(){
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("saleListList.out");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(saleListList);	
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
	public void readSaleListList(){
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try{
			
			fis=new FileInputStream("saleListList.out");
			ois=new ObjectInputStream(fis);
			saleListList=(ArrayList<SaleListPO>) ois.readObject();
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
	
	public FinancialDataService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		writeSaleListList();
		writeAllBillList();
		writeOperatingConditionList();
		
		readSaleListList();
		readAllBillList();
		readOperatingConditionList();
	}
	
/*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑上面是Financial的序列化和构造方法↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/

	public ArrayList<SaleListPO> getSaleList() {
		int i=0;
		ArrayList<SaleListPO> po=new ArrayList<SaleListPO>();
		for(i=0;i<saleListList.size();i++){
			po.add(saleListList.get(i).copy());
		}
		return po;
	}

	public ArrayList<AllBillPO> getAllBill() {
		int i=0;
		ArrayList<AllBillPO> po=new ArrayList<AllBillPO>();
		for(i=0;i<allBillList.size();i++){
			po.add(allBillList.get(i).copy());
		}
		return po;
	}

	public ArrayList<OperatingConditionPO> getOperatingCondition() {
		ArrayList<OperatingConditionPO> array=new ArrayList<OperatingConditionPO>();
		for(int i=0;i<operatingConditionList.size();i++){
			array.add(operatingConditionList.get(i).copy());
		}
		return array;
	}

	public boolean addSaleList(SaleListPO po) {
		saleListList.add(po.copy());
		return true;
	}

	public boolean addAllBill(AllBillPO po) {
		allBillList.add(po.copy());
		return true;
	}

	public boolean addOperatingCondition(OperatingConditionPO po) {
		operatingConditionList.add(po.copy());
		return true;
	}

	public boolean clear() {
		saleListList=new ArrayList<SaleListPO>();
		allBillList=new ArrayList<AllBillPO>();
		operatingConditionList=new ArrayList<OperatingConditionPO>();
		return true;
	}

}
