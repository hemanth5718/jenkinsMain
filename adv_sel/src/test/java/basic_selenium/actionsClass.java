package basic_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//h3[contains(text(),'Information')]"));
		//action.moveToElement(ele).perform();
		//action.scrollByAmount(0, 500).perform();
		
			action.scrollToElement(ele).perform();
		//driver.close();
		

	}

}
