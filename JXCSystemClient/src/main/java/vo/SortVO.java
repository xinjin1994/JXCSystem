package vo;

import java.util.ArrayList;

public class SortVO {
	
	public String name;
<<<<<<< HEAD
	//public int level;
	public String fatherSort;
	public String id;
	
	public SortVO(String name,String fatherSort,String id){
		this.name=name;
		this.fatherSort = fatherSort;
	//	this.level=level;
		this.id = id;
	}
	
	public String getID(){
		return id;
=======
	
	SortVO fatherSort;
	ArrayList<CommodityVO> commodity=new ArrayList<CommodityVO>();
	ArrayList<SortVO> sortList=new ArrayList<SortVO>();
	
	public SortVO(String name){
		this.name=name;
>>>>>>> 3194f728791ad4884a6ad08b5012b214c97480c2
	}
	
	public String getName(){
		return name;
	}
	
<<<<<<< HEAD
//	public int getLevel(){
//		return level;
//	}
=======
	public boolean addSort(SortVO sonSort){
		sonSort.fatherSort=this;
		sortList.add(sonSort);
		return true;
	}
	
	public boolean addCommodity(CommodityVO sonCommodity){
		sonCommodity.fatherSort=this;
		commodity.add(sonCommodity);
		return true;
	}
>>>>>>> 3194f728791ad4884a6ad08b5012b214c97480c2

}
