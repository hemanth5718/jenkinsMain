package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement header;
	
	@FindBy(id= "dtlview_Organization Name")
	private WebElement actOrgName;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement indName;
	
	@FindBy(id="mouseArea_Type")
	private WebElement indType;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phoneNum;
	
	//encapsulation
	
	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getIndType() {
		return indType;
	}

	public WebElement getIndName() {
		return indName;
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}
	

	
	

}
