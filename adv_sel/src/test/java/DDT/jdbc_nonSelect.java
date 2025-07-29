package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class jdbc_nonSelect {

	public static void main(String[] args) throws Throwable {
		
		Driver driveRefDriver = new Driver();
		DriverManager.registerDriver(driveRefDriver);
	    Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	    
		  Statement stat = conn.createStatement(); 
		 int result = stat.executeUpdate("insert into emp values('777','hemanth571','7777','support eng07','book')");
		 System.out.println(result);
		    conn.close();
		 
		 
	    
	}
}
 