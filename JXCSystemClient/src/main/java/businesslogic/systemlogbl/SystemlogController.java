package businesslogic.systemlogbl;

import java.util.ArrayList;

import vo.SystemlogVO;
import businesslogicservice.systemlogblservice.SystemlogblService;

public class SystemlogController implements SystemlogblService{
	
	public Systemlog systemlog=new Systemlog();

	public ArrayList<SystemlogVO> show_up() {
		// TODO Auto-generated method stub
		ArrayList<SystemlogVO> result=systemlog.show_up();
		return result;
	}

	public int add_up(String word) {
		// TODO Auto-generated method stub
		int message=systemlog.add_up(word);
		return message;
	}

	public int exportExcel_up() {
		// TODO Auto-generated method stub
		return 0;
	}

}
