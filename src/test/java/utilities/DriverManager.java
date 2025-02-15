package utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager 
{
	static WebDriver driver1;
	
	public static void setDriver(WebDriver driver)
	{
		driver1=driver;
	}

	public static WebDriver getDriver()
	{
	  return driver1;	
	}
}
