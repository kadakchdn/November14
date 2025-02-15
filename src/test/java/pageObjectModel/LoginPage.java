package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage
{
   
	
    public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//element on register page
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email_login ;
	
	@FindBy(xpath="//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement password_login ;
	
	@FindBy(xpath="//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement SignInButton_login ;
	
	public void enterEmail(String email)
	{
		email_login.sendKeys(email);
	}
	
	public void enterPassword(String pass)
	{
		password_login.sendKeys(pass);
	}
	
	public void clickonSignInfromLogin()
	{
		SignInButton_login.click();
	}
	


}
