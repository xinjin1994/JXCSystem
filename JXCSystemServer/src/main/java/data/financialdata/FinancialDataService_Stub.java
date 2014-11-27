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
	}

	public SaleListPO[] getSaleList() {
		return new SaleListPO[1];
	}

	public AllBillPO[] getAllBill() {
		return new AllBillPO[1];
	}

	public OperatingConditionPO[] getOperatingCondition() {
		return new OperatingConditionPO[1];
	}

	public boolean addSaleList(SaleListPO po) {
		return true;
	}

	public boolean addAllBill(AllBillPO po) {
		return true;
	}

	public boolean addOperatingCondition(OperatingConditionPO po) {
		return true;
	}

	public boolean clear() {
		return true;
	}

}
