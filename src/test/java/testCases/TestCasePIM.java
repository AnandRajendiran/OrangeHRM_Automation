package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

@Listeners(utilities.ExtendReportManger.class)
public class TestCasePIM extends BaseClass{
	
	String ID;
	String name;
	
	@Test
	public void AddEmployee() throws InterruptedException
	{
		LoginPage LP = new LoginPage(getDriver());
		LP.Username("Admin");
		LP.Password("admin123");
		LP.LoginClick();
		Homepage HP =new Homepage(getDriver());
		HP.Validate_PIMSection();	
		PIMPage PP = new PIMPage(getDriver());
		PP.ClickAddRecord();
		name = PP.FirstName("anand");
		PP.MiddleName("dude");
		PP.LastName("r");
		ID = PP.CaptureEmployeeID();
		PP.Click_Savebtn();
		Thread.sleep(3000);
				
	}
	

	public void SearchEmployee() throws InterruptedException
	{
		PIMPage PP = new PIMPage(getDriver());
		Thread.sleep(3000);
		PP.Click_EmployeeListSection();
		PP.SearchWithEmployeeName(name);
		Thread.sleep(3000);
		PP.ClickSearchButton();
		PP.delete();
		PP.confirmbtn();

	}
	
	@Test(priority=2)
	public void DeleteEmployeeRecord() throws InterruptedException
	{
		PIMPage PP = new PIMPage(getDriver());
		PP.Click_EmployeeListSection();
		Thread.sleep(2000);
		PP.DeleteRecord(ID);
		
	}
	

}
