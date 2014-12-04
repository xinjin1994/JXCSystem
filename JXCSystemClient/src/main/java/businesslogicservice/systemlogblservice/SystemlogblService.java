package businesslogicservice.systemlogblservice;

import java.util.ArrayList;

import vo.SystemlogVO;

public interface SystemlogblService {
	
	//显示系统日志
	public ArrayList<SystemlogVO> show_up();
	
	//导出Excel，未实现
	public int exportExcel_up();

	//添加系统日志
	public int add_up(String word);
	
}
