package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import crm.generic.databaseutility.copy.DataBaseUtility;
import crm.generic.fileutility.ExcelUtility;
import crm.generic.fileutility.FileUtility;
import crm.generic.webdriverutility.JavaUtility;
import crm.generic.webdriverutility.UtilityClassObject;
import crm.generic.webdriverutility.WebDriverUtility;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.LoginPage;

public class BaseClass {

	public DataBaseUtility dblib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver edriver = null;

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws Throwable {
		System.out.println("===connect to Db , Report config===");
		dblib.getDBconnection();
	}

	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	//public void configBC() throws Throwable {
		public void configBC(@Optional("chrome")String browser) throws Throwable {
		//String browser
		System.out.println("==launch the Browser==");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
				//flib.getDataFromPropertiesFile("browser");
				//browser;
				
		if (BROWSER.equals("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if (BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		} 
		else if (BROWSER.equals("edge")) 
		{
			driver = new EdgeDriver();
		} 
		else {
			driver = new ChromeDriver();
		}
		edriver= driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("===login===");

		  wlib.maxWindow(driver);
		  wlib.waitForPageLoad(driver);
		String url = flib.getDataFromPropertiesFile("url"); 
		  String username = flib.getDataFromPropertiesFile("username");
		  String password = flib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url,username,password );
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("==logout==");
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp();
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("==close the browser==");
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAs() throws Throwable {
		System.out.println("==disconnected to Db, Backup the report==");
		dblib.closeDbconnect();
	}

}
