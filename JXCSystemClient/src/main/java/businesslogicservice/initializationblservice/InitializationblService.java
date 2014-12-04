package businesslogicservice.initializationblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.SortVO;
import vo.UserVO;


//在删除期初信息时，进行简单的判断是否能删除或添加，
public interface InitializationblService {
	
	//新建库存
	public int newSystem_up(ArrayList<CommodityVO> vo1,ArrayList<SortVO> vo2,ArrayList<CustomerVO> vo3,
			ArrayList<AccountVO> vo4,ArrayList<UserVO> vo5);

//	//添加商品
//	public String addCommodity(String name, String type, int in_price,
//			int out_price);
//
//	//添加客户
//	public String addCustomer(String name, String phone,int level,int money );
//
//	//添加账户
//	public String addAccount(String name, int money);
	
	//获得之前的商品信息
	public ArrayList<CommodityVO> getOldCommodity_up();
	
	//获得之前的分类信息
	public ArrayList<SortVO> getOldSort_up();
	
	//获得之前的客户信息
	public ArrayList<CustomerVO> getOldCustomer_up();
	
	//获得之前的账户信息
	public ArrayList<AccountVO> getOldAccount_up();
	
	//获得之前的用户信息
	public ArrayList<UserVO> getOldUser_up();

	//显示期初信息
	public String showInformation_up();
	
}
