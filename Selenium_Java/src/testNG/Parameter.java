package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	
	@Test
	@Parameters({"a","b"})
	public void add(int a, int b) {
		int sum=a+b;
		System.out.println("value is" + sum);
	}
}
