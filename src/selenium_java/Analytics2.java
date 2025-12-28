package selenium_java;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Analytics2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();

		//		ChromeOptions chromeOptions = new ChromeOptions();
		//	    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//	    WebDriver driver = new ChromeDriver(chromeOptions);

		WebDriver driver = new EdgeDriver();

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

		Thread.sleep(15000);

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
		//Thread.sleep(3000);

		long start = System.currentTimeMillis();	
		driver.findElement(By.tagName("cds-ui-analytics-report-viewer"));
		// Switch to the iframe containing the reports
		WebElement iframeElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframeElement);
		System.out.println("Start Time::"+start);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String result = js.executeScript("return document.readyState").toString();
		driver.findElement(By.xpath("//div[@name='Tabular@TCell1']"));
		System.out.println("DOMContentLoaded::"+result);
		if (!result.equals("complete")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String reportName=driver.findElement(By.xpath("(//div[@id='sheetArea']//preceding-sibling::div[3]//div[contains(@name,'Label')])[1]")).getText();
		reportName = reportName.replaceAll("[^a-zA-Z0-9]", " "); 
		System.out.println(reportName);
		driver.switchTo().defaultContent();    
		long finish = System.currentTimeMillis();
		System.out.println("End Time::"+finish);
		long totalTime = finish - start; 
		long totalTimeInSec = totalTime/1000;
		System.out.println("totalTime::"+totalTimeInSec);
		System.out.println(reportName + " Report loaded successfully in "+totalTimeInSec+" Seconds");

		// Close the browser
		driver.quit();

	}


}
