package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemlogPO extends AllBillPO implements Serializable{

	public String operator;//����
	public String old_note;
	
	public SystemlogPO(String operation, String note) {
		this.operator = operation;
		this.old_note=note;
		this.doc_type=10;
	}
	
	public SystemlogPO copy(){
		SystemlogPO po=new SystemlogPO(operator,note);
		po.setNote(note);
		po.setTime(time);
		return po;
	}
	
	public String getOperation() {
		return operator;
	}
	public String getOldTime() {
		return time;
	}
	
	public SystemlogPO copy(SystemlogPO po){
		Date date = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format( date ); //这一段要不要写在这里啊啊啊啊啊啊啊啊
		
		return new SystemlogPO(po.getOperation(),time);
		
	}
}
