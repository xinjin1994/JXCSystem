package ui.setting;

import java.text.SimpleDateFormat;
/**
 * 查询时间格式是否正确
 * @author ZYC
 *
 */
public class CheckTimeFormat {
	String time;
	public CheckTimeFormat(String time) {
		this.time = time;
		check();
	}
	public boolean check() {
		SimpleDateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		boolean isLegal = true;
		try{
			dateFormat.parse(time);
			isLegal = true;
		}catch(Exception e2){
			isLegal = false;
		}
		return isLegal;
	}

}
