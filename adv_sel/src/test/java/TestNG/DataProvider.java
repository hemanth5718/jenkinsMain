package TestNG;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider = "getData")
	public void createConatctTest(String firstName,String LastName, long phoneNumber) {
		System.out.println("firstName:"+ firstName +", LastName:" + LastName +", phoneNum:" +phoneNumber);
	}

	@org.testng.annotations.DataProvider
	public Object[][] getData(){
		Object[][] objarr = new Object[3][3];
		objarr[0][0]= "hemanth";
		objarr[0][1]= "gowda";
		objarr[0][2]= 88925044784l;
		
		objarr[1][0]= "jogi";
		objarr[1][1]= "shiva";
		objarr[1][2]= 88925044745l;
		
		objarr[2][0]= "vk";
		objarr[2][1]= "sachin";
		objarr[2][2]= 88925044785454l;
		return objarr;
		
	}
	
	
	
}
