package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() 
	{
		driver.quit();
	}
	
	
	public String capturescreen(String tname) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourcefile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath = System.getProperty("user.dir")+"\\Screenshots\\" +tname +"_"+ timestamp + ".png";
		File targetfile = new File(targetfilepath);
		
		 FileUtils.copyFile(sourcefile, targetfile);
		
		return targetfilepath;
	}
	
}
