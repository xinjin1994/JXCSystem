package businesslogicservice.userblservice;

public interface UserblService {
	
	//添加用户
	public String addUser(String name, String password, int duty);

	/**
	 * 删除用户
	 * @param name
	 * @return
	 */
	public String delUser(String name);

	/**
	 * 显示所有用户
	 * @return
	 */
	public String show();

	/**
	 * 验证登陆账号密码
	 * 0代表管理员
	 * 1代表库存人员
	 * 2代表销售人员
	 * 3代表销售经理
	 * 4代表财务人员
	 * 5代表财务经理
	 * 6代表总经理
	 */
	public int login(String name, String password);
}
