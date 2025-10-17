package testCases;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;

public class TestCaseLogin extends BaseClass{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
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
		LP.Username("Admin");
		LP.Password("admin1234");
		LP.LoginClick();
		WebElement alert = wait.until(ExpectedConditions.visibilityOf(LP.alertElement()));
		String msg = alert.getText().trim();
        Assert.assertTrue(msg.contains("Invalid credentials"), "Unexpected alert: " + msg);
	}
	
	@Test(priority = 3)
	public void login_With_InValid_Credential_in_username()
	{
		LoginPage LP = new LoginPage(driver);
		LP.Username("dude");
		LP.Password("admin123");
		LP.LoginClick();
		WebElement alert = wait.until(ExpectedConditions.visibilityOf(LP.alertElement()));
		String msg = alert.getText().trim();
//		Assert.assertEquals(msg, "Invalid credentials");
		if (msg.contains("Invalid credentials")) {
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
		wait.until(ExpectedConditions.visibilityOf(RP.cancelButton()));
		RP.Cancel();


	}
	
	@Test(priority = 7)
	public void Resetpassword()
	{
		LoginPage LP= new LoginPage(driver);
		LP.forgot_password();
		ResetPasswordPage RP= new ResetPasswordPage(driver);
		 wait.until(ExpectedConditions.visibilityOf(RP.headerElement()));
		RP.Header();
		RP.Description();
		

	}
}
