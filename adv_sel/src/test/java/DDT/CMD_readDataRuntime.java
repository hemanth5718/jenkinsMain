package DDT;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CMD_readDataRuntime {

		@Test
		public void seleniumTest() throws Throwable
		{
			
			String browser = System.getProperty("browser");
			String url = System.getProperty("url");
			String un = System.getProperty("username");
			String pass = System.getProperty("password");
			
			WebDriver driver = null;
			if(browser.equals("chrome")) {
				driver = new ChromeDriver();
			}
			else if (browser.equals("edge"))
			{
			    driver= new EdgeDriver();
			}
			else if (browser.equals("firefox"))
			{
			  driver = new FirefoxDriver();
			}
			else
			{
			 driver	= new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pass);
			driver.findElement(By.id("submitButton")).click();
			
			driver.close();
			
			
		}

	}


