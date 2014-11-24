package Test_rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.commoditydata.CommodityDataService_Stub;
import dataservice.commoditydataservice.CommodityDataService;

public class Test {
	
	public static void main(String[] args){
		
		CommodityDataService commoditydataservice;
		try {
			
			commoditydataservice = new CommodityDataService_Stub();
		
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://127.0.0.1:8888/CommodityDataService",commoditydataservice);
			
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
