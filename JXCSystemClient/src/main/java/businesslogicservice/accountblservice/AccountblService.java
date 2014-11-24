package businesslogicservice.accountblservice;

public interface AccountblService {
	public String checkAccount();

	public String addAccount(String name, int money);

	public String delAccount(String name);

	public String updateAccount(String name1, String name2);

	public String searchAccount(String word);

	public String addReceipt(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps);

	public String addPayment(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps);
}
