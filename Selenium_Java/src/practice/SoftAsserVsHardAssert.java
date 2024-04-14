package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsserVsHardAssert {
	//1.hard assert
	//2.soft assert
	
	// Here, used soft assert
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void method1() {
		System.out.println("enter user name");
		Assert.assertEquals(false, true);
		System.out.println("enter the password");
		System.out.println("click on login button");
		softAssert.assertAll();
	}
	
	// Here, used hard assert
	@Test
	public void method2() {
		System.out.println("verify home page");
		Assert.assertEquals(false, true);
		System.out.println("navigate to career page");
		Assert.assertEquals(false, true);
		System.out.println("enroll as a candidate");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
