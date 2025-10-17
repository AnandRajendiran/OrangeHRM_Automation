package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResetPasswordPage extends Basepage 
{
	
	public ResetPasswordPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath = "//h6[normalize-space()='Reset Password']")
	WebElement Header;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p']")
	WebElement description;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath ="//button[normalize-space()='Cancel']")
	WebElement Cancel;
	
	@FindBy(xpath ="//button[normalize-space()='Reset Password']")
	WebElement Reset;
	
	public WebElement headerElement() {
	    return Header;
	}
	public void Header()
	{
		Assert.assertTrue(Header.isDisplayed(), "❌ Header 'Reset Password' is not displayed!");
		Assert.assertEquals(Header.getText(), "Reset Password", "❌ Header text mismatch!");

	}
	
	public void Description()
	{

		Assert.assertEquals(description.getText(), "Please enter your username to identify your account to reset your password", "❌ Description text mismatch!");
	}
	
	public void Username(String name)
	{
		username.sendKeys(name);
	}
	
	public WebElement cancelButton() {
	    return Cancel;
	}
	public void Cancel()
	{
		cancelButton().click();
	}
	
	public void Reset()
	{
		Reset.click();
	}
}

