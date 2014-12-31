package businesslogic.commoditybl;

import java.util.ArrayList;

import main.ClientStart;
import po.CommodityPO;
import po.PatchPO;
import po.SortPO;
import vo.CommodityVO;
import vo.ExamineVO;
import vo.SortVO;
import vo.StockVO;
import vo.WarnVO;
import vo.bill.PatchVO;
import businesslogic.userbl.User;
import businesslogicservice.commodityblservice.CommodityblService;

public class CommodityController implements CommodityblService{

	public Commodity commodity=new Commodity();
	
	public CommodityController(){
		commodity=ClientStart.commodity;
	}
	
	public int addCommodity_up(CommodityVO vo1,SortVO vo2) {
		// TODO Auto-generated method stub
		CommodityPO com=new CommodityPO(false,vo1.name,vo1.type,vo1.inValue,vo1.outValue,
				vo1.id,vo1.latestInValue,vo1.latestOutValue,vo1.num);
		com.warn=vo1.warn;
		SortPO sort=new SortPO(vo2.name);
		return commodity.addCommodity(com,sort);
	}

	public int delCommodity_up(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodity.delCommodity(vo.name,vo.type);
	}

	public int updateCommodity_up(CommodityVO vo1,CommodityVO vo2) {
		// TODO Auto-generated method stub
		CommodityPO po1=new CommodityPO(vo1.name,vo1.type);
		CommodityPO po2=new CommodityPO(false, vo1.name,vo1.type,vo2.inValue,vo2.outValue, null, 0, 0, 0);
		po2.warn=vo2.warn;
		return commodity.updateCommodity(po1, po2);
	}

	public ArrayList<CommodityVO> searchFuzzyCommodity_up(String word) {
		// TODO Auto-generated method stub
		ArrayList<CommodityPO> po=commodity.searchCommodity(word);
		ArrayList<CommodityVO> vo=new ArrayList<CommodityVO>();
		CommodityVO com;
		int i=0;
		for(i=0;i<po.size();i++){
			com=new CommodityVO(po.get(i).getNote(), po.get(i).getName(), po.get(i).getType(), po.get(i).getNumber(), po.get(i).getIn_price(), po.get(i).getOut_price(), po.get(i).getRecent_in_price(), po.get(i).getRecent_out_price(),po.get(i).warn);
			com.fatherSort=po.get(i).father;
			vo.add(com);
		}
		return vo;
	}

	public int addSort_up(SortVO vo1,SortVO vo2) {
		// TODO Auto-generated method stub
		SortPO po1=new SortPO(vo1.name);
		po1.note=vo1.note;
		if(vo2==null){
			return commodity.addSort(po1, null);
		}
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

	public ArrayList<ExamineVO> Examine_up(String time1, String time2) {
		// TODO Auto-generated method stub
		ArrayList<ExamineVO> vo=commodity.Examine(time1, time2);
//		ExamineVO lin;
		int i=0;
		for(i=0;i<vo.size();i++){
			for(int j=1;j<vo.size();j++){
				if(vo.get(j).time.compareTo(vo.get(j-1).time)<0){
//					lin=vo.get(j);
//					vo.set(j, vo.get(j-1));
//					vo.set(j-1, lin);
				}	
			}
		}
		
		return vo;
	}

	public ArrayList<StockVO> Iventory_up() {
		// TODO Auto-generated method stub
		//无用方法o(╯□╰)o
		return commodity.Iventory();
	}

	public int addGift(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodity.addGift(vo.name,vo.type,vo.num);
	}

	public int delGift(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodity.delGift(vo.name,vo.type);
	}

	public int patch_up(PatchVO vo) {
		// TODO Auto-generated method stub
		System.out.println("kanxianote:"+vo.note);
		int res=commodity.patch(vo.name,vo.type,vo.number,vo.note);
		System.out.println("Patch:"+res);
		return res;
	}

	public int warn_up(WarnVO vo) {
		// TODO Auto-generated method stub
		return commodity.warn(vo.name,vo.type,vo.number);
	}
	
	public ArrayList<CommodityVO> getAllWarnGood_up(){
		ArrayList<CommodityPO> po=commodity.getAllWarnGood();
		ArrayList<CommodityVO> array=new ArrayList<CommodityVO>();
		CommodityVO vo=null;
		for(int i=0;i<po.size();i++){
			vo=new CommodityVO(po.get(i).getNote(), po.get(i).getName(), po.get(i).getType(), po.get(i).getNumber(), po.get(i).getIn_price(), po.get(i).getOut_price(), po.get(i).getRecent_in_price(), po.get(i).getRecent_out_price(),po.get(i).warn);
			vo.fatherSort=po.get(i).father;
			array.add(vo);
		}
		return array;
	}

//	public ArrayList<CommodityVO> searchAccurateCommodity_up(CommodityVO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public int updateCommodity_up(CommodityVO vo1, SortVO vo2) {
		// TODO Auto-generated method stub
		CommodityPO po1=new CommodityPO(vo1.name,vo1.type);
		SortPO po2=new SortPO(vo2.name);
		return commodity.updateCommodity(po1,po2);
	}

