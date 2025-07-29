package TestNG;

import org.testng.annotations.Test;

public class Priority {
	@Test(priority = -7)
	public void createContactTest()
	{
		System.out.println("execute createContact");
	}
	
	@Test(priority=-1)
	public void modifyContactTest()
	{
		System.out.println("execute modifyConatct");
	}
	
	@Test(priority=2)
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest");
	}
	

}
