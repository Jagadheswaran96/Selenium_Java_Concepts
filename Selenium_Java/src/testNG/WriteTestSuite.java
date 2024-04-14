package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteTestSuite {
	
	WebDriver driver;
	long startTime;
	long endTime;
	
	@BeforeSuite
	public void openBrowser() {
		WebDriverManager.firefoxdriver().setup();
		startTime=System.currentTimeMillis();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void openGoogle() throws InterruptedException {
		driver.get("https://www.google.com/");
	}
	@Test
	public void openBing() throws InterruptedException {
		driver.get("https://www.bing.com/");
	}
	@Test
	public void openYahoo() throws InterruptedException {
		driver.get("https://in.yahoo.com/");
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		endTime=System.currentTimeMillis();
		long runTime=endTime-startTime;
		System.out.println("Time taken"+runTime);
	}
	
}		

