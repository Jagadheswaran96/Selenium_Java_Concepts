package selenium_java;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginWithExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		WorkWithExcel_2 excel_2=new WorkWithExcel_2();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
		for (int i = 1; i <=4; i++) {
			String userName=excel_2.excelLogin("sheet1", i, 0);
			String passWord=excel_2.excelLogin("sheet1", i, 1);
			driver.findElement(By.id("username")).sendKeys(userName);
			driver.findElement(By.name("pwd")).sendKeys(passWord);
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(10000);
			driver.findElement(By.id("logoutLink")).click();
			Thread.sleep(10000);
		}
		
	}

}
