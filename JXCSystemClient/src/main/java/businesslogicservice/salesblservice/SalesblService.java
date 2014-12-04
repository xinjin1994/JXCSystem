package businesslogicservice.salesblservice;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.CustomerVO;
import vo.ExportMenuVO;
import vo.ImportMenuVO;

public interface SalesblService {
	
	//添加客户
	public int addCustomer_up(CustomerVO customerVO);
	
	//删除客户
	public int delCustomer_up(CustomerVO customerVO);
	
	//修改客户
	public int updateCustomer_up(CustomerVO vo1,CustomerVO vo2);
	
	//模糊查找客户
	public ArrayList<CustomerVO> searchFuzzyCustomer_up(String word);
	//精确查找客户
	public CustomerVO searchExactCustomer_up(String name);
	
	//添加进货单
	public int addImport_up(ImportMenuVO importMenuVO);
	
	//添加进货退货单
	public int addImport_Return_up(ImportMenuVO importMenuVO);
	
	//添加销售单
	public int addExport_up(ExportMenuVO exportMenuVO);
	
	//添加销售退货单
	public int addExport_Return_up(ExportMenuVO exportMenuVO);
	
	//获得所有商品信息
	public ArrayList<CommodityVO> getAllCommodity_up(); 
	//获得单个商品信息
	public CommodityVO getCommodity_up(CommodityVO vo);
	
	//获得所有客户信息
	public ArrayList<CustomerVO> getAllCustomer_up();
	//获得单个客户信息
	public CustomerVO getCustomer_up(CustomerVO vo);
	
	//获得所有供货商信息
	public ArrayList<CustomerVO> getAllImportCustomer_up();
	//获得所有销售客户信息
	public ArrayList<CustomerVO> getAllExportCustomer_up();
	
	//获得操作员权限
	public int getClerk_up();
	
	//查看获得的折扣促销
	public int getDiscount_up(int money,int level);
	//查看获得的代金券促销
	public int getVoucher_up(int money,int level);
	//查看获得的赠品促销
	public CommodityVO getProGift_up(int money,int level);
	//查看当前其他促销策略
	public String getOtherPromotion_up();
	
}
