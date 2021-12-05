package Testing;

import java.io.FileNotFoundException;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import Data.Doc;

@Generated(value = "org.junit-tools-1.1.0")
public class DocTest {

	private Doc createTestSubject() throws FileNotFoundException {
		return new Doc("Star Wars", "", "");
	}

	@MethodRef(name = "getTitle", signature = "()QString;")
	@Test
	public void testGetTitle() throws Exception {
		Doc testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getTitle();
	}

	@MethodRef(name = "getAuthor", signature = "()QString;")
	@Test
	public void testGetAuthor() throws Exception {
		Doc testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAuthor();
	}

	@MethodRef(name = "getDate", signature = "()QString;")
	@Test
	public void testGetDate() throws Exception {
		Doc testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getDate();
	}

	@MethodRef(name = "getLocation", signature = "()QString;")
	@Test
	public void testGetLocation() throws Exception {
		Doc testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getLocation();
	}

	@MethodRef(name = "getText", signature = "()QString;")
	@Test
	public void testGetText() throws Exception {
		Doc testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getText();
	}

	@MethodRef(name = "formText", signature = "()QString;")
	@Test
	public void testFormText() throws Exception {
		Doc testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.formText();
	}

	@MethodRef(name = "shortForm", signature = "(QString;)QString;")
	@Test
	public void testShortForm() throws Exception {
		Doc testSubject = new Doc("Star Wars", "1","");
		String keyword = "he became so";
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.shortForm(keyword);
		result = testSubject.shortForm("Monty");
		System.out.println(result);
	}

	@MethodRef(name = "toString", signature = "()QString;")
	@Test
	public void testToString() throws Exception {
		Doc testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
	}
}