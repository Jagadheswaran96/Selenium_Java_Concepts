package selenium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gsmarena.com/samsung-phones-9.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title=driver.findElement(By.xpath("//img[contains(@title,'A72')]")).getAttribute("title");
		System.out.println(title);
		driver.close();
	}

}
