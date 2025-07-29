package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.generic.fileutility.ExcelUtility;

public class DataProviderFromExcel {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		// search product
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys(brandName, Keys.ENTER);

		// capture product info
		String x = "//div[text()='" + productName + "']/../../div[2]/div[1]/div[1]/div[1]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable {

		ExcelUtility elib = new ExcelUtility();
		int rowcount = elib.getLastRowCount("products");

		Object[][] objarr = new Object[rowcount][2];

		for (int i = 0; i < rowcount; i++) {
			objarr[i][0] = elib.getDataFromExcel("products", i + 1, 0);
			objarr[i][1] = elib.getDataFromExcel("products", i + 1, 1);

		}

		return objarr;

	}

}
