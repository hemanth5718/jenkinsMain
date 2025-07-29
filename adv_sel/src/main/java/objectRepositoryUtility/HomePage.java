package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.generic.webdriverutility.WebDriverUtility;
/**
 * @author heman
 */
public class HomePage {
	
	//rule 1 create a  java class
		//rule 2 object creation
		
		WebDriver driver;
		public HomePage(WebDriver driver) { 
			this.driver = driver;
		 PageFactory.initElements(driver,this);
		}
		
		@FindBy(linkText="Organizations")
		private WebElement organizationLink;
		
		@FindBy(linkText = "Contacts")
		private  WebElement contactLink;
		
		@FindBy(linkText = "Opportunities")
		private WebElement opportunityLink;
		
		@FindBy(linkText = "Products")
		private WebElement productsLink;
		
		@FindBy(linkText = "Trouble Tickets")
		private WebElement troubleTicketsLink;
		
		@FindBy(xpath="//img[@alt='Open Calendar...']")
		private WebElement calenderIcon;
		
		@FindBy(xpath="//a[contains(text(),'16')]")
		private WebElement selectDate;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement logoutlogo;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signoutBtn;
		
		
		
		
		
		
		
		//rule 3 object initialization  in test script
		
		public WebElement getSignoutBtn() {
			return signoutBtn;
		}

		public WebElement getLogoutlogo() {
			return logoutlogo;
		}

		public WebElement getCalenderIcon() {
			return calenderIcon;
		}

		public WebElement getSelectDate() {
			return selectDate;
		}

		public WebElement getTroubleTicketsLink() {
			return troubleTicketsLink;
		}

		public WebElement getProductsLink() {
			return productsLink;
		}

		public WebElement getOpportunityLink() {
			return opportunityLink;
		}

		public WebElement getContactLink() {
			return contactLink;
		}

		//rule 4 object encapsulation
		public WebElement getOrganizationLink() {
			return organizationLink;
		}
		
		public void logoutOfApp()
		{
			WebDriverUtility wlib = new WebDriverUtility();
			WebElement ele = logoutlogo;
			wlib.mouseMoveOnElement(driver, ele);
			signoutBtn.click();
					
		}
		
	


}
