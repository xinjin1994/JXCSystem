package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.systemlogbl.MockAdd;
import businesslogic.systemlogbl.Systemlog;

public class SystemlogGetTester {

	@Test
	public void test() {
		MockAdd mock=new MockAdd();
		Systemlog sys=new Systemlog();
		sys.setSys(mock);
		assertEquals("成功",sys.show_up());
	}

}
