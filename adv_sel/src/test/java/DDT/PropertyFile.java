package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFile {

	public static void main(String[] args) throws IOException   {

		
		FileInputStream fis = new FileInputStream("C:\\Users\\heman\\Downloads\\ddt.properties");
		  Properties p = new Properties(); 
		  p.load(fis); 
		  String browser = p.getProperty("Browser"); 
		  String url = p.getProperty("Url"); 
		  String name = p.getProperty("Name"); 
		  String email = p.getProperty("Email"); 
		  String phone = p.getProperty("Phone");
		  
		  WebDriver driver = null; 
		  if (browser.equals("chrome")) 
		  { 
			  driver = new ChromeDriver(); 
		  } 
		  else if (browser.equals("firefox")) 
		  { 
			  driver = new FirefoxDriver(); 
		  } 
		  else if (browser.equals("edge"))
		  { 
			  driver = new EdgeDriver();
		  } 
		  else 
		  { 
			  driver = new ChromeDriver();
		  } 
		  driver.manage().window().maximize();
		  driver.get(url);
		  driver.findElement(By.id("name")).sendKeys(name);
		  driver.findElement(By.id("email")).sendKeys(email);
		  driver.findElement(By.id("phone")).sendKeys(phone);
		  driver.close();
	}

}
