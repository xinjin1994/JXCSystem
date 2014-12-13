package businesslogic.commoditybl;

import java.util.ArrayList;

import po.CommodityPO;
import po.SortPO;
import vo.CommodityVO;
import vo.SortVO;
import vo.StockVO;
import vo.WarnVO;
import vo.bill.PatchVO;
import businesslogicservice.commodityblservice.CommodityblService;

public class CommodityController implements CommodityblService{

	public Commodity commodity=new Commodity();
	
	public int addCommodity_up(CommodityVO vo1,SortVO vo2) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false,vo1.name,vo1.type,vo1.inValue,vo1.outValue,
				vo1.id,vo1.latestInValue,vo1.latestOutValue,vo1.num);
		SortPO sort=new SortPO(vo2.name);
		sort.note=vo2.note;
		return commodity.addCommodity(com,sort);
	}

	public int delCommodity_up(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodity.delCommodity(vo.name,vo.type);
	}

	public int updateCommodity_up(CommodityVO vo1,CommodityVO vo2) {
		// TODO Auto-generated method stub
		return commodity.updateCommodity(vo1.name, vo1.type, vo2.inValue, vo2.outValue);
	}

	public ArrayList<CommodityVO> searchFuzzyCommodity_up(String word) {
		// TODO Auto-generated method stub
		ArrayList<CommodityPO> po=commodity.searchCommodity(word);
		ArrayList<CommodityVO> vo=new ArrayList<CommodityVO>();
		CommodityVO com;
		int i=0;
		for(i=0;i<po.size();i++){
			com=new CommodityVO(po.get(i).getNote(), po.get(i).getName(), po.get(i).getType(), po.get(i).getNumber(), po.get(i).getIn_price(), po.get(i).getOut_price(), po.get(i).getRecent_in_price(), po.get(i).getRecent_out_price());
			com.fatherSort="father";
			vo.add(com);
		}
		
		return vo;
	}

	public int addSort_up(SortVO vo1,SortVO vo2) {
		// TODO Auto-generated method stub
		SortPO po1=new SortPO(vo1.name);
		po1.note=vo1.note;
		SortPO po2=new SortPO(vo2.name);
		po2.note=vo2.note;
		return commodity.addSort(po1,po2);
	}

	public int delSort_up(SortVO vo) {
		// TODO Auto-generated method stub
		return commodity.delSort(vo.name);
	}

	public int updateSort_up(SortVO vo1,SortVO vo2) {
		// TODO Auto-generated method stub
		return commodity.updateSort(vo1.name, vo2.name);
	}

	public ArrayList<CommodityVO> Examine_up(String time1, String time2) {
		// TODO Auto-generated method stub
		ArrayList<CommodityPO> po=commodity.Examine(time1, time2);
		ArrayList<CommodityVO> vo=new ArrayList<CommodityVO>();
		CommodityVO com;
		int i=0;
		for(i=0;i<po.size();i++){
			com=new CommodityVO(po.get(i).getNote(), po.get(i).getName(), po.get(i).getType(), po.get(i).getNumber(), po.get(i).getIn_price(), po.get(i).getOut_price(), po.get(i).getRecent_in_price(), po.get(i).getRecent_out_price());
			com.fatherSort="father";
			vo.add(com);
		}
		return vo;
	}

	public ArrayList<StockVO> Iventory_up() {
		// TODO Auto-generated method stub
//		return commodity.Iventory();
		return null;
	}

	public int addGift(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodity.addGift(vo.name,vo.type,vo.num);
	}

	public int delGift(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodity.delGift(vo.name,vo.type,vo.num);
	}

	public int patch_up(PatchVO vo) {
		// TODO Auto-generated method stub
		
		return commodity.patch(vo.name,vo.type,vo.number,vo.note);
	}

	public int warn_up(WarnVO vo) {
		// TODO Auto-generated method stub
		return commodity.warn(vo.name,vo.type,vo.number);
	}

//	public ArrayList<CommodityVO> searchAccurateCommodity_up(CommodityVO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public int updateCommodity_up(CommodityVO vo1, SortVO vo2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateSort_up_Inf(SortVO vo1, SortVO vo2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateSort_up_Mov(SortVO vo1, SortVO vo2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<SortVO> getAllSort_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CommodityVO> getAllCommodity_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public int patchDraft_up(PatchVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PatchVO> getAllDraftPatch_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public PatchVO searchDraftPatch_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPatchNote() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCommodityNote_up(SortVO vo1) {
		// TODO Auto-generated method stub
		return null;
	}

	public SortVO searchSort_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSortNote_up(SortVO vo1) {
		// TODO Auto-generated method stub
		return null;
	}

	public PatchVO searchPatch_up(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommodityVO searchAccurateCommodity_up(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SortVO> getComSort_up() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<SortVO> getSortSort_up() {
		// TODO Auto-generated method stub
		return null;
	}


}
