package vo;

import po.SystemlogPO;

public class SystemlogVO {
	
	public String time;
	public String operation;
	
	public SystemlogVO(SystemlogPO po){
		this.time=po.getTime();
		this.operation=po.getOperation();
	}
	
	public SystemlogVO(String time,String operation){
		this.time=time;
		this.operation=operation;
	}
	
}
