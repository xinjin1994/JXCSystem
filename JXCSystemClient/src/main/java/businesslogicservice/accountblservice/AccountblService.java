package businesslogicservice.accountblservice;

public interface AccountblService {
	
	//查看当前账户信息
	public String checkAccount();

	//添加账户
	public String addAccount(String name, int money);

	//删除账户
	public String delAccount(String name);

	//修改账户
	public String updateAccount(String name1, String name2);

	//查找账户
	public String searchAccount(String word);

	//添加收款单
	public String addReceipt(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps);
	//添加付款单
	public String addPayment(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps);
	
}
