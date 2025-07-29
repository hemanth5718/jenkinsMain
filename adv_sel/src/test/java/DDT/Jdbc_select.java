package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Jdbc_select {

	public static void main(String[] args) throws Throwable {
		Connection conn = null;
		try {

			Driver driveRefDriver = new Driver();
			DriverManager.registerDriver(driveRefDriver);
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");

			Statement stat = conn.createStatement();
			ResultSet resultset = stat.executeQuery("select * from project");
			while (resultset.next()) {
				System.out.println	(resultset.getString(1) + "\t" + resultset.getString(2) + "\t" + resultset.getString(3));
			}
			// System.out.println(resultset.getMetaData());
		}

		catch (Exception e) {
			System.out.println("handle exception");
		}

		finally {
			conn.close();

		}
	}

}
