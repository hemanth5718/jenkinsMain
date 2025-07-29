package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	public ContactsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//finding
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
    private WebElement createContactbtn;
	
	
	public WebElement getCreateContactbtn() {
		return createContactbtn;
	}
	
	
	
	
}
