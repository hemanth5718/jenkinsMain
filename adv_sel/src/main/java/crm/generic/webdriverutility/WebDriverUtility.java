package crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialUrl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext())
		{
			String windowsID = it.next();
			driver.switchTo().window(windowsID);
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver, String partialTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext())
		{
			String windowsID = it.next();
			driver.switchTo().window(windowsID);
			
			String actUrl = driver.getTitle();
			if(actUrl.contains(partialTitle)) {
				break;
			}
		}
	}
	
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void deSelect(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	public void deSelectAll(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}
	
	
	public void mouseMoveOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void dradAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	public void scrollByAmount(WebDriver driver, int x, int y )
	{
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element )
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element )
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void keyDownShift(WebDriver driver, WebElement element )
	{
		Actions act = new Actions(driver);
		act.keyDown(element, Keys.SHIFT).keyUp(Keys.SHIFT).perform();	
	}
	public void sendKeys(WebDriver driver, String dataToPass )
	{
		Actions act = new Actions(driver);
		act.sendKeys(dataToPass).perform();	
	}
	
	public void keyUPShift(WebDriver driver, WebElement element )
	{
		Actions act = new Actions(driver);
		act.keyUp(element, Keys.SHIFT).keyUp(Keys.SHIFT).perform();	
	}

	public void disableNotification()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	}
	
	
	public void takeScreenShotOfPage(WebDriver driver,String location) throws IOException
	{
		
		  TakesScreenshot ts = (TakesScreenshot)driver; 
		  File src = ts.getScreenshotAs(OutputType.FILE); 
		  File dst = new File(location); 
		  FileHandler.copy(src, dst);	 
	}
	public void takeScreenShotOfElement(WebDriver driver,WebElement element,String location) throws IOException
	{ 
		  File src = element.getScreenshotAs(OutputType.FILE); 
		  File dst = new File(location); 
		  FileHandler.copy(src, dst);	 
	}
	
	
	public void javaScriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
	public void selectFirstOpt (WebElement element)
	{
		Select sel = new Select(element);
		sel.getFirstSelectedOption();
	}
	
	
	public void maxWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
