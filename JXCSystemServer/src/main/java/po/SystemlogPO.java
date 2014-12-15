package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemlogPO extends AllBillPO implements Serializable{

	public String operator;//����
	public String old_note;
	
	public String word;
	
	public SystemlogPO(String operation, String word) {
		this.operator = operation;
		this.word=word;
		this.doc_type=10;
	}
	
	public SystemlogPO copy(){
		SystemlogPO po=new SystemlogPO(operator,word);
		po.setNote(note);
		po.setTime(time);
		return po;
	}
	
	public String getOperation() {
		return operator;
	}
	public String getWord() {
		return word;
	}

}
