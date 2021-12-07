package Testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

///////////////////////////////////////////////////////////////////////////////////////////////////
////This test suite uses a java.awt.Robot package to test the functionalities of all GUI buttons///
////////////////////////You must only run this if you are on Windows!////////////////////////////// 
///////////Your display resolution must be 1080p and "Scale and Layout" must be at 100%////////////
///////////////DO NOT MOVE MOUSE OR TYPE ON THE KEYBOARD WHILE TEST IS RUNNING/////////////////////
/////////////////////////TEST TAKES APPROX 50 SECONDS THEN WILL END////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

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