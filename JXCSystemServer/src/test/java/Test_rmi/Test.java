package Test_rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.accountdata.AccountDataService_Stub;
import data.commoditydata.CommodityDataService_Stub;
import data.financialdata.FinancialDataService_Stub;
import data.initializationdata.InitializationDataService_Stub;
import data.invoicedata.InvoiceDataService_Stub;
import data.promotiondata.PromotionDataService_Stub;
import data.salesdata.SalesDataService_Stub;
import data.systemlogdata.SystemlogDataService_Stub;
import data.userdata.UserDataService_Stub;
import dataservice.accountdataservice.AccountDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.financialdataservice.FinancialDataService;
import dataservice.initializationdataservice.InitializationDataService;
import dataservice.invoicedataservice.InvoiceDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.salesdataservice.SalesDataService;
import dataservice.systemlogdataservice.SystemlogDataService;
import dataservice.userdataservice.UserDataService;

public class Test {
	
	public static void main(String[] args){
		
		CommodityDataService commoditydataservice;
		AccountDataService accountdataservice;
		FinancialDataService financialdataservice;
		InitializationDataService initializationdataservice;
		InvoiceDataService invoicedataservice;
		PromotionDataService promotiondataservice;
		SalesDataService salesdataservice;
		SystemlogDataService systemlogdataservice;
		UserDataService userdataservice;
		
		try {
			
			commoditydataservice = new CommodityDataService_Stub();		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/CommodityDataService",commoditydataservice);
			
			accountdataservice = new AccountDataService_Stub();		
			LocateRegistry.createRegistry(8889);
			Naming.bind("rmi://127.0.0.1:8889/AccountDataService",accountdataservice);
			
			financialdataservice = new FinancialDataService_Stub();		
			LocateRegistry.createRegistry(8890);
			Naming.bind("rmi://127.0.0.1:8890/FinancialDataService",financialdataservice);
			
			initializationdataservice = new InitializationDataService_Stub();		
			LocateRegistry.createRegistry(8891);
			Naming.bind("rmi://127.0.0.1:8891/InitializationDataService",initializationdataservice);
			
			invoicedataservice = new InvoiceDataService_Stub();		
			LocateRegistry.createRegistry(8892);
			Naming.bind("rmi://127.0.0.1:8892/InvoiceDataService",invoicedataservice);
			
			promotiondataservice = new PromotionDataService_Stub();		
			LocateRegistry.createRegistry(8893);
			Naming.bind("rmi://127.0.0.1:8893/PromotionDataService",promotiondataservice);
			
//			salesdataservice = new SalesDataService_Stub();		
//			LocateRegistry.createRegistry(8894);
//			Naming.bind("rmi://127.0.0.1:8894/SalesDataService",salesdataservice);
			
			systemlogdataservice = new SystemlogDataService_Stub();		
			LocateRegistry.createRegistry(8895);
			Naming.bind("rmi://127.0.0.1:8895/SystemlogDataService",systemlogdataservice);
			
			userdataservice = new UserDataService_Stub();		
			LocateRegistry.createRegistry(8896);
			Naming.bind("rmi://127.0.0.1:8896/UserDataService",userdataservice);
			
			System.out.println("Service Start!");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
