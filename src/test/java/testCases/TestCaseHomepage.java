package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;

@Listeners(utilities.ExtendReportManger.class)
public class TestCaseHomepage extends BaseClass{
	
	
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
			Thread.sleep(2000);
		}
		
	}
}
