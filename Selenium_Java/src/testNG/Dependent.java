package testNG;

import org.testng.annotations.Test;

public class Dependent {

	  @Test 
	  public void SignIn() {
	   System.out.println("This will execute second (SignIn)");
	  }
	 
	  @Test(dependsOnMethods ="SignIn")
	  public void OpenBrowser() {
	   System.out.println("This will execute first (Open Browser)");
	  }
	}