package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage 
{
	
  
	
    //constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//element present on home page
	
	@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement createAccountlink ;
	
	
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement SignInlink ;
	
	
	
	//actions for element on home page
	
	public void clickOnCreateAnAccountLink()
	{
		createAccountlink.click();
		
	}
	
	public void clickOnlogInLink()
	{
		SignInlink.click();	
	}
	
	
	
	

}
