package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class OpenOrangeHRM {

	public static void main(String[] args) {
		WebDriver driver;
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");	
			driver.findElement(By.xpath("//div[@class=\"oxd-form-actions orangehrm-login-action\"]")).click();
			boolean status = driver.findElement(By.xpath("//p[text()='Quick Launch']")).isDisplayed();
			Assert.assertTrue(status);
	}

}
