package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class sample {
	@Test
	public void projectCheck() throws Throwable
	{
		String expectedProjectName ="mytrip";		
		
		boolean flag=false;
		
		Driver driveRefDriver = new Driver();
		DriverManager.registerDriver(driveRefDriver);
		
	    Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	    
		  Statement stat = conn.createStatement(); 
		  ResultSet resultset = stat.executeQuery("select * from project");
		  while(resultset.next())
		  {
			  String actProjectName = resultset.getString(4);
			  if(expectedProjectName.equals(actProjectName))
			  {
				  flag=true;
				  System.out.println(expectedProjectName + " is available" );
			  }
			  
		  }
		  if(flag=false)
		  {
			  System.out.println(expectedProjectName + "is not available");
			  Assert.fail();
		  }
		  conn.close();
	}
}
