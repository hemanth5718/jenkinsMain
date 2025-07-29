package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderScenario {
	
	@Test(dataProvider ="getData")
	public void getProductInfoTest(String brandName,String productName) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		//search product
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		String x="//div[text()='"+productName+"']/../../div[2]/div[1]/div[1]/div[1]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objarr = new Object[3][2];
		objarr[0][0]= "iphone";
		objarr[0][1]= "Apple iPhone 16 (White, 128 GB)";
		
		objarr[1][0]= "iphone";
		objarr[1][1]= "Apple iPhone 16 (Teal, 256 GB)";
		
		objarr[2][0]= "iphone";
		objarr[2][1]= "Apple iPhone 15 (Black, 128 GB)";
		
		return objarr;
		
	}
	
	

}
