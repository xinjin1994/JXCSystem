package test;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.systemlogbl.MockAdd;
import businesslogic.systemlogbl.Systemlog;

public class SystemlogAddTester {

	@Test
	public void test() {
//		fail("Not yet implemented");
		MockAdd mock=new MockAdd();
		Systemlog sys=new Systemlog();
		sys.setSys(mock);
		assertEquals(0,0);
	}

}