	public int updateSort_up_Inf(SortVO vo1, SortVO vo2) {
		// TODO Auto-generated method stub
		return commodity.updateSort(vo1.getName(),vo2.getName());
	}

	public int updateSort_up_Mov(SortVO vo1, SortVO vo2) {
		// TODO Auto-generated method stub
		SortPO po1=new SortPO(vo1.name);
		SortPO po2=null;
		if(vo2!=null){
			po2=new SortPO(vo2.name);
		}else{
			po2=null;
		}
		return commodity.updateSort_Mov(po1, po2);
	}

	public ArrayList<SortVO> getAllSort_up() {
		// TODO Auto-generated method stub
		ArrayList<SortPO> sort=commodity.getAllSort();
		ArrayList<SortVO> array=new ArrayList<SortVO>();
		SortVO vo=null;
		for(int i=0;i<sort.size();i++){
			array.add(getMulSort(sort.get(i)));
		}
		return array;
	}
	
	public SortVO getMulSort(SortPO po){
		SortVO vo=new SortVO(po.getName());
		vo.fatherSort=po.father;
		vo.note=po.getNote();
		int i=0;
		
		if(po.commodityList!=null){
			for(i=0;i<po.commodityList.size();i++){
				CommodityVO com=new CommodityVO(po.commodityList.get(i).getNote(), po.commodityList.get(i).getName(), po.commodityList.get(i).getType(), po.commodityList.get(i).getNumber(), po.commodityList.get(i).getIn_price(), po.commodityList.get(i).getOut_price(),
						po.commodityList.get(i).getRecent_in_price(), po.commodityList.get(i).getRecent_out_price(),po.commodityList.get(i).warn);
				com.fatherSort=po.commodityList.get(i).father;
				vo.commodity.add(com);
			}
		}
		
//		for(i=0;i<po.sortList.size();i++){
//			SortVO so=getMulSort(po.sortList.get(i));
//			vo.sortList.add(so);
//		}
		return vo;
	}

	public ArrayList<CommodityVO> getAllCommodity_up() {
		// TODO Auto-generated method stub
		ArrayList<CommodityPO> po=commodity.getAllCommodity();
		ArrayList<CommodityVO> array=new ArrayList<CommodityVO>();
		CommodityVO vo=null;
		for(int i=0;i<po.size();i++){
			vo=new CommodityVO(po.get(i).getNote(), po.get(i).getName(), po.get(i).getType(), po.get(i).getNumber(), po.get(i).getIn_price(), po.get(i).getOut_price(), po.get(i).getRecent_in_price(), po.get(i).getRecent_out_price(),po.get(i).warn);
			vo.fatherSort=po.get(i).father;
			array.add(vo);
		}
		return array;
	}

	public int patchDraft_up(PatchVO vo) {
		// TODO Auto-generated method stub
		CommodityPO com=commodity.findCommodity(vo.name,vo.type);
		PatchPO po=new PatchPO(com, vo.number, User.operator);
		po.setNote(vo.note);
		po.setCondition(0);
		return commodity.patchDraft(po);
	}
	
