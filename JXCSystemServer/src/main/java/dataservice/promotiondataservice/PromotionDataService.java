package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DiscountPO;
import po.ProGiftPO;

public interface PromotionDataService extends Remote{
	public boolean addDiscount(DiscountPO po) throws RemoteException;
	public boolean addGift(ProGiftPO po) throws RemoteException;
	public boolean delDiscount(DiscountPO po) throws RemoteException;
	public boolean delGift(ProGiftPO po) throws RemoteException;
	public DiscountPO getDiscount() throws RemoteException;
	public ProGiftPO getGift() throws RemoteException;
	public ArrayList<DiscountPO> showDiscount() throws RemoteException;
	public ArrayList<ProGiftPO> showProGift() throws RemoteException;
}
	
