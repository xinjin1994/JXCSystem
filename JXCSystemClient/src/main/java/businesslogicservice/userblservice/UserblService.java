package businesslogicservice.userblservice;

public interface UserblService {
	public String addUser(String name, String password, int duty);

	public String delUser(String name);

	public String show();

	public String login(String name, String password);
}
