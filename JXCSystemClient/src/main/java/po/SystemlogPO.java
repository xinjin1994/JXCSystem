package po;

import java.io.Serializable;

public class SystemlogPO implements Serializable{

	String operation;//����
	String time;//ʱ��
	
	public SystemlogPO(String operation, String time) {
		this.operation = operation;
		this.time = time;
	}
	
	public SystemlogPO copy(){
		return new SystemlogPO(operation, time);
	}
	
	public String getOperation() {
		return operation;
	}
	public String getTime() {
		return time;
	}
}
