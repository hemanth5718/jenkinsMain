package basic_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class select_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/books");
		WebElement position = driver.findElement(By.id("products-orderby"));
		 
		Select sel = new Select(position);
		  sel.selectByVisibleText("Name: A to Z");
		
		 WebElement pos = driver.findElement(By.id("products-pagesize"));
		 
		 Select se = new Select(pos);
		  se.selectByVisibleText("12");
		  
		  

	}

}
