package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryActivateSim {
	@Test(retryAnalyzer = crm.listenersUtility.RetryListenerImp.class)
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("login", "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}
