package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import locators.LoginLocators;


public class LoginPage extends Basepage{
		
	LoginLocators loc;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		loc = new LoginLocators();
        PageFactory.initElements(driver, loc);  // Initialize PageFactory locators

	}
	
	
	public void Username(String name)
	{
		WebElement user = wait.until(ExpectedConditions.visibilityOf(loc.username));
		user.sendKeys(name);
	}
		
	public void Password(String pwd)
	{
		wait.until(ExpectedConditions.visibilityOf(loc.password)).sendKeys(pwd);
		
	}
	
	public void LoginClick()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.Loginbtn)).click();;
	}
	
	public void login(String username, String password)
	{
		Username(username);
		Password(password);
		LoginClick();
		
	}
	
	public WebElement alertElement() {
	    return loc.Invalidalert;  // loc.Invalidalert is your WebElement
	}
	
	public String getalert() 
	{
		try
		{
			return(loc.Invalidalert.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void Linkdin_link()
	{
		loc.Linkdin.click();
	}
	
	public void Facebook_link()
	{
		loc.Facebook.click();
	}
	
	public void Twitter_link()
	{
		loc.X.click();
	}

	public void Youtube_link()
	{
		loc.Youtube.click();
	}
	
	public void brandlogo()
	{
		Assert.assertTrue(loc.brandLogo.isDisplayed(), "Logo is not displayed!");
		System.out.println("Company logo is Displayed");
		
	}
	
	public void forgot_password() 
	{
		loc.Forgotpwd.click();
	}
}
