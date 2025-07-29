package mock;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class flipkart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		 WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		//WebElement ele1 = driver.findElement(By.xpath("//div[@id='toast-ctn']"));
		//action.moveToElement(ele1).perform();
		//Thread.sleep(4000);
		WebElement ele2 = driver.findElement((By.xpath("(//a[@class='_3490ry'])[2]")));
		action.moveToElement(ele2).perform();
		ele2.click();
		
		driver.close();
				
				

	}

}
