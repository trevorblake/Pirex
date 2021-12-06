package Testing;

import javax.annotation.processing.Generated;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import Display.Login;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

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

	@Test
	public void adminLogin() throws Exception {
		Login testSubject;
		testSubject = createTestSubject();
		testSubject.createLogin();
		Robot bot = new Robot();		
		
		//test show password
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_A);
		Thread.sleep(300);
		bot.mouseMove(178, 315);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//test reset button
		bot.mouseMove(258, 360);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		//test invalid combo
		bot.mouseMove(118, 363);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		bot.mouseMove(201, 285);
		Thread.sleep(300);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		//test login enter
		bot.mouseMove(220, 210);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_A);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_D);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_M);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_I);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_N);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_P);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_A);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_S);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_S);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_W);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_O);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_R);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_D);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		testSubject.createLogin();
		Thread.sleep(1000);
		
		bot.mouseMove(118, 363);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		pirexButtonsAdmin();
		
		
	}

	@Test
	public void userLogin() throws Exception {
		Login testSubject;
		testSubject = createTestSubject();
		testSubject.createLogin();
		Robot bot = new Robot();		
		
		//test login enter
		bot.mouseMove(220, 210);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_U);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_S);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_E);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_R);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_P);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_A);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_S);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_S);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_W);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_O);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_R);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_D);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		testSubject.createLogin();
		Thread.sleep(1000);
		
		bot.mouseMove(118, 363);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		pirexButtonsUser();
		
		
		
	}
	
	public void pirexButtonsAdmin() throws Exception {
		Robot bot = new Robot();
			
		//click on summarize
		Thread.sleep(300);
		bot.mouseMove(722, 155);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//export docs
		bot.mouseMove(566, 222);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		//remove if privilege is 0
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		//click on search
		bot.mouseMove(315, 151);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on query
		bot.mouseMove(480, 285);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//type query
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_T);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_H);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_E);
		Thread.sleep(300);
		
		//click clear
		bot.mouseMove(877, 287);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on query
		bot.mouseMove(480, 285);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//type query
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_T);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_H);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_E);
		Thread.sleep(300);
		
		//click on match
		bot.mouseMove(483, 332);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on edit
		bot.mouseMove(874, 406);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//close edit
		bot.mouseMove(1632, 208);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseMove(547, 453);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		//click on load
		bot.mouseMove(495, 153);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on browse
		bot.mouseMove(900, 229);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//close browse
		bot.mouseMove(1234, 315);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);


	}
	
	public void pirexButtonsUser() throws Exception {
		Robot bot = new Robot();
			
		//click on summarize
		bot.mouseMove(722, 155);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//export docs
		bot.mouseMove(566, 222);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		//click on search
		bot.mouseMove(315, 151);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on query
		bot.mouseMove(480, 285);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//type query
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_T);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_H);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_E);
		Thread.sleep(300);
		
		//click clear
		bot.mouseMove(877, 287);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on query
		bot.mouseMove(480, 285);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//type query
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_T);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_H);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_E);
		Thread.sleep(300);
		
		//click on match
		bot.mouseMove(483, 332);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on edit
		bot.mouseMove(874, 406);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		//click on delete
		bot.mouseMove(874, 466);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		//click on load
		bot.mouseMove(495, 153);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		
		//click on browse
		bot.mouseMove(900, 229);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		
		//click on process
		bot.mouseMove(900, 302);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		bot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(300);
		

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
		//Login.createPirex();
	}
}