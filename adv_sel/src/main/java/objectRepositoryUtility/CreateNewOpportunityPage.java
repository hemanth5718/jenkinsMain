package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunityPage {
	
	WebDriver driver;
	
	public CreateNewOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement opportunityNametxt;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement newOrgName;
	
	@FindBy(id = "search_txt")
	private WebElement windowSearchTxtx;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement windowSearchBtn;
	
	@FindBy(xpath = "//select[@name='assigned_user_id']")
	private WebElement assignToDD;
	
	@FindBy(id ="jscal_field_closingdate")
	private WebElement expectedEndDateDD;
	
	@FindBy(xpath ="//select[@name='sales_stage']")
	private WebElement salesStageDD;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getExpectedEndDateDD() {
		return expectedEndDateDD;
	}

	public WebElement getSalesStageDD() {
		return salesStageDD;
	}

	public WebElement getWindowSearchTxtx() {
		return windowSearchTxtx;
	}

	public WebElement getWindowSearchBtn() {
		return windowSearchBtn;
	}

	public WebElement getAssignToDD() {
		return assignToDD;
	}

	public WebElement getOpportunityNametxt() {
		return opportunityNametxt;
	}

	public WebElement getNewOrgName() {
		return newOrgName;
	}

}
