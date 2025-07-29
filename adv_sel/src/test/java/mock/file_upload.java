package mock;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class file_upload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 700);
		WebElement ele = driver.findElement(By.id("singleFileInput"));
		ele.sendKeys("‪C:\\Users\\heman\\OneDrive\\Desktop\\relative locators.txt");
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		
		

	}

}
