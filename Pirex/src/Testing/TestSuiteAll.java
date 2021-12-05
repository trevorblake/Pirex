package Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ TestSuiteData.class, TestSuiteDisplay.class, TestSuitePirex.class })
public class TestSuiteAll { 
}
