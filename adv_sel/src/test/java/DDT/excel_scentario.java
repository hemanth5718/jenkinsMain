package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class excel_scentario {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\heman\\OneDrive\\Desktop\\ddt\\ddt.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("Url");
		String un = prop.getProperty("Uname");
		String pass = prop.getProperty("Pass");
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\heman\\OneDrive\\Desktop\\ddt\\ddt_excel.xlsx");
		  Workbook wf = WorkbookFactory.create(fis1); 
		  Sheet sh = wf.getSheet("Sheet1");
		 Row rw = sh.getRow(1);
		Cell cel = rw.getCell(1);
		 String data = cel.getStringCellValue();
		
		
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
		driver.findElement(By.xpath("//a[contains(text(),'Organizations')]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		Random random = new Random();
		int randomnum = random.nextInt(100);
		
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data + randomnum );
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
		Row sh1 = sh.getRow(1);
		Cell cel1 = sh1.createCell(2);
		cel1.setCellType(CellType.STRING);
		cel1.setCellValue("Pass");
		
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\heman\\\\OneDrive\\\\Desktop\\\\ddt\\\\ddt_excel.xlsx");
				wf.write(fos);
		wf.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
