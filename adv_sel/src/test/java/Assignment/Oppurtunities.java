package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import objectRepositoryUtility.CreateNewOpportunityPage;
import objectRepositoryUtility.CreateNewOrganizationPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.OpportunityInfoPage;
import objectRepositoryUtility.OrganizationInfoPage;
import objectRepositoryUtility.OrganizationPage;
import objectRepositoryUtility.opportunityPage;

public class Oppurtunities extends BaseClass {

	@Test
	public void oppurtunities() throws Throwable {

		int rnum = jlib.getRandomNumber();

		String oppname = elib.getDataFromExcel("opportunities", 1, 2) + rnum;
		String orgname = elib.getDataFromExcel("opportunities", 1, 3) + rnum;

		// org
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreatingOrganization().click();

		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.getOrgName().sendKeys(orgname);
		cop.getSaveBtn().click();

		// verify expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeader().getText();
		if (headerInfo.contains(orgname)) {
			System.out.println(orgname + " is created == pass");
		} else {
			System.out.println(orgname + " is not created == fail");
		}

		// opp
		hp.getOpportunityLink().click();

		opportunityPage opp = new opportunityPage(driver);
		opp.getCreateOpportunitytbtn().click();

		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.getOpportunityNametxt().sendKeys(oppname);
		cnop.getNewOrgName().click();

		wlib.switchToTabOnURL(driver, "Accounts&action");

		cnop.getWindowSearchTxtx().sendKeys(orgname);
		cnop.getWindowSearchBtn().click();
		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();

		wlib.switchToTabOnURL(driver, "Contacts&action");
		WebElement ele = cnop.getAssignToDD();
		ele.click();

		wlib.select(ele, 2);
		String enddate = jlib.getRequiredDateyyymmdd(30);

		cnop.getExpectedEndDateDD().clear();
		cnop.getExpectedEndDateDD().sendKeys(enddate);

		WebElement ele2 = cnop.getSalesStageDD();
		ele2.click();
		wlib.select(ele2, 1);
		Thread.sleep(2000);
		cnop.getSaveBtn().click();

		// verify opp
		OpportunityInfoPage noip = new OpportunityInfoPage(driver);
		String actualOpp = noip.getHeader().getText();
		if (actualOpp.contains(oppname)) {
			System.out.println(oppname + " opportunity is created == pass");
		} else {
			System.out.println(oppname + " opportunity is not created == pass");
		}
	}

}
