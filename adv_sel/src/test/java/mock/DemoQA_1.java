package mock;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DemoQA_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.id("messageWindowButton"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
		String parent = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for(String handles:allwindow) 
		{
			driver.switchTo().window(handles);
			if (!parent.equals(handles)) 
			{
				WebElement ele = driver.findElement(By.tagName("body"));
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//wait.until(ExpectedConditions.visibilityOf(ele));
				String txt = ele.getText();
				System.out.println(txt);
				driver.close();
		}
		}
		}
	}


