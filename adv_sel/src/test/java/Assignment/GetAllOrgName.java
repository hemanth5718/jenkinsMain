package Assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.OrganizationPage;

public class GetAllOrgName extends BaseClass {

	@Test
	public void getAllOrgName() throws Throwable {

		wlib.maxWindow(driver);
		wlib.waitForPageLoad(driver);

		// Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		List<WebElement> ele = op.getAllOrganization();
		
			for (int i=0;i<=333;i++)
			{
				for (WebElement e : ele) 
				{
					String allo = e.getText();
					System.out.println(allo);
				}
				Thread.sleep(5000);
				op.getNextBtn().click();
			
			}
			
		}
	}

