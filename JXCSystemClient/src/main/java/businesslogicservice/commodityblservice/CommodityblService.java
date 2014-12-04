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

	//添加商品
//	public int addCommodity(String name, String type, int in_price,
//			int out_price);
	
	//删除商品
	public int delCommodity_up(CommodityVO vo);
	
	//删除商品
	public int updateCommodity_up(CommodityVO vo1,CommodityVO vo2);

	//模糊查找商品
	public ArrayList<CommodityVO> searchFuzzyCommodity_up(String word);
	
	//精确查找商品
	public ArrayList<CommodityVO> searchAccurateCommodity_up(CommodityVO vo);

	//添加分类
	public int addSort(SortVO vo1, SortVO vo2);
	
	//删除分类
	public int delSort(SortVO vo);

	//修改分类
	public int updateSort(SortVO vo1, SortVO vo2);

	//查看库存
	public ArrayList<CommodityVO> Examine(String time1, String time2);

	//库存盘点
	public ArrayList<StockVO> Iventory();

	//库存赠送单
	public int addGift(CommodityVO vo);

	//删除库存赠送
	public int delGift(CommodityVO vo);

	//库存报溢报损单
	public int patch(PatchVO vo);

	//设置库存警戒数量
	public int warn(WarnVO vo);

}
