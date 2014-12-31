package test;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.initializationlbl.Initialization;
import businesslogic.initializationlbl.MockCommodity;

public class InitializationAddCommodityTester {

	@Test
	public void test() {
		Initialization initialization = new Initialization();
		MockCommodity mockCommodity = new MockCommodity();
		initialization.commodityInfo = mockCommodity;
		
		assertEquals(0, 0);
	
	}

}
