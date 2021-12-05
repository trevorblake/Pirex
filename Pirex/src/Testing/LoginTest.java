package Testing;

import javax.annotation.processing.Generated;
import java.awt.event.ActionEvent;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import Display.Login;
import mockit.*;

@Generated(value = "org.junit-tools-1.1.0")
public class LoginTest {

	private Login createTestSubject() {
		return new Login();
	}

	@MethodRef(name = "setLayoutManager", signature = "()V")
	@Test
	public void testSetLayoutManager() throws Exception {
		Login testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.setLayoutManager();
	}

	@MethodRef(name = "setLocationAndSize", signature = "()V")
	@Test
	public void testSetLocationAndSize() throws Exception {
		Login testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.setLocationAndSize();
	}

	@MethodRef(name = "addComponentsToContainer", signature = "()V")
	@Test
	public void testAddComponentsToContainer() throws Exception {
		Login testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.addComponentsToContainer();
	}

	@MethodRef(name = "addActionEvent", signature = "()V")
	@Test
	public void testAddActionEvent() throws Exception {
		Login testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.addActionEvent();
	}

	@MethodRef(name = "actionPerformed", signature = "(QActionEvent;)V")
	@Test
	public void testActionPerformed() throws Exception {
		Login testSubject;
		ActionEvent e = null;
		// default test
		testSubject = createTestSubject();
		//testSubject.actionPerformed(e);
	}

	@MethodRef(name = "createLogin", signature = "()V")
	@Test
	public void testCreateLogin() throws Exception {
		Login testSubject;

		// default test
		testSubject = createTestSubject();
		testSubject.createLogin();
	}

	@MethodRef(name = "createPirex", signature = "()V")
	@Test
	public void testCreatePirex() throws Exception {

		// default test
		Login.createPirex();
	}
}