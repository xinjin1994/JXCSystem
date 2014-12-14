package test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.CommodityPO;
import po.SortPO;
import dataservice.commoditydataservice.CommodityDataService;

public class Test {
	
	public static void main(String[] args){
		
		try {
			CommodityDataService commoditydata= (CommodityDataService) Naming.lookup("rmi://127.0.0.1:8888/CommodityDataService");
			
			CommodityPO po1=new CommodityPO("name", "type");
			SortPO po2=new SortPO("name");
			commoditydata.addGood(po1, po2);
			
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
		
		
	}

}
