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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	// ✅ Common wait timeout (you can adjust globally)
    public static final int EXPLICIT_WAIT_TIMEOUT = 15;
    public static final int IMPLICIT_WAIT_TIMEOUT = 10;
	
	@BeforeClass
	public void setup()
	{
		
		WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        
        driver = new ChromeDriver(options);
   
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() 
	{

		 if (driver != null) {
			 driver.quit();
	        }
	}
	
	
	public String capturescreen(String tname) throws IOException
	{
	
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourcefile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath = System.getProperty("user.dir")+"\\Screenshots\\" +tname +"_"+ timestamp + ".png";
		File targetfile = new File(targetfilepath);
		
		 FileUtils.copyFile(sourcefile, targetfile);
		 System.out.println("Screenshot taken: " + tname);
		 
		 return targetfilepath;
		
		
	}
	
}
