package testNG;

import org.testng.annotations.Test;

public class PriorityAnnotation {
	@Test(priority=-2)
	public void powerOnLaptop() {
		System.out.println("Powered on laptop");

	}
	@Test(priority=-1)
	public void enterUserName() {
		System.out.println("Entered username");
	}
	@Test(priority=0)
	public void enterPassword() {
		System.out.println("Entered password");
	}
	@Test(priority=1)
	public void clickSubmit() {
		System.out.println("Submitted");
	}
	@Test(priority=2)
	public void openEclipse() {
		System.out.println("Eclipse opened");
	}
}
