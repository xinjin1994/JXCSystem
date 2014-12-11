package businesslogic.userbl;

import java.util.ArrayList;

import vo.UserVO;
import businesslogicservice.userblservice.UserblService;

public class UserController implements UserblService{
	
	public User user=new User();

	public int addUser(String name, String password, int duty) {
		// TODO Auto-generated method stub
		int message=user.addUser(name, password, duty);
		return message;
	}

	public int delUser(String name) {
		// TODO Auto-generated method stub
		int message=user.delUser(name);
		return message;
	}

	public ArrayList<UserVO> show_up() {
		// TODO Auto-generated method stub
		ArrayList<UserVO> result=user.show();
		return result;
	}

	public int login_up(String name, String password) {
		// TODO Auto-generated method stub
		int message=user.login(name, password);
		return message;
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

	public String getUserNote() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserVO searchUser_Note(String note) {
		// TODO Auto-generated method stub
		return null;
	}

}
