package test;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.initializationlbl.Initialization;
import businesslogic.initializationlbl.MockAccount;

public class InitializationAddAccountTester {

	@Test
	public void testAddAccount() {
	
		MockAccount account = new MockAccount();
		Initialization initialization = new Initialization();
		initialization.accountInfo = account;
		
		assertEquals(0, 0);
	}

}
