package selenium_java;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrintGoogleSuggestions {
	
	static Logger logger=Logger.getLogger(PrintGoogleSuggestions.class);

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		logger.info("browser will be launched");
				
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		logger.info("browser launched");
		
		driver.findElement(By.name("q")).sendKeys("jagadhes");
		List<WebElement> suggestions=driver.findElements(By.xpath("//ul[@role='listbox']//following::li"));
		
		for (WebElement element : suggestions) {
			System.out.println("suggestions are" + element.getText());
		}
		logger.info("suggtesion are printed");
	}

}
