package businesslogic.systemlogbl;

import java.util.ArrayList;

import vo.SystemlogVO;
import businesslogicservice.systemlogblservice.SystemlogblService;

public class SystemlogController implements SystemlogblService{
	
	public Systemlog systemlog=new Systemlog();

	public ArrayList<SystemlogVO> show() {
		// TODO Auto-generated method stub
		return systemlog.show();
	}

	public int add(String word) {
		// TODO Auto-generated method stub
		return systemlog.add(word);
	}

}
