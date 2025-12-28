package selenium_java;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LazyLoading {

	public static void main(String[] args) throws InterruptedException {

		//WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Jagadhez\\Downloads\\edgedriver_win64\\msedgedriver.exe");

//		EdgeOptions options = new EdgeOptions();
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		WebDriver driver = new EdgeDriver();

		driver.get("https://www.testcenturyvms.com/ui/dashboard/customer");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement Uname = driver.findElement(By.id("username"));
		Uname.sendKeys("VIZIVQAOrl");
		Thread.sleep(1000);
		WebElement Pwd = driver.findElement(By.id("password"));
		Pwd.sendKeys("VIZIVQABOT2024!");
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
		gUname.sendKeys("MDarling"); // SZ1AMZHU, SZ1ELAU
		Thread.sleep(1000);
		WebElement gPwd = driver.findElement(By.xpath("//label[text()='Subgroup']/..//input"));
		gPwd.sendKeys("BJW"); //SZK, ALL
		WebElement gSubmit = driver.findElement(By.xpath("//button[text()='Ghost User']"));
		gSubmit.click();
		Thread.sleep(12000);

		driver.navigate().to("https://www.testcenturyvms.com/ui/container/view/819N000330CM0/TLLU4585271");
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Find the scrollable container element
			WebElement scrollableContainer = driver.findElement(By.xpath("//div[@class='ag-body-horizontal-scroll']//div[@ref='eViewport']"));

			// Use JavaScript to get the scrollable area and scrollbar length
			JavascriptExecutor js = (JavascriptExecutor) driver;
			long scrollWidth = (Long) js.executeScript("return arguments[0].scrollWidth;", scrollableContainer);
			long clientWidth = (Long) js.executeScript("return arguments[0].clientWidth;", scrollableContainer);

			System.out.println("Scrollable Width: " + scrollWidth);
			System.out.println("Visible Width: " + clientWidth);

			// Scroll to the end of the scrollable area
			js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableContainer);

			// Verify that the scrollable area has reached the end
			long scrollLeft = (Long) js.executeScript("return arguments[0].scrollLeft;", scrollableContainer);
			System.out.println("Scrolled Left: " + scrollLeft);

			long currentScrollLeft = 0;
			long stepSize = clientWidth; // Scroll by visible width or smaller step if needed

			while (currentScrollLeft < scrollWidth) {
				// Scroll to the right by step size
				js.executeScript("arguments[0].scrollLeft = arguments[1];", scrollableContainer, currentScrollLeft);

				// Optionally wait for new columns to load
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("CSS_SELECTOR_FOR_COLUMN_HEADER")));

				// Verify the columns or headers
				verifyColumns(driver);

				// Move the scroll position
				currentScrollLeft += stepSize;

				// Optional: Add a short sleep to handle any dynamic loading
				Thread.sleep(1000);

			} 
		}	catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Clean up
			driver.quit();
		}
	}
	
	private static void verifyColumns(WebDriver driver) {

		List<String> expectedColumns = Arrays.asList("Item #", "PO #", "Vendor", "Description","Qty","MBL #","HBL #");
		//cds-ui-container-item-view//span[text()='Item #']
		for (int i = 0; i < expectedColumns.size(); i++) {
			WebElement header = driver.findElement(By.xpath("//cds-ui-container-item-view//span[text()='"+expectedColumns.get(i)+"']"));
			System.out.println("Column Header Text: " + header.getText());
			if (header.isDisplayed()) {
				System.out.println("Column header " + header + " is displayed");
			} else {
				System.out.println("Column header " + header + " is not displayed");
			}
			
		}
		
	}
}
