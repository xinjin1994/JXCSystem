package businesslogic.accountbl;

public class AccountSingleton {
	
	private static Account account;
	
	public static Account getInstace(){
		return account;
	}
	
	public static void setInstace(Account account1){
		account=account1;
	}

}
