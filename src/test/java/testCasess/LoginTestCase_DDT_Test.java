package testCasess;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;


public class LoginTestCase_DDT_Test extends BaseCase
{

	@Test(dataProvider="manoj")
	void login_DDT(String email, String password) throws IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnlogInLink();
		
		LoginPage lp=new LoginPage(driver);
		
		
		
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickonSignInfromLogin();
	}
	
	
	@DataProvider(name="manoj")
	String[][] getDatafromexcelFile() throws IOException
	{
		
		String[][] data1 = utilities.ReadDataFromExcelFile.getData();
		
		return data1;
	}
	
	
}
