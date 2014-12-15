package vo;

import po.SystemlogPO;

public class SystemlogVO {
	
	public String time;
	public String operation;
	public String word;
	
	public SystemlogVO(String time,String operation,String word){
		this.time=time;
		this.operation=operation;
		this.word=word;
	}
	
}
