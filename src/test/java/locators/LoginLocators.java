package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginLocators{
	
	
	@FindBy(xpath ="//input[@name='username']")
	public WebElement username; 
		
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Loginbtn;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	public WebElement Invalidalert;
	
	@FindBy(xpath ="//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")
	public WebElement Linkdin;
	
	@FindBy(xpath ="//a[@href='https://www.facebook.com/OrangeHRM/']")
	public WebElement Facebook;
	
	@FindBy(xpath = "//a[@href='https://twitter.com/orangehrm?lang=en']")
	public WebElement X;
	
	@FindBy(xpath ="//a[@href='https://www.youtube.com/c/OrangeHRMInc']")
	public WebElement Youtube;
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	public WebElement brandLogo;
	
	@FindBy(xpath ="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	public WebElement Forgotpwd;

	@FindBy(xpath ="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	public WebElement EmployeeID;
}
