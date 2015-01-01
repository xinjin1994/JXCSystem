package businesslogic.financialbl;

import businesslogic.accountbl.Account;

public class FinancialSingleton {

	private static Financial financial;
	
	public static Financial getInstace(){
		return financial;
	}
	
	public static void setInstace(Financial financial1){
		financial=financial1;
	}
	
	
}
