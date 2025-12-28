package selenium_java;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompanyCodeInGrid {

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
		gUname.sendKeys("SZ1AMZHU");
		Thread.sleep(1000);
		WebElement gPwd = driver.findElement(By.xpath("//label[text()='Subgroup']/..//input"));
		gPwd.sendKeys("SZK");
		WebElement gSubmit = driver.findElement(By.xpath("//button[text()='Ghost User']"));
		gSubmit.click();
		Thread.sleep(12000);
		
		driver.navigate().to("https://www.testcenturyvms.com/ui/dashboard/origin?development=1");
		Thread.sleep(10000);
		
		WebElement shipmentManagement = driver.findElement(By.xpath("(//cds-ui-dashboard-shipping-management-widget//li/span[contains(@class,'heading')]/span)[1]"));
		shipmentManagement.click();
		Thread.sleep(10000);
		
		WebElement selectorButton = driver.findElement(By.id("companySeletor"));
		selectorButton.click();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@aria-labelledby='companySeletor']//div[@class='dropdown-item'][position() > 1]//input"));
		List<String> alreadySelectedCompanyCodes = new ArrayList<>();
		List<String> UnelectedCompanyCodes = new ArrayList<>();
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			String companyId = checkbox.getAttribute("id");
			String companyCode = companyId.replaceAll("[^0-9]", "").trim();
			if (checkbox.isSelected()) {
				alreadySelectedCompanyCodes.add(companyCode);
			} else {
				UnelectedCompanyCodes.add(companyCode);
			}
		}
		WebElement selectorButton2 = driver.findElement(By.id("companySeletor"));
		selectorButton2.click();

		WebElement companyCodeInlineFilter = driver.findElement(By.xpath("//div[@aria-colindex='2']//button[@aria-label='Open Filter Menu']/span"));
		companyCodeInlineFilter.click();
		List<WebElement> companyCodesInGrid = driver.findElements(By.xpath("//div[@role='listbox' and @ref='eContainer']/div[position() > 1]//div[@ref='eLabel']"));
		List<String> companyCodeInGrid = new ArrayList<>();                                                         
		for (int i = 0; i < companyCodesInGrid.size(); i++) {
			String compCode = companyCodesInGrid.get(i).getText();
			companyCodeInGrid.add(compCode);
		}
		WebElement eFilter = driver.findElement(By.xpath("//span[@role='tab']/span"));
		eFilter.click();                                            
		boolean containsAll = alreadySelectedCompanyCodes.containsAll(companyCodeInGrid);                                                         
		if (containsAll==true) {
			System.out.println("The following company codes " + alreadySelectedCompanyCodes + " selected in drop down are available in grid that are " + companyCodeInGrid);
		} else {
			System.out.println("The following company codes " + alreadySelectedCompanyCodes + " selected in drop down are not available in grid that are " + companyCodeInGrid);
		}

		// Close the browser
		//driver.close();

	}


}
