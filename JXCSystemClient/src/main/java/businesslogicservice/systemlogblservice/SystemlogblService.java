package businesslogicservice.systemlogblservice;

import java.util.ArrayList;

import vo.SystemlogVO;

public interface SystemlogblService {
	
	//显示系统日志
	public ArrayList<SystemlogVO> show();

	//添加系统日志
	public int add(String word);
	
}
