package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AllBillPO;
import po.CommodityPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.OperatingConditionPO;
import po.PatchPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.SaleListPO;
import po.SendGiftPO;
import businesslogic.accountbl.Account;
import businesslogic.commoditybl.Commodity;
import businesslogic.salesbl.Sales;
import businesslogic.systemlogbl.Systemlog;
import data.financialdata.FinancialDataService_Stub;
import dataservice.financialdataservice.FinancialDataService;

public class Financial implements businesslogic.accountbl.FinancialInfo{
	
	public FinancialDataService financial=new FinancialDataService_Stub();
	public AccountInfo account;
	public CommodityInfo commodity;
	public SalesInfo sales;
	public SystemlogInfo systemlog;
	
	
	public void setInfo(AccountInfo account,CommodityInfo commodity, SalesInfo sales, SystemlogInfo systemlog){
		this.account=account;
		this.commodity=commodity;
		this.sales=sales;
		this.systemlog=systemlog;
	}
	

	public ArrayList<SaleListPO> saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, String wareHouse) {
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
					(wareHouse==null||fin.get(i).getWareHouse()==wareHouse)){
					
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
			String customer_name, String clerk, String warehouse) {
		// TODO Auto-generated method stub
		ArrayList<AllBillPO> array=new ArrayList<AllBillPO>();
		try {
			ArrayList<AllBillPO> fin=financial.getAllBill();
			
			for(int i=0;i<array.size();i++){
				
				if(!((time1==null||fin.get(i).getTime().compareTo(time1)>=0)&&(time2==null||fin.get(i).getTime().compareTo(time2)<=0))){
//						&&
//						(note_type==null||fin.get(i).getDocType().equals(note_type))&&
//						(good_type==null||fin.get(i).getCommodity().getType().equals(good_type))&&
//						(customer_name==null||fin.get(i).getCustomer().getName().equals(customer_name))&&
//						(clerk==null||fin.get(i).getClerk().equals(clerk))&&
//						(warehouse==null||fin.get(i).getWareHouse()==wareHouse)){
					fin.remove(i);
					continue;
				}
				
				switch(fin.get(i).getDocType()){
					case 1: SendGiftPO po1=(SendGiftPO) fin.get(i);
							if(customer_name==null||po1.getCustomer().equals(customer_name)){
								if(clerk==null){
									if(warehouse==null){
										array.add(fin.get(i));
									}
								}
							}
							break;
					case 2: ImportPO po2=(ImportPO) fin.get(i);
							if(customer_name==null||po2.getCustomer().getName().equals(customer_name)){
								if(clerk==null||po2.getClerk().equals(clerk)){
									if(warehouse==null||po2.getWareHouse().equals(warehouse)){
										array.add(fin.get(i));
									}
								}
							}
							break;
					case 3: Import_ReturnPO po3=(Import_ReturnPO) fin.get(i);
							if(customer_name==null||po3.getCustomer().getName().equals(customer_name)){
								if(clerk==null||po3.getClerk().equals(clerk)){
									if(warehouse==null||po3.getWareHouse().equals(warehouse)){
										array.add(fin.get(i));
									}
								}
							}
							break;
					case 4: ExportPO po4=(ExportPO) fin.get(i);
							if(customer_name==null||po4.getCustomer().getName().equals(customer_name)){
								if(clerk==null||po4.getClerk().equals(clerk)){
									if(warehouse==null||po4.getWareHouse().equals(warehouse)){
										array.add(fin.get(i));
									}
								}
							}
							break;
					case 5: Export_ReturnPO po5=(Export_ReturnPO) fin.get(i);
							if(customer_name==null||po5.getCustomer().getName().equals(customer_name)){
								if(clerk==null||po5.getClerk().equals(clerk)){
									if(warehouse==null||po5.getWareHouse().equals(warehouse)){
										array.add(fin.get(i));
									}
								}
							}
							break;
					case 6: PatchPO po6=(PatchPO) fin.get(i);
							if(customer_name==null){
								if(clerk==null){
									if(warehouse==null){
										array.add(fin.get(i));
									}
								}
							}
							break;
					case 7: ReceiptPO po7=(ReceiptPO) fin.get(i);
							if(customer_name==null||po7.getCustomer().getName().equals(customer_name)){
								if(clerk==null){
									if(warehouse==null){
										array.add(fin.get(i));
									}
								}
							}
							break;
					case 8: PaymentPO po8=(PaymentPO) fin.get(i);
							if(customer_name==null||po8.getItem().get(0).getItemName().equals(customer_name)){
								if(clerk==null){
									if(warehouse==null){
										array.add(fin.get(i));
									}
								}
							}
							break;
				}
						
			}
				
			
			
			
			if(array!=null){
				return array;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public ArrayList<OperatingConditionPO> operatingCondition(String time1, String time2) {
		// TODO Auto-generated method stub
		ArrayList<OperatingConditionPO> array=new ArrayList<OperatingConditionPO>();
		try {
			ArrayList<OperatingConditionPO> fin=financial.getOperatingCondition();
			
			for(int i=0;i<fin.size();i++){
				if((time1==null||fin.get(i).getTime().compareTo(time1)>=0)&&
						(time2==null||fin.get(i).getTime().compareTo(time2)<=0)){
						
						array.add(fin.get(i));
					}
			}
			
			
			if(array!=null){
				return array;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	
	
	public boolean addSaleList(SaleListPO po) {
		try {
			return financial.addSaleList(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean addAllBill(AllBillPO po) {
		try {
			return financial.addAllBill(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addAllBill(ReceiptPO po) {
		
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
	
	public boolean addOperatingCondition(ImportPO po) {
		OperatingConditionPO po1=new OperatingConditionPO(po.getNote(),po.getTime(),0,0,po.getTotalMoney(), 0, 0);
		try {
			return financial.addOperatingCondition(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addOperatingCondition(Import_ReturnPO po){
		OperatingConditionPO po1=new OperatingConditionPO(po.getNote(),po.getTime(),0,0,-po.getTotalMoney(), 0, 0);
		try {
			return financial.addOperatingCondition(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addOperatingCondition(ExportPO po) {
		OperatingConditionPO po1=new OperatingConditionPO(po.getNote(),po.getTime(),po.getTotalMoneyBefore(),0,0, 0,po.getDiscount()+po.getVoucher());
		try {
			return financial.addOperatingCondition(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addOperatingCondition(Export_ReturnPO po) {
		OperatingConditionPO po1=new OperatingConditionPO(po.getNote(),po.getTime(),-po.getTotalMoneyBefore(),0,0, 0,-(po.getDiscount()+po.getVoucher()));
		try {
			return financial.addOperatingCondition(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addOperatingCondition(PatchPO po){
		ArrayList<CommodityPO> com=commodity.getAllCommodity();
	

		try {	
			for(int i=0;i<com.size();i++){
				if(com.get(i).getName().equals(po.getCommodity().getName())&&com.get(i).getType().equals(po.getCommodity().getType())){
					OperatingConditionPO po1;
					if(po.getNumber()>0){
						po1=new OperatingConditionPO(po.getNote(),po.getTime(),0,com.get(i).getMean()*po.getNumber(),0, 0, 0);
					}else{
						po1=new OperatingConditionPO(po.getNote(),po.getTime(),0,0,0,-com.get(i).getMean()*po.getNumber(), 0);
					}
					return financial.addOperatingCondition(po1);
				}
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addOperatingCondition(SendGiftPO po){
		ArrayList<CommodityPO> com=commodity.getAllCommodity();
		try {	
			for(int i=0;i<com.size();i++){
				if(com.get(i).getName().equals(po.getCommodity().getName())&&com.get(i).getType().equals(po.getCommodity().getType())){
					OperatingConditionPO po1=new OperatingConditionPO(po.getNote(),po.getTime(),0,0,0, com.get(i).getMean()*po.getNumber(), 0);
					return financial.addOperatingCondition(po1);
				}
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
