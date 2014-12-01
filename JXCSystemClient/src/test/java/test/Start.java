package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.financialdataservice.FinancialDataService;
import dataservice.initializationdataservice.InitializationDataService;
import dataservice.invoicedataservice.InvoiceDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.salesdataservice.SalesDataService;
import dataservice.systemlogdataservice.SystemlogDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.accountdataservice.AccountDataService;
import businesslogic.accountbl.Account;
import businesslogic.accountbl.AccountController;
import businesslogic.commoditybl.Commodity;
import businesslogic.commoditybl.CommodityController;
import businesslogic.financialbl.Financial;
import businesslogic.financialbl.FinancialController;
import businesslogic.initializationlbl.Initialization;
import businesslogic.initializationlbl.InitializationController;
import businesslogic.invoicebl.Invoice;
import businesslogic.invoicebl.InvoiceController;
import businesslogic.promotionbl.Promotion;
import businesslogic.promotionbl.PromotionController;
import businesslogic.salesbl.Sales;
import businesslogic.salesbl.SalesController;
import businesslogic.systemlogbl.Systemlog;
import businesslogic.systemlogbl.SystemlogController;
import businesslogic.userbl.User;
import businesslogic.userbl.UserController;

public class Start {
	
	
	public static void main(String[] args){
		
		CommodityController commodityController=new CommodityController();
		commodityController.commodity=new Commodity();
		
		AccountController accountController=new AccountController();
		accountController.account=new Account();
		
		FinancialController financialController=new FinancialController();
		financialController.financial=new Financial();
		
		InitializationController initializationController=new InitializationController();
		initializationController.initialization=new Initialization();
		
		InvoiceController invoiceController=new InvoiceController();
		invoiceController.invoice=new Invoice();
		
		PromotionController promotionController=new PromotionController();
		promotionController.promotion=new Promotion();
		
		SalesController salesController=new SalesController();
		salesController.sale=new Sales();
		
		SystemlogController systemlogController=new SystemlogController();
		systemlogController.systemlog=new Systemlog();
		
		UserController userController=new UserController();
		userController.user=new User();
		
		try {
			
			commodityController.commodity.sto=(CommodityDataService) Naming.lookup("rmi://127.0.0.1:8888/CommodityDataService");
			accountController.account.account=(AccountDataService) Naming.lookup("rmi://127.0.0.1:8888/AccountDataService");
			financialController.financial.financial=(FinancialDataService) Naming.lookup("rmi://127.0.0.1:8888/FinancialDataService");
			initializationController.initialization.initialization=(InitializationDataService) Naming.lookup("rmi://127.0.0.1:8888/InitializationDataService");
			invoiceController.invoice.invoice=(InvoiceDataService) Naming.lookup("rmi://127.0.0.1:8888/InvoiceDataService");
			promotionController.promotion.promotion=(PromotionDataService) Naming.lookup("rmi://127.0.0.1:8888/PromotionDataService");
			salesController.sale.sale=(SalesDataService) Naming.lookup("rmi://127.0.0.1:8888/SalesDataService");
			systemlogController.systemlog.sys=(SystemlogDataService) Naming.lookup("rmi://127.0.0.1:8888/SystemlogDataService");
			userController.user.us=(UserDataService) Naming.lookup("rmi://127.0.0.1:8888/UserDataService");
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		commodityController.addCommodity("name", "type",1,2);
	
	}

}
