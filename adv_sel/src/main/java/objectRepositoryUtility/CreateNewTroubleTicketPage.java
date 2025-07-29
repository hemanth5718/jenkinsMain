package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTroubleTicketPage {
	
	WebDriver driver;
	 public CreateNewTroubleTicketPage(WebDriver driver) { 
		this.driver = driver;
	 PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//textarea[@name='ticket_title']")
	private WebElement troubleTicketTxt;
	
	@FindBy(xpath ="(//input[@type='radio'])[2]")
	private WebElement assignedRadioBtn;
	
	@FindBy(xpath ="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement newContactsIcon;
	
	@FindBy(id ="search_txt")
	private WebElement windowSearchTxt;
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement windowSearchBtn;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement  saveBtn;
	
	
	public WebElement getTroubleTicketTxt() {
		return troubleTicketTxt;
	}

	public WebElement getAssignedRadioBtn() {
		return assignedRadioBtn;
	}

	public WebElement getNewContactsIcon() {
		return newContactsIcon;
	}

	public WebElement getWindowSearchTxt() {
		return windowSearchTxt;
	}

	public WebElement getWindowSearchBtn() {
		return windowSearchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	
	

}
