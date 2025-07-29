package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderPage {
	WebDriver driver;
	public CalenderPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className =  "calAddButton")
	private WebElement addCalBtn;
	
	@FindBy(id =  "addmeeting")
	private WebElement mettingLink;
	
	@FindBy(xpath =  "//input[@name='subject']")
	private WebElement windowEventName;
	
	@FindBy(id =  "starthr")
	private WebElement windowEventStartDD;
	
	@FindBy(id =  "availableusers")
	private WebElement windowAvailableUser;
	
	@FindBy(xpath =  "(//input[@class='crm button small save'])[2]")
	private WebElement saveBtn;
	
	
	
	public WebElement getWindowEventName() {
		return windowEventName;
	}
	public WebElement getWindowEventStartDD() {
		return windowEventStartDD;
	}
	public WebElement getWindowAvailableUser() {
		return windowAvailableUser;
	}
	public WebElement getMettingLink() {
		return mettingLink;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getAddCalBtn() {
		return addCalBtn;
	}

}
