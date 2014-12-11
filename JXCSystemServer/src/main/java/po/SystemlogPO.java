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

}
