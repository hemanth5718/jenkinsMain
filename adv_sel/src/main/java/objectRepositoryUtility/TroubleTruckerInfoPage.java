package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTruckerInfoPage {

	WebDriver driver;
	 public TroubleTruckerInfoPage(WebDriver driver) { 
		this.driver = driver;
	 PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement header;
	
	
	public WebElement getHeader() {
		return header;
	}
}
