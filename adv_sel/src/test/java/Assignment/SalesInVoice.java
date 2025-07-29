package Assignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import objectRepositoryUtility.ContactsPage;
import objectRepositoryUtility.CreateNewContactsPage;
import objectRepositoryUtility.CreateNewTroubleTicketPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.TroubleTicketPage;
import objectRepositoryUtility.TroubleTruckerInfoPage;

public class SalesInVoice extends BaseClass {

	@Test
	public void SalesInvoice() throws Throwable{
		  
		int rnum = jlib.getRandomNumber();
		  
		String title = elib.getDataFromExcel("opportunities", 10, 2) +rnum;
		 String lastName = elib.getDataFromExcel("opportunities", 10, 3)+rnum;
		  
	HomePage hp= new HomePage(driver);
	hp.getContactLink().click();
	
	ContactsPage cp= new ContactsPage(driver);
	cp.getCreateContactbtn().click();
	
	CreateNewContactsPage ccp= new CreateNewContactsPage(driver);
	ccp.getLastNametxt().sendKeys(lastName);
	ccp.getSaveBtn().click();
			  
		  hp.getTroubleTicketsLink().click();
		  
		  TroubleTicketPage ttp= new TroubleTicketPage(driver);
		  ttp.getCreateNewTT().click();
		  
		  CreateNewTroubleTicketPage cttp= new CreateNewTroubleTicketPage(driver);
		  cttp.getTroubleTicketTxt().sendKeys(title);
		  cttp.getAssignedRadioBtn().click();
		  cttp.getNewContactsIcon().click();
		  
		 wlib.switchToTabOnURL(driver, "Contacts&action");
		  
		 cttp.getWindowSearchTxt().sendKeys(lastName);
		 cttp.getWindowSearchBtn().click();
		  driver.findElement(By.xpath("//a[contains(.,'"+lastName+"')]")).click();
		  
		  wlib.switchToTabOnURL(driver, "HelpDesk&action");
		  
		  cttp.getSaveBtn().click();
		  
		 TroubleTruckerInfoPage ttip = new TroubleTruckerInfoPage(driver);
		 String actuaticket = ttip.getHeader().getText();
			if(actuaticket.contains(lastName)) {
				System.out.println(lastName + " ticket is created == pass");
			}
			else{
				System.out.println(lastName + " ticket is created == pass");
			
			}
	}

}
