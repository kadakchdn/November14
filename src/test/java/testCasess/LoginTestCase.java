package testCasess;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import utilities.ConfigManager;

public class LoginTestCase extends BaseCase
{
	

	@Test
	void login() throws IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnlogInLink();
		
		LoginPage lp=new LoginPage(driver);
		
		String eemail=ConfigManager.getProperty("email");
		String epassword=ConfigManager.getProperty("password");
		
		lp.enterEmail(eemail);
		logger.info("email for login enterted");
		
		lp.enterPassword(epassword);
		logger.info("password for login enterted");
		
		lp.clickonSignInfromLogin();
		logger.info("login buttonm cliked");
	}
	
	

}
