package basic_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/heman/OneDrive/Desktop/ifram.html");
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("pollanswers-1")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("(//a[contains(text(),'Google')])[1]")).click();
		//driver.switchTo().parentFrame();
		//driver.findElement(By.id("name")).sendKeys("hemanth");
		
	//	driver.quit();
		
		

	}

}
