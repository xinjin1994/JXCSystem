package businesslogicservice.userblservice;

public interface UserblService {
	
	//添加用户
	public String addUser(String name, String password, int duty);

	//删除用户
	public String delUser(String name);

	//显示所有用户
	public String show();

	//验证登陆账号密码
	public String login(String name, String password);
}
