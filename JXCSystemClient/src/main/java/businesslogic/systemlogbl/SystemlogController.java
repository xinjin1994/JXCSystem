package businesslogic.systemlogbl;

import businesslogicservice.systemlogblservice.SystemlogblService;

public class SystemlogController implements SystemlogblService{
	
	Systemlog systemlog=new Systemlog();

	public String show() {
		// TODO Auto-generated method stub
		return systemlog.show();
	}

	public String add(String word) {
		// TODO Auto-generated method stub
		return systemlog.add(word);
	}

}
