package CrmOrgTest;
/**
 * 
 * @author heman
 * 
 **/
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;
import crm.generic.webdriverutility.UtilityClassObject;
import objectRepositoryUtility.CreateNewOrganizationPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.OrganizationInfoPage;
import objectRepositoryUtility.OrganizationPage;


public class CreateOrg extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrg() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		int rnum = jlib.getRandomNumber();
		String orgname = elib.getDataFromExcel("org", 1, 2) + rnum;

		// Organization
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreatingOrganization().click();

		UtilityClassObject.getTest().log(Status.INFO,"Create new org");
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.getOrgName().sendKeys(orgname);
		;

		cno.getSaveBtn().click();

		// verify expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeader().getText();
		boolean status1 = headerInfo.contains(orgname);
		Assert.assertEquals(status1, false);
		
		// verify orgName
		String actualOrgName = oip.getActOrgName().getText();
		boolean status2 = actualOrgName.contains(orgname);
		Assert.assertEquals(status2, true);

	}

	@Test(groups = "regressionTest")
	public void CreateOrgWithIndustry() throws Throwable {

		int rnum = jlib.getRandomNumber();

		String orgname = elib.getDataFromExcel("org", 4, 2) + rnum;
		String indName = elib.getDataFromExcel("org", 4, 3);
		String indType = elib.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreatingOrganization().click();

		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.getOrgName().sendKeys(orgname);
		;
		WebElement ele = cop.getIndustrytxt();
		wlib.select(ele, indName);

		WebElement ele2 = cop.getIndType();
		wlib.select(ele2, indType);

		cop.getSaveBtn().click();
		;

		// verify industry name
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String industryName = oip.getIndName().getText();
		boolean status4 = industryName.contains(indName);
		Assert.assertEquals(status4, true);
	
		// verify industry type
		String industryType = oip.getIndType().getText();
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(industryType, indType);
		sf.assertAll();

	}

	@Test(groups = "regressionTest")
	public void CreateOrgWithPhNo() throws Throwable {

		int rnum = jlib.getRandomNumber();

		String orgname = elib.getDataFromExcel("org", 7, 2) + rnum;
		String phoneNo = elib.getDataFromExcel("org", 7, 3);

		// Home page
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		// Organization page
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreatingOrganization().click();

		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.getOrgName().sendKeys(orgname);

		cop.getPhoneNo().sendKeys(phoneNo);

		cop.getSaveBtn().click();

		// verify phone number

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhoneNum = oip.getPhoneNum().getText();
	boolean status3	= actPhoneNum.contains(phoneNo);
		Assert.assertEquals(status3, true);

	}
}
