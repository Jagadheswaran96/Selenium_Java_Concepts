package testNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListeners.class)
public class TestAnnotation {
	
	@Test
	public void powerOnLaptop() {
		System.out.println("Powered on laptop");
		int a=10;
		int b=20;
		assertEquals(b, a);

	}
	@Test
	public void enterUserName() {
		System.out.println("Entered username");
	}
	@Test
	public void enterPassword() {
		System.out.println("Entered password");
	}
	@Test
	public void clickSubmit() {
		System.out.println("Submitted");
	}
	@Test
	public void openEclipse() {
		System.out.println("Eclipse opened");
	}
}
