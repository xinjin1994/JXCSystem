package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DiscountPO;
import po.ProGiftPO;
import po.VoucherPO;

public interface PromotionDataService extends Remote {
	public boolean addDiscount(DiscountPO po) throws RemoteException;
	public boolean addGift(ProGiftPO po) throws RemoteException;
	public boolean addVoucher(VoucherPO po) throws RemoteException;
//	public boolean addOther(String pro) throws RemoteException;
	public boolean delDiscount(int level) throws RemoteException;
	public boolean delGift(int level) throws RemoteException;
	public boolean delVoucher(int level) throws RemoteException;
//	public boolean delOther(String pro);
	public DiscountPO getDiscount(int level) throws RemoteException;
	public ProGiftPO getGift(int level) throws RemoteException;
	public VoucherPO getVoucher(int level) throws RemoteException;
	public ArrayList<DiscountPO> showDiscount() throws RemoteException;
	public ArrayList<ProGiftPO> showProGift() throws RemoteException;
	public ArrayList<VoucherPO> showVoucher() throws RemoteException;
	public boolean clear() throws RemoteException;
}
	
