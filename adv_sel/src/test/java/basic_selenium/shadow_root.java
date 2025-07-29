package basic_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadow_root {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		SearchContext shadow = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		shadow.findElement(By.cssSelector("input[type='text']")).sendKeys("hemanth");
		//driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		//driver.findElement(By.xpath("//h1[contains(text(),'Login')]")).click();
		
		
		/*
		 * Actions action = new Actions(driver); action.sendKeys(Keys.TAB).perform();
		 * action.sendKeys("hemanth").perform();
		 */
		
		
		
		
		
		
		
	}

}
