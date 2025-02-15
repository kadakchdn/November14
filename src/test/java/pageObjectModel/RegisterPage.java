package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage
{
	
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	//element on register page
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstname_registration ;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastname_registration ;

	@FindBy(xpath="//input[@id='email_address']")
	WebElement email_registration ;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password_registration ;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement confirmpassword_registration ;
	
	@FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement createAnAccountButton ;
	
	public void enterFirstname(String firstname)
	{
		firstname_registration.sendKeys(firstname);
	}
	
	public void enterlastFirstname(String lastname)
	{
		lastname_registration.sendKeys(lastname);
	}
	
	public void enterEmailforRegistration(String emailForRegistration)
	{
		email_registration.sendKeys(emailForRegistration);
	}
	
	public void enterPassword_and_ConfirmPassword(String password)
	{
		password_registration.sendKeys(password);
		
		confirmpassword_registration.sendKeys(password);
	}
	
	public void clickOnCreateAnAccountButton()
	{
		createAnAccountButton.click();
	}
	
	
}
