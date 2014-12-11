package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.SaleListPO;
import vo.ConditionVO;
import businesslogic.accountbl.Account;
import businesslogic.commoditybl.Commodity;
import businesslogic.salesbl.Sales;
import businesslogic.systemlogbl.Systemlog;
import data.financialdata.FinancialDataService_Stub;
import dataservice.financialdataservice.FinancialDataService;

public class Financial implements businesslogic.accountbl.FinancialInfo{
	
	public FinancialDataService financial=new FinancialDataService_Stub();
	public AccountInfo account=new Account();
	public CommodityInfo commodity=new Commodity();
	public SalesInfo sales=new Sales();
	public SystemlogInfo systemlog=new Systemlog();
	

	public ArrayList<SaleListPO> saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int wareHouse) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		int i=0;
		ArrayList<SaleListPO> array=new ArrayList<SaleListPO>();
		
		try {
			ArrayList<SaleListPO> fin=financial.getSaleList();
			
			for(i=0;i<fin.size();i++){
				
				if((time1==null||fin.get(i).getTime().compareTo(time1)>=0)&&
					(time2==null||fin.get(i).getTime().compareTo(time2)<=0)&&
					(good_name==null||fin.get(i).getCommodity().equals(good_name))&&
					(good_type==null||fin.get(i).getCommodity().getType().equals(good_type))&&
					(customer_name==null||fin.get(i).getCustomer().getName().equals(customer_name))&&
					(clerk==null||fin.get(i).getClerk().equals(clerk))&&
					(wareHouse==0||fin.get(i).getWareHouse()==wareHouse)){
					
					array.add(fin.get(i));
				}
				
			}
			
				return array;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public ArrayList<AllBillPO> allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		try {
			ArrayList<AllBillPO> array=financial.getAllBill();
			if(array!=null){
				return array;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public OperatingConditionPO operatingCondition(String time1, String time2) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		try {
			OperatingConditionPO po=financial.getOperatingCondition();
			if(po!=null){
				return po;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public boolean addSaleList(SaleListPO po) {
//		financial= new FinancialDataService_Stub();
		try {
			return financial.addSaleList(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean addAllBill(AllBillPO po) {
//		financial= new FinancialDataService_Stub();
		try {
			return financial.addAllBill(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addAllBill(ReceiptPO po) {
//		financial= new FinancialDataService_Stub();
		
		try {
			return financial.addAllBill(po.copy());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addAllBill(PaymentPO po) {
//		financial= new FinancialDataService_Stub();
		try {
			return financial.addAllBill(po.copy());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean addOperatingCondition(OperatingConditionPO po) {
//		financial= new FinancialDataService_Stub();
		try {
			return financial.addOperatingCondition(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addOperatingCondition(ReceiptPO po) {
//		financial= new FinancialDataService_Stub();
		OperatingConditionPO po1=new OperatingConditionPO(0,0,po.getTotalMoney(), 0, 0);
		try {
			return financial.addOperatingCondition(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addOperatingCondition(PaymentPO po) {
//		financial= new FinancialDataService_Stub();
		OperatingConditionPO po1=new OperatingConditionPO(po.getTotalMoney(),0,0, 0, 0);
		try {
			return financial.addOperatingCondition(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
