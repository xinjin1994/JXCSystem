package po;

import java.io.Serializable;

public class SystemlogPO implements Serializable{

	String operation;//²Ù×÷
	String time;//Ê±¼ä
	
	public SystemlogPO(String operation, String time) {
		this.operation = operation;
		this.time = time;
	}
	
	public String getOperation() {
		return operation;
	}
	public String getTime() {
		return time;
	}
}
