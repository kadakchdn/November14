package testCasess;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.HomePage;
import pageObjectModel.RegisterPage;
import utilities.ConfigManager;
import utilities.RandomMethods;

public class RegistrationTestCase extends BaseCase
{
	
	
	@Test
	void Registration() throws IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnCreateAnAccountLink();
		
		RegisterPage rp=new RegisterPage(driver);
		rp.enterFirstname("Aakash");
		logger.info("first name entered");
		
		rp.enterlastFirstname("Gandhi");
		logger.info("last name entered");
		
		String randomEmail=RandomMethods.getRamdomEmail();
		ConfigManager.setProperty("email", randomEmail);
		System.out.println(randomEmail);
		
		
		rp.enterEmailforRegistration(randomEmail);
		logger.info("email entered");
		
		String randomPassword = RandomMethods.getRamdomEmail();
		ConfigManager.setProperty("password", randomPassword);
		System.out.println(randomPassword);
		
		rp.enterPassword_and_ConfirmPassword(randomPassword);
		logger.info("password and confirm password entered");

		rp.clickOnCreateAnAccountButton();
		logger.info("register button cliked ");
		
		
	}
	
	

}
