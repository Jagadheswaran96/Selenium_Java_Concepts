package testNG;

import org.testng.annotations.Test;

public class TestAnnotation {
	@Test
	public void powerOnLaptop() {
		System.out.println("Powered on laptop");

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
