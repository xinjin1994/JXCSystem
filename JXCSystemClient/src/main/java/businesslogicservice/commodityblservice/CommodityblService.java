package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.PatchVO;
import vo.SortVO;
import vo.StockVO;
import vo.WarnVO;

//int错误类型：
//-1 未知错误
//1  商品已存在
//2  商品不存在
//3  分类已存在
//4  分类不存在
//5  分类中存在商品，不能删除
//6  商品数量不足，不能添加为赠品
//7  赠品数量不足，不能删除
//8  商品数量不能为负


public interface CommodityblService {

	//添加商品
	public int addCommodity_up(CommodityVO vo1,SortVO vo2);
	
	//删除商品
	public int delCommodity_up(CommodityVO vo);
	
	//更新商品信息
	public int updateCommodity_up(CommodityVO vo1,CommodityVO vo2);
	//将商品移至其他分类中
	public int updateCommodity_up(CommodityVO vo1,SortVO vo2);
	
	//获得商品分配的编号
	public String getCommodityNote_up(SortVO vo1);

	//模糊查找商品
	public ArrayList<CommodityVO> searchFuzzyCommodity_up(String word);
	//精确查找商品
	public ArrayList<CommodityVO> searchAccurateCommodity_up(CommodityVO vo);

	//添加分类
	public int addSort_up(SortVO vo1, SortVO vo2);
	
	//删除分类
	public int delSort_up(SortVO vo);

	//修改分类信息
	public int updateSort_up_Inf(SortVO vo1, SortVO vo2);
	//将分类移至另一分类下
	public int updateSort_up_Mov(SortVO vo1,SortVO vo2);
	//根据编号查找Sort
	public SortVO searchSort_up(String note);

	//获得分配的分类编号，vo2==null代表根分类
	public String getSortNote_up(SortVO vo1);
	
	//查看库存，注意库存数量要有合计，就在数据层用个for算一下吧o(╯□╰)o
	public ArrayList<CommodityVO> Examine_up(String time1, String time2);

	//库存盘点，目前已经在计划中，但还没有实现o(╯□╰)o
	public ArrayList<StockVO> Iventory_up();

//	//库存赠送单
//	public int addGift(CommodityVO vo);
//
//	//删除库存赠送
//	public int delGift(CommodityVO vo);

	//库存报溢报损单
	public int patch_up(PatchVO vo);
	//添加草稿报溢报损单
	public int patchDraft_up(PatchVO vo);
	//获得所有的草稿报溢报损单
	public ArrayList<PatchVO> getAllDraftPatch_up();
	//获得报溢报损单编号
	public String getPatchNote();
	//根据编号查找草稿报溢报损单
	public PatchVO searchDraftPatch_up(String note);
	//根据编号查找报溢报损单
	public PatchVO searchPatch_up(String note);
	
	
	//设置库存警戒数量，无须审批
	public int warn_up(WarnVO vo);
	
	//获得所有分类信息，用于添加与更新商品或分类时分类的选择
	public ArrayList<SortVO> getAllSort_up();
	
	//获得所有商品，用于报溢报损报警单中商品的选择
	public ArrayList<CommodityVO> getAllCommodity_up();
}
