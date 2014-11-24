package po;

import java.io.Serializable;

public class SortPO implements Serializable{
	String sort;
	int level;
	
	public SortPO(String sort, int level) {
		this.sort = sort;
		this.level = level;
	}
	
	public String getSort() {
		return sort;
	}

	public int getLevel() {
		return level;
	}

}
