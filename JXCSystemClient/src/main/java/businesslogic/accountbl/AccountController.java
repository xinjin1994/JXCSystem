package businesslogic.accountbl;

import businesslogicservice.accountblservice.AccountblService;

public class AccountController implements AccountblService{
	public Account account=new Account();

	public String checkAccount() {
		// TODO Auto-generated method stub
		String message=account.checkAccount();
		return message;
	}

	public String addAccount(String name, int money) {
		// TODO Auto-generated method stub
		String message=account.addAccount(name,money);
		return message;
	}

	public String delAccount(String name) {
		// TODO Auto-generated method stub
		String message=account.delAccount(name);
		return message;
	}

	public String updateAccount(String name1, String name2) {
		// TODO Auto-generated method stub
		String message=account.updateAccount(name1,name2);
		return message;
	}

	public String searchAccount(String word) {
		// TODO Auto-generated method stub
		String result=account.searchAccount(word);
		return result;
	}

	public String addReceipt(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
		String message=account.addReceipt(customer_name, clerk, account_name, money, all_money, ps);
		return message;
	}

	public String addPayment(String customer_name, String clerk,
			String account_name, int money, int all_money, String ps) {
		// TODO Auto-generated method stub
		String message=account.addPayment(customer_name, clerk, account_name, money, all_money, ps);
		return message;
	}

}
