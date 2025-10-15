package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.EmployeeProfile;

public class ProfilePage extends Basepage {
	
	EmployeeProfile loc;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public ProfilePage(WebDriver driver)
	{
		super(driver);
		loc = new EmployeeProfile();
		PageFactory.initElements(driver, loc);
	}
	
	
	//public void NickName(String Nname)
	{
	//	loc.NickName.sendKeys(Nname);
	}
	
	public void OtherID(String OID)
	{
		loc.OtherID.click();;
		loc.OtherID.sendKeys(OID);
	}
	
	public void DL(String DL)
	{
		loc.DL.click();;
		loc.DL.sendKeys(DL);
	}
	
	public void GenderMale()
	{
		WebElement maleLabel = loc.GenderMale;

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", maleLabel);
	    wait.until(ExpectedConditions.elementToBeClickable(maleLabel));

	    try {
	        maleLabel.click();
	    } catch (ElementClickInterceptedException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleLabel);
	    }
	}
	
	public void GenderFemale()
	{
		WebElement FemaleLabel = loc.GenderFemale;

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FemaleLabel);
	    wait.until(ExpectedConditions.elementToBeClickable(FemaleLabel));

	    try {
	    	FemaleLabel.click();
	    } catch (ElementClickInterceptedException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", FemaleLabel);
	    }
	}
	
	public void EmployeDetailsSaveBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.EmployeedetailsSaveBtn));
	}
	
	public void Testfield(String rndm)
	{
		loc.TestField.sendKeys(rndm);
	}
	
	public void CustomedetailsSaveBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loc.CustomfieldSaveBtn));
	
	}
	
	public void LicenceDatePicker(String Year, String Date,String Month ) throws InterruptedException
	{
		loc.ExpireDate.click();
		loc.DatePickerSelectYear.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text() = '"+Year+"']"))).click();
		
		loc.DatePickerSelectMonth.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text() = '"+Month+"']"))).click();
		Thread.sleep(2000);
		
		WebElement Day = driver.findElement(By.xpath("//div[@class='oxd-calendar-date' and normalize-space()='"+Integer.parseInt(Date)+"']"));
		Day.click();				
		
	}
	
	public void Nationality(String Nation)
	{
		loc.Nationality.click();
		WebElement national = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role = 'option' and normalize-space() = '"+Nation+"']")));
		national.click();
	}

	public void MartialStatus(String Martial)
	{
		loc.MartialStatus.click();
		WebElement martial = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role = 'option' and normalize-space() = '"+Martial+"']")));
		martial.click();
	}
	
	public void DOB(String Year, String Date,String Month ) throws InterruptedException
	{
		
		loc.DOB.click();
		loc.DatePickerSelectYear.click();
		WebElement yearOption = wait.until(ExpectedConditions.elementToBeClickable(
		            By.xpath("//li[normalize-space()='" + Year + "']")));
		 yearOption.click();

		
		loc.DatePickerSelectMonth.click();
		WebElement monthOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='"+Month+"']")));
		monthOption.click();

		WebElement Day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-calendar-date' and normalize-space()='"+Integer.parseInt(Date)+"']")));
		Day.click();
		
	}
	
	public void BloodType(String BT) throws InterruptedException
	{
		loc.BloodType.click();
		Thread.sleep(2000);
		WebElement Bt = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//div[@role='option' and normalize-space()='" + BT + "']")
			));
		Bt.click();
	}
}
