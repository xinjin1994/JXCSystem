package vo;

public class SortVO {
	
	public String name;
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
	}
	
	public String getName(){
		return name;
	}
	
//	public int getLevel(){
//		return level;
//	}

}
