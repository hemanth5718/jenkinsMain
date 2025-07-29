package TestNG;

import org.testng.annotations.Test;

public class DependsOn {
	
	@Test
	public void createOrderTest() {
		System.out.println("execute createOrderTest-->123");
		  String str = "hi";
		System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods = "createOrderTest")
	public void billingAnOrderTest() {
		System.out.println("executeOrderTest-->>456");
	}

}
