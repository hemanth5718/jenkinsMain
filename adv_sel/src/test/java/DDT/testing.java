package DDT;

import org.testng.annotations.Test;

public class testing {
	
	@Test
	public void runtime()
	{
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		System.out.println("evn data==> url  "+ url);
		System.out.println("browser data==>  "+ browser);
		System.out.println("username data==>  "+ username);
		System.out.println("password data==>  "+ password);
		
	}

}
