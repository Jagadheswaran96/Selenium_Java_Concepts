package selenium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/poco-x3-cobalt-blue-64-gb/p/itme71cba415d626?pid=MOBFVQJ5K89TYFXR&lid="
				+ "LSTMOBFVQJ5K89TYFXRFJRVJ1&marketplace=FLIPKART&store=tyy%2F4io&srno=b_1_1&otracker=hp_bannerads_"
				+ "5_2.bannerAdCard.BANNERADS_cat-mob-hpw7-POCOX3_6ZXS7QU9IC4X&fm=organic&iid=93f88526-5415-4695-8958-"
				+ "c077a4bd6d58.MOBFVQJ5K89TYFXR.SEARCH&ppt=hp&ppn=homepage&ssid=aujbxrayzgx7m29s1617250811854");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("(//span[@class='question'])[1]")).click();
		String text = driver.findElement(By.xpath("//div[@class='_3ELZs9']")).getText();
		System.out.println(text);
		
	}

}
