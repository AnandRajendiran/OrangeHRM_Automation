package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import locators.PIMPageLocators;

public class PIMPage extends Basepage {
	
	PIMPageLocators loc;
	
	public PIMPage(WebDriver driver)
	
	{
		super(driver);
		loc = new PIMPageLocators();		
		PageFactory.initElements(driver, loc);
	}

	public void ClickAddRecord()
	{
		loc.ADD.click();
	}
		
	public String FirstName(String Fname)
	{
		loc.Firstname.sendKeys(Fname);
		String name =loc.Firstname.getAttribute("value");
		return name;
	}
	
	public void MiddleName(String MName)
	{
		loc.Middlename.sendKeys(MName);
	}
	
	public void LastName(String LName)
	{
		loc.Lastname.sendKeys(LName);
	}
	
	public void Click_Savebtn()
	{
		loc.Savebtn.click();
		
	}
	
	public void Click_EmployeeListSection()
	{
		loc.Employeelist.click();
	}
	
	public void SearchWithEmployeeName(String EName)
	{
		loc.Searchemployeename.sendKeys(EName);
	}
	
	public void ClickSearchButton() throws InterruptedException
	{
		loc.Searchbtn.click();
		Thread.sleep(2000);
	}
	
	public void DeleteRecord(String EmpID) throws InterruptedException
	{
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class= 'oxd-table-body']//div[@class ='oxd-table-card']"));
	
		for(WebElement row: rows)
		{
			 WebElement cols = row.findElement(By.xpath("(.//div[@class='oxd-table-cell oxd-padding-cell'])[2]"));
			 String idcol = cols.getText().trim();
			 System.out.println("row id :" +idcol);
				 if(idcol.equals(EmpID))
				 {
					 WebElement Deletebtn = driver.findElement(By.xpath("//i[@class ='oxd-icon bi-trash']"));
					 Deletebtn.click();
					 Thread.sleep(3000);
					 loc.Confirmbtn.click();
					 Thread.sleep(3000);
					 System.out.println("employee  "+ EmpID + "  Deleted");
					 break;
				 }

			 }
	
		}
	

//		Boolean found = false;
//		for(int p=1;p<=loc.Pages.size(); p++) 
//		{
//			WebElement page = driver.findElement(By.xpath("//ul[@class='oxd-pagination__ul']/li[" + p + "]"));
//			page.click();
//			Thread.sleep(8000);
//			
//			 List<WebElement> rows = driver.findElements(By.xpath(".//div[@role ='row']"));
//			 System.out.println("rows- " +rows);
//			 for(WebElement row:rows)
//			 {
//				 Thread.sleep(2000);
//				 String CurrentID =row.findElement(By.xpath("(.//div[@role='cell'])[2]")).getText().trim();
//				 System.out.println("CurrentID-" + CurrentID);
//				 if(CurrentID.equalsIgnoreCase(EmpID.trim()))
//				 {
//					 WebElement Deletebtn = driver.findElement(By.xpath("//i[@class ='oxd-icon bi-trash']"));
//					 Deletebtn.click();
//					 Thread.sleep(3000);
//					 loc.Confirmbtn.click();
//					 Thread.sleep(3000);
//					 System.out.println("employee"+ EmpID + "Deleted");
//					 found = true;		
//					 break;
//				 }
//				 
//			 }
//			 if(found) break;
//			 
//			 }
//		
//			if(!found) {
//				System.out.println("Employee"+EmpID+"not found in table in page");
//		}

	
	public String CaptureEmployeeID()
	{
		String id = loc.EmployeeID.getAttribute("value").trim();
		return id;
	}
	
	public void delete()
	{
		loc.Deletbtn.click();
	}
	
	public void confirmbtn()
	{
		loc.Confirmbtn.click();
	}


}

