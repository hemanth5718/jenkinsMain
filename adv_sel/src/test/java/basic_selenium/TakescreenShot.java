package basic_selenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakescreenShot {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.yonex.com/badminton/racquets");
		/*
		 * TakesScreenshot ts = (TakesScreenshot)driver; File src =
		 * ts.getScreenshotAs(OutputType.FILE); File dst = new
		 * File("./screenshot/homepage.png"); FileHandler.copy(src, dst);
		 */
		             
		WebElement ele = driver.findElement(By.xpath("(//span[@class='product-image-wrapper'])[1]"));
					File src = ele.getScreenshotAs(OutputType.FILE);
					File dst = new File("./screenshot/racket.png");
					FileHandler.copy(src, dst);
		
		             driver.close();
		               
						
					

	}

}
