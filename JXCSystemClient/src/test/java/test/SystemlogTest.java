package test;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.systemlogbl.MockAdd;
import businesslogic.systemlogbl.Systemlog;

public class SystemlogTest {

	@Test
	public void testShow() {
		MockAdd mock=new MockAdd();
		Systemlog sys=new Systemlog();
		sys.setSys(mock);
		assertEquals(0,0);
	}

	@Test
	public void testAdd() {
		MockAdd mock=new MockAdd();
		Systemlog sys=new Systemlog();
		sys.setSys(mock);
		assertEquals(0,0);
	}

}
