package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;

@Listeners(utilities.ExtendReportManger.class)
public class TestCaseLogin extends BaseClass{
		
	@Test(priority = 1)
	public void login_With_Valid_Creadtial() 
	{
		LoginPage LP = new LoginPage(driver);
		LP.Username("Admin");
		LP.Password("admin123");
		LP.LoginClick();
		
		Homepage HP = new Homepage(driver);
		HP.Clickprofile();
		HP.Clicklogout();
			
	}
	
	@Test(priority = 2)
	public void login_With_InValid_Credential_in_Password()
	{
		LoginPage LP = new LoginPage(driver);
		LP.Username("admin");
		LP.Password("admin1234");
		LP.LoginClick();
		String msg = LP.getalert();
		Assert.assertEquals(msg, "Invalid credentials");
	}
	
	@Test(priority = 3)
	public void login_With_InValid_Credential_in_username()
	{
		LoginPage LP = new LoginPage(driver);
		LP.Username("dude");
		LP.Password("admin123");
		LP.LoginClick();
		String msg = LP.getalert();
//		Assert.assertEquals(msg, "Invalid credentials");
		if (msg.equals("Invalid credentials")) {
		    System.out.println("Test Passed: Got expected error message");
		    Assert.assertTrue(true);
		} else {
		    System.out.println("Unexpected behavior: Login succeeded, proceeding...");
		    Homepage HP = new Homepage(driver);
		    try {
	            HP.Clickprofile();
	            HP.Clicklogout();
	        } catch (Exception e) {
	            System.out.println("Profile/Logout not found: " + e.getMessage());
	        }
	        Assert.fail("Expected 'Invalid credentials' but got: " + msg);
	    }
	}
	
	
	public void Social_media_link()
	{
		LoginPage LP= new LoginPage(driver);
		LP.Linkdin_link();
		LP.Facebook_link();
		LP.Twitter_link();
		LP.Youtube_link();
		
	}
	
	@Test(priority = 5)
	public void BrandLogo()
	{
		LoginPage LP= new LoginPage(driver);
		LP.brandlogo();		
		
	}
	
	@Test(priority = 6)
	public void ForgotPassword()
	{
		LoginPage LP= new LoginPage(driver);
		LP.forgot_password();
		ResetPasswordPage RP= new ResetPasswordPage(driver);
		RP.Cancel();


	}
	
	@Test(priority = 7)
	public void Resetpassword()
	{
		LoginPage LP= new LoginPage(driver);
		LP.forgot_password();
		ResetPasswordPage RP= new ResetPasswordPage(driver);
		RP.Header();
		RP.Description();
		

	}
}
