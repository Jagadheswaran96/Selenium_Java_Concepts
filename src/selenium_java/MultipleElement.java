package selenium_java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://krninformatix.com/");
		
		List<WebElement> AllWebElement=driver.findElements(By.xpath("//a"));
			int size=AllWebElement.size();
			
			for (int i = 0; i < size; i++) {
				WebElement all=AllWebElement.get(i);
				String text=all.getText();
				System.out.println(text);
				
			}
	}	

}
