package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageLocators{
	
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	public WebElement profile;

	@FindBy(xpath ="//a[normalize-space()='Logout']")
	public WebElement Logout;
	
	@FindBy(xpath ="//h6[normalize-space()='Dashboard']")
	public WebElement Dashboardtext;
	
	@FindBy(xpath ="//img[@alt='client brand banner']")
	public WebElement HomeLogo;
	
	@FindBy(xpath = "//span[text()='Admin']")
	public WebElement Admin;
	
	@FindBy(xpath ="//span[normalize-space()='PIM']")
	public WebElement PIM;
	
	@FindBy(xpath ="//span[normalize-space()='Leave']")
	public WebElement Leave;
	
	@FindBy(xpath ="//span[normalize-space()='Time']")
	public WebElement Time;
	
	@FindBy(xpath ="//span[normalize-space()='Recruitment']")
	public WebElement Recruitment;
	
	@FindBy(xpath ="//span[normalize-space()='My Info']")
	public WebElement Myinfo;
	
	@FindBy(xpath ="//span[normalize-space()='Performance']")
	public WebElement Performace;
	
	@FindBy(xpath ="//span[normalize-space()='Dashboard']")
	public WebElement Dashboard;
	
	@FindBy(xpath ="//span[normalize-space()='Directory']")
	public WebElement Directory;
	
	@FindBy(xpath ="//span[normalize-space()='Maintenance']")
	public WebElement Maintenance;
	
	@FindBy(xpath ="//span[normalize-space()='Claim']")
	public WebElement Claim;
	
	@FindBy(xpath ="//span[normalize-space()='Buzz']")
	public WebElement Buzz;
	
	@FindBy(xpath ="//a[normalize-space()='About']")
	public WebElement About;
	
	@FindBy(xpath ="//a[normalize-space()='Support']")
	public WebElement Support;
	
	@FindBy(xpath ="//a[normalize-space()='Change Password']")
	public WebElement ChangePassword;
	
	@FindBy(xpath ="//input[@placeholder='Search']")
	public WebElement Search;
	
	@FindBy(xpath ="//div[@class='oxd-topbar-header-title']")
	public WebElement AdminPageHeader;
	
	@FindBy(xpath ="//h6[normalize-space()='PIM']")
	public WebElement PIMHeader;
	
	@FindBy(xpath ="//button[normalize-space()='×']")
	public WebElement AboutClosebtn;
}
