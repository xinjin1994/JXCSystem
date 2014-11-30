package businesslogic.financialbl;

import java.rmi.RemoteException;

import po.AllBillPO;
import po.OperatingConditionPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.SaleListPO;
import businesslogic.accountbl.Account;
import businesslogic.commoditybl.Commodity;
import businesslogic.salesbl.Sales;
import businesslogic.systemlogbl.Systemlog;
import businesslogicservice.financialblservice.FinancialblService;
import data.financialdata.FinancialDataService_Stub;
import dataservice.financialdataservice.FinancialDataService;

public class Financial implements businesslogic.accountbl.FinancialInfo{
	
	public FinancialDataService financial=new FinancialDataService_Stub();
	public AccountInfo account=new Account();
	public CommodityInfo commodity=new Commodity();
	public SalesInfo sales=new Sales();
	public SystemlogInfo systemlog=new Systemlog();
	

	public String saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		try {
			if(financial.getSaleList()!=null){
				return "�ɹ�";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ʧ��";
	}

	public String allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		try {
			if(financial.getAllBill()!=null){
				return " �ɹ�";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ʧ��";
	}

	public String operatingCondition(String time1, String time2) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		try {
			if(financial.getOperatingCondition()!=null){
				return " �ɹ�";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ʧ��";
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
		AllBillPO po1=new AllBillPO(po);
		try {
			return financial.addAllBill(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addAllBill(PaymentPO po) {
//		financial= new FinancialDataService_Stub();
		AllBillPO po1=new AllBillPO(po);
		try {
			return financial.addAllBill(po1);
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
		OperatingConditionPO po1=new OperatingConditionPO(po.getTotal(),0,0);
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
		OperatingConditionPO po1=new OperatingConditionPO(0,0,po.getTotal());
		try {
			return financial.addOperatingCondition(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
