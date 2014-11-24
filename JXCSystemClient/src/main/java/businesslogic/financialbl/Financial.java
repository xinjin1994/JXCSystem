package businesslogic.financialbl;

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

public class Financial implements FinancialblService,
			businesslogic.accountbl.FinancialInfo{
	
	public FinancialDataService financial=new FinancialDataService_Stub();
	public AccountInfo account=new Account();
	public CommodityInfo commodity=new Commodity();
	public SalesInfo sales=new Sales();
	public SystemlogInfo systemlog=new Systemlog();
	

	public String saleList(String time1, String time2, String good_name,
			String good_type, String customer_name, String clerk, int warehouse) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		if(financial.getSaleList()!=null){
			return "�ɹ�";
		}
		return "ʧ��";
	}

	public String allBill(String time1, String time2, String note_type,
			String customer_name, String clerk, int warehouse) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		if(financial.getAllBill()!=null){
			return " �ɹ�";
		}
		return "ʧ��";
	}

	public String operatingCondition(String time1, String time2) {
		// TODO Auto-generated method stub
//		financial= new FinancialDataService_Stub();
		if(financial.getOperatingCondition()!=null){
			return " �ɹ�";
		}
		return "ʧ��";
	}
	
	
	
	public boolean addSaleList(SaleListPO po) {
//		financial= new FinancialDataService_Stub();
		return financial.addSaleList(po);
	}

	public boolean addAllBill(AllBillPO po) {
//		financial= new FinancialDataService_Stub();
		return financial.addAllBill(po);
	}
	
	public boolean addAllBill(ReceiptPO po) {
//		financial= new FinancialDataService_Stub();
		AllBillPO po1=new AllBillPO(po);
		return financial.addAllBill(po1);
	}
	
	public boolean addAllBill(PaymentPO po) {
//		financial= new FinancialDataService_Stub();
		AllBillPO po1=new AllBillPO(po);
		return financial.addAllBill(po1);
	}

	public boolean addOperatingCondition(OperatingConditionPO po) {
//		financial= new FinancialDataService_Stub();
		return financial.addOperatingCondition(po);
	}
	
	public boolean addOperatingCondition(ReceiptPO po) {
//		financial= new FinancialDataService_Stub();
		OperatingConditionPO po1=new OperatingConditionPO(po.getTotal(),0,0,0);
		return financial.addOperatingCondition(po1);
	}
	
	public boolean addOperatingCondition(PaymentPO po) {
//		financial= new FinancialDataService_Stub();
		OperatingConditionPO po1=new OperatingConditionPO(0,0,po.getTotal(),0);
		return financial.addOperatingCondition(po1);
	}

}
