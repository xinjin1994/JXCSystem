package po;

import java.io.Serializable;
import java.util.ArrayList;

public class SortPO implements Serializable{
	String sort;
	int level;
	
	ArrayList<CommodityPO> commodityList=new ArrayList<CommodityPO>();
	ArrayList<SortPO> sortList;
	
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
	
	

}
