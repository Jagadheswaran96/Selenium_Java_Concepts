package testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

public class Assertion {
	
	@Test
	public void sum() {
		String actual="Selenium";
		String expected="Selenium";
		assertEquals(actual, expected);
		assertNotEquals(actual, expected, "they are not equal");
	}
}
