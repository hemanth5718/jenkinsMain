package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
	
	WebDriver driver;
	public CreateNewContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNametxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="jscal_field_support_start_date")
	private WebElement startDateTxt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement addOrg;
	
	@FindBy(id = "search_txt")
	private WebElement windowSearchtxt;
	
	
	
	
	public WebElement getWindowSearchtxt() {
		return windowSearchtxt;
	}
	public WebElement getWindowSearchBtn() {
		return windowSearchBtn;
	}
	
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement windowSearchBtn;
	
	
	
	
	
	public WebElement getAddOrg() {
		return addOrg;
	}
	public WebElement getStartDateTxt() {
		return startDateTxt;
	}
	public WebElement getEndDateTxt() {
		return endDateTxt;
	}

	@FindBy(id="jscal_field_support_end_date")
	private WebElement endDateTxt;
	
	public WebElement getLastNametxt() {
		return lastNametxt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
