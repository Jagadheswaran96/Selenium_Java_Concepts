package testNG;

import org.testng.annotations.Test;

public class DependiesManagement {
	// if parent test case is failed, should not run child test case. So, we use dependsOn() function to achieve the task
	@Test(priority=0)
	public void powerOnLaptop() {
		System.out.println("Powered on laptop");
	}
	@Test(dependsOnMethods="powerOnLaptop")
	public void enterUserName() {
		System.out.println("Entered username");
	}
	@Test(dependsOnMethods="enterUserName")
	public void enterPassword() {
		System.out.println("Entered password");
	}
	@Test(dependsOnMethods="enterPassword")
	public void clickSubmit() {
		System.out.println("Submitted");
	}
	@Test(dependsOnMethods="clickSubmit")
	public void openEclipse() {
		System.out.println("Eclipse opened");
	}

}
