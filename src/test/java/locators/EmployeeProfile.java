package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EmployeeProfile {
	

	//@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	//public WebElement NickName;
	
	@FindBy(xpath ="//label[text()='Other Id']/following::input[1]")
	public WebElement OtherID;
	
	@FindBy(xpath ="//label[text()=\"Driver's License Number\"]//following::input[1]")
	public WebElement DL;
	
	@FindBy(xpath = "(//i[@class ='oxd-icon bi-calendar oxd-date-input-icon'])[1]")
	public WebElement ExpireDate;
	
//	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[7]")
//	public WebElement SSNNumber;
	
//	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[8]")
//	public WebElement SINNumber;
	
	@FindBy(xpath ="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'][1]")
	public WebElement Nationality;
	
	@FindBy(xpath ="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
	public WebElement MartialStatus;
	
	@FindBy(xpath = "(//i[@class ='oxd-icon bi-calendar oxd-date-input-icon'])[2]")
	public WebElement DOB;
	
	@FindBy(xpath ="//label[normalize-space()='Male']")
	public WebElement GenderMale;
	
	@FindBy(xpath = "//label[normalize-space()='Female']")
	public WebElement GenderFemale;
	
	@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[10]")
	public WebElement MilitaryService;
	
	@FindBy(xpath = "//label[normalize-space() ='Yes']")
	public WebElement Smoker;
	
	@FindBy(xpath ="(//button[@type ='submit'])[1]")
	public WebElement EmployeedetailsSaveBtn;
	
	@FindBy(xpath = "(//i[@class ='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]")
	public WebElement BloodType;
	
	@FindBy(xpath ="//label[text()='Test_Field']//following::input[1]")
	public WebElement TestField;
	
	@FindBy(xpath = "(//button[@type ='submit'])[2]")
	public WebElement CustomfieldSaveBtn;
	
	@FindBy(xpath ="(//i[@class ='oxd-icon bi-caret-down-fill oxd-icon-button__icon'])[2]")
	public WebElement DatePickerSelectYear;
	
	@FindBy(xpath ="(//i[@class ='oxd-icon bi-caret-down-fill oxd-icon-button__icon'])[1]")
	public WebElement DatePickerSelectMonth;
	
	@FindBy(xpath = "//div[@class='oxd-calendar-dates-grid']")
	public WebElement DatePickerSelectDate;            // Can be use with select class if its available
}

