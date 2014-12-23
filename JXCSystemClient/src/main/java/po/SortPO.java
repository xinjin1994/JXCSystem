package po;

import java.io.Serializable;
import java.util.ArrayList;

public class SortPO implements Serializable{
	public String name;
	public String note;
	
	public String father;
	
	public ArrayList<CommodityPO> commodityList=new ArrayList<CommodityPO>();
	public ArrayList<SortPO> sortList=new ArrayList<SortPO>();
	
	public boolean hasSort(){
		if(sortList!=null&&sortList.size()>0){
			return true;
		}
		return false;
	}
	
	public boolean hasCommodity(){
		if(commodityList!=null&&commodityList.size()>0){
			return true;
		}
		return false;
	}
	
	public SortPO(String sort) {
		this.name = sort;
	}
	
	public SortPO copy(){
		SortPO po=new SortPO(name);
		po.note=note;
		po.father=father;
		ArrayList<CommodityPO> array;
		if(commodityList!=null){
			array=new ArrayList<CommodityPO>();
			for(int i=0;i<commodityList.size();i++){
				array.add(commodityList.get(i).copy());
			}
			po.commodityList=array;
		}
		ArrayList<SortPO> array2;
		if(sortList!=null){
			array2=new ArrayList<SortPO>();
			for(int i=0;i<sortList.size();i++){
				array2.add(sortList.get(i).copy());
			}
			po.sortList=array2;
		}
		return po;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addCommodity(CommodityPO po){
		int i=0;
		
		if(hasSort()){
			return false;
		}
		
		for(i=0;i<commodityList.size();i++){
			if(commodityList.get(i).getName().equals(po.getName())&&
					commodityList.get(i).getType().equals(po.getType())){
				return false;
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
			if(po1!=null&&!(po1.hasCommodity()||po1.hasSort())){
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
	
	public SortPO findSort_In(String name){
		int i=0;
		
		if(this.name.equals(name)){
			return this;
		}
		
		if(hasCommodity()){
			return null;
		}
		if(hasSort()){
			for(i=0;i<sortList.size();i++){
				SortPO lin=sortList.get(i).findSort_In(name);
				if(lin!=null){
					return lin;
				}
//				if(sortList.get(i).getName().equals(name)){
//					return sortList.get(i);
//				}else{
//					if(sortList.get(i).findSort_true(name)!=null){
//						return sortList.get(i).findSort_true(name);
//					}
//				}
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
		}
//		if(hasSort()){
//			for(i=0;i<sortList.size();i++){
//				if(sortList.get(i).delCommodity(po)){
//					return true;
//				}
//			}
//		}
		return false;
	}
	
	public String getNote(){
		return note;
	}
	
	public ArrayList<CommodityPO> getAllCommodity(){
		ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
		int i=0;
		for(i=0;i<commodityList.size();i++){
			array.add(commodityList.get(i).copy());
		}
		for(i=0;i<sortList.size();i++){
			ArrayList<CommodityPO> lin=sortList.get(i).getAllCommodity();
			for(int j=0;j<lin.size();j++){
				array.add(lin.get(j).copy());
			}
		}
		return array;
	}
	

}
