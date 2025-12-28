package selenium_java;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompanyCodeUpdate {

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
		gUname.sendKeys("SZ1AMZHU"); // SZ1AMZHU, SZ1ELAU
		Thread.sleep(1000);
		WebElement gPwd = driver.findElement(By.xpath("//label[text()='Subgroup']/..//input"));
		gPwd.sendKeys("SZK"); //SZK, ALL
		WebElement gSubmit = driver.findElement(By.xpath("//button[text()='Ghost User']"));
		gSubmit.click();
		Thread.sleep(12000);

		driver.navigate().to("https://www.testcenturyvms.com/ui/dashboard/origin?development=1");
		Thread.sleep(10000);

		WebElement shipmentManagement = driver.findElement(By.xpath("(//cds-ui-dashboard-shipping-management-widget//li/span[contains(@class,'heading')]/span)[1]"));
		shipmentManagement.click();
		Thread.sleep(10000);

		System.out.println("Modifying company code selection in selector");  
		WebElement selectorButton = driver.findElement(By.id("companySeletor"));
		selectorButton.click();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@aria-labelledby='companySeletor']//div[@class='dropdown-item'][position() > 1]//input"));
		List<String> alreadySelectedCompanyCodes = new ArrayList<>();
		List<String> UnselectedCompanyCodes = new ArrayList<>();
		for (int i = 0; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);
			String companyId = checkbox.getAttribute("id");
			//String companyCode = companyId.replaceAll("[^0-9]", "").trim();
			String[] companyCode = companyId.split("-");
			String compCode = companyCode[companyCode.length - 1].trim();
			if (checkbox.isSelected()) {
				alreadySelectedCompanyCodes.add(compCode);
			} else if (!checkbox.isSelected()) {
				UnselectedCompanyCodes.add(compCode);
			} else if (companyCode == null || compCode.trim().isEmpty()) {
				System.out.println(companyCode +" is null or empty");	
			}
		}
		System.out.println("Already checked company code(s) - " + alreadySelectedCompanyCodes);
		System.out.println("Unchecked company code(s) - " + UnselectedCompanyCodes);

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
		
		System.out.println("Available company code(s) in the grid - " + companyCodeInGrid);

		if (!UnselectedCompanyCodes.isEmpty()) {
			WebElement selectorButton2 = driver.findElement(By.id("companySeletor"));
			selectorButton2.click(); 
			for (String compCodeFromgrid : companyCodeInGrid) {
				for (int j = 0; j < alreadySelectedCompanyCodes.size(); j++) {
					String compCodeFromSelector = alreadySelectedCompanyCodes.get(j);
					if (compCodeFromgrid==compCodeFromSelector && !UnselectedCompanyCodes.contains(compCodeFromgrid)) {
						WebElement uncheckSelectedCheckBox = driver.findElement(By.xpath("//input[@id='select-companies-" + compCodeFromgrid + "']"));
						uncheckSelectedCheckBox.click();
						System.out.println("Company code " + compCodeFromgrid + "is unchecked in selector");
					} else {
						System.out.println("Unchecked Company code(s) is available in the grid - " + compCodeFromgrid);
					}
				}
			}
			for (int i = 0; i < UnselectedCompanyCodes.size(); i++) {
				String UnselectedCompCodes = UnselectedCompanyCodes.get(i);
				WebElement uncheckedCheckBoxToSelect = driver.findElement(By.xpath("//input[@id='select-companies-" + UnselectedCompCodes + "']"));
				uncheckedCheckBoxToSelect.click();
				WebElement uncheckedCheckBoxToSelect2 = driver.findElement(By.xpath("//input[@id='select-companies-" + UnselectedCompCodes + "']"));
				if (uncheckedCheckBoxToSelect2.isSelected()) {
					System.out.println("New Checkbox is selected.");  
				} else {
					System.out.println("Issue in selecting new company code in selector");
				}
			}
			WebElement selectorButton3 = driver.findElement(By.id("companySeletor"));
			selectorButton3.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Loading')]")));
				WebElement companyCodeInlineFilter2 = driver.findElement(By.xpath("//div[@aria-colindex='2']//button[@aria-label='Open Filter Menu']/span"));
				companyCodeInlineFilter2.click();
				List<WebElement> companyCodesInGrid2 = driver.findElements(By.xpath("//div[@role='listbox' and @ref='eContainer']/div[position() > 1]//div[@ref='eLabel']"));
				List<String> companyCodeInGrid2 = new ArrayList<>();                                                         
				for (int i = 0; i < companyCodesInGrid2.size(); i++) {
					String compCode2 = companyCodesInGrid2.get(i).getText();
					companyCodeInGrid2.add(compCode2);
				}

				WebElement eFilter2 = driver.findElement(By.xpath("//span[@role='tab']/span"));
				eFilter2.click();

				if (!companyCodesInGrid2.isEmpty()) {
					for (String UnselectedCompanyCode : UnselectedCompanyCodes) {
						for (int i = 0; i < companyCodeInGrid2.size(); i++) {
							String compCode3 = companyCodeInGrid2.get(i);
							if (UnselectedCompanyCode.contains(compCode3)) {
								System.out.println("Selected company code is present in the grid " + compCode3);
							}
						}
					}

				} else {
					System.out.println("Selected company code(s) doesn't have data to show" + UnselectedCompanyCodes);
				}
			} catch (TimeoutException e) {
				System.out.println("After selected company code in selector, data in grid keeps loading upto 2 mins. Unfotunately failing this test case since it takes more time than usual");
				System.err.println("Timeout waiting for element to become invisible");
				e.printStackTrace();
			} finally {
				driver.close();
			}
		} else {
			System.out.println("Company code(s) that are available already selected in selector - " + alreadySelectedCompanyCodes);
		}
	}
}