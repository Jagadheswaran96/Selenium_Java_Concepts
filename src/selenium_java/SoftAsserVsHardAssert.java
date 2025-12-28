package selenium_java;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsserVsHardAssert {
	//1.hard assert
	//2.soft assert
	
	// Here, used soft assert
	SoftAssert softAssert = new SoftAssert();
	@Test (enabled = true)
	public void method1() {
		System.out.println("enter user name");
		softAssert.assertEquals(false, true);
		System.out.println("enter the password");
		System.out.println("click on login button");
		softAssert.assertAll();
	}
	
	// Here, used hard assert. It will stop execution once error has occurred
	@Test 
	public void method2() {
		System.out.println("verify home page");
		Assert.assertEquals(true, true);
		System.out.println("navigate to career page");
		Assert.assertEquals(false, true);
		System.out.println("enroll as a candidate");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
