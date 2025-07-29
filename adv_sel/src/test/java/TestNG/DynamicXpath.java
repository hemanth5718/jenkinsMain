package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import crm.generic.fileutility.ExcelUtility;
import crm.generic.fileutility.FileUtility;
import crm.generic.webdriverutility.JavaUtility;
import crm.generic.webdriverutility.WebDriverUtility;
import objectRepositoryUtility.CreateNewOrganizationPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LoginPage;
import objectRepositoryUtility.OrganizationInfoPage;
import objectRepositoryUtility.OrganizationPage;

public class DynamicXpath {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib= new FileUtility(); 
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		  String browser = flib.getDataFromPropertiesFile("browser");
		  String url = flib.getDataFromPropertiesFile("url"); 
		  String username = flib.getDataFromPropertiesFile("username");
		  String password = flib.getDataFromPropertiesFile("password");
		  
		int rnum = jlib.getRandomNumber();
		  
		  String orgname = elib.getDataFromExcel("org", 1, 2)+ rnum;
		  	
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
		  
		  wlib.maxWindow(driver);
		  wlib.waitForPageLoad(driver);
		  
		 LoginPage lp = new LoginPage(driver);
		 
		 lp.loginToApp(url,username, password);
		  
		  //Organization
		 HomePage hp = new HomePage(driver);
		 hp.getOrganizationLink().click();
		  
		  OrganizationPage op = new OrganizationPage(driver);
		  op.getCreatingOrganization().click();
		  
		 CreateNewOrganizationPage cno= new CreateNewOrganizationPage(driver);
		 cno.getOrgName().sendKeys(orgname);;
		 
		 cno.getSaveBtn().click();
		  
		  //verify expected result 
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeader().getText();
		
		if(headerInfo.contains(orgname)) {
			System.out.println(orgname + " is created == pass");
		}
		else{
			System.out.println(orgname + " is not created == pass");
		}
		  //verify orgName 
		String actualOrgName = oip.getActOrgName().getText();
		if(actualOrgName.contains(orgname)) {
			System.out.println(orgname + " is created == pass");
		}
		else{
			System.out.println(orgname + " is not created == pass");
		}
		
		hp.getOrganizationLink().click();
		
		  op.getSearchForOrg().sendKeys(orgname);
		WebElement ele = op.getSeatchDD();
		wlib.select(ele, "Organization Name");
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		
		  
		driver.quit();
	}

}
