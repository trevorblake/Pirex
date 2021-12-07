package Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


///////////////////////////////////////////////////////////////////////////////////////////////////
////This test suite uses a java.awt.Robot package to test the functionalities of all GUI buttons///
////////////////////////You must only run this if you are on Windows!////////////////////////////// 
///////////Your display resolution must be 1080p and "Scale and Layout" must be at 100%////////////
///////////////DO NOT MOVE MOUSE OR TYPE ON THE KEYBOARD WHILE TEST IS RUNNING/////////////////////
/////////////////////////TEST TAKES APPROX 50 SECONDS THEN WILL END////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ TestSuiteData.class, TestSuiteDisplay.class, TestSuitePirex.class })
public class TestSuiteAll { 
}
