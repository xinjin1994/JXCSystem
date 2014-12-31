package test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.AccountVO;
import businesslogic.accountbl.Account;
import businesslogic.accountbl.MockAccountData;
import businesslogic.accountbl.MockInvoice;
import businesslogic.accountbl.MockSystemlog;

public class AccountTest extends Account {

	@Test
	public void testAddAccount() {
		Account account=new Account();
		MockAccountData mock=new MockAccountData("mainAccount",0);
		account.account=mock;
		MockSystemlog mock2=new MockSystemlog();
		account.systemlog=mock2;
		AccountVO po=new AccountVO("name",0);
		assertEquals(0,account.addAccount_up(po));
	}

	@Test
	public void testAddReceipt() {
		Account account=new Account();
		MockAccountData mock=new MockAccountData("mainAccount",0);
		account.account=mock;
		MockSystemlog mock2=new MockSystemlog();
		account.systemlog=mock2;
		MockInvoice mock3=new MockInvoice();
		account.invoice=mock3;
		assertEquals(0,0);
	}
	
	@Test
	public void testCheckAccount(){
		Account account=new Account();
		MockAccountData mock=new MockAccountData("mainAccount",0);
		account.account=mock;
		assertEquals(0,0);
	}

}
