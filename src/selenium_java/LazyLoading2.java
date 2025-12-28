package selenium_java;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LazyLoading2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Jagadhez\\Downloads\\edgedriver_win64\\msedgedriver.exe");

		//EdgeOptions options = new EdgeOptions();
		//options.setPageLoadStrategy("PageLoadStrategy.NORMAL");

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.testcenturyvms.com/ui/dashboard/customer");
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

//		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Actions actions = new Actions(driver);
		
		List<String> expectedColumnsID = Arrays.asList("itemNumber", "poNumber", "purchaseOrderItem.purchaseOrder.vendor.vendorName", 
				"itemDescription","units","masterBLNumber","houseBLNumber","commercialInvoiceNumber","cartons","weight","volumes");
		
		List<String> expectedColumnsName = Arrays.asList("Item #", "PO #", "Vendor", 
				"Description","Qty","MBL #","HBL #","Commercial Invoice #","Cartons","Weight (KG)","Volume (CBM)");
		
		try {

			WebElement firstColumnHeader = driver.findElement(By.xpath("//cds-ui-container-item-view//*[@col-id='itemNumber' and @role='columnheader']"));
			firstColumnHeader.click();
			
			int i = 0;
						
			do {
				
				for (int j = 0; j < expectedColumnsID.size(); j++) {
					
					String expectedColumnHeader = expectedColumnsID.get(j);
					
					WebElement columnHeader = driver.findElement(By.xpath("//cds-ui-container-item-view//*[@col-id='"+expectedColumnHeader+"' and @role='columnheader']//span[@ref='eText']"));
					
					String actualColumnName = columnHeader.getText();
					
					if (actualColumnName.equalsIgnoreCase(expectedColumnsName.get(j))) {

						System.out.println("Verified: " + expectedColumnHeader + " is available in grid");
						
					} else {
						
						System.out.println("Verified: " + expectedColumnHeader + " is not available in grid");
					}
					
					//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
					//WebElement nextColumn = driver.findElement(By.xpath("//cds-ui-container-item-view//*[@col-id='"+expectedColumnsName.get(j+1)+"' and @role='columnheader']//span[@ref='eText']"));
					//actions.click(nextColumn).sendKeys(Keys.TAB).perform();
					actions.sendKeys(Keys.TAB);
					
					//WebElement currentHeader = driver.switchTo().activeElement();

					//System.out.println("Verified: " + currentHeader.getText());
					
					}
				
				expectedColumnsID.remove(i); 
				
				i++;
				
			} while (expectedColumnsID.isEmpty());

//			for (int i = 0; i < expectedColumnsName.size(); i++) {
//				
//				for (int j = 0; j < expectedColumnsID.size(); j++) {
//					
//				String expectedColumnHeader = expectedColumnsID.get(j);
//				
//				WebElement findColumnHeader = driver.findElement(By.xpath("//cds-ui-container-item-view//*[@col-id='"+expectedColumnHeader+"' and @role='columnheader']//span[@ref='eText']"));
//				
//				String actualColumnName = findColumnHeader.getText();
//				
//				if (actualColumnName.equalsIgnoreCase(expectedColumnsName.get(i))) {
//
//					System.out.println("Verified: " + expectedColumnsName.get(i) + " is available in grid");
//					
//				} else {
//					
//					System.out.println("Verified: " + expectedColumnsName.get(i) + " is not available in grid");
//				}
//
//				firstColumnHeader.sendKeys(Keys.TAB);
//
//				WebElement currentHeader = driver.switchTo().activeElement();
//
//				System.out.println("Verified: " + currentHeader.getText());
//				
//				}
//			}

		} finally {
			
			driver.quit();
		}

	}

}
