package ui.setting;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.SortVO;
/**
 * 测试。。。
 * @author ZYC
 *
 */
public class Com {
	public ArrayList<SortVO> allSorts = new ArrayList<SortVO>();
//	public static void main(String[] args) {
//		setSort();
//		new MySortTree(allSorts);
//	}

	public Com() {
		setSort();
	}
	public  void setSort() {
		CommodityVO com1 = new CommodityVO("1", "2", "3", 12, 12, 12,12, 12, 0);
		CommodityVO com2 = new CommodityVO("2", "2", "3", 12, 12, 12,12, 12,0);
		CommodityVO com3 = new CommodityVO("3", "2", "3", 12, 12, 12,12, 12,0);
		ArrayList<CommodityVO> commodityVOs = new ArrayList<CommodityVO>();
		commodityVOs.add(com1);
		commodityVOs.add(com2);
		commodityVOs.add(com3);
		
		SortVO sort1 = new SortVO("11");
		sort1.setNote ("2-11");
		sort1.commodity = commodityVOs;
		
		SortVO sort2 = new SortVO("22");
		sort2.setNote ("2-22");
		sort2.commodity = null;
		
		SortVO sort3 = new SortVO("33");
		sort3.setNote ("2-22-00");
		sort3.commodity = null;
		
		SortVO sort4 = new SortVO("44");
		sort4.setNote ("2-00-99");
		sort4.commodity = commodityVOs;
		
		allSorts.add(sort1);
		allSorts.add(sort2);
		allSorts.add(sort3);
		allSorts.add(sort4);
	}
}
