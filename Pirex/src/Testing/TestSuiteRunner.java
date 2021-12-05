package Testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestSuiteRunner {
	public static void main(String[] args) {
		new TestSuiteAll();
		new TestSuiteRunner();
		new TestSuiteData();
		new TestSuitePirex();
		new TestSuiteDisplay();
		Result result = JUnitCore.runClasses(TestSuiteAll.class);
		System.out.println(result.wasSuccessful());
	}
}