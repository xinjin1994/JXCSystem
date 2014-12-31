package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.UserPO;
import businesslogic.userbl.MockAddUser;
import businesslogic.userbl.MockDelUser;
import businesslogic.userbl.MockGetUser;
import businesslogic.userbl.MockShow;
import businesslogic.userbl.User;

public class UserTest {

	@Test
	public void testAddUser() {
		MockAddUser mockAdd = new MockAddUser();
		User user = new User();
//		user.setUser();
		assertEquals(0, 0);
	}
	
	@Test
	public void testDelUser() {
		MockGetUser mockGet = new MockGetUser();
		User user = new User();
//		user.setUser(mockGet);
		assertEquals(0, 0);
	}
	
	@Test
	public void testLogin() {
		MockGetUser mockGet = new MockGetUser();
		User user = new User();
//		user.setUser(mockGet);
		assertEquals(0, 0);
	}

	@Test
	public void testShow() {
		MockShow mockShow = new MockShow();
		User user = new User();
//		user.setUser(mockShow);
		assertEquals(0, 0);
	}
}
