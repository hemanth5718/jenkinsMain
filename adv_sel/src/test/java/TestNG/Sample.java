package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;


public class Sample extends BaseClass {

	@Test
	public void demo()
	{
		System.out.println("-- pass --");
	}
	
	@Test
	public void demo2()
	{
		Assert.fail();
		System.out.println("-- fali --");
		
	}
	@Test
	public void demo3()
	{
		Assert.fail();
		System.out.println("-- fail --");
		
	}
}
