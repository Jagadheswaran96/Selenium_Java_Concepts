package selenium_java;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PendingAction {

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
		Thread.sleep(10000);

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

		System.out.println("Verify pending action");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<WebElement> unselectFilters = driver.findElements(By.xpath("//button[contains(text(),'Ready to Process')]"));
		for (int i = 0; i < unselectFilters.size(); i++) {
			String unselectFilter = unselectFilters.get(i).getAttribute("class");
			if (unselectFilter.contains("active")) {
				WebElement select = driver.findElements(By.xpath("//button[contains(text(),'Ready to Process')]")).get(i);
				js.executeScript("arguments[0].scrollIntoView(true);", select);
				wait.until(ExpectedConditions.elementToBeClickable(select));
				select.click();
			}
		}
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Loading')]")));

		List<WebElement> selectFilters = driver.findElements(By.xpath("//button[contains(text(),'Pending Actions')]"));
		for (int i = 0; i < selectFilters.size(); i++) {
			String selectFilter = selectFilters.get(i).getAttribute("class");
			if (selectFilter.contains("active")) {
				break;
			}
		}
	
		List<String> definedPendingActions = Arrays.asList("Pending BL Release Date Input", "Pending BL Assignment to Container", "Missing FCR #", "Missing Vendor Docs Received Date");
		List<String> matches = new ArrayList<>();
		List<String> noMatches = new ArrayList<>();
		for (int i = 0; i < definedPendingActions.size(); i++) {
			if (i==0) {
				WebElement scrollBar = driver.findElement(By.xpath("//div[@class='ag-body-horizontal-scroll-viewport']"));
				js.executeScript("arguments[0].scrollLeft += 350;", scrollBar);
				Thread.sleep(1000);
			}
			String pendingActionPosition = driver.findElement(By.xpath("//div[@col-id='pendingActions']")).getAttribute("aria-colindex");
			WebElement pendingActionInlineFilter = driver.findElement(By.xpath("//div[@aria-colindex='" + pendingActionPosition + "']//button[@aria-label='Open Filter Menu']/span"));
			wait.until(ExpectedConditions.visibilityOf(pendingActionInlineFilter));
			pendingActionInlineFilter.click();
			if (i==0) {
				WebElement selectAll = driver.findElement(By.xpath("//div[@ref='eLabel' and contains(text(),'Select All')]"));
				wait.until(ExpectedConditions.elementToBeClickable(selectAll));
				selectAll.click();
			}
			String pendingActionName = definedPendingActions.get(i);
			WebElement searchFilter = driver.findElement(By.xpath("//input[@ref='eInput' and @aria-label='Search filter values']"));
			searchFilter.sendKeys(pendingActionName);
			Thread.sleep(1000);
			try {
				WebElement element = driver.findElement(By.xpath("(//div[@ref='eLabel' and contains(text(),'" + pendingActionName + "')])[1]"));
				if (element.isDisplayed()) {
//					WebElement checkBox = driver.findElement(By.xpath("(//div[@ref='eLabel' and contains(text(),'" + pendingActionName + "')])[1]/following-sibling::div/input"));
//					wait.until(ExpectedConditions.elementToBeClickable(checkBox));
//					checkBox.click();
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					WebElement vizivOverviewShipKey = driver.findElement(By.xpath("(//div[@col-id='pendingActions' "
							+ "and contains(text(),'" + pendingActionName + "')])[1]/preceding-sibling::div[@col-id='shipKey']//a"));
					String parentWindow = driver.getWindowHandle();
					String overviewShipKey = vizivOverviewShipKey.getText();
					System.out.println(overviewShipKey);
					//js.executeScript("arguments[0].click();", vizivOverviewShipKey);
					boolean clicked = false;
					int attempts = 0;

					while (!clicked && attempts < 3) {
						try {
							vizivOverviewShipKey.click();
							clicked = true;
						} catch (Exception e) {
							attempts++;
							try {
								Thread.sleep(1000); // Wait for 1 second before retrying
							} catch (InterruptedException ie) {
								ie.printStackTrace();
							}
						}
					}

					if (!clicked) {
						System.out.println("Failed to click the element after multiple attempts.");
					}
					Thread.sleep(2000);
					Set<String> allWindowHandles = driver.getWindowHandles();
					for (String handle : allWindowHandles) {
						if (!handle.equals(parentWindow)) {
							driver.switchTo().window(handle);
							WebElement vmsDetailShipKey  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'ShipKey #:')]")));
							String detailShipKey = vmsDetailShipKey.getText();
							if (detailShipKey.contains(overviewShipKey)) {
								System.out.println("VIZIV redirected to shipment detail screen as expected");
							}
							String shipmentDetailPageTitle = driver.getTitle();
							if (shipmentDetailPageTitle.equalsIgnoreCase("Shipping")) {
								System.out.println("Shipment Detail Page is displayed");
								if (pendingActionName.equalsIgnoreCase("Pending BL Release Date Input")) {
									matches.add(pendingActionName);
									WebElement targetElement  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#shippingAddUpdateShipmentBLGrid_component']")));
									int elementPosition = targetElement.getLocation().getY();
									js.executeScript("window.scroll(0, " + elementPosition + ");");
									Thread.sleep(5000);
									WebElement releaseDate = driver.findElement(By.xpath("//ancestor::ag-grid-angular//div[@class='ag-body']//div[@colid='carrier_bl_release_date']/span"));
									String carrierBLReleaseDate = releaseDate.getText();
									if (carrierBLReleaseDate.isBlank() || carrierBLReleaseDate.isEmpty() || carrierBLReleaseDate==null || carrierBLReleaseDate.length()<0) {
										System.out.println("Carrier BL release date (mm/dd/yyyy) is empty as expected");
									} else {
										System.out.println("Carrier BL release date (mm/dd/yyyy) has date is " + carrierBLReleaseDate);
									}

								} else if (pendingActionName.equalsIgnoreCase("Pending BL Assignment to Container")) {
									matches.add(pendingActionName);
									WebElement targetElement  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#ShippingAddUpdateShipmentItemGrid_component']")));
									int elementPosition = targetElement.getLocation().getY();
									js.executeScript("window.scroll(0, " + elementPosition + ");");
									Thread.sleep(5000);
									List<WebElement> MBLNumber = driver.findElements(By.xpath("(//ancestor::ag-grid-angular//div[@class='ag-body']//div[@colid='masterbl_no']/span)[1]"));
									for (int j = 0; j < MBLNumber.size(); j++) {
										String MBL = MBLNumber.get(j).getText().trim();
										if (MBL.isBlank() || MBL.isEmpty() || MBL==null || MBL.length()<2) {
											System.out.println("Master BL# is empty as expected");
										} else {
											System.out.println("Master BL# is not empty as unepected");
										}
									}
								} else if (pendingActionName.equalsIgnoreCase("Missing FCR #") || pendingActionName.equalsIgnoreCase("Missing Vendor Docs Received Date")) {
									matches.add(pendingActionName);
									WebElement targetElement  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#ShippingAddUpdateShipmentItemGrid_component']")));
									int elementPosition = targetElement.getLocation().getY();
									js.executeScript("window.scroll(0, " + elementPosition + ");");
									Thread.sleep(5000);
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PO #']")));
									List<WebElement> FCRNumber = driver.findElements(By.xpath("(//ancestor::ag-grid-angular//div[@class='ag-body']//div[@colid='fcr_no'])[1]"));
									for (int l = 0; l < FCRNumber.size(); l++) {
										String FCR = FCRNumber.get(l).getText().trim();
										if (FCR.isBlank() || FCR.isEmpty() || FCR==null || FCR.length()<2) {
											System.out.println("FCRnumber is empty as expected for " + pendingActionName);
										} else {
											System.out.println("FCRnumber is not empty as unexpected for " + pendingActionName);
										}
									}
								}
							}
						}
					}
					driver.close(); 
					driver.switchTo().window(parentWindow);
					Thread.sleep(1000);
					//js.executeScript("window.scrollBy(1200, 0)");
					//WebElement scrollBar2 = driver.findElement(By.xpath("//div[@class='ag-body-horizontal-scroll-viewport']"));
					//js.executeScript("arguments[0].scrollLeft += 1200;", scrollBar2);
					//Thread.sleep(2000);
					String pendingActionPosition2 = driver.findElement(By.xpath("//div[@col-id='pendingActions']")).getAttribute("aria-colindex");
					WebElement pendingActionInlineFilter2 = driver.findElement(By.xpath("//div[@aria-colindex='" + pendingActionPosition2 + "']//button[@aria-label='Open Filter Menu']/span"));
					wait.until(ExpectedConditions.visibilityOf(pendingActionInlineFilter2));
					pendingActionInlineFilter2.click();
					WebElement element2 = driver.findElement(By.xpath("(//div[@ref='eLabel' and contains(text(),'" + pendingActionName + "')])[1]"));
					wait.until(ExpectedConditions.elementToBeClickable(element2));
					element2.click();
					WebElement searchFilter2 = driver.findElement(By.xpath("//input[@ref='eInput' and @aria-label='Search filter values']"));
					wait.until(ExpectedConditions.visibilityOf(searchFilter2));
					searchFilter2.clear();
					WebElement closeInlineFilter = driver.findElement(By.xpath("(//div[@aria-label='Column Menu']//span)[1]"));
					wait.until(ExpectedConditions.visibilityOf(closeInlineFilter));
					wait.until(ExpectedConditions.elementToBeClickable(closeInlineFilter));
					closeInlineFilter.click();
				} 
			} catch (NoSuchElementException e) {
				noMatches.add(pendingActionName);
				WebElement searchFilter3 = driver.findElement(By.xpath("//input[@ref='eInput' and @aria-label='Search filter values']"));
				wait.until(ExpectedConditions.visibilityOf(searchFilter3));
				//searchFilter3.clear();
				//js.executeScript("arguments[0].value='';", searchFilter3);
				searchFilter3.sendKeys(Keys.CONTROL + "a");
				searchFilter3.sendKeys(Keys.DELETE);
				WebElement closeInlineFilter = driver.findElement(By.xpath("(//div[@aria-label='Column Menu']//span)[1]"));
				wait.until(ExpectedConditions.visibilityOf(closeInlineFilter));
				wait.until(ExpectedConditions.elementToBeClickable(closeInlineFilter));
				closeInlineFilter.click();
			}	catch (Exception e) {
				System.out.println("Execution is stopped due to some error. Please try re-run.");
				driver.close();
			}
		}
		if (!matches.isEmpty() && !noMatches.isEmpty()) {
			System.out.println("Only " + matches + " was available in the grid and validated successfully. " + noMatches + " was not available.");
		} else if (!matches.isEmpty()) {
			System.out.println(matches + " was available in the grid and validated successfully.");
		} else if (!noMatches.isEmpty()) {
			System.out.println(noMatches + " was not available in the grid to validate.");
		}
		driver.close();
	}

}