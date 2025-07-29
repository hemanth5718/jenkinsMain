package basic_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsexecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("file:///C:/Users/heman/OneDrive/Desktop/js.html");
		driver.get("https://www.yonex.com/badminton/racquets");
		driver.findElement(By.xpath("(//*[local-name()='svg'])[3]")).click();
		
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('search').value='muscle power';");
		

	}

}
