package testCasess;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.DriverManager;

public class BaseCase 
{
	
    public static WebDriver driver;
    public Logger logger ;
	
    @Parameters({"browser","os"})
    @BeforeMethod
	void setUp(String br, String os)
	{
    	logger = LogManager.getLogger(this.getClass());
    	
    	
    	switch(br)
    	{
    	case "chrome" : driver=new ChromeDriver(); break;
    	case "firefox" :  driver=new FirefoxDriver(); break;
    	case "edge" : driver=new EdgeDriver(); break;
    	default : System.out.println("Invalid browser name..."); return ;	
    	
    	}
    	
    	
    	DriverManager.setDriver(driver);
    	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		
		logger.info("Browser started and website lauched");
	}

    @AfterMethod
	void tearDownMethod()
	{
	  driver.close();
	}
	
}
