package po;

import java.io.Serializable;
import java.util.ArrayList;

public class SortPO implements Serializable{
	public String sort;
	public int level;
	public String note;
	
	ArrayList<CommodityPO> commodityList=new ArrayList<CommodityPO>();
	public ArrayList<SortPO> sortList;
	
	public boolean hasCommodity(){
		if(sortList!=null){
			return false;
		}
		return true;
	}
	
	public SortPO(String sort, int level) {
		this.sort = sort;
		this.level = level;
	}
	
	public SortPO copy(){
		return new SortPO(sort, level);
	}
	
	public String getName() {
		return sort;
	}

	public int getLevel() {
		return level;
	}
	
	public boolean addCommodity(CommodityPO po){
		int i=0;
		for(i=0;i<commodityList.size();i++){
			if(commodityList.get(i).getName().equals(po.getName())&&
					commodityList.get(i).getType().equals(po.getType())){
				commodityList.get(i).number=commodityList.get(i).number+po.number;
				return true;
			}
		}
		commodityList.add(po.copy());
		return true;
	}
	
	public boolean addSort(SortPO po){
		if(hasCommodity()){
			return false;
		}else{
			SortPO po1=findSort_true(po.getName());
			if(po1!=null){
				return false;
			}else {
				sortList.add(po);
				return true;
			}
		}
	}
	
	public boolean delSort(SortPO po){
		if(hasCommodity()){
			return false;
		}else{
			SortPO po1=findSort_true(po.getName());
			if(po1!=null){
				sortList.remove(po1);
				return true;
			}else {
				return false;
			}
		}
	}
	
	public SortPO findSort_true(String name){
		int i=0;
		if(hasCommodity()){
			return null;
		}else{
			for(i=0;i<sortList.size();i++){
				if(sortList.get(i).getName().equals(name)){
					return sortList.get(i);
				}
			}
		}
		return null;
	}
	
	public CommodityPO findCommodity_true(String name,String type){
		int i=0;
		if(hasCommodity()){
			for(i=0;i<commodityList.size();i++){
				if(commodityList.get(i).getName().equals(name)&&
						commodityList.get(i).getType().equals(type)){
					return commodityList.get(i);
				}
			}
		}else{
			for(i=0;i<sortList.size();i++){
				CommodityPO po2=sortList.get(i).findCommodity_true(name,type);
				if(po2!=null){
					return po2;
				}
			}
		}
		return null;
	}
	
	public boolean delCommodity(CommodityPO po){
		int i=0;
		if(hasCommodity()){
			for(i=0;i<commodityList.size();i++){
				if(commodityList.get(i).getName().equals(po.name)&&
						commodityList.get(i).getType().equals(po.type)){
					commodityList.remove(i);
					return true;
				}
			}
		}else{
			for(i=0;i<sortList.size();i++){
				if(sortList.get(i).delCommodity(po)){
					return true;
				}
			}
		}
		return false;
	}
	
	public String getNote(){
		return note;
	}
	
	

}
