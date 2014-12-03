package po;


//这个是所有单据PO的父类
public class DocumentPO {

	String time;
	String note;
	
	public String getTime(){
		return time;
	}
	public String getNote(){
		return note;
	}
	
	public void setTime(String time){
		this.time=time;
	}
	public void setNote(String note){
		this.note=note;
	}
}
