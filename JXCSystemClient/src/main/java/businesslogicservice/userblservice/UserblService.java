package businesslogicservice.userblservice;

import java.util.ArrayList;

import vo.UserVO;

public interface UserblService {
	
	//添加用户
	public int addUser_up(UserVO vo);

	/**
	 * 删除用户
	 * @param name
	 * @return
	 */
	public int delUser_up(UserVO vo);

	/**
	 * 显示所有用户
	 * @return
	 */
	public ArrayList<UserVO> show_up();

	/**
	 * 验证登陆账号密码
	 * <0代表失败
	 * 0代表管理员
	 * 1代表库存人员
	 * 2代表销售人员
	 * 3代表销售经理
	 * 4代表财务人员
	 * 5代表财务经理
	 * 6代表总经理
	 */
	public int login_up(String name, String password);
	
	public UserVO searchUser_up(String name);

}
