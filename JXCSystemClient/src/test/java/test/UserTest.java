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
		assertEquals("�ɹ�", user.addUser("name", "password", 10, null));
	}
	
	@Test
	public void testDelUser() {
		MockGetUser mockGet = new MockGetUser();
		User user = new User();
//		user.setUser(mockGet);
		assertEquals("�ɹ�", user.delUser("name"));
	}
	
	@Test
	public void testLogin() {
		MockGetUser mockGet = new MockGetUser();
		User user = new User();
//		user.setUser(mockGet);
		assertEquals("�ɹ�", user.login("name", "password"));
	}

	@Test
	public void testShow() {
		MockShow mockShow = new MockShow();
		User user = new User();
//		user.setUser(mockShow);
		assertEquals("�ɹ�", user.show());
	}
}
