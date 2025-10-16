package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PIMPageLocators {
	
	
	@FindBy(xpath="//button[normalize-space()='Add']")   //Locator in ADD Employee section
	public WebElement ADD;

	@FindBy(xpath= "//input[@name='firstName']")    //Locator in ADD Employee section
	public WebElement Firstname;
	
	@FindBy(xpath = "//input[@name='middleName']")  //Locator in ADD Employee section
	public WebElement Middlename;
	
	@FindBy(xpath ="//input[@name='lastName']")   //Locator in ADD Employee section
	public WebElement Lastname;
	
	@FindBy(xpath ="//button[@type='submit']")    //Locator in ADD Employee section
	public WebElement Savebtn;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")  //Locator in ADD Employee section
	public WebElement Cancelbtn;
	
	@FindBy(xpath = "///a[contains(.,'Employee List')]")  //Locator in PIM Page
	public WebElement Employeelist;
	
	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[2]")  //Locator in ADD Employee section
	public WebElement EmployeeID;
	
	@FindBy(xpath ="(//input[@placeholder='Type for hints...'])[1]")  // Locator in Employee list section
	public WebElement Searchemployeename;
	
	@FindBy(xpath ="//button[normalize-space()='Search']")  // Locator in Employee list section
	public WebElement Searchbtn;
	
	@FindBy(xpath ="//i[@class ='oxd-icon bi-trash']")
	public WebElement Deletbtn;
	
	@FindBy(xpath ="//button[normalize-space()='Yes, Delete']")
	public WebElement Confirmbtn;

	@FindBy(xpath= "//div[@class='orangehrm-container']")
	public WebElement Table;
	
	@FindBy(xpath ="//ul[@class='oxd-pagination__ul']/li")
	public List<WebElement> Pages;
	
	@FindBy(xpath= "//div[@role ='row']")
	public List<WebElement> rows;
	
	@FindBy(xpath ="//div[@class ='oxd-table orangehrm-employee-list']//div[@role ='cell'][2]")
	public WebElement Employeeidcolm;
	
	
	

}
