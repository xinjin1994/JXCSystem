package businesslogic.userbl;

import java.util.ArrayList;

import main.ClientStart;
import po.UserPO;
import vo.UserVO;
import businesslogicservice.userblservice.UserblService;

public class UserController implements UserblService{
	
	public User user=new User();
	
	public UserController(){
		user=ClientStart.user;
	}

	public ArrayList<UserVO> show_up() {
		// TODO Auto-generated method stub
		ArrayList<UserPO> po=user.show();
		ArrayList<UserVO> array=new ArrayList<UserVO>();
		for(int i=0;i<po.size();i++){
			UserVO vo=new UserVO(po.get(i).getNote(),po.get(i).getName(),"",po.get(i).getDuty());
			array.add(vo);
		}
		return array;
	}

	public int login_up(String name, String password) {
		// TODO Auto-generated method stub
		int message=user.login(name, password);
		return message;
	}

	public int addUser_up(UserVO vo) {
		// TODO Auto-generated method stub
		return user.addUser(vo.name, vo.password, vo.duty,vo.id);
	}

	public int delUser_up(UserVO vo) {
		// TODO Auto-generated method stub
		return user.delUser(vo.id);
	}

	public ArrayList<UserVO> searchUser_up(String name) {
		// TODO Auto-generated method stub
		ArrayList<UserPO> po=user.getUser_Note(name);
		ArrayList<UserVO> array=new ArrayList<UserVO>();
		for(int i=0;i<po.size();i++){
			UserVO vo=new UserVO(po.get(i).getNote(),po.get(i).getName(),"",po.get(i).getDuty());
			array.add(vo);
		}
		return array;
	}

	public String getUserNote() {
		// TODO Auto-generated method stub
		return user.getUserNote();
	}

}
