package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelAttribute {
	WebDriver driver;
	@Test
	public void openChrome() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		/*driver.manage().window().maximize();*/
		driver.get("https://www.google.com");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}
	@Test
	public void openBing() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.bing.com");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}
}
