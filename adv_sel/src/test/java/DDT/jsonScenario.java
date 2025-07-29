package DDT;

import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class jsonScenario {
	@Test
	public void seleniumTest() throws Throwable
	{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\heman\\OneDrive\\Desktop\\ddt\\commonData.json"));
		 JSONObject map = (JSONObject)obj;
		 
		
		String browser = map.get("browser").toString();
		String url = map.get("url").toString();
		String un = map.get("username").toString();
		String pass = map.get("password").toString();
		
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
