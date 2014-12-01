package vo;

public class SortVO {
	
	public String name;
	public int level;
	
	public SortVO(String name,int level){
		this.name=name;
		this.level=level;
	}
	
	public String getName(){
		return name;
	}
	
	public int getLevel(){
		return level;
	}

}
