package businesslogicservice.initializationblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.UserVO;

public interface InitializationblService {
	
	//新建库存
	public int newSystem(ArrayList<CommodityVO> vo1,ArrayList<CustomerVO> vo2,
			ArrayList<AccountVO> vo3,ArrayList<UserVO> vo4);

//	//添加商品
//	public String addCommodity(String name, String type, int in_price,
//			int out_price);
//
//	//添加客户
//	public String addCustomer(String name, String phone,int level,int money );
//
//	//添加账户
//	public String addAccount(String name, int money);

	//显示期初信息
	public String showInformation();
}
