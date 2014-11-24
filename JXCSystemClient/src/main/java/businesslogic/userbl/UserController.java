package businesslogic.userbl;

import businesslogicservice.userblservice.UserblService;

public class UserController implements UserblService{
	
	User user=new User();

	public String addUser(String name, String password, int duty) {
		// TODO Auto-generated method stub
		return user.addUser(name, password, duty);
	}

	public String delUser(String name) {
		// TODO Auto-generated method stub
		return user.delUser(name);
	}

	public String show() {
		// TODO Auto-generated method stub
		return user.show();
	}

	public String login(String name, String password) {
		// TODO Auto-generated method stub
		return user.login(name, password);
	}

}
