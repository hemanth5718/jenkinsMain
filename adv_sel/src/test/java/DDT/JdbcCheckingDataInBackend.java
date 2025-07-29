package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JdbcCheckingDataInBackend {

	@Test
	public void jdbc() throws Throwable{
		
		Random random = new Random();
		int num = random.nextInt(1000);
		  String pname ="insta"+ num; 
		  String browser = System.getProperty("browser");
		  String url = System.getProperty("url"); 
		  String username = System.getProperty("username");
		  String password =System.getProperty("password");
		 
			
			 WebDriver driver=null; 
			  if(browser.equals("chrome")) 
			  { driver= new ChromeDriver(); 
			  }
			  else if (browser.equals("edge")) 
			  { driver= new EdgeDriver(); 
			  } 
			  else if (browser.equals("firefox")) 
			  { driver = new FirefoxDriver(); 
			  } 
			  else { driver= new ChromeDriver();
			  }
			 
		 
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-lg btn-block']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//i[@class='material-icons']")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[5]")).sendKeys(pname);
		driver.findElement(By.xpath("(//input[@class='form-control'])[7]")).sendKeys("hemanth");
		
		  WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		  ele.click();
		 Select sel = new Select(ele);
		 sel.selectByIndex(1);
		 
		 driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		 driver.close();
		 
			boolean flag = false;
			  Driver driverref = new Driver();
			  DriverManager.registerDriver(driverref);
			  Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root@%", "root"); 
			  Statement stat = conn.createStatement(); 
			  ResultSet result = stat.executeQuery("select * from project"); 
			  while (result.next())
			  {
			 String actProject = result.getString(4);
			 if (pname.equals(actProject))
			 {
				 flag= true;
				 System.out.println(pname+ "is availableis db");
			 }
			  }
			  
			  if(flag== false)
			  {
				  System.out.println(pname+" is not available== fail");
				  Assert.fail();
			  }
			  conn.close();
	}

}
