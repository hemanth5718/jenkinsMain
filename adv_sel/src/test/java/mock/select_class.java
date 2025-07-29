package mock;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class select_class {
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://candymapper.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[local-name()='svg'])[18]")).click();
		Thread.sleep(4000);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1000)");
		 driver.switchTo().frame(1);
		 WebElement fr = driver.findElement(By.id("tCounty"));
	 fr.click();
	 Thread.sleep(1000);
	 Select s = new Select(fr);
	 s.selectByIndex(3);
	 driver.close();
			
	}

}
