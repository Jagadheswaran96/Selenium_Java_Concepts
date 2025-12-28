package selenium_java;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriveTestDataUsingHashMap {
	
	//creating user data
	public static HashMap<String, String> testData() {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Mani", "admin:manager");
		hashMap.put("Eesa", "admin:manager");
		hashMap.put("Ranjith", "admin:manager");
		hashMap.put("Vishnu", "admin:manager");
		return hashMap;
	}
	
	public static String userName(String uName) {
		String credentials = testData().get(uName);
		return credentials.split(":")[0];
	}
	
	public static String passWord(String pWord) {
		String credentials = testData().get(pWord);
		return credentials.split(":")[1];
	}

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.actitime.com/login.do");
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(userName("Mani"));
		WebElement passWord = driver.findElement(By.name("pwd"));
		passWord.sendKeys(passWord("Mani"));
		WebElement loginButton = driver.findElement(By.id("loginButton"));
		loginButton.sendKeys(Keys.ENTER);
	}

}
