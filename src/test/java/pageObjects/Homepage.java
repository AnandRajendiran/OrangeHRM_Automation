package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import locators.HomePageLocators;

public class Homepage extends Basepage {
	
	HomePageLocators loc;
	
	public WebDriver driver;

	public Homepage(WebDriver driver)
	{
		super(driver);
		loc = new HomePageLocators();
		PageFactory.initElements(driver, loc);
	}

	
	public void Clickprofile()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.profile)).click();
	}
	
	public void Clicklogout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.Logout)).click();
	}
	
	public void ClickAbout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.About)).click();
	}
	
	public void ClickSupport()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.Support)).click();
	}
	
	public void ClickChange_passowrd()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.ChangePassword)).click();
	}
	
	public WebElement searchwait()
	{
		return loc.Search;
	}
	public void Search(String SectionName) throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.Search)).click();
		loc.Search.sendKeys(SectionName);
		loc.Search.sendKeys(Keys.CONTROL + "a");
	    loc.Search.sendKeys(Keys.DELETE);
	    Thread.sleep(3000);
	}
	
	public void Validate_AdminSection()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.Admin)).click();
		String Header = loc.AdminPageHeader.getText();
		Assert.assertEquals(Header,"Admin/User Management");
	}
	
	public void Validate_PIMSection()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.PIM)).click();
		String Header = loc.PIMHeader.getText();
		Assert.assertEquals(Header,"PIM");
	}
	
	public void ClickAbout_close()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.AboutClosebtn)).click();
	}
}
