package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;
import pageObjects.ProfilePage;

@Listeners(utilities.ExtendReportManger.class)
public class TestCaseProfile extends BaseClass{
	
	@BeforeMethod						// i want to use beforeclass annotation if i have multiple Testcases.
	public void Beforemethod() throws InterruptedException
	{
		LoginPage LP = new LoginPage(driver);
		LP.Username("admin");
		LP.Password("admin123");
		LP.LoginClick();
		Homepage HP = new Homepage(driver);
		HP.Validate_PIMSection();
		PIMPage PP = new PIMPage(driver);
		PP.ClickAddRecord();
		PP.FirstName("anand");
		PP.MiddleName("dude");
		PP.LastName("r");
		PP.CaptureEmployeeID();
		PP.Click_Savebtn();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void ProfilePage() throws InterruptedException
	{
	
		ProfilePage Pp = new ProfilePage(driver);
		Thread.sleep(5000);
		Pp.OtherID("None");
		Pp.DL("Tn1123145");
		Thread.sleep(3000);
		Pp.LicenceDatePicker("2024",  "06","August");
		Thread.sleep(3000);
		Pp.Nationality("Indian");
		Pp.MartialStatus("Single");
		Pp.DOB("1993", "14", "June");
		Pp.GenderMale();
		Pp.EmployeDetailsSaveBtn();
		Pp.BloodType("O+");
		Pp.Testfield("awdhqu");
		Pp.CustomedetailsSaveBtn();
	}
	
}

	
