package po;

import java.io.Serializable;
import java.util.ArrayList;

public class SortPO implements Serializable{
	String sort;
	int level;
	
	ArrayList<CommodityPO> commodityList=new ArrayList<CommodityPO>();
	
	public SortPO(String sort, int level) {
		this.sort = sort;
		this.level = level;
	}
	
	public SortPO copy(){
		return new SortPO(sort, level);
	}
	
	public String getSort() {
		return sort;
	}

	public int getLevel() {
		return level;
	}

}
