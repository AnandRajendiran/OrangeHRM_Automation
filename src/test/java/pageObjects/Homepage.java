package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import locators.HomePageLocators;

public class Homepage extends Basepage {
	
	HomePageLocators loc;

	public Homepage(WebDriver driver)
	{
		super(driver);
		loc = new HomePageLocators();
		PageFactory.initElements(driver, loc);
	}

	
	public void Clickprofile()
	{
		loc.profile.click();
	}
	
	public void Clicklogout()
	{
		loc.Logout.click();
	}
	
	public void ClickAbout()
	{
		loc.About.click();
	}
	
	public void ClickSupport()
	{
		loc.Support.click();
	}
	
	public void ClickChange_passowrd()
	{
		loc.ChangePassword.click();
	}
	
	public void Search(String SectionName) throws InterruptedException
	{
		loc.Search.click();
		loc.Search.sendKeys(SectionName);
		loc.Search.sendKeys(Keys.CONTROL + "a");
	    loc.Search.sendKeys(Keys.DELETE);
	    Thread.sleep(3000);
	}
	
	public void Validate_AdminSection()
	{
		loc.Admin.click();
		String Header = loc.AdminPageHeader.getText();
		Assert.assertEquals(Header,"Admin/User Management");
	}
	
	public void Validate_PIMSection()
	{
		loc.PIM.click();
		String Header = loc.PIMHeader.getText();
		Assert.assertEquals(Header,"PIM");
	}
	
	public void ClickAbout_close()
	{
		loc.AboutClosebtn.click();
	}
}
