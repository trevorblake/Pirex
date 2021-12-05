package Testing;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import Data.User;

@Generated(value = "org.junit-tools-1.1.0")
public class UserTest {

	private User createTestSubject() {
		return new User("", "", 0);
	}

	@MethodRef(name = "getPassword", signature = "()QString;")
	@Test
	public void testGetPassword() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPassword();
	}

	@MethodRef(name = "getUsername", signature = "()QString;")
	@Test
	public void testGetUsername() throws Exception {
		User testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUsername();
	}

	@MethodRef(name = "getPrivilege", signature = "()I")
	@Test
	public void testGetPrivilege() throws Exception {
		User testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPrivilege();
	}
}