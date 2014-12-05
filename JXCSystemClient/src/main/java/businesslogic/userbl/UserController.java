package businesslogic.userbl;

import java.util.ArrayList;

import vo.UserVO;
import businesslogicservice.userblservice.UserblService;

public class UserController implements UserblService{
	
	public User user=new User();

	public int addUser(String name, String password, int duty) {
		// TODO Auto-generated method stub
		return user.addUser(name, password, duty);
	}

	public int delUser(String name) {
		// TODO Auto-generated method stub
		return user.delUser(name);
	}

	public ArrayList<UserVO> show_up() {
		// TODO Auto-generated method stub
		return user.show();
	}

	public int login_up(String name, String password) {
		// TODO Auto-generated method stub
		return user.login(name, password);
	}

	public int addUser_up(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delUser_up(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserVO searchUser_up(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
