package mock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import crm.generic.webdriverutility.WebDriverUtility;

public class flipkartFirstMock {

	@Test
	public void flipKart() {
		
		WebDriverUtility  wlib = new WebDriverUtility();
		
 		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		wlib.maxWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Men')]")).click();
		driver.findElement(By.xpath("//a[@title='T-Shirts']")).click();
		driver.findElement(By.xpath("//div[@data-id='TSHH9FFHCEX4X7KB']")).click();
		wlib.switchToTabOnURL(driver, "tripr-striped-men-polo-neck-beige-t-shirt");
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		wlib.switchToTabOnURL(driver, "clothing-and-accessories/topwear");
		driver.findElement(By.xpath("//a[@class='_9Wy27C']")).click();
		WebElement priceElement = driver.findElement(By.xpath("//span[@class='LAlF6k re6bBo']"));
		String priceText = priceElement.getText().replaceAll("₹", ""); 
		 int price = Integer.parseInt(priceText);
		 int expected = price+4;
		 System.out.println(expected);
		 WebElement priceEle = driver.findElement(By.xpath("//div[@class='_1Y9Lgu']"));
		 String pricetxt = priceEle.getText().replaceAll("₹", ""); 
		 int actual = Integer.parseInt(pricetxt);
		 System.out.println(actual);

		 Assert.assertEquals(actual,expected);
		 driver.quit();
		
	}
	
}
