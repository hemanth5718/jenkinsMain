package Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import objectRepositoryUtility.CalenderPage;
import objectRepositoryUtility.HomePage;

public class SchedulingMeeting extends BaseClass {

	@Test
	public void schedulingMeething() throws Throwable {

		int rnum = jlib.getRandomNumber();

		String eventname = elib.getDataFromExcel("opportunities", 7, 2) + rnum;

		// Calendar
		HomePage hp = new HomePage(driver);
		hp.getCalenderIcon().click();
		Thread.sleep(2000);
		hp.getSelectDate().click();
		Thread.sleep(2000);
		CalenderPage cp = new CalenderPage(driver);
		WebElement ele = cp.getAddCalBtn();
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);

		cp.getMettingLink().click();
		cp.getWindowEventName().sendKeys(eventname);

		WebElement ele2 = cp.getWindowEventStartDD();
		ele2.click();
		Select sel2 = new Select(ele2);
		sel2.selectByVisibleText("23");
		Thread.sleep(2000);

		WebElement ele1 = cp.getWindowAvailableUser();
		Select sel = new Select(ele1);
		sel.selectByVisibleText("Hombale Studios_1904");

		cp.getSaveBtn().click();

		System.out.println("Meeting scheduled TestCase ==>> pass");
	}

}
