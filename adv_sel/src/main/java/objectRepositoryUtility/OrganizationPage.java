package objectRepositoryUtility;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//rule 1 create a  java class
			//rule 2 object creation
			
			WebDriver driver;
			public OrganizationPage(WebDriver driver) { 
				this.driver = driver;
			 PageFactory.initElements(driver,this);
			}
			
			@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
			private WebElement creatingOrganization;
			
			@FindBy(className = "txtBox")
			private WebElement searchForOrg;
			
			@FindBy(id="bas_searchfield")
			private WebElement seatchDD;
			
			@FindBy(name = "submit")
			private WebElement searchBtn;
			
			
			@FindBy(xpath = "//a[@title='Organizations']")
			private List<WebElement> allOrganization;
			
			@FindBy(xpath = "(//img[@src='themes/images/next.gif'])[2]")
			private WebElement nextBtn;
			//rule 3 object initialization  in test script
			
			//rule 4 object encapsulation
			
			
			public WebElement getNextBtn() {
				return nextBtn;
			}

			public List<WebElement> getAllOrganization() {
				return allOrganization;
			}

			public WebElement getSearchBtn() {
				return searchBtn;
			}

			public WebElement getSeatchDD() {
				return seatchDD;
			}

			public WebElement getSearchForOrg() {
				return searchForOrg;
			}

			public WebElement getCreatingOrganization() {
				return creatingOrganization;
			}

			

	
}
