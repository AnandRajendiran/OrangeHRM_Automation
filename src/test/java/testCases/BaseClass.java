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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver()
	{
		return driver.get();	}
	
	// ✅ Common wait timeout (you can adjust globally)
    private static final int EXPLICIT_WAIT_TIMEOUT = 15;
    private static final int IMPLICIT_WAIT_TIMEOUT = 10;
	
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
        
		WebDriver localdriver = new ChromeDriver(options);
		driver.set(localdriver);
		getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        getDriver().manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() 
	{
		 if (getDriver() != null) {
	            getDriver().quit();
	            driver.remove();
	        }
	}
	
	 public WebDriverWait getwait() {
	        return new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
	    }
	
	public String capturescreen(String tname) throws IOException
	{
	
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) getDriver();
		File sourcefile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath = System.getProperty("user.dir")+"\\Screenshots\\" +tname +"_"+ timestamp + ".png";
		File targetfile = new File(targetfilepath);
		
		 FileUtils.copyFile(sourcefile, targetfile);
		 System.out.println("Screenshot taken: " + tname);
		 
		 return targetfilepath;
		
		
	}
	
}