	public ArrayList<PatchVO> getAllPatch_up() {
		// TODO Auto-generated method stub
		ArrayList<PatchPO> po=commodity.getAllPatch();
		ArrayList<PatchVO> array=new ArrayList<PatchVO>();
		PatchVO vo=null;
		for(int i=0;i<po.size();i++){
			vo=new PatchVO(po.get(i).getCommodity().getName(),po.get(i).getCommodity().getType(),po.get(i).getNumber(),po.get(i).getNote(),po.get(i).getTime(),po.get(i).getOperator(),po.get(i).getInvoiceNote());
			array.add(vo);
		}
		return array;
	}

	public ArrayList<PatchVO> getAllDraftPatch_up() {
		// TODO Auto-generated method stub
		ArrayList<PatchPO> po=commodity.getAllDraftPatch();
		ArrayList<PatchVO> array=new ArrayList<PatchVO>();
		PatchVO vo=null;
		for(int i=0;i<po.size();i++){
			vo=new PatchVO(po.get(i).getCommodity().getName(),po.get(i).getCommodity().getType(),po.get(i).getNumber(),po.get(i).getNote(),po.get(i).getTime(),po.get(i).getOperator(),po.get(i).getInvoiceNote());
			array.add(vo);
		}
		return array;
	}

	public PatchVO searchDraftPatch_up(String note) {
		// TODO Auto-generated method stub
		PatchPO po=commodity.searchDraftPatch(note);
		if(po==null){
			return null;
		}
		PatchVO vo=new PatchVO(po.getCommodity().getName(),po.getCommodity().getType(),po.getNumber(),po.getNote(),po.getTime(),po.getOperator(),po.getInvoiceNote());
		return vo;
	}

	public String getPatchNote() {
		// TODO Auto-generated method stub
		return commodity.getPatchNote();
	}

	public String getCommodityNote_up(SortVO vo1) {
		// TODO Auto-generated method stub
		SortPO po1=new SortPO(vo1.getName());
		return commodity.getCommodityNote(po1);
	}

	public SortVO searchSort_up(String name) {
		// TODO Auto-generated method stub
		SortPO po=commodity.findSort(name);
		if(po==null){
			return null;
		}
		SortVO vo=new SortVO(po.getName());
		vo.fatherSort=po.father;
		vo.note=po.note;
		return vo;
	}

	public String getSortNote_up(SortVO vo1) {
		// TODO Auto-generated method stub
		SortPO po1=new SortPO(vo1.getName());
		return commodity.getSortNote(po1);
	}

	public PatchVO searchPatch_up(String note) {
		// TODO Auto-generated method stub
		PatchPO po=commodity.searchPatch(note);
		if(po==null){
			return null;
		}
		PatchVO vo=new PatchVO(po.getCommodity().getName(),po.getCommodity().getType(),po.getNumber(),po.getNote(),po.getTime(),po.getOperator(),po.getInvoiceNote());
		return vo;
	}

	public CommodityVO searchAccurateCommodity_up(String name,String type) {
		// TODO Auto-generated method stub
		CommodityPO po=commodity.findCommodity(name, type);

		if(po==null){
			return null;
		}
		CommodityVO vo=new CommodityVO(po.getNote(), po.getName(), po.getType(), po.getNumber(), po.getIn_price(), po.getOut_price(), po.getRecent_in_price(), po.getRecent_out_price(),po.warn);
		vo.fatherSort=po.father;
		return vo;
	}

	public ArrayList<SortVO> getComSort_up() {
		// TODO Auto-generated method stub
		ArrayList<SortVO> array=new ArrayList<SortVO>();
		ArrayList<SortPO> po=commodity.getComSort();
		SortVO so;
		for(int i=0;i<po.size();i++){
			so=new SortVO(po.get(i).getName());
			so.fatherSort=po.get(i).father;
			so.note=po.get(i).getNote();
			array.add(so);
		}
		return array;
	}

	public ArrayList<SortVO> getSortSort_up() {
		// TODO Auto-generated method stub
		ArrayList<SortVO> array=new ArrayList<SortVO>();
		ArrayList<SortPO> po=commodity.getSortSort();
		SortVO so;
		for(int i=0;i<po.size();i++){
			so=new SortVO(po.get(i).getName());
			so.fatherSort=po.get(i).father;
			so.note=po.get(i).getNote();
			array.add(so);
		}
		return array;
	}


}
