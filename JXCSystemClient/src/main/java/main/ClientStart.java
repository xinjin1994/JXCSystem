package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
import dataservice.accountdataservice.AccountDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.financialdataservice.FinancialDataService;
import dataservice.initializationdataservice.InitializationDataService;
import dataservice.invoicedataservice.InvoiceDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.salesdataservice.SalesDataService;
import dataservice.systemlogdataservice.SystemlogDataService;
import dataservice.userdataservice.UserDataService;

public class ClientStart {
	
	public static Commodity commodity;
	public static Account account;
	public static Financial financial;
	public static Initialization initialization;
	public static Invoice invoice;
	public static Promotion promotion;
	public static Sales sales;
	public static Systemlog systemlog;
	public static User user;
	
	
	public void start(){
//		CommodityController commodityController=new CommodityController();
		commodity=new Commodity();
		
//		AccountController accountController=new AccountController();
		account=new Account();
		
//		FinancialController financialController=new FinancialController();
		financial=new Financial();
		
//		InitializationController initializationController=new InitializationController();
		initialization=new Initialization();
		
//		InvoiceController invoiceController=new InvoiceController();
		invoice=new Invoice();
		
//		PromotionController promotionController=new PromotionController();
		promotion=new Promotion();
		
//		SalesController salesController=new SalesController();
		sales=new Sales();
		
//		SystemlogController systemlogController=new SystemlogController();
		systemlog=new Systemlog();
		
//		UserController userController=new UserController();
		user=new User();
		
		try {
			
			commodity.sto=(CommodityDataService) Naming.lookup("rmi://127.0.0.1:8888/CommodityDataService");
			account.account=(AccountDataService) Naming.lookup("rmi://127.0.0.1:8889/AccountDataService");
			financial.financial=(FinancialDataService) Naming.lookup("rmi://127.0.0.1:8890/FinancialDataService");
			initialization.initialization=(InitializationDataService) Naming.lookup("rmi://127.0.0.1:8891/InitializationDataService");
			invoice.invoice=(InvoiceDataService) Naming.lookup("rmi://127.0.0.1:8892/InvoiceDataService");
			promotion.promotion=(PromotionDataService) Naming.lookup("rmi://127.0.0.1:8893/PromotionDataService");
			sales.sale=(SalesDataService) Naming.lookup("rmi://127.0.0.1:8894/SalesDataService");
			systemlog.sys=(SystemlogDataService) Naming.lookup("rmi://127.0.0.1:8895/SystemlogDataService");
			user.us=(UserDataService) Naming.lookup("rmi://127.0.0.1:8896/UserDataService");

			commodity.setInfo(invoice, systemlog,sales);
			account.setInfo(financial, invoice, sales, systemlog);
			financial.setInfo(account, commodity, sales, systemlog);
			invoice.setInfo(account, sales, commodity);
			promotion.setInfo(systemlog, commodity);
			user.setInfo(systemlog);
			sales.setInfo(invoice, systemlog, commodity);
			
//			commodityController.commodity.sto=commodityRMI;
//			accountController.account.account=accountRMI;
//			financialController.financial.financial=financialRMI;
//			initializationController.initialization.initialization=initializationRMI;
//			invoiceController.invoice.invoice=invoiceRMI;
//			promotionController.promotion.promotion=promotionRMI;
//			salesController.sale.sale=salesRMI;
//			systemlogController.systemlog.sys=systemlogRMI;
//			userController.user.us=userRMI;

			
//			System.out.println("Hello");
//			for(int i=0;i<1000;i++){
//
//				commodityController.commodity.getSortSort();
//			}
//			System.out.println("1");
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
