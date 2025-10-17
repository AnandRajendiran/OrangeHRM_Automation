package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;

@Listeners(utilities.ExtendReportManger.class)
public class TestCaseHomepage extends BaseClass{
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	@Test(priority =1)
	public void HomeScreenProfile() throws InterruptedException
	{
		LoginPage LP = new LoginPage(driver);
		LP.Username("admin");
		LP.Password("admin123");
		LP.LoginClick();
		
		Homepage HP =new Homepage(driver);
		HP.Clickprofile();
		HP.ClickAbout();
		HP.ClickAbout_close();
		HP.Clickprofile();
		HP.ClickSupport();
		HP.Clickprofile();
		HP.ClickChange_passowrd();
		HP.Clickprofile();
		HP.Clicklogout();
		Thread.sleep(3000);		
	}
	
	@Test(priority =2)
	public void validattionOfSearchbox() throws InterruptedException
	{
		LoginPage LP = new LoginPage(driver);
		LP.Username("admin");
		LP.Password("admin123");
		LP.LoginClick();
		
		Homepage HP =new Homepage(driver);
		String[]  SearchItems = {"admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard","Directory","Maintenance","Claim", "Buzz"};
		
		for(String items:SearchItems)
		{
			HP.Search(items);
			wait.until(ExpectedConditions.visibilityOf(HP.searchwait()));
		}
		
	}
}
