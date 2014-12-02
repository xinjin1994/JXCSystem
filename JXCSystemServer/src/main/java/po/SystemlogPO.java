package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemlogPO implements Serializable{

	String operation;//����
	public String time;//ʱ��
	
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
	
	public SystemlogPO copy(SystemlogPO po){
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format( date ); //这一段要不要写在这里啊啊啊啊啊啊啊啊
		
		return new SystemlogPO(po.getOperation(),time);
		
	}
}
