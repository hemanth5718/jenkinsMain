package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	
	//rule 1 create a  java class
	//rule 2 object creation
	
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(xpath ="//input[@name='accountname']")
	private WebElement ORGNametxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industrytxt;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement indType;
	
	@FindBy(id = "phone")
	private WebElement phoneNo;
	
	//rule 3 object initialization  in test script
	
	//rule 4 object encapsulation

	public WebElement getPhoneNo() {
		return phoneNo;
	}

	public WebElement getIndType() {
		return indType;
	}

	public WebElement getIndustrytxt() {
		return industrytxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgName() {
		return ORGNametxt;
	}

	
}
