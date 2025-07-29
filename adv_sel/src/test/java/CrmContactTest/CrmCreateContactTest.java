package CrmContactTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import objectRepositoryUtility.ContactInfoPage;
import objectRepositoryUtility.ContactsPage;
import objectRepositoryUtility.CreateNewContactsPage;
import objectRepositoryUtility.CreateNewOrganizationPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.OrganizationInfoPage;
import objectRepositoryUtility.OrganizationPage;

public class CrmCreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void crmCreateContactTest() throws Throwable {

		int rnum = jlib.getRandomNumber();

		String lastName = elib.getDataFromExcel("contact", 1, 2) + rnum;
		// home
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactbtn().click();

		CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
		ccp.getLastNametxt().sendKeys(lastName);

		ccp.getSaveBtn().click();

		// verify phone number
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actLastName = cip.getConConfirmation().getText();
		boolean status1 = actLastName.contains(lastName);
		Assert.assertEquals(status1, true);
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		int rnum = jlib.getRandomNumber();

		String orgname = elib.getDataFromExcel("contact", 7, 2) + rnum;
		String contactLastName = elib.getDataFromExcel("contact", 7, 3);

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
		boolean status2 = headerInfo.contains(orgname);
		Assert.assertEquals(status2, true);

		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactbtn().click();

		CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
		ccp.getLastNametxt().sendKeys(contactLastName);

		ccp.getAddOrg().click();

		wlib.switchToTabOnURL(driver, "Accounts&action");

		ccp.getWindowSearchtxt().sendKeys(orgname);
		ccp.getWindowSearchBtn().click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[.='" + orgname + "']")).click();

		wlib.switchToTabOnURL(driver, "Contacts&action");

		ccp.getSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(driver);
		String actOrgName = cip.getOrgConfirmation().getText();
		boolean status3 = actOrgName.contains(orgname);
		Assert.assertEquals(status3, true);
	}
	
	@Test(groups = {"smoke","regressionTest"})
	public void createContactWithSupportDateTest() throws Throwable {

		int rnum = jlib.getRandomNumber();

		String lastName = elib.getDataFromExcel("contact", 4, 2) + rnum;

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactbtn().click();

		String startdate = jlib.getSystemDateyyyymmdd();
		String enddate = jlib.getRequiredDateyyymmdd(30);

		CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
		ccp.getLastNametxt().sendKeys(lastName);

		ccp.getStartDateTxt().clear();
		ccp.getStartDateTxt().sendKeys(startdate);

		ccp.getEndDateTxt().clear();
		ccp.getEndDateTxt().sendKeys(enddate);

		ccp.getSaveBtn().click();

		// verify start date
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actStartDate = cip.getActStartDate().getText();
		boolean status4 = actStartDate.contains(startdate);
		Assert.assertEquals(status4, true);

		// verify end date
		String actEndtDate = cip.getActEndDate().getText();
		boolean status5 = actEndtDate.contains(enddate);

		Assert.assertEquals(status5, true);
	}
}
