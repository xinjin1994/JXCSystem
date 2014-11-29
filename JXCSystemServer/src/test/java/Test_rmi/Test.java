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
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/AccountDataService",accountdataservice);
			
			financialdataservice = new FinancialDataService_Stub();		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/FinancialDataService",financialdataservice);
			
			initializationdataservice = new InitializationDataService_Stub();		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/InitializationDataService",initializationdataservice);
			
			invoicedataservice = new InvoiceDataService_Stub(null, null, null);		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/InvoiceDataService",invoicedataservice);
			
			promotiondataservice = new PromotionDataService_Stub();		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/PromotionDataService",promotiondataservice);
			
			salesdataservice = new SalesDataService_Stub();		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/SalesDataService",salesdataservice);
			
			systemlogdataservice = new SystemlogDataService_Stub();		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/SystemlogDataService",systemlogdataservice);
			
			userdataservice = new UserDataService_Stub();		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/UserDataService",userdataservice);
			
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
