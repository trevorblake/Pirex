package Testing;

import javax.annotation.processing.Generated;

import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;

import Pirex.Driver;

@Generated(value = "org.junit-tools-1.1.0")
public class DriverTest {

	@MethodRef(name = "main", signature = "([QString;)V")
	@Test
	public void testMain() throws Exception {
		String[] args = new String[] { "" };

		// default test
		Driver.main(args);
	}
}