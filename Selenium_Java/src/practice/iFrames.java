package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://krninformatix.com/frames/frames.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("secondframe");
		//driver.switchTo().frame(arg0)
		driver.findElement(By.xpath("//input[@name='name1']")).sendKeys("selenium");
		driver.findElement(By.name("rep")).click();
		driver.switchTo().frame("String");
		driver.switchTo().frame("WebElement");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.findElement(By.name("check")).click();
		
	}

}
