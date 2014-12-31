package test;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.initializationlbl.Initialization;
import businesslogic.initializationlbl.MockSales;

public class InitializationAddCustomerTester {

	@Test
	public void test() {
		Initialization initialization = new Initialization();
		MockSales mockSales = new MockSales();
		initialization.salesInfo = mockSales;
		
		assertEquals(0, 0);
		
	}

}
