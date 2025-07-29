package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement conConfirmation;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement ActStartDate;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement ActEndDate;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgConfirmation;
	
	
	public WebElement getOrgConfirmation() {
		return orgConfirmation;
	}


	public WebElement getConConfirmation() {
		return conConfirmation;
	}


	public WebElement getActStartDate() {
		return ActStartDate;
	}


	public WebElement getActEndDate() {
		return ActEndDate;
	}
	
	

}
