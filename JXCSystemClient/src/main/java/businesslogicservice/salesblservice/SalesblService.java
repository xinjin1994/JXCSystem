package businesslogicservice.salesblservice;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.CustomerVO;
import vo.bill.ExportMenuVO;
import vo.bill.ImportMenuVO;

public interface SalesblService {

	// 添加客户
	public int addCustomer_up(CustomerVO customerVO);

	// 删除客户
	public int delCustomer_up(CustomerVO customerVO);

	// 修改客户
	public int updateCustomer_up(CustomerVO vo1, CustomerVO vo2);

	// 获得分配的客户编号
	public String getCustomerNote_up();

	// 模糊查找客户
	public ArrayList<CustomerVO> searchFuzzyCustomer_up(String word);

	// 精确查找客户
	public CustomerVO searchExactCustomer_up(String name);

	// 添加进货单
	public int addImport_up(ImportMenuVO importMenuVO);

	// 添加草稿进货单
	public int addDraftImport_up(ImportMenuVO impoerMenuVO);

	// 获得所有的草稿进货单
	public ArrayList<ImportMenuVO> getAllDraftImport_up();

	// 根据编号查找草稿进货单
	public ImportMenuVO searchDraftImport_up(String note);

	// 添加进货退货单
	public int addImport_Return_up(ImportMenuVO importMenuVO);

	// 添加草稿进货退货单
	public int addDraftImport_Return_up(ImportMenuVO importMenuVO);

	// 获得所有的草稿进货退货单
	public ArrayList<ImportMenuVO> getAllDraftImport_Return_up();

	// 根据编号查找草稿进货退货单
	public ImportMenuVO searchDraftImport_Return_up(String note);

	// 添加销售单
	public int addExport_up(ExportMenuVO exportMenuVO);

	// 添加草稿销售单
	public int addDraftExport_up(ExportMenuVO exportMenuVO);

	// 获得所有的草稿销售单
	public ArrayList<ExportMenuVO> getAllDraftExport_up();

	// 添加销售退货单
	public int addExport_Return_up(ExportMenuVO exportMenuVO);

	// 添加草稿销售退货单
	public int addDraftExport_Return_up(ExportMenuVO exportMenuVO);

	// 获得所有的草稿销售退货单
	public ArrayList<ExportMenuVO> getAllDraftExport_Return_up();

	// 根据编号查找草稿销售退货单
	public ExportMenuVO searchDraftExport_Return_up(String note);

	// 获得进货单编号
	public String getImportNote_up();

	// 获得进货退货单编号
	public String getImport_ReturnNote_up();

	// 获得销售单编号
	public String getExportNote_up();

	// 获得销售退货单编号
	public String getExport_ReturnNote_up();

	// 根据编号查找进货单
	public ImportMenuVO searchImportNote_up(String note);

	// 根据编号查找销售单
	public ExportMenuVO searchExportNote_up(String note);

	// 根据编号查找进货退货单
	public ImportMenuVO searchImport_ReturnNote_up(String note);
	
	// 根据编号查找销售退货单
	public ExportMenuVO searchExport_ReturnNote_up(String note);
	
	// 获得所有客户信息
	public ArrayList<CustomerVO> getAllCustomer_up();

	// 获得单个客户信息
	public CustomerVO getCustomer_up(CustomerVO vo);

	// 获得所有供货商信息
	public ArrayList<CustomerVO> getAllImportCustomer_up();

	// 获得所有销售客户信息
	public ArrayList<CustomerVO> getAllExportCustomer_up();

	// 根据进货编号查找进货可退货最大数量,输入进货时的编号，返回最大可退货数量
	public int getImport_ReturnMaxNumber_up(String old_note);

	// 根据销售编号查找销售可退货最大数量，输入进货时的编号，返回最大可退货数量
	public int getExport_ReturnMaxNumber_up(String old_note);

	// 获得所有商品信息
	public ArrayList<CommodityVO> getAllCommodity_up();

	// 获得单个商品信息
	public CommodityVO getCommodity_up(String name, String type);

//	// 获得操作员权限
//	public int getClerk_up();

	// 获得操作员能修改的最大折扣，注意这里的折扣不包括促销产生的折扣
	public int getClerkDiscount_up();

	// 查看获得的折扣促销
	public int getDiscount_up(int money, int level);

	// 查看获得的代金券促销
	public int getVoucher_up(int money, int level);

	// 查看获得的赠品促销
	public CommodityVO getProGift_up(int money, int level);

	// 查看当前其他促销策略
	public String getOtherPromotion_up();

	// 根据编号查找草稿销售单
	public ExportMenuVO searchDraftExport_up(String note);

}
