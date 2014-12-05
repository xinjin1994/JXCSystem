package businesslogic.systemlogbl;

import java.util.ArrayList;

import vo.SystemlogVO;
import businesslogicservice.systemlogblservice.SystemlogblService;

public class SystemlogController implements SystemlogblService{
	
	public Systemlog systemlog=new Systemlog();

	public ArrayList<SystemlogVO> show_up() {
		// TODO Auto-generated method stub
		return systemlog.show_up();
	}

	public int add_up(String word) {
		// TODO Auto-generated method stub
		return systemlog.add_up(word);
	}

	public int exportExcel_up() {
		// TODO Auto-generated method stub
		return 0;
	}

}
