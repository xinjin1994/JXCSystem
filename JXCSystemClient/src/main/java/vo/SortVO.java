package vo;

import java.util.ArrayList;

public class SortVO {
	
	public String name;
	public String note;
	
	public String fatherSort;
	public ArrayList<CommodityVO> commodity=new ArrayList<CommodityVO>();
	ArrayList<SortVO> sortList=new ArrayList<SortVO>();
	
	public SortVO(String name){
		this.name=name;
		commodity = null;
	}
	
	
	public String getName(){
		return name;
	}
	
	public String getNote(){
		return note;
	}
	
	public void setNote(String note){
		this.note=note;
	}
	
	public boolean addSort(SortVO sonSort){
		sonSort.fatherSort=name;
		sortList.add(sonSort);
		return true;
	}
	
	public boolean addCommodity(CommodityVO sonCommodity){
		sonCommodity.fatherSort=name;
		commodity.add(sonCommodity);
		return true;
	}

}
