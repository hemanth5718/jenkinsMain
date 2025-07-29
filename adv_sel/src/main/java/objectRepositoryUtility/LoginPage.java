package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//rule 1 create a  java class
	//rule 2 object creation
	
	WebDriver driver;
	public LoginPage(WebDriver driver) { 
		this.driver = driver;
	 PageFactory.initElements(driver,this);
	}
	
	@FindAll({@FindBy(name ="user_name"), @FindBy(xpath = "//input[@type='text']")})
   private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;

	//rule 3 object initialization  in test script
	
	//rule 4 object encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//provide action
	public void loginToApp(String url,String userName, String Password)
	{
		
		driver.get(url);
		usernameEdt.sendKeys(userName);
		passwordEdt.sendKeys(Password);
		submitBtn.click();	
	}

}
