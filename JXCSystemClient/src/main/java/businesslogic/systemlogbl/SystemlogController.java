package businesslogic.systemlogbl;

import java.util.ArrayList;

import po.SystemlogPO;
import vo.SystemlogVO;
import businesslogicservice.systemlogblservice.SystemlogblService;

public class SystemlogController implements SystemlogblService{
	
	public Systemlog systemlog=new Systemlog();

	public ArrayList<SystemlogVO> show_up() {
		// TODO Auto-generated method stub
		ArrayList<SystemlogPO> po=systemlog.show_up();
		ArrayList<SystemlogVO> vo=new ArrayList<SystemlogVO>();
		
		for(int i=0;i<po.size();i++){
			SystemlogVO lin=new SystemlogVO(po.get(i).getTime(),po.get(i).getOperation(),po.get(i).getWord());
			vo.add(lin);
		}
		return vo;
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
