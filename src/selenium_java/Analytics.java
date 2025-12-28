package selenium_java;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Analytics {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		
//		ChromeOptions chromeOptions = new ChromeOptions();
//	    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//	    WebDriver driver = new ChromeDriver(chromeOptions);
		
		WebDriver driver = new EdgeDriver();

		// Execute JavaScript to gather performance metrics
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return window.performance.timing;";
		js.executeScript(script);

		driver.get("https://www.testcenturyvms.com/ui/dashboard/customer");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Uname = driver.findElement(By.id("username"));
		Uname.sendKeys("Jagad");
		Thread.sleep(1000);
		WebElement Pwd = driver.findElement(By.id("password"));
		Pwd.sendKeys("TCSPass1");
		Thread.sleep(1000);
		WebElement Submit = driver.findElement(By.id("btnLogin"));
		Submit.click();

		Thread.sleep(20000);

		WebElement profileIcon = driver.findElement(By.xpath("//button[@id='accountDropdown']"));
		profileIcon.click();
		Thread.sleep(3000);
		WebElement userIcon = driver.findElement(By.xpath("//a[text()='Ghost User']"));
		userIcon.click();
		Thread.sleep(5000);
		WebElement gUname = driver.findElement(By.xpath("//label[text()='UserID']/..//input"));
		gUname.sendKeys("salesdemo");
		Thread.sleep(1000);
		WebElement gPwd = driver.findElement(By.xpath("//label[text()='Subgroup']/..//input"));
		gPwd.sendKeys("DMO");
		WebElement gSubmit = driver.findElement(By.xpath("//button[text()='Ghost User']"));
		gSubmit.click();
		Thread.sleep(12000);

		WebElement Analytics = driver.findElement(By.xpath("//a[text()='Analytics']"));
		Analytics.click();
		Thread.sleep(8000);

		WebElement card = driver.findElement(By.xpath("(//img[@class='card-img-top'])[2]"));
		card.click();
		
		// Switch to the new tab
		String newTabHandle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(newTabHandle);
		
		Long navigationStart = (Long) js.executeScript("return window.performance.timing.responseEnd;");
		
		Thread.sleep(3000);

		// Switch to the iframe containing the reports
		WebElement iframeElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframeElement);
		
		Long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");

		// Calculate the loading time
		long loadingTime = loadEventEnd - navigationStart;
		System.out.println("Loading time of reports: " + loadingTime + " milliseconds");

		// Close the browser
		driver.quit();

	}

}
