package basic_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class relative_Locators {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.yonex.com/badminton");
		
		//driver.findElement(RelativeLocator.with(By.id("vesitem-451750289360912865313"))
	//			.toLeftOf(By.id("vesitem-51750289360707370775"))).click();
           driver.findElement(RelativeLocator.with(By.xpath("//a[contains(text(),'Racquets')]")).
        		   above(By.xpath("//a[contains(text(),'Strings')]"))).click();
		
	}

}
